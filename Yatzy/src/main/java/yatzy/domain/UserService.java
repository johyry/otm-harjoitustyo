package yatzy.domain;

import java.util.List;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;

     /**
     * This class is responsible of handling users information with DAO class.
     */

public class UserService {

    private UserDao userDao;

    public UserService(Database database) throws Exception {
        
        userDao = new FileUserDao(database);
    }
    
    /**
     * logs in a user
     * 
     * @param username
     * 
     * @return user if found in db
     */

    public User logIn(String username) throws Exception {

        User user = userDao.findByUsername(username);

        if (user == null) {
            return null;
        }

        return user;

    }
    
    /**
     * creates a new user
     * 
     * @param username
     * @param name
     * 
     * @return true if username is not in use and creation is successful
     *  
     */

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
    
    /**
     * Method for printing all existing users in database
     *  
     */

    public void printAllExistingUsers() throws Exception {

        List<User> users = userDao.getAll();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
        }

    }
    
    /**
     * Method for finding users userID
     * 
     * @param username
     * 
     * @return userid
     *  
     */
    
    public int findUserId(String username) throws Exception {
        
        if (userDao.findByUsername(username) == null) {
            return -1;
        }
        
        int id = userDao.getId(username);
        
        return id;
    }



}

