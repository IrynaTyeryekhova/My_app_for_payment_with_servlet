package org.example.dbServices;

public interface DBConstants {
    String INSERT_CLIENT = "INSERT INTO clients (e_mail, password, name, role_id, status_id) values (?, ?, ?, ?, ?);";
}
