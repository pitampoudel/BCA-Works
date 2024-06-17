package pitam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    private static final String URL = "jdbc:mysql://localhost:3306/demoapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Obtain a connection
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        boolean wasAcknowledged = st.execute("SELECT * FROM users");
        if (wasAcknowledged) {

        }

        con.close();
    }
}
