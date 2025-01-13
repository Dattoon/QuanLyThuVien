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

}