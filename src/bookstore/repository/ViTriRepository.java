package bookstore.repository;

import bookstore.model.ViTriModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ViTriRepository extends BaseRepository<ViTriModel> {

    private static final String INSERT_QUERY = "INSERT INTO ViTri (Khu, Ke, Ngan) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE ViTri SET Khu = ?, Ke = ?, Ngan = ? WHERE MaVT = ?";
    private static final String DELETE_QUERY = "DELETE FROM ViTri WHERE MaVT = ?";
    private static final String SELECT_QUERY = "SELECT * FROM ViTri WHERE MaVT = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ViTri";
    private static final String SELECT_TEN_VI_TRI = "SELECT TenVT FROM ViTri WHERE MaVT = ?";
    
    private static final String GET_ALL_VI_TRI_NAMES_QUERY = "SELECT TenVT FROM ViTri";


    public void addViTri(ViTriModel viTri) throws SQLException {
        add(INSERT_QUERY, viTri.getKhu(), viTri.getKe(), viTri.getNgan());
    }

    public void updateViTri(ViTriModel viTri) throws SQLException {
        edit(UPDATE_QUERY, viTri.getKhu(), viTri.getKe(), viTri.getNgan(), viTri.getMaVT());
    }

    public void deleteViTri(int maVT) throws SQLException {
        delete(DELETE_QUERY, maVT);
    }

    public ViTriModel getViTriById(int maVT) throws SQLException {
        String query = "SELECT Khu, Ke, Ngan FROM ViTri WHERE MaVT = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maVT);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ViTriModel(maVT, rs.getString("Khu"), rs.getString("Ke"), rs.getString("Ngan"));
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }


   
	    public List<ViTriModel> getAllViTri() {
	        List<ViTriModel> list = new ArrayList<>();
	        String query = "SELECT * FROM ViTri";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                list.add(new ViTriModel(rs.getInt("MaVT"), rs.getString("Khu"), rs.getString("Ke"), rs.getString("Ngan")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
    
    

    
    
    
    public List<String> getAllViTriNames() {
        List<String> viTriNames = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_VI_TRI_NAMES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                viTriNames.add(resultSet.getString("TenVT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viTriNames;
    }
    
    

    

}
