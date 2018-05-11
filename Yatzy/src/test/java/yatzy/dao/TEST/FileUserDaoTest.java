/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.dao.TEST;

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;
import yatzy.domain.User;

/**
 *
 * @author johyry
 */
public class FileUserDaoTest {
    
    private Database database;
    private UserDao userDao;
    
    public FileUserDaoTest() throws ClassNotFoundException {
        database = new Database("jdbc:sqlite:test.db");
        database.init();
        
        userDao = new FileUserDao(database);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        userDao.create(new User("testaaja", "testi"));
        userDao.create(new User("tester", "test"));
        
    }
    
    @After
    public void tearDown() throws SQLException {
        database.deleteAllData();
    }

    @Test
    public void findByUserNameTest() throws SQLException {
        User user = userDao.findByUsername("testaaja");
        
        assertEquals(user, user);
    }
    
    @Test
    public void getAllTest() throws SQLException {
        List<User> list = userDao.getAll();
        
        assertEquals(2, list.size());
    }
    
    @Test
    public void getIdTest() throws SQLException {
        int id = userDao.getId("testaaja");
        
        assertEquals(1, id);
    }
}
