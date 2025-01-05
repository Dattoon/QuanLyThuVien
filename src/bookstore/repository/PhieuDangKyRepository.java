package bookstore.repository;

import bookstore.model.PhieuDangKyModel;
import java.sql.*;
import java.util.List;

public class PhieuDangKyRepository extends BaseRepository<PhieuDangKyModel> {

    private static final String INSERT_QUERY = "INSERT INTO PhieuDangKy (NgayDK, MaDG) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE PhieuDangKy SET NgayDK = ?, MaDG = ? WHERE MaDK = ?";
    private static final String DELETE_QUERY = "DELETE FROM PhieuDangKy WHERE MaDK = ?";
    private static final String SELECT_QUERY = "SELECT * FROM PhieuDangKy WHERE MaDK = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PhieuDangKy";

    public void addPhieuDangKy(PhieuDangKyModel phieuDangKy) throws SQLException {
        add(INSERT_QUERY, phieuDangKy.getNgayDK(), phieuDangKy.getMaDG());
    }

    public void updatePhieuDangKy(PhieuDangKyModel phieuDangKy) throws SQLException {
        edit(UPDATE_QUERY, phieuDangKy.getNgayDK(), phieuDangKy.getMaDG(), phieuDangKy.getMaDK());
    }

    public void deletePhieuDangKy(int maDK) throws SQLException {
        delete(DELETE_QUERY, maDK);
    }

    public PhieuDangKyModel getPhieuDangKyById(int maDK) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<PhieuDangKyModel>() {
            @Override
            public PhieuDangKyModel mapRow(ResultSet resultSet) throws SQLException {
                return new PhieuDangKyModel(
                        resultSet.getInt("MaDK"),
                        resultSet.getDate("NgayDK").toString(),
                        resultSet.getInt("MaDG")
                );
            }
        }, maDK);
    }

    public List<PhieuDangKyModel> getAllPhieuDangKy() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<PhieuDangKyModel>() {
            @Override
            public PhieuDangKyModel mapRow(ResultSet resultSet) throws SQLException {
                return new PhieuDangKyModel(
                        resultSet.getInt("MaDK"),
                        resultSet.getDate("NgayDK").toString(),
                        resultSet.getInt("MaDG")
                );
            }
        });
    }
}
