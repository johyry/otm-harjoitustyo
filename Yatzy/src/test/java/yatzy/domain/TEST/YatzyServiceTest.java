/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.domain.TEST;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.domain.Dice;
import yatzy.domain.ScoreSheetService;
import yatzy.domain.User;
import yatzy.domain.YatzyService;

/**
 *
 * @author johyry
 */
public class YatzyServiceTest {
    
    private YatzyService yatzyService;
    private List<Dice> dices;
    
    public YatzyServiceTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        this.yatzyService = new YatzyService();
        yatzyService.createUser("testi", "testaaja");
        yatzyService.login("testi");
        dices = new ArrayList<>();
        
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
    public void insertScoreOnePair() {
        
    }
}
