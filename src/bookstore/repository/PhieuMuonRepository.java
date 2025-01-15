package bookstore.repository;

import bookstore.model.PhieuMuonModel;
import java.sql.*;
import java.util.List;

public class PhieuMuonRepository extends BaseRepository<PhieuMuonModel> {

	private static final String INSERT_QUERY = "INSERT INTO PhieuMuon (NgayMuon, NgayHetHan, MaDG, MaSach) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE PhieuMuon SET NgayMuon = ?, NgayHetHan = ?, MaDG = ?, MaSach = ? WHERE MaMuon = ?";
	private static final String DELETE_QUERY = "DELETE FROM PhieuMuon WHERE MaMuon = ?";
	private static final String SELECT_QUERY = "SELECT * FROM PhieuMuon WHERE MaMuon = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM PhieuMuon";

	public void addPhieuMuon(PhieuMuonModel phieuMuon) throws SQLException {
		add(INSERT_QUERY, phieuMuon.getNgayMuon(), phieuMuon.getNgayHetHan(), phieuMuon.getMaDG(),
				phieuMuon.getMaSach());
	}

	public void updatePhieuMuon(PhieuMuonModel phieuMuon) throws SQLException {
		edit(UPDATE_QUERY, phieuMuon.getNgayMuon(), phieuMuon.getNgayHetHan(), phieuMuon.getMaDG(),
				phieuMuon.getMaSach(), phieuMuon.getMaMuon());
	}

	public void deletePhieuMuon(int maMuon) throws SQLException {
		String sql = "DELETE FROM PhieuMuon WHERE MaMuon = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, maMuon);
			pstmt.executeUpdate();
		}
	}

	public PhieuMuonModel getPhieuMuonById(int maMuon) throws SQLException {
		return getOne(SELECT_QUERY, new RowMapper<PhieuMuonModel>() {
			@Override
			public PhieuMuonModel mapRow(ResultSet rs) throws SQLException {
				return new PhieuMuonModel(rs.getInt("MaMuon"), rs.getDate("NgayMuon"), rs.getDate("NgayHetHan"),
						rs.getInt("MaDG"), rs.getInt("MaSach"));
			}
		}, maMuon);
	}

	public List<PhieuMuonModel> getAllPhieuMuon() throws SQLException {
		return getAll(SELECT_ALL_QUERY, new RowMapper<PhieuMuonModel>() {
			@Override
			public PhieuMuonModel mapRow(ResultSet rs) throws SQLException {
				return new PhieuMuonModel(rs.getInt("MaMuon"), rs.getDate("NgayMuon"), rs.getDate("NgayHetHan"),
						rs.getInt("MaDG"), rs.getInt("MaSach"));
			}
		});
	}

	public List<PhieuMuonModel> getPhieuMuonByMaDG(int maDG) throws SQLException {
		String query = "SELECT pm.MaMuon, ds.MaSach, ds.TuaSach, dg.TenDG, pm.NgayMuon, pm.NgayHetHan "
				+ "FROM PhieuMuon pm " + "JOIN DauSach ds ON pm.MaSach = ds.MaSach "
				+ "JOIN DocGia dg ON pm.MaDG = dg.MaDG " + "WHERE pm.MaDG = ?";

		return getAll(query, new RowMapper<PhieuMuonModel>() {
			@Override
			public PhieuMuonModel mapRow(ResultSet rs) throws SQLException {
				return new PhieuMuonModel(rs.getInt("MaMuon"), rs.getInt("MaSach"), rs.getString("TuaSach"),
						rs.getString("TenDG"), rs.getDate("NgayMuon"), rs.getDate("NgayHetHan"));
			}
		}, maDG);
	}

	public void incrementSL(int maSach) throws SQLException {
		String query = "UPDATE DauSach SET SL = SL + 1 WHERE MaSach = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, maSach);
			stmt.executeUpdate();
		}
	}

	public void deleteChiTietPhieuMuonByMaMuon(int maMuon) throws SQLException {
		String sql = "DELETE FROM chitietphieumuon WHERE MaMuon = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, maMuon);
			pstmt.executeUpdate();
		}
	}
	

}
