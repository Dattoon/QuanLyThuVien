package bookstore.repository;

import java.sql.*;

public class ReportRepository extends BaseRepository<Object> {

	public int countBooksBorrowed() throws SQLException {
		String query = "SELECT COUNT(*) FROM PhieuMuon";
		return count(query);
	}

	public int countOverdueBooks() throws SQLException {
		String query = "SELECT COUNT(*) FROM PhieuMuon WHERE NgayHetHan < CURDATE() AND MaMuon NOT IN (SELECT MaMuon FROM ChiTietPhieuMuon WHERE NgayTra IS NOT NULL)";
		return count(query);
	}

	public int countRegisteredReaders() throws SQLException {
		String query = "SELECT COUNT(*) FROM DocGia";
		return count(query);
	}

	public int count(String query) throws SQLException {
		int count = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		}
		return count;
	}
}
