package bookstore.repository;

import bookstore.model.ChiTietPhieuMuonModel;
import java.sql.*;
import java.util.List;

public class ChiTietPhieuMuonRepository extends BaseRepository<ChiTietPhieuMuonModel> {

    private static final String INSERT_QUERY = "INSERT INTO ChiTietPhieuMuon (MaMuon, MaSach, NgayTra, TienPhat) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE ChiTietPhieuMuon SET MaMuon = ?, MaSach = ?, NgayTra = ?, TienPhat = ? WHERE MaChiTiet = ?";
    private static final String DELETE_QUERY = "DELETE FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_QUERY = "SELECT * FROM ChiTietPhieuMuon WHERE MaChiTiet = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ChiTietPhieuMuon";
    private static final String SELECT_BY_MA_MUON_QUERY = "SELECT * FROM ChiTietPhieuMuon WHERE MaMuon = ?";
    private static final String GET_NGAY_HET_HAN_QUERY = "SELECT NgayHetHan FROM phieumuon WHERE MaMuon = ?";
    private static final String UPDATE_TIEN_PHAT_QUERY = "UPDATE ChiTietPhieuMuon SET TienPhat = ? WHERE MaMuon = ?";

    public void addChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        add(INSERT_QUERY, chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra(), chiTietPhieuMuon.getTienPhat());
    }

    public void updateChiTietPhieuMuon(ChiTietPhieuMuonModel chiTietPhieuMuon) throws SQLException {
        edit(UPDATE_QUERY, chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getMaSach(), chiTietPhieuMuon.getNgayTra(), chiTietPhieuMuon.getTienPhat(), chiTietPhieuMuon.getMaChiTiet());
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
                    rs.getDate("NgayTra"),
                    rs.getFloat("TienPhat")
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
                    rs.getDate("NgayTra"),
                    rs.getFloat("TienPhat")
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
                    rs.getDate("NgayTra"),
                    rs.getFloat("TienPhat")
                );
            }
        }, maMuon);
    }

    public Date getNgayHetHan(int maMuon) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_NGAY_HET_HAN_QUERY)) {
            ps.setInt(1, maMuon);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDate("NgayHetHan");
                }
            }
        }
        return null;
    }
    public void updateTienPhat(int maMuon, float tienPhat) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_TIEN_PHAT_QUERY)) {
            if (tienPhat == 0) {
                ps.setNull(1, Types.FLOAT);
            } else {
                ps.setFloat(1, tienPhat);
            }
            ps.setInt(2, maMuon);
            ps.executeUpdate();
        }
    }
}
