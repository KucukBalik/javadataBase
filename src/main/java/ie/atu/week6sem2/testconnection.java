package ie.atu.week6sem2;
import java.sql.*;

public class testconnection {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Attempt to load the MySQL JDBC Driver (this is optional with JDBC 4.0 and above)
            Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure you have the JDBC driver in your classpath

            // Attempt to create a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "EmrePassword24.");

            // If connection is successful
            System.out.println("Connection made to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            // Print any exception that occurs
            e.printStackTrace();
        } finally {
            // Close the connection when finished
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
