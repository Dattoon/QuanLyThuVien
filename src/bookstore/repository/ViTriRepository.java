package bookstore.repository;

import bookstore.model.ViTriModel;
import java.sql.*;
import java.util.List;


public class ViTriRepository extends BaseRepository<ViTriModel> {

    private static final String INSERT_QUERY = "INSERT INTO ViTri (Khu, Ke, Ngan) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE ViTri SET Khu = ?, Ke = ?, Ngan = ? WHERE MaVT = ?";
    private static final String DELETE_QUERY = "DELETE FROM ViTri WHERE MaVT = ?";
    private static final String SELECT_QUERY = "SELECT * FROM ViTri WHERE MaVT = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ViTri";

    public void addViTri(ViTriModel viTri) throws SQLException {
        add(INSERT_QUERY, viTri.getKhu(), viTri.getKe(), viTri.getNgan());
    }

    public void updateViTri(ViTriModel viTri) throws SQLException {
        edit(UPDATE_QUERY, viTri.getKhu(), viTri.getKe(), viTri.getNgan(), viTri.getMaVT());
    }

    public void deleteViTri(int maVT) throws SQLException {
        delete(DELETE_QUERY, maVT);
    }

    public ViTriModel getViTriById(int maVT) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<ViTriModel>() {
            @Override
            public ViTriModel mapRow(ResultSet resultSet) throws SQLException {
                return new ViTriModel(
                        resultSet.getInt("MaVT"),
                        resultSet.getString("Khu"),
                        resultSet.getString("Ke"),
                        resultSet.getString("Ngan")
                );
            }
        }, maVT);
    }

    public List<ViTriModel> getAllViTri() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<ViTriModel>() {
            @Override
            public ViTriModel mapRow(ResultSet resultSet) throws SQLException {
                return new ViTriModel(
                        resultSet.getInt("MaVT"),
                        resultSet.getString("Khu"),
                        resultSet.getString("Ke"),
                        resultSet.getString("Ngan")
                );
            }
        });
    }
}
