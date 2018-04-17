package yatzy.domain;

import java.util.List;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService(Database database) throws Exception {
        
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
    

    public void printAllExistingUsers() throws Exception {

        List<User> users = userDao.getAll();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
        }

    }
    
    public int findUserId(String username) throws Exception {
        
        if (userDao.findByUsername(username) == null) {
            return -1;
        }
        
        int id = userDao.getId(username);
        
        return id;
    }



}

