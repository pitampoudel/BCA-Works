package pitam.login;

import java.sql.*;

public class UsersData {
    private static final String URL = "jdbc:mysql://localhost:3306/demoapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    Connection con;

    public void closeConnection() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public UsersData() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean isValidUser(String username, String password) {

        // Use a prepared statement to prevent SQL injection
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);

            try (ResultSet result = pst.executeQuery()) {
                if (result.next()) {
                    String storedHash = result.getString("hashed_password");
                    // TODO compare the password
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }


}
