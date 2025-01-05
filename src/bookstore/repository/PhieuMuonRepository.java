package bookstore.repository;

import bookstore.model.PhieuMuonModel;
import java.sql.*;
import java.util.List;

public class PhieuMuonRepository extends BaseRepository<PhieuMuonModel> {

    private static final String INSERT_QUERY = "INSERT INTO PhieuMuon (NgayMuon, NgayHetHan, MaDK) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE PhieuMuon SET NgayMuon = ?, NgayHetHan = ?, MaDK = ? WHERE MaMuon = ?";
    private static final String DELETE_QUERY = "DELETE FROM PhieuMuon WHERE MaMuon = ?";
    private static final String SELECT_QUERY = "SELECT * FROM PhieuMuon WHERE MaMuon = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PhieuMuon";

    public void addPhieuMuon(PhieuMuonModel phieuMuon) throws SQLException {
        add(INSERT_QUERY, phieuMuon.getNgayMuon(), phieuMuon.getNgayHetHan(), phieuMuon.getMaDK());
    }

    public void updatePhieuMuon(PhieuMuonModel phieuMuon) throws SQLException {
        edit(UPDATE_QUERY, phieuMuon.getNgayMuon(), phieuMuon.getNgayHetHan(), phieuMuon.getMaDK(), phieuMuon.getMaMuon());
    }

    public void deletePhieuMuon(int maMuon) throws SQLException {
        delete(DELETE_QUERY, maMuon);
    }

    public PhieuMuonModel getPhieuMuonById(int maMuon) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<PhieuMuonModel>() {
            @Override
            public PhieuMuonModel mapRow(ResultSet resultSet) throws SQLException {
                return new PhieuMuonModel(
                        resultSet.getInt("MaMuon"),
                        resultSet.getDate("NgayMuon").toString(),
                        resultSet.getDate("NgayHetHan").toString(),
                        resultSet.getInt("MaDK")
                );
            }
        }, maMuon);
    }

    public List<PhieuMuonModel> getAllPhieuMuon() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<PhieuMuonModel>() {
            @Override
            public PhieuMuonModel mapRow(ResultSet resultSet) throws SQLException {
                return new PhieuMuonModel(
                        resultSet.getInt("MaMuon"),
                        resultSet.getDate("NgayMuon").toString(),
                        resultSet.getDate("NgayHetHan").toString(),
                        resultSet.getInt("MaDK")
                );
            }
        });
    }
}
