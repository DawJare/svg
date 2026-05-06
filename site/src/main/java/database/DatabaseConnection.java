package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void connect(String path) {
        try {
            String url = "jdbc:sqlite:" + path;
            connection = DriverManager.getConnection(url);
            System.out.println("Połączono z bazą danych: " + path);
        } catch (SQLException e) {
            System.err.println("Błąd połączenia: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Rozłączono z bazą danych.");
            }
        } catch (SQLException e) {
            System.err.println("Błąd podczas rozłączania: " + e.getMessage());
        }
    }
}