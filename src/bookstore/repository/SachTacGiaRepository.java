package bookstore.repository;

import bookstore.model.SachTacGiaModel;
import java.sql.*;
import java.util.List;

public class SachTacGiaRepository extends BaseRepository<SachTacGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO Sach_TacGia (MaSach, MaTG) VALUES (?, ?)";
    private static final String DELETE_BY_MASACH_QUERY = "DELETE FROM Sach_TacGia WHERE MaSach = ?";
    private static final String DELETE_QUERY = "DELETE FROM Sach_TacGia WHERE MaSach = ? AND MaTG = ?";
    private static final String SELECT_BY_MASACH_QUERY = "SELECT * FROM Sach_TacGia WHERE MaSach = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Sach_TacGia";

    public void addSachTacGia(int maSach, int maTG) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, maSach);
            statement.setInt(2, maTG);
            statement.executeUpdate();
        }
    }

    public void deleteSachTacGiaByMaSach(int maSach) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_MASACH_QUERY)) {
            statement.setInt(1, maSach);
            statement.executeUpdate();
        }
    }

    public void deleteSachTacGia(int maSach, int maTG) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, maSach);
            statement.setInt(2, maTG);
            statement.executeUpdate();
        }
    }

    public List<SachTacGiaModel> getSachTacGiaByMaSach(int maSach) throws SQLException {
        return getAll(SELECT_BY_MASACH_QUERY, new RowMapper<SachTacGiaModel>() {
            @Override
            public SachTacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new SachTacGiaModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getInt("MaTG")
                );
            }
        }, maSach);
    }

    public List<SachTacGiaModel> getAllSachTacGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<SachTacGiaModel>() {
            @Override
            public SachTacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new SachTacGiaModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getInt("MaTG")
                );
            }
        });
    }
}
