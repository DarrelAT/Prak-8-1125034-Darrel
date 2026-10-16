package hy.material8database.database;

import hy.material8database.config.AppConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                AppConfig.DB_URL, 
                AppConfig.DB_USER, 
                AppConfig.DB_PASSWORD
            );
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
        return connection;
    }
}