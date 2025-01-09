package bookstore.repository;

import bookstore.model.TacGiaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacGiaRepository extends BaseRepository<TacGiaModel> {
    private static final String SELECT_BY_MASACH_QUERY = "SELECT TG.* FROM TacGia TG "
            + "JOIN Sach_TacGia STG ON TG.MaTG = STG.MaTG " + "WHERE STG.MaSach = ?";

    // Thêm một tác giả mới vào cơ sở dữ liệu
    public void addTacGia(TacGiaModel tacGia) throws SQLException {
        String query = "INSERT INTO TacGia (TenTG, DiaChiTG) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tacGia.getTenTG());
            stmt.setString(2, tacGia.getDiaChiTG());
            stmt.executeUpdate();
        }
    }

    // Cập nhật thông tin một tác giả
    public void updateTacGia(TacGiaModel tacGia) throws SQLException {
        String query = "UPDATE TacGia SET TenTG = ?, DiaChiTG = ? WHERE MaTG = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tacGia.getTenTG());
            stmt.setString(2, tacGia.getDiaChiTG());
            stmt.setInt(3, tacGia.getMaTG());
            stmt.executeUpdate();
        }
    }

    // Xóa một tác giả khỏi cơ sở dữ liệu
    public void deleteTacGia(int maTG) throws SQLException {
        String query = "DELETE FROM TacGia WHERE MaTG = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maTG);
            stmt.executeUpdate();
        }
    }

    // Lấy thông tin một tác giả theo mã tác giả
    public TacGiaModel getTacGiaById(int maTG) throws SQLException {
        String query = "SELECT * FROM TacGia WHERE MaTG = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maTG);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TacGiaModel(rs.getInt("MaTG"), rs.getString("TenTG"), rs.getString("DiaChiTG"));
                }
            }
        }
        return null;
    }

    // Lấy danh sách tất cả tác giả
    public List<TacGiaModel> getAllTacGia() {
        List<TacGiaModel> list = new ArrayList<>();
        String query = "SELECT * FROM TacGia";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new TacGiaModel(rs.getInt("MaTG"), rs.getString("TenTG"), rs.getString("DiaChiTG")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    // Tìm kiếm tác giả theo từ khóa
    public List<TacGiaModel> searchTacGia(String keyword) throws SQLException {
        String searchKeyword = "%" + keyword + "%";
        List<TacGiaModel> list = new ArrayList<>();
        String query = "SELECT * FROM TacGia WHERE TenTG LIKE ? OR DiaChiTG LIKE ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, searchKeyword);
            stmt.setString(2, searchKeyword);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new TacGiaModel(rs.getInt("MaTG"), rs.getString("TenTG"), rs.getString("DiaChiTG")));
                }
            }
        }
        return list;
    }

    // Lấy danh sách tác giả theo mã sách
    public List<TacGiaModel> getTacGiaByDauSachId(int maSach) throws SQLException {
        return getAll(SELECT_BY_MASACH_QUERY, new RowMapper<TacGiaModel>() {
            @Override
            public TacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new TacGiaModel(resultSet.getInt("MaTG"), resultSet.getString("TenTG"), resultSet.getString("DiaChiTG"));
            }
        }, maSach);
    }
}
