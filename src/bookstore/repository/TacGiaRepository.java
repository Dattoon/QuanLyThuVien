package bookstore.repository;

import bookstore.model.TacGiaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacGiaRepository extends BaseRepository<TacGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO TacGia (TenTG, DiaChiTG) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE TacGia SET TenTG = ?, DiaChiTG = ? WHERE MaTG = ?";
    private static final String DELETE_QUERY = "DELETE FROM TacGia WHERE MaTG = ?";
    private static final String SELECT_QUERY = "SELECT * FROM TacGia WHERE MaTG = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM TacGia";
    private static final String SEARCH_QUERY = "SELECT * FROM TacGia WHERE TenTG LIKE ? OR DiaChiTG LIKE ?";

    public void addTacGia(TacGiaModel tacGia) throws SQLException {
        add(INSERT_QUERY, tacGia.getTenTG(), tacGia.getDiaChiTG());
    }

    public void updateTacGia(TacGiaModel tacGia) throws SQLException {
        edit(UPDATE_QUERY, tacGia.getTenTG(), tacGia.getDiaChiTG(), tacGia.getMaTG());
    }

    public void deleteTacGia(int maTG) throws SQLException {
        delete(DELETE_QUERY, maTG);
    }

    public TacGiaModel getTacGiaById(int maTG) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<TacGiaModel>() {
            @Override
            public TacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new TacGiaModel(resultSet.getInt("MaTG"), resultSet.getString("TenTG"), resultSet.getString("DiaChiTG"));
            }
        }, maTG);
    }

    public List<TacGiaModel> getAllTacGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<TacGiaModel>() {
            @Override
            public TacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new TacGiaModel(resultSet.getInt("MaTG"), resultSet.getString("TenTG"), resultSet.getString("DiaChiTG"));
            }
        });
    }

    public List<TacGiaModel> searchTacGia(String keyword) throws SQLException {
        String searchKeyword = "%" + keyword + "%";
        return search(SEARCH_QUERY, new RowMapper<TacGiaModel>() {
            @Override
            public TacGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new TacGiaModel(resultSet.getInt("MaTG"), resultSet.getString("TenTG"), resultSet.getString("DiaChiTG"));
            }
        }, searchKeyword, searchKeyword);
    }

    public List<TacGiaModel> getTacGiaByDauSachId(int dauSachId) throws SQLException {
        List<TacGiaModel> tacGiaList = new ArrayList<>();
        String query = "SELECT tg.* FROM TacGia tg JOIN DauSachTacGia dstg ON tg.MaTG = dstg.MaTG WHERE dstg.MaDS = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, dauSachId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TacGiaModel tacGia = new TacGiaModel(
                        rs.getInt("MaTG"),
                        rs.getString("TenTG"),
                        rs.getString("DiaChiTG")
                    );
                    tacGiaList.add(tacGia);
                }
            }
        }
        return tacGiaList;
    }

}
