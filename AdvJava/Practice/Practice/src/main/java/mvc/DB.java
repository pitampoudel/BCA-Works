package mvc;

import java.sql.*;

public class DB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/adv_java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    public void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }

    public void validateUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
            }
        }
    }

    public void insertUser(String username, String password) throws SQLException {
        String query = "INSERT INTO users (username ,password) VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        int k = stmt.executeUpdate(Statement.RETURN_GENERATED_KEYS);

    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
