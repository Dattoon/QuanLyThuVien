package bookstore.repository;

import bookstore.model.ChiTietPhieuMuonModel;
import java.sql.*;
import java.util.List;

public class ChiTietPhieuMuonRepository extends BaseRepository<ChiTietPhieuMuonModel> {

    private static final String INSERT_QUERY = "INSERT INTO ChiTietPhieuMuon (MaMuon, MaSach, NgayTra) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE ChiTietPhieuMuon SET MaMuon = ?, MaSach = ?, NgayTra = ? WHERE MaChiTiet = ?";
    private static final String DELETE_QUERY = "DELETE FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_QUERY = "SELECT * FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ChiTietPhieuMuon";
    private static final String SELECT_BY_MA_MUON_QUERY = "SELECT * FROM ChiTietPhieuMuon WHERE MaMuon = ?";

    public void addChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        add(INSERT_QUERY, chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra());
    }

    public void updateChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        edit(UPDATE_QUERY, chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra(), chiTietPhieuMuon.getMaChiTiet());
    }

    public void deleteChiTietPhieuMuon(int maChiTiet) throws SQLException {
        delete(DELETE_QUERY, maChiTiet);
    }

    public ChiTietPhieuMuonModel getChiTietPhieuMuonById(int maChiTiet) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<ChiTietPhieuMuonModel>() {
            @Override
            public ChiTietPhieuMuonModel mapRow(ResultSet rs) throws SQLException {
                return new ChiTietPhieuMuonModel(
                        rs.getInt("MaChiTiet"),
                        rs.getInt("MaMuon"),
                        rs.getInt("MaSach"),
                        rs.getDate("NgayTra")
                );
            }
        }, maChiTiet);
    }

    public List<ChiTietPhieuMuonModel> getAllChiTietPhieuMuon() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<ChiTietPhieuMuonModel>() {
            @Override
            public ChiTietPhieuMuonModel mapRow(ResultSet rs) throws SQLException {
                return new ChiTietPhieuMuonModel(
                        rs.getInt("MaChiTiet"),
                        rs.getInt("MaMuon"),
                        rs.getInt("MaSach"),
                        rs.getDate("NgayTra")
                );
            }
        });
    }

    public List<ChiTietPhieuMuonModel> getChiTietPhieuMuonByMaMuon(int maMuon) throws SQLException {
        return search(SELECT_BY_MA_MUON_QUERY, new RowMapper<ChiTietPhieuMuonModel>() {
            @Override
            public ChiTietPhieuMuonModel mapRow(ResultSet rs) throws SQLException {
                return new ChiTietPhieuMuonModel(
                        rs.getInt("MaChiTiet"),
                        rs.getInt("MaMuon"),
                        rs.getInt("MaSach"),
                        rs.getDate("NgayTra")
                );
            }
        }, maMuon);
    }
}
