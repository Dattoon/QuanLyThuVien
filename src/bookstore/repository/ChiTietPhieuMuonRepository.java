package bookstore.repository;

import bookstore.model.ChiTietPhieuMuonModel;
import java.sql.*;
import java.util.List;

public class ChiTietPhieuMuonRepository extends BaseRepository<ChiTietPhieuMuonModel> {

    private static final String INSERT_QUERY = "INSERT INTO ChiTietPhieuMuon (MaDK, MaMuon, MaSach, NgayTra) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE ChiTietPhieuMuon SET MaDK = ?, MaMuon = ?, MaSach = ?, NgayTra = ? WHERE MaChiTiet = ?";
    private static final String DELETE_QUERY = "DELETE FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_QUERY = "SELECT * FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ChiTietPhieuMuon";

    public void addChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        add(INSERT_QUERY, chiTietPhieuMuon.getMaDK(), chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra());
    }

    public void updateChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        edit(UPDATE_QUERY, chiTietPhieuMuon.getMaDK(), chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra(), chiTietPhieuMuon.getMaChiTiet());
    }

    public void deleteChiTietPhieuMuon(int maChiTiet) throws SQLException {
        delete(DELETE_QUERY, maChiTiet);
    }

    public ChiTietPhieuMuonModel getChiTietPhieuMuonById(int maChiTiet) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<ChiTietPhieuMuonModel>() {
            @Override
            public ChiTietPhieuMuonModel mapRow(ResultSet resultSet) throws SQLException {
                return new ChiTietPhieuMuonModel(
                        resultSet.getInt("MaChiTiet"),
                        resultSet.getInt("MaDK"),
                        resultSet.getInt("MaMuon"),
                        resultSet.getInt("MaSach"),
                        resultSet.getDate("NgayTra").toString()
                );
            }
        }, maChiTiet);
    }

    public List<ChiTietPhieuMuonModel> getAllChiTietPhieuMuon() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<ChiTietPhieuMuonModel>() {
            @Override
            public ChiTietPhieuMuonModel mapRow(ResultSet resultSet) throws SQLException {
                return new ChiTietPhieuMuonModel(
                        resultSet.getInt("MaChiTiet"),
                        resultSet.getInt("MaDK"),
                        resultSet.getInt("MaMuon"),
                        resultSet.getInt("MaSach"),
                        resultSet.getDate("NgayTra").toString()
                );
            }
        });
    }
}
