/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.domain.TEST;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.domain.Scoresheet;
import yatzy.domain.User;

/**
 *
 * @author johyry
 */
public class ScoreSheetTest {
    
    Scoresheet scoresheet;
    User user;
    
    public ScoreSheetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User("testi", "testaaja");
        scoresheet = new Scoresheet(user);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void setOnes() {
//        scoresheet.setOnes(3);
//        assertEquals(3, scoresheet.getOnes());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
