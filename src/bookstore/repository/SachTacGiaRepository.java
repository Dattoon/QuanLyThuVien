package bookstore.repository;

import bookstore.model.SachTacGiaModel;

import java.sql.SQLException;
import java.util.List;

public class SachTacGiaRepository extends BaseRepository<SachTacGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO sach_tacgia (MaSach, MaTG) VALUES (?, ?)";
    private static final String DELETE_BY_MASACH_QUERY = "DELETE FROM sach_tacgia WHERE MaSach = ?";
    private static final String DELETE_BY_MATACGIA_QUERY = "DELETE FROM sach_tacgia WHERE MaTG = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM sach_tacgia";

    public void addSachTacGia(int maSach, int maTacGia) throws SQLException {
        add(INSERT_QUERY, maSach, maTacGia);
    }

    public void deleteSachTacGiaByMaSach(int maSach) throws SQLException {
        delete(DELETE_BY_MASACH_QUERY, maSach);
    }

    public void deleteSachTacGiaByMaTacGia(int maTacGia) throws SQLException {
        delete(DELETE_BY_MATACGIA_QUERY, maTacGia);
    }

    public List<SachTacGiaModel> getAllSachTacGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<SachTacGiaModel>() {
            @Override
            public SachTacGiaModel mapRow(java.sql.ResultSet resultSet) throws SQLException {
                return new SachTacGiaModel(
                        resultSet.getInt("MaSach"),
                        resultSet.getInt("MaTG")
                );
            }
        });
    }
}
