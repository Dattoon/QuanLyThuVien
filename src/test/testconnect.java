package test;

import java.sql.Connection;
import java.sql.SQLException;
import bookstore.repository.DatabaseConnection;

public class testconnect {
    public static void main(String[] args) {
        testconnect tester = new testconnect();
        tester.testConnection();
    }

    public void testConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
