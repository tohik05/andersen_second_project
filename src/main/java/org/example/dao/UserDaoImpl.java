package org.example.dao;

import org.example.exception.DatabaseException;
import org.example.exception.EntityNotFoundException;
import org.example.util.DBConfigurator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private static UserDao userDao;

    private final String GET_BY_ID = "SELECT u.id, u.name, u.lastname, u.age " +
            "FROM users u WHERE id = ?";
    private final String GET_ALL = "SELECT u.id, u.name, u.lastname, u.age FROM users u";
    private final String CREATE = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?);";
    private final String UPDATE = "UPDATE users SET name = ?, lastname = ?, age = ? WHERE id= ?";
    public final String DELETE = "DELETE FROM users WHERE id = ?";

    public static UserDao getInstance(){
        if (userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public User getById(Long id) {
        try {
            PreparedStatement statement = DBConfigurator.getConnection()
                    .prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return getUserFromResultSet(resultSet);
            } else {
                throw  new EntityNotFoundException("There is no user with id: " + id);
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("Can't get user with id: " + id);
        }
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setLastname(resultSet.getString("lastname"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = DBConfigurator.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                users.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new EntityNotFoundException("Can't get all users");
        }
        return users;
    }

    @Override
    public User create(User user) {
        try {
            PreparedStatement statement = DBConfigurator.getConnection()
                    .prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            setStatement(user, statement);
            int result = statement.executeUpdate();
            if (result != 1){
                throw new DatabaseException("Can't create user");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                return getById(generatedKeys.getLong("id"));
            } else {
                throw new DatabaseException("Can't create user");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't create user");
        }
    }

    @Override
    public User update(User user) {
        try {
            PreparedStatement statement = DBConfigurator.getConnection()
                    .prepareStatement(UPDATE);
            setStatement(user, statement);
            statement.setLong(4, user.getId());
            int result = statement.executeUpdate();
            if (result != 1){
                throw new DatabaseException("Can't update user with id: " + user.getId());
            }
            return getById(user.getId());
        } catch (SQLException e) {
            throw new DatabaseException("Can't update user with id: " + user.getId());
        }
    }

    private static void setStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getName());
        statement.setString(2, user.getLastname());
        statement.setInt(3, user.getAge());
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            PreparedStatement statement = DBConfigurator.getConnection()
                    .prepareStatement(DELETE);
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            throw new DatabaseException("Can't delete user with id: " + id);
        }
    }
}
