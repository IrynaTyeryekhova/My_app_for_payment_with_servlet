package org.example.dbServices;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Fields;
import org.example.Roles;
import org.example.Statuses;
import org.example.connection.DataSource;
import org.example.entities.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBClientService {
    static DBClientService instance;
    public static final Logger LOG= Logger.getLogger(DBClientService.class.getName());
    private DBClientService() {
    }
    public static synchronized DBClientService getInstance() {
        if (instance == null) {
            instance = new DBClientService();
        }
        return instance;
    }
    public int insertClient(Client client) throws DBException{
        Connection con = null;
        PreparedStatement stmt = null;
        int result = 0;
        final String queryMySQL = DBConstants.INSERT_CLIENT;
        try {
            con = DataSource.getConnection();
            stmt = con.prepareStatement(queryMySQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, client.geteMail());
            stmt.setString(2, client.getPassword());
            stmt.setString(3, client.getName());
            stmt.setInt(4, Roles.USER);
            stmt.setInt(5, Statuses.UNBLOCK);
            int insertAmount = stmt.executeUpdate();
            if (insertAmount > 0) {
                result = 1;
            }
        } catch (SQLException e) {
            LOG.info("SQLException in insertClient method");
            return result;
        }
        finally {
            new DBCloseService().close(stmt);
            new DBCloseService().close(con);
        }
        return result;
    }

    public int updateClientStatus(String email, int status) throws DBException {
        Connection con = null;
        PreparedStatement stmt = null;
        int result = 0;
        final String queryMySQL = "UPDATE clients SET clients.status_id=? WHERE clients.e_mail=?";
        try {
            con = DataSource.getConnection();
            stmt = con.prepareStatement(queryMySQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, status);
            stmt.setString(2, email);
            int insertAmount = stmt.executeUpdate();
            if (insertAmount > 0) {
                result = 1;
            }
        } catch (SQLException e) {
            LOG.info("SQLException in updateClientStatus method");
            return result;
        } finally {
            new DBCloseService().close(stmt);
            new DBCloseService().close(con);
        }
        return result;
    }

    public List<Client> findAllClientsForRole(int role) {
        List<Client> clients = new ArrayList<>();
        Client client = null;
        String query = "SELECT * FROM clients WHERE clients.role_id = ?";
        try (Connection con = DataSource.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setInt(1, role);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    client = new Client(rs.getString(Fields.E_MAIL), rs.getString(Fields.NAME));
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            LOG.info("SQLException in findAllClientsForRole method");
            return null;
        }
        return clients;
    }

    public List<Client> findAllClientsForRole(int role, String orderBy, String typeSort, int limit, int offset) {
        List<Client> clients = new ArrayList<>();
        Client client = null;
        String query = "SELECT * FROM clients INNER JOIN statuses ON clients.status_id=statuses.id " +
                "WHERE clients.role_id = ? ORDER BY "
                + orderBy + " " + typeSort + " limit ? offset ?";
        try (Connection con = DataSource.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setInt(1, role);
            stmt.setInt(2, limit);
            stmt.setInt(3, offset);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    client = new Client(rs.getString(Fields.E_MAIL), rs.getString(Fields.NAME));
                    client.setStatus(rs.getString(Fields.STATUS_NAME));
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            LOG.info("SQLException in findAllClientsForRole method");
        }
        return clients;
    }

    public Client getClientInfo(String email) {
        Client client = null;
        String query = "SELECT * FROM clients " +
                "INNER JOIN roles INNER JOIN statuses ON clients.role_id=roles.id AND clients.status_id=statuses.id  " +
                "WHERE clients.e_mail=?";
        try (Connection con = DataSource.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    client = new Client(rs.getString(Fields.E_MAIL), rs.getString(Fields.PASSWORD), rs.getString(Fields.CLIENTS_NAME), rs.getString(Fields.ROLE_NAME), rs.getString(Fields.STATUS_NAME));
                }
            }
        } catch (SQLException e) {
            LOG.info("SQLException in getClientInfo method");
            return client;
        }
        return client;
    }

    public boolean equalsClientPassword(String email, String password) throws DBException {
        boolean result = false;
        String passwordClient;
        String query = "SELECT * FROM clients  WHERE clients.e_mail=?";
        try (Connection con = DataSource.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    passwordClient = rs.getString(Fields.PASSWORD);
                    if (passwordClient.equals(password)) {
                        result = true;
                    }
                }
            }
        } catch (SQLException e) {
            LOG.info("SQLException in equalsClientPassword method");
            return result;
        }
        return result;
    }
}
