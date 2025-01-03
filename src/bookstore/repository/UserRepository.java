package bookstore.repository;

import bookstore.model.User;

import java.sql.*;

public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super();
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM NguoiDung WHERE TenDangNhap = ?";
        return getOne(query, resultSet -> new User(
                resultSet.getString("MaNguoiDung"),
                resultSet.getString("TenDangNhap"),
                resultSet.getString("MatKhau")
        ), username);
    }
}
