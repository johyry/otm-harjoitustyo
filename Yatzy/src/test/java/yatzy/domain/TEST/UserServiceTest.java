/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.domain.TEST;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.dao.Database;
import yatzy.domain.User;
import yatzy.domain.UserService;

/**
 *
 * @author johyry
 */
public class UserServiceTest {
    private Database database;
    private UserService userService;
    
    
    public UserServiceTest() throws ClassNotFoundException, Exception {
        database = new Database("jdbc:sqlite:test.db");
        database.init();
        
        userService = new UserService(database);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() throws SQLException {
        database.deleteAllData();
    }

    @Test
    public void createUserTest() throws Exception {
        boolean test = userService.createUser("tester", "test");
        
        assertEquals(true, test);
    }
    
    @Test
    public void createUserFalseTest() throws Exception {
        userService.createUser("tester", "test");
        boolean test = userService.createUser("tester", "test");
        
        
        assertEquals(false, test);
    }
    
    @Test
    public void logInFalseTest() throws Exception {
        User test = userService.logIn("falseTest");
        
        
        assertEquals(null, test);
    }
}
