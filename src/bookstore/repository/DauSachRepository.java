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

    public void addDauSach(DauSachModel dauSach) throws SQLException {
        add(INSERT_QUERY, dauSach.getTuaSach(), dauSach.getTomTat(), dauSach.getSl(), dauSach.getMaNN(), dauSach.getMaVT());
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
}
