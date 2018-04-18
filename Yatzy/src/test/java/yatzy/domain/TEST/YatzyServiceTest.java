/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.domain.TEST;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.dao.Database;
import yatzy.domain.Dice;
import yatzy.domain.ScoreSheetService;
import yatzy.domain.StatisticsService;
import yatzy.domain.User;
import yatzy.domain.UserService;
import yatzy.domain.YatzyService;

/**
 *
 * @author johyry
 */
public class YatzyServiceTest {

    private List<User> usersLoggedIn;
    private List<ScoreSheetService> scoreSheetServices;

    private UserService userService;
    private StatisticsService statisticsService;

    private YatzyService yatzyService;

    public YatzyServiceTest() throws Exception {
        Database database = new Database("jdbc:sqlite:test1.db");
        database.init();

        userService = new UserService(database);
        statisticsService = new StatisticsService(database, userService);

        usersLoggedIn = new ArrayList<>();
        scoreSheetServices = new ArrayList<>();

        yatzyService = new YatzyService();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        yatzyService.createUser("testi", "testaaja");
        yatzyService.login("testi");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void createUser() throws Exception {
        yatzyService.createUser("testi", "testaaja");
    }

    @Test
    public void logIn() {

    }

    @Test
    public void printGeneralStatistics() throws SQLException {
        yatzyService.printGeneralStatistics();
    }
    
    @Test
    public void printUserStatistics() throws SQLException, Exception {
        
        yatzyService.printUserStatistics("testi");
    }

    @Test
    public void throwDices() {
        List<Dice> dices = new ArrayList<>();
        dices.add(new Dice(1));
        dices.add(new Dice(1));
        dices.add(new Dice(1));
        dices.add(new Dice(1));
        dices.add(new Dice(1));
        
        
        String input = "1 2 3 4 5";

        dices = yatzyService.throwDices(dices, input);
        
        assertEquals(1, dices.get(0).getValue());
        assertEquals(1, dices.get(1).getValue());
        assertEquals(1, dices.get(2).getValue());
        assertEquals(1, dices.get(3).getValue());
        assertEquals(1, dices.get(4).getValue());
    }

}
