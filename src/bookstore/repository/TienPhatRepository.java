package bookstore.repository;

import bookstore.model.TienPhatModel;
import java.sql.*;
import java.util.List;

public class TienPhatRepository extends BaseRepository<TienPhatModel> {

    private static final String INSERT_QUERY = "INSERT INTO TienPhat (MaChiTiet, TienPhat) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE TienPhat SET TienPhat = ? WHERE MaChiTiet = ?";
    private static final String DELETE_QUERY = "DELETE FROM TienPhat WHERE MaChiTiet = ?";
    private static final String SELECT_QUERY = "SELECT * FROM TienPhat WHERE MaChiTiet = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM TienPhat";

    public void addTienPhat(TienPhatModel tienPhat) throws SQLException {
        add(INSERT_QUERY, tienPhat.getMaChiTiet(), tienPhat.getTienPhat());
    }

    public void updateTienPhat(TienPhatModel tienPhat) throws SQLException {
        edit(UPDATE_QUERY, tienPhat.getTienPhat(), tienPhat.getMaChiTiet());
    }

    public void deleteTienPhat(int maChiTiet) throws SQLException {
        delete(DELETE_QUERY, maChiTiet);
    }

    public TienPhatModel getTienPhatById(int maChiTiet) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<TienPhatModel>() {
            @Override
            public TienPhatModel mapRow(ResultSet resultSet) throws SQLException {
                return new TienPhatModel(
                        resultSet.getInt("MaChiTiet"),
                        resultSet.getFloat("TienPhat")
                );
            }
        }, maChiTiet);
    }

    public List<TienPhatModel> getAllTienPhat() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<TienPhatModel>() {
            @Override
            public TienPhatModel mapRow(ResultSet resultSet) throws SQLException {
                return new TienPhatModel(
                        resultSet.getInt("MaChiTiet"),
                        resultSet.getFloat("TienPhat")
                );
            }
        });
    }
}
