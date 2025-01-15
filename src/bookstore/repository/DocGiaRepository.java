package bookstore.repository;

import bookstore.model.DocGiaModel;
import java.sql.*;
import java.util.List;

public class DocGiaRepository extends BaseRepository<DocGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO DocGia (TenDG, DiaChiDG, NgaySinh, DienThoai, MaThe, NgayHetHan) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE DocGia SET TenDG = ?, DiaChiDG = ?, NgaySinh = ?, DienThoai = ?, MaThe = ?, NgayHetHan = ? WHERE MaDG = ?";
    private static final String DELETE_QUERY = "DELETE FROM DocGia WHERE MaDG = ?";
    private static final String SELECT_QUERY = "SELECT * FROM DocGia WHERE MaDG = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DocGia";
    private static final String SELECT_BY_MA_THE_QUERY = "SELECT * FROM DocGia WHERE MaThe = ?";
    private static final String SELECT_QUERY_BY_MA_THE = "SELECT MaDG FROM DocGia WHERE MaThe = ?";
    private static final String SELECT_TEN_DG_BY_MA_DG = "SELECT TenDG FROM DocGia WHERE MaDG = ?";

    public void addDocGia(DocGiaModel docGia) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            stmt.setString(1, docGia.getTenDG());
            stmt.setString(2, docGia.getDiaChiDG());
            stmt.setDate(3, docGia.getNgaySinh());
            stmt.setString(4, docGia.getDienThoai());
            stmt.setString(5, docGia.getMaThe());
            stmt.setDate(6, docGia.getNgayHetHan());
            stmt.executeUpdate();
        }
    }

    public void updateDocGia(DocGiaModel docGia) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
            stmt.setString(1, docGia.getTenDG());
            stmt.setString(2, docGia.getDiaChiDG());
            stmt.setDate(3, docGia.getNgaySinh());
            stmt.setString(4, docGia.getDienThoai());
            stmt.setString(5, docGia.getMaThe());
            stmt.setDate(6, docGia.getNgayHetHan());
            stmt.setInt(7, docGia.getMaDG());
            stmt.executeUpdate();
        }
    }

    public void deleteDocGia(int maDG) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {
            stmt.setInt(1, maDG);
            stmt.executeUpdate();
        }
    }

    public DocGiaModel getDocGiaById(int maDG) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {
            stmt.setInt(1, maDG);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DocGiaModel(
                            rs.getInt("MaDG"),
                            rs.getString("TenDG"),
                            rs.getDate("NgaySinh"),
                            rs.getString("DiaChiDG"),
                            rs.getString("DienThoai"),
                            rs.getString("MaThe"),
                            rs.getDate("NgayHetHan")
                    );
                }
            }
        }
        return null;
    }

    public List<DocGiaModel> getAllDocGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<DocGiaModel>() {
            @Override
            public DocGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new DocGiaModel(
                        resultSet.getInt("MaDG"),
                        resultSet.getString("TenDG"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("DiaChiDG"),
                        resultSet.getString("DienThoai"),
                        resultSet.getString("MaThe"),
                        resultSet.getDate("NgayHetHan")
                );
            }
        });
    }

    public DocGiaModel getDocGiaByMaThe(String maThe) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_MA_THE_QUERY)) {
            stmt.setString(1, maThe);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DocGiaModel(
                            rs.getInt("MaDG"),
                            rs.getString("TenDG"),
                            rs.getDate("NgaySinh"),
                            rs.getString("DiaChiDG"),
                            rs.getString("DienThoai"),
                            rs.getString("MaThe"),
                            rs.getDate("NgayHetHan")
                    );
                }
            }
        }
        return null;
    }

    public int getMaDGByMaThe(String maThe) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_BY_MA_THE)) {
            preparedStatement.setString(1, maThe);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("MaDG");
                } else {
                    throw new SQLException("Mã thẻ không tồn tại.");
                }
            }
        }
    }

    public String getTenDGByMaDG(int maDG) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_TEN_DG_BY_MA_DG)) {
            stmt.setInt(1, maDG);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("TenDG");
                }
            }
        }
        return null;
    }
}
