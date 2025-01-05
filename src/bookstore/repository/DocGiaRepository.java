package bookstore.repository;

import bookstore.model.DocGiaModel;
import java.sql.*;
import java.util.List;

public class DocGiaRepository extends BaseRepository<DocGiaModel> {

    private static final String INSERT_QUERY = "INSERT INTO DocGia (TenDG, DienThoai, NgayHetHan) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE DocGia SET TenDG = ?, DienThoai = ?, NgayHetHan = ? WHERE MaDG = ?";
    private static final String DELETE_QUERY = "DELETE FROM DocGia WHERE MaDG = ?";
    private static final String SELECT_QUERY = "SELECT * FROM DocGia WHERE MaDG = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DocGia";

    public void addDocGia(DocGiaModel docGia) throws SQLException {
        add(INSERT_QUERY, docGia.getTenDG(), docGia.getDienThoai(), Date.valueOf(docGia.getNgayHetHan()));
    }

    public void updateDocGia(DocGiaModel docGia) throws SQLException {
        edit(UPDATE_QUERY, docGia.getTenDG(), docGia.getDienThoai(), Date.valueOf(docGia.getNgayHetHan()), docGia.getMaDG());
    }

    public void deleteDocGia(String maDG) throws SQLException {
        delete(DELETE_QUERY, maDG);
    }

    public DocGiaModel getDocGiaById(String maDG) throws SQLException {
        return getOne(SELECT_QUERY, new RowMapper<DocGiaModel>() {
            @Override
            public DocGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new DocGiaModel(
                        resultSet.getString("MaDG"),
                        resultSet.getString("TenDG"),
                        resultSet.getString("DienThoai"),
                        resultSet.getDate("NgayHetHan").toString()
                );
            }
        }, maDG);
    }

    public List<DocGiaModel> getAllDocGia() throws SQLException {
        return getAll(SELECT_ALL_QUERY, new RowMapper<DocGiaModel>() {
            @Override
            public DocGiaModel mapRow(ResultSet resultSet) throws SQLException {
                return new DocGiaModel(
                        resultSet.getString("MaDG"),
                        resultSet.getString("TenDG"),
                        resultSet.getString("DienThoai"),
                        resultSet.getDate("NgayHetHan").toString()
                );
            }
        });
    }
}
