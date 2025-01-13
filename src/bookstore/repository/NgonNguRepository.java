package bookstore.repository;

import bookstore.model.NgonNguModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NgonNguRepository extends BaseRepository<NgonNguModel> {

	private static final String INSERT_QUERY = "INSERT INTO NgonNgu (TenNN) VALUES (?)";
	private static final String UPDATE_QUERY = "UPDATE NgonNgu SET TenNN = ? WHERE MaNN = ?";
	private static final String DELETE_QUERY = "DELETE FROM NgonNgu WHERE MaNN = ?";
	private static final String SELECT_QUERY = "SELECT * FROM NgonNgu WHERE MaNN = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM NgonNgu";
    private static final String SELECT_TEN_NGON_NGU = "SELECT TenNN FROM NgonNgu WHERE MaNN = ?";
    
    private static final String GET_ALL_NGON_NGU_NAMES_QUERY = "SELECT TenNN FROM NgonNgu";



	public void addNgonNgu(NgonNguModel ngonNgu) throws SQLException {
		add(INSERT_QUERY, ngonNgu.getTenNN());
	}

	public void updateNgonNgu(NgonNguModel ngonNgu) throws SQLException {
		edit(UPDATE_QUERY, ngonNgu.getTenNN(), ngonNgu.getMaNN());
	}

	public void deleteNgonNgu(int maNN) throws SQLException {
		delete(DELETE_QUERY, maNN);
	}

	public NgonNguModel getNgonNguById(int maNN) throws SQLException {
		return getOne(SELECT_QUERY, new RowMapper<NgonNguModel>() {
			@Override
			public NgonNguModel mapRow(ResultSet resultSet) throws SQLException {
				return new NgonNguModel(resultSet.getInt("MaNN"), resultSet.getString("TenNN"));
			}
		}, maNN);
	}

	public List<NgonNguModel> getAllNgonNgu() {
		List<NgonNguModel> list = new ArrayList<>();
		String query = "SELECT * FROM NgonNgu";
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				list.add(new NgonNguModel(rs.getInt("MaNN"), rs.getString("TenNN")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public String getTenNgonNguById(int maNN) throws SQLException {
	    String query = "SELECT TenNN FROM NgonNgu WHERE MaNN = ?";
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, maNN);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getString("TenNN");
	            }
	        }
	    }
	    return null; // Trả về null nếu không tìm thấy
	}

	public List<String> getAllNgonNguNames() {
        List<String> ngonNguNames = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_NGON_NGU_NAMES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ngonNguNames.add(resultSet.getString("TenNN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ngonNguNames;
    }
	

}
