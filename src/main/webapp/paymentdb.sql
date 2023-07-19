DROP database IF EXISTS paymentdb;

CREATE database paymentdb;

USE paymentdb;

CREATE TABLE statuses (
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(15)
);
CREATE TABLE stages (
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(15)
);

CREATE TABLE roles (
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(15)
);

CREATE TABLE clients (
	e_mail VARCHAR(40) PRIMARY KEY,
	password VARCHAR(10) UNIQUE
    );

CREATE TABLE cards (
	id INT PRIMARY KEY auto_increment,
	number BIGINT (16)
);

CREATE TABLE payments (
	id INT PRIMARY KEY auto_increment,
    date DATE,
    sum INT 
	);

CREATE TABLE clients_cards (
	client_id VARCHAR(40) REFERENCES clients(e_mail) on delete cascade,
	card_id INT REFERENCES cards(id) on delete cascade,
	UNIQUE (client_id, card_id)
);
CREATE TABLE clients_role (
	client_id VARCHAR(40) REFERENCES clients(e_mail) on delete cascade,
	role_id INT REFERENCES roles(id) on delete cascade,
	UNIQUE (client_id, role_id)
);
CREATE TABLE clients_status (
	client_id VARCHAR(40) REFERENCES clients(e_mail) on delete cascade,
	status_id INT REFERENCES statuses(id) on delete cascade,
	UNIQUE (client_id, status_id)
);
CREATE TABLE cards_status (
	card_id INT REFERENCES cards(id) on delete cascade,
	status_id INT REFERENCES statuses(id) on delete cascade,
	UNIQUE (card_id, status_id)
);

CREATE TABLE payments_stage (
	payment_id INT REFERENCES payments(id) on delete cascade,
	stage_id INT REFERENCES stages(id) on delete cascade,
	UNIQUE (payment_id, stage_id)
);

CREATE TABLE clients_payments (
	client_id VARCHAR(40) REFERENCES clients(e_mail) on delete cascade,
    payment_id INT REFERENCES payments(id) on delete cascade,

	UNIQUE (client_id, payment_id)
);

INSERT INTO statuses VALUES (DEFAULT, 'block');
INSERT INTO statuses VALUES (DEFAULT, 'unblock');

INSERT INTO roles VALUES (DEFAULT, 'user');
INSERT INTO roles VALUES (DEFAULT, 'moderator');

INSERT INTO stages VALUES (DEFAULT, 'prepared');
INSERT INTO stages VALUES (DEFAULT, 'sent');
INSERT INTO clients VALUES ('admin@gmail.com', '1234');
INSERT INTO clients_role VALUES ('admin@gmail.com', 2);

SELECT * FROM statuses;
SELECT * FROM roles;
SELECT * FROM stages;
SELECT * FROM clients;
SELECT * FROM cards;
SELECT * FROM payments;
SELECT * FROM clients_cards;
SELECT * FROM clients_role;
SELECT * FROM clients_status;
SELECT * FROM cards_status;
SELECT * FROM payments_stage;
SELECT * FROM clients_payments;
SELECT client_id FROM clients_role cr WHERE cr.role_id=2;