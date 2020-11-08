package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysqlforbindelse {
    private static Connection conn;

    private Mysqlforbindelse() {
    }

    public static Mysqlforbindelse getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=Europe/Amsterdam&amp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Mysqlforbindelse) conn;
    }

    public static void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

