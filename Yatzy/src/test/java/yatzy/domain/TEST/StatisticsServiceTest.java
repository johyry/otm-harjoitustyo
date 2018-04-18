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
import yatzy.dao.FileStatisticsDao;
import yatzy.dao.StatisticsDao;
import yatzy.domain.ScoreSheetService;
import yatzy.domain.Statistics;
import yatzy.domain.StatisticsService;
import yatzy.domain.User;
import yatzy.domain.UserService;

/**
 *
 * @author johyry
 */
public class StatisticsServiceTest {
    StatisticsService statisticsService;
    Database database;
    
    ScoreSheetService scoreSheetService1;
    ScoreSheetService scoreSheetService2;
    ScoreSheetService scoreSheetService3;
    UserService userService;
    StatisticsDao statisticsDao;

    User user;
    
    public StatisticsServiceTest() throws Exception {
        database = new Database("jdbc:sqlite:test.db");
        database.init();

        userService = new UserService(database);
        statisticsDao = new FileStatisticsDao(database);
        statisticsService = new StatisticsService(database, userService);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        
    }

    @Before
    public void setUp() {
        
        user = new User("testaaja", "testi");
        scoreSheetService1 = new ScoreSheetService(user);
        scoreSheetService2 = new ScoreSheetService(user);
        scoreSheetService3 = new ScoreSheetService(user);

    }

    @After
    public void tearDown() throws SQLException {
        database.deleteAllData();
    }

    @Test
    public void averageTotalScore() throws Exception {
        scoreSheetService1.scoresheet.setOnePair(100);
        scoreSheetService1.scoresheet.calculateTotals();
        scoreSheetService2.scoresheet.setTwoPair(200);
        scoreSheetService2.scoresheet.calculateTotals();
        scoreSheetService3.scoresheet.setFourOfAKind(300);
        scoreSheetService3.scoresheet.calculateTotals();

        statisticsService.insertScoresheetToStatistics(user, scoreSheetService1.scoresheet);
        statisticsService.insertScoresheetToStatistics(user, scoreSheetService2.scoresheet);
        statisticsService.insertScoresheetToStatistics(user, scoreSheetService3.scoresheet);
        
        Statistics statistics = new Statistics();
        statistics = statisticsDao.getStatistics(-1);
        assertEquals(200, statistics.getAverageTotal(), 0.1);
    }
    
    @Test
    public void averageUserTotalScore() throws Exception {
        scoreSheetService1.scoresheet.setOnePair(100);
        scoreSheetService1.scoresheet.calculateTotals();
        scoreSheetService2.scoresheet.setTwoPair(200);
        scoreSheetService2.scoresheet.calculateTotals();
        scoreSheetService3.scoresheet.setFourOfAKind(300);
        scoreSheetService3.scoresheet.calculateTotals();

        statisticsService.insertScoresheetToStatistics(user, scoreSheetService1.scoresheet);
        statisticsService.insertScoresheetToStatistics(user, scoreSheetService2.scoresheet);
        statisticsService.insertScoresheetToStatistics(user, scoreSheetService3.scoresheet);
        
        int id = userService.findUserId(user.getUsername());
        
        Statistics statistics = new Statistics();
        statistics = statisticsDao.getStatistics(id);
        assertEquals(200, statistics.getAverageTotal(), 0.1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
