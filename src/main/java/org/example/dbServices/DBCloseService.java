package org.example.dbServices;

import org.example.DBException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCloseService {
    static void close(AutoCloseable con) throws DBException {
        if (con != null)
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new DBException("DBException", e);
            }
    }

    static void rollBack(Connection con) throws DBException {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("DBException", e);
        }
    }

    static void setAutocommit(Connection con, boolean value) throws DBException {
        try {
            con.setAutoCommit(value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException("DBException", e);
        }
    }
}
