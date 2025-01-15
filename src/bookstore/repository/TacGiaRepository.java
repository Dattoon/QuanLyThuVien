package bookstore.repository;

import bookstore.model.TacGiaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacGiaRepository extends BaseRepository<TacGiaModel> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM TacGia";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM TacGia WHERE MaTG = ?";
    private static final String SELECT_BY_DAUSACH_ID_QUERY = 
        "SELECT TG.* FROM TacGia TG " +
        "JOIN SachTacGia STG ON TG.MaTG = STG.MaTG " +
        "WHERE STG.MaSach = ?";
    private static final String INSERT_TACGIA_QUERY = "INSERT INTO TacGia (TenTG, DiaChiTG) VALUES (?, ?)";
    private static final String UPDATE_TACGIA_QUERY = "UPDATE TacGia SET TenTG = ?, DiaChiTG = ? WHERE MaTG = ?";
    private static final String DELETE_TACGIA_QUERY = "DELETE FROM TacGia WHERE MaTG = ?";

    public List<TacGiaModel> getAllTacGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, resultSet -> new TacGiaModel(
                resultSet.getInt("MaTG"),
                resultSet.getString("TenTG"),
                resultSet.getString("DiaChiTG")
        ));
    }

    public TacGiaModel getTacGiaById(int maTG) throws SQLException {
        return getOne(SELECT_BY_ID_QUERY, resultSet -> new TacGiaModel(
                resultSet.getInt("MaTG"),
                resultSet.getString("TenTG"),
                resultSet.getString("DiaChiTG")
        ), maTG);
    }

    public List<TacGiaModel> getTacGiaByDauSachId(int maSach) throws SQLException {
        return getAll(SELECT_BY_DAUSACH_ID_QUERY, resultSet -> new TacGiaModel(
                resultSet.getInt("MaTG"),
                resultSet.getString("TenTG"),
                resultSet.getString("DiaChiTG")
        ), maSach);
    }

    public List<String> getAllTacGiaNames() throws SQLException {
        String query = "SELECT TenTG FROM TacGia";
        List<String> names = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                names.add(resultSet.getString("TenTG"));
            }
        }
        return names;
    }

    public int addTacGia(TacGiaModel tacGia) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TACGIA_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, tacGia.getTenTG());
            statement.setString(2, tacGia.getDiaChiTG());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating author failed, no ID obtained.");
                }
            }
        }
    }

    public void updateTacGia(TacGiaModel tacGia) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TACGIA_QUERY)) {
            statement.setString(1, tacGia.getTenTG());
            statement.setString(2, tacGia.getDiaChiTG());
            statement.setInt(3, tacGia.getMaTG());
            statement.executeUpdate();
        }
    }

    public void deleteTacGia(int maTacGia) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TACGIA_QUERY)) {
            statement.setInt(1, maTacGia);
            statement.executeUpdate();
        }
    }
}
