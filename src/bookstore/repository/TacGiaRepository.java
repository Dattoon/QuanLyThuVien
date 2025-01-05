package bookstore.repository;

import bookstore.model.TacGia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacGiaRepository {
    private Connection connection;

    public TacGiaRepository() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TacGia> getAllTacGia() {
        List<TacGia> tacGiaList = new ArrayList<>();
        String query = "SELECT * FROM TacGia";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String maTG = resultSet.getString("MaTG");
                String tenTG = resultSet.getString("TenTG");
                String diaChiTG = resultSet.getString("DiaChiTG");

                TacGia tacGia = new TacGia(maTG, tenTG, diaChiTG);
                tacGiaList.add(tacGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tacGiaList;
    }
}
