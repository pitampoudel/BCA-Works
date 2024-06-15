package pitam.jdbc;

import java.sql.*;
import java.sql.SQLException;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "localhost";
        String username = "root";
        String password = "";
        String query = "insert into users values( 'test user')";

        // Loading and registering drivers
        Class.forName("com.mysql.jdbc.Driver");

        // Obtain a connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        int count = st.executeUpdate(query);
        System.out.println("number of rows affected by this query= " + count);

        // Closing the connection as per the
        // requirement with connection is completed
        con.close();
    }
}
