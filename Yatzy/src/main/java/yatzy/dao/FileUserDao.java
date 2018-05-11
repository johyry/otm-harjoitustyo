package yatzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import yatzy.domain.User;

/**
 * This class is responsible of handling User information with database.
 */

public class FileUserDao implements UserDao {

    private Database database;

    public FileUserDao(Database database) {
        this.database = database;

    }
    
    /**
     * Creates one user row in database.
     * 
     * @param user object
     * 
     * @return user object
     */

    @Override
    public User create(User user) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO user (username, name) VALUES (?, ?)");
        stmt.setObject(1, user.getUsername());
        stmt.setObject(2, user.getName());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return user;
    }
    
    /**
     * Finds user from database by given username
     * 
     * @param username
     * 
     * @return user object
     */

    @Override
    public User findByUsername(String username) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        User user = new User(rs.getString("username"), rs.getString("name"));

        stmt.close();
        rs.close();
        connection.close();
        return user;
    }
    
    /**
     * Gets all users from database
     * 
     * 
     * @return list of users
     */

    @Override
    public List<User> getAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user");
        
        List<User> users = new ArrayList<>();
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String name = rs.getString("name");
            users.add(new User(username, name));
        }

        rs.close();
        stmt.close();
        connection.close();
        
        return users;
    }
    
    /**
     * Finds users id by username
     * 
     * @param username
     * 
     * @return userId as INT
     */

    @Override
    public int getId(String username) throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        
        int id = rs.getInt("id");
        
        rs.close();
        stmt.close();
        connection.close();
        
        return id;
    }
}
