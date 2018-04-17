
package yatzy.dao;

import java.sql.SQLException;
import java.util.List;
import yatzy.domain.User;


public interface UserDao {
    User create(User user) throws SQLException;

    User findByUsername(String username) throws SQLException;
    
    int getId(String username) throws SQLException;

    List<User> getAll() throws SQLException;
    
    
}
