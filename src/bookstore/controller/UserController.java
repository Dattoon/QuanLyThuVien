package bookstore.controller;

import bookstore.model.User;
import bookstore.repository.UserRepository;

import java.sql.SQLException;

public class UserController {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public boolean login(String username, String password) {
        try {
            User user = userRepository.getUserByUsername(username);
            return user != null && user.getMatKhau().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;	
        }
    }
}
