package bookstore.repository;

import bookstore.model.NgonNguModel;
import java.sql.*;
import java.util.List;

public class NgonNguRepository extends BaseRepository<NgonNguModel> {

    private static final String INSERT_QUERY = "INSERT INTO NgonNgu (TenNN) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE NgonNgu SET TenNN = ? WHERE MaNN = ?";
    private static final String DELETE_QUERY = "DELETE FROM NgonNgu WHERE MaNN = ?";
    private static final String SELECT_QUERY = "SELECT * FROM NgonNgu WHERE MaNN = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM NgonNgu";

    public void addNgonNgu(NgonNguModel ngonNgu) throws SQLException {
        add(INSERT_QUERY, ngonNgu.getTenNN());
    }

    public void updateNgonNgu(NgonNguModel ngonNgu) throws SQLException {
        edit(UPDATE_QUERY, ngonNgu.getTenNN(), ngonNgu.getMaNN());
    }

    public void deleteNgonNgu(int maNN) throws SQLException {
        delete(DELETE_QUERY, maNN);
    }

    public NgonNguModel getNgonNguById(int maNN) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<NgonNguModel>() {
            @Override
            public NgonNguModel mapRow(ResultSet resultSet) throws SQLException {
                return new NgonNguModel(
                        resultSet.getInt("MaNN"),
                        resultSet.getString("TenNN")
                );
            }
        }, maNN);
    }

    public List<NgonNguModel> getAllNgonNgu() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<NgonNguModel>() {
            @Override
            public NgonNguModel mapRow(ResultSet resultSet) throws SQLException {
                return new NgonNguModel(
                        resultSet.getInt("MaNN"),
                        resultSet.getString("TenNN")
                );
            }
        });
    }
}
