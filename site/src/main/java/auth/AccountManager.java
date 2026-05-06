package auth;

import database.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountManager {
    private final DatabaseConnection db;

    public AccountManager(DatabaseConnection db) {
        this.db = db;
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT UNIQUE NOT NULL, " +
                "password_hash TEXT NOT NULL)";
        try (Statement stmt = db.getConnection().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Błąd przy tworzeniu tabeli accounts: " + e.getMessage());
        }
    }

    public void register(String username, String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        String sql = "INSERT INTO accounts (username, password_hash) VALUES (?, ?)";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hash);
            pstmt.executeUpdate();
            System.out.println("Zarejestrowano użytkownika: " + username);
        } catch (SQLException e) {
            System.err.println("Błąd rejestracji (być może nazwa jest zajęta): " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        String sql = "SELECT password_hash FROM accounts WHERE username = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password_hash");
                    return BCrypt.checkpw(password, storedHash);
                }
            }
        } catch (SQLException e) {
            System.err.println("Błąd autentykacji: " + e.getMessage());
        }
        return false;
    }

    public Account getAccount(String username) {
        String sql = "SELECT id, username FROM accounts WHERE username = ?";
        return queryAccount(sql, username);
    }

    public Account getAccount(int id) {
        String sql = "SELECT id, username FROM accounts WHERE id = ?";
        return queryAccount(sql, id);
    }

    private Account queryAccount(String sql, Object param) {
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            if (param instanceof String) {
                pstmt.setString(1, (String) param);
            } else {
                pstmt.setInt(1, (Integer) param);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(rs.getInt("id"), rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Błąd pobierania konta: " + e.getMessage());
        }
        return null;
    }
}