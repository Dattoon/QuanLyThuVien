package bookstore.repository;

import bookstore.model.SachTacGiaModel;
import java.sql.*;
import java.util.List;

public class SachTacGiaRepository extends BaseRepository<SachTacGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO Sach_TacGia (MaSach, MaTG) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Sach_TacGia SET MaTG = ? WHERE MaSach = ?";
    private static final String DELETE_QUERY = "DELETE FROM Sach_TacGia WHERE MaSach = ? AND MaTG = ?";
    private static final String SELECT_QUERY = "SELECT * FROM Sach_TacGia WHERE MaSach = ? AND MaTG = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Sach_TacGia";

    public void addSachTacGia(SachTacGiaModel sachTacGia) throws SQLException {
        add(INSERT_QUERY, sachTacGia.getMaSach(), sachTacGia.getMaTG());
    }

    public void updateSachTacGia(SachTacGiaModel sachTacGia) throws SQLException {
        edit(UPDATE_QUERY, sachTacGia.getMaTG(), sachTacGia.getMaSach());
    }

    public void deleteSachTacGia(int maSach, int maTG) throws SQLException {
        delete(DELETE_QUERY, maSach, maTG);
    }

    public SachTacGiaModel getSachTacGiaById(int maSach, int maTG) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<SachTacGiaModel>() {
            @Override
            public SachTacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new SachTacGiaModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getInt("MaTG")
                );
            }
        }, maSach, maTG);
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
