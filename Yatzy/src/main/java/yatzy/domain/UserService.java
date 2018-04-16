package yatzy.domain;

import java.util.List;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;

public class UserService {

    private Database database;
    private UserDao userDao;

    public UserService() throws Exception {
        database = new Database("jdbc:sqlite:users.db");
        database.init();
        userDao = new FileUserDao(database);
    }

    public User logIn(String username) throws Exception {

        User user = userDao.findByUsername(username);

        if (user == null) {
            return null;
        }

        return user;

    }

    public boolean createUser(String username, String name) throws Exception {
        
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, name);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }

        return true;

    }
    
    public void printAllUsers() throws Exception {
        List<User> users = userDao.getAll();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
        }

    }

}
