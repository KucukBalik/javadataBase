package ie.atu.week6sem2;

import java.sql.*;
import java.util.Scanner;

public class DeleteClass {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "EmrePassword24.";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username to delete: ");
        String userName = scanner.nextLine();

        String deleteSQL = "DELETE FROM users WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {

            // Set the username in the query
            pstmt.setString(1, userName);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User '" + userName + "' deleted successfully.");
            } else {
                System.out.println("No user found with username: " + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
