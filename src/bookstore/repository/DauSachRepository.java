package bookstore.repository;

import bookstore.model.DauSachModel;
import java.sql.*;
import java.util.List;

public class DauSachRepository extends BaseRepository<DauSachModel> {

    private static final String INSERT_QUERY = "INSERT INTO DauSach (TuaSach, TomTat, SL, MaNN, MaVT) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE DauSach SET TuaSach = ?, TomTat = ?, SL = ?, MaNN = ?, MaVT = ? WHERE MaSach = ?";
    private static final String DELETE_QUERY = "DELETE FROM DauSach WHERE MaSach = ?";
    private static final String SELECT_QUERY = "SELECT * FROM DauSach WHERE MaSach = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DauSach";
    private static final String SELECT_TUA_SACH_BY_MA_SACH = "SELECT TuaSach FROM DauSach WHERE MaSach = ?";

    public int addDauSach(DauSachModel dauSach) throws SQLException {
        int maSach = 0;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, dauSach.getTuaSach());
            statement.setString(2, dauSach.getTomTat());
            statement.setInt(3, dauSach.getSl());
            statement.setInt(4, dauSach.getMaNN());
            statement.setInt(5, dauSach.getMaVT());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    maSach = generatedKeys.getInt(1);
                }
            }
        }
        return maSach;
    }

    public void updateDauSach(DauSachModel dauSach) throws SQLException {
        edit(UPDATE_QUERY, dauSach.getTuaSach(), dauSach.getTomTat(), dauSach.getSl(), dauSach.getMaNN(), dauSach.getMaVT(), dauSach.getMaSach());
    }

    public void deleteDauSach(int maSach) throws SQLException {
        delete(DELETE_QUERY, maSach);
    }

    public DauSachModel getDauSachById(int maSach) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<DauSachModel>() {
            @Override
            public DauSachModel mapRow(ResultSet resultSet) throws SQLException {
                return new DauSachModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getString("TuaSach"),
                        resultSet.getString("TomTat"),
                        resultSet.getInt("SL"),
                        resultSet.getInt("MaNN"),
                        resultSet.getInt("MaVT")
                );
            }
        }, maSach);
    }

    public List<DauSachModel> getAllDauSach() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<DauSachModel>() {
            @Override
            public DauSachModel mapRow(ResultSet resultSet) throws SQLException {
                return new DauSachModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getString("TuaSach"),
                        resultSet.getString("TomTat"),
                        resultSet.getInt("SL"),
                        resultSet.getInt("MaNN"),
                        resultSet.getInt("MaVT")
                );
            }
        });
    }

    public void decrementSL(int maSach) throws SQLException {
        String query = "UPDATE DauSach SET SL = SL - 1 WHERE MaSach = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSach);
            stmt.executeUpdate();
        }
    }

    public String getTuaSachByMaSach(int maSach) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_TUA_SACH_BY_MA_SACH)) {
            stmt.setInt(1, maSach);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("TuaSach");
                }
            }
        }
        return null;
    }
}
