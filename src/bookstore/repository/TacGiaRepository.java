package bookstore.repository;

import bookstore.model.TacGia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacGiaRepository {

    private Connection connection;

    public TacGiaRepository() {
        // Kết nối đến cơ sở dữ liệu (Cần chắc chắn rằng connection được thiết lập đúng cách)
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLTV", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức thêm tác giả vào cơ sở dữ liệu
    public boolean addTacGia(TacGia tacGia) throws SQLException {
        String query = "INSERT INTO TacGia (MaTG, TenTG, DiaChiTG) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tacGia.getMaTG());
            stmt.setString(2, tacGia.getTenTG());
            stmt.setString(3, tacGia.getDiaChiTG());

            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức lấy danh sách tất cả tác giả từ cơ sở dữ liệu
    public List<TacGia> getAllTacGia() throws SQLException {
        List<TacGia> tacGiaList = new ArrayList<>();
        String query = "SELECT * FROM TacGia";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String maTG = rs.getString("MaTG");
                String tenTG = rs.getString("TenTG");
                String diaChiTG = rs.getString("DiaChiTG");

                TacGia tacGia = new TacGia(maTG, tenTG, diaChiTG);
                tacGiaList.add(tacGia);
            }
        }

        return tacGiaList;
    }
}
