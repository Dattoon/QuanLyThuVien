package bookstore.repository;

import bookstore.model.PhieuDangKyModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuDangKyRepository extends BaseRepository<PhieuDangKyModel>{

    private static final String INSERT_QUERY = "INSERT INTO PhieuDangKy (MaDG, NgayDK) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE PhieuDangKy SET MaDG = ?, NgayDK = ? WHERE MaDK = ?";
    private static final String DELETE_QUERY = "DELETE FROM PhieuDangKy WHERE MaDK = ?";
    private static final String SELECT_QUERY = "SELECT * FROM PhieuDangKy WHERE MaDK = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PhieuDangKy";

    public void addPhieuDangKy(PhieuDangKyModel phieuDangKy) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setInt(1, phieuDangKy.getMaDG());
            stmt.setDate(2, phieuDangKy.getNgayDK());
            stmt.executeUpdate();
        }
    }

    public void updatePhieuDangKy(PhieuDangKyModel phieuDangKy) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setInt(1, phieuDangKy.getMaDG());
            stmt.setDate(2, phieuDangKy.getNgayDK());
            stmt.setInt(3, phieuDangKy.getMaDK());
            stmt.executeUpdate();
        }
    }

    public void deletePhieuDangKy(int maDK) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {
            stmt.setInt(1, maDK);
            stmt.executeUpdate();
        }
    }

    public PhieuDangKyModel getPhieuDangKyById(int maDK) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setInt(1, maDK);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PhieuDangKyModel(
                            rs.getInt("MaDK"),
                            rs.getInt("MaDG"),
                            rs.getDate("NgayDK")
                    );
                }
            }
        }
        return null;
    }

    public List<PhieuDangKyModel> getAllPhieuDangKy() throws SQLException {
        List<PhieuDangKyModel> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new PhieuDangKyModel(
                        rs.getInt("MaDK"),
                        rs.getInt("MaDG"),
                        rs.getDate("NgayDK")
                ));
            }
        }
        return list;
    }

  
}
