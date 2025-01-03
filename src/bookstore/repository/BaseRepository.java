package bookstore.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/QLTV";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void add(String query, Object... parameters) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
        }
    }

    public void edit(String query, Object... parameters) throws SQLException {
        add(query, parameters);
    }

    public void delete(String query, Object... parameters) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
        }
    }

    public List<T> getAll(String query, RowMapper<T> rowMapper) throws SQLException {
        List<T> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                list.add(rowMapper.mapRow(resultSet));
            }
        }
        return list;
    }

    public T getOne(String query, RowMapper<T> rowMapper, Object... parameters) throws SQLException {
        T object = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setParameters(preparedStatement, parameters);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    object = rowMapper.mapRow(resultSet);
                }
            }
        }
        return object;
    }

    private void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            preparedStatement.setObject(i + 1, parameters[i]);
        }
    }

    public interface RowMapper<T> {
        T mapRow(ResultSet resultSet) throws SQLException;
    }
}
