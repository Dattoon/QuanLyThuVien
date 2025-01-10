package bookstore.repository;

import bookstore.model.PhieuDangKyModel;
import java.sql.*;
import java.util.List;

public class PhieuDangKyRepository extends BaseRepository<PhieuDangKyModel> {

    private static final String INSERT_QUERY = "INSERT INTO PhieuDangKy (NgayDK, MaDG) VALUES (?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM PhieuDangKy WHERE MaDK = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PhieuDangKy";
    private static final String DELETE_QUERY = "DELETE FROM PhieuDangKy WHERE MaDK = ?";

    public void addPhieuDangKy(PhieuDangKyModel phieuDangKy) throws SQLException {
        add(INSERT_QUERY, phieuDangKy.getNgayDK(), phieuDangKy.getMaDG());
    }

    public PhieuDangKyModel getPhieuDangKyById(int maDK) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<PhieuDangKyModel>() {
            @Override
            public PhieuDangKyModel mapRow(ResultSet rs) throws SQLException {
                return new PhieuDangKyModel(
                    rs.getInt("MaDK"),
                    rs.getInt("	"),
                    rs.getDate("NgayDK")
                );
            }
        }, maDK);
    }

    public List<PhieuDangKyModel> getAllPhieuDangKy() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<PhieuDangKyModel>() {
            @Override
            public PhieuDangKyModel mapRow(ResultSet rs) throws SQLException {
                return new PhieuDangKyModel(
                    rs.getInt("MaDK"),
                    rs.getInt("MaDG"),
                    rs.getDate("NgayDK")
                );
            }
        });
    }

    public void deletePhieuDangKy(int maDK) throws SQLException {
        delete(DELETE_QUERY, maDK);
    }
}
