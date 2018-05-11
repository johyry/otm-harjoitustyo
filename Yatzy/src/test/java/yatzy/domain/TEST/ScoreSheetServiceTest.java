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
import yatzy.domain.Scoresheet;
import yatzy.domain.User;

/**
 *
 * @author johyry
 */
public class ScoreSheetServiceTest {

    ScoreSheetService scoresheetservice;
    User user;
    List<Dice> nopat;

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        user = new User("testi", "testaaja");
        scoresheetservice = new ScoreSheetService(user);

        nopat = new ArrayList<>();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void setOnes() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.insertScore(nopat, "1");
        assertEquals(3, scoresheetservice.scoresheet.getOnes());

    }

    @Test
    public void setOnesTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

       
        scoresheetservice.setOnes(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isOnesSet());

    }
    
    @Test
    public void setOnesFalse() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

       
        scoresheetservice.setOnes(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "1"));

    }
    
    
    @Test
    public void setTwos() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.insertScore(nopat, "2");
        assertEquals(4, scoresheetservice.scoresheet.getTwos());

    }

    @Test
    public void setTwosTrue() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setTwos(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isTwosSet());

    }
    
    @Test
    public void setTwosFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setTwos(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "2"));

    }

    @Test
    public void setThrees() {
        nopat.add(new Dice(3));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.insertScore(nopat, "3");
        assertEquals(6, scoresheetservice.scoresheet.getThrees());

    }

    @Test
    public void setThreesTrue() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        
        scoresheetservice.setThrees(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isThreesSet());

    }
    
    @Test
    public void setThreesFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(2));
        nopat.add(new Dice(1));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        
        scoresheetservice.setThrees(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "3"));

    }

    @Test
    public void setFours() {
        nopat.add(new Dice(4));
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "4");
        assertEquals(12, scoresheetservice.scoresheet.getFours());

    }

    @Test
    public void setFoursTrue() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFours(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isFoursSet());

    }
    
    @Test
    public void setFoursFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFours(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "4"));

    }

    @Test
    public void setFives() {
        nopat.add(new Dice(5));
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "5");
        assertEquals(5, scoresheetservice.scoresheet.getFives());

    }

    @Test
    public void setFivesTrue() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFives(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isFivesSet());

    }
    
    @Test
    public void setFivesFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFives(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "5"));

    }

    @Test
    public void setSixes() {
        nopat.add(new Dice(4));
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "6");
        assertEquals(0, scoresheetservice.scoresheet.getSixes());

    }

    @Test
    public void setSixesTrue() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setSixes(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isSixesSet());

    }
    
    @Test
    public void setSixesFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setSixes(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "6"));

    }

    @Test
    public void setUpperSectionTotal() {
        nopat.add(new Dice(4));
        nopat.add(new Dice(2));
        nopat.add(new Dice(6));
        nopat.add(new Dice(3));
        nopat.add(new Dice(4));

        scoresheetservice.setSixes(nopat);
        scoresheetservice.scoresheet.calculateTotals();
        assertEquals(6, scoresheetservice.scoresheet.getUpperSectionTotal());

    }

    @Test
    public void setOnePair() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.insertScore(nopat, "9");
        assertEquals(2, scoresheetservice.scoresheet.getOnePair());

    }

    @Test
    public void setOnePairTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setOnePair(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isOnePairSet());

    }
    
    @Test
    public void setOnePairFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setOnePair(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "9"));

    }

    @Test
    public void setTwoPair() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "10");
        assertEquals(10, scoresheetservice.scoresheet.getTwoPair());

    }

    @Test
    public void setTwoPairTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setTwoPair(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isTwoPairSet());

    }
    
    @Test
    public void setTwoPairFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setTwoPair(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "10"));

    }

    @Test
    public void setThreeOfAKind() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "11");
        assertEquals(3, scoresheetservice.scoresheet.getThreeOfAKind());

    }

    @Test
    public void setThreeOfAKindTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setThreeOfAKind(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isThreeOfAKindSet());

    }
    
    @Test
    public void setThreeOfAKindFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setThreeOfAKind(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "11"));

    }

    @Test
    public void setFourOfAKind() {
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));

        scoresheetservice.insertScore(nopat, "12");
        assertEquals(16, scoresheetservice.scoresheet.getFourOfAKind());

    }

    @Test
    public void setFourOfAKindTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setFourOfAKind(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isFourOfAKindSet());

    }
    
    @Test
    public void setFourOfAKindFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFourOfAKind(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "12"));

    }

    @Test
    public void setSmallStraight() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(2));
        nopat.add(new Dice(5));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));

        scoresheetservice.insertScore(nopat, "13");
        assertEquals(15, scoresheetservice.scoresheet.getSmallStraight());

    }

    @Test
    public void setSmallStraightTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setSmallStraight(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isSmallStraightSet());

    }
    
    @Test
    public void setSmallStraightFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setSmallStraight(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "13"));

    }

    @Test
    public void setBigStraight() {
        nopat.add(new Dice(6));
        nopat.add(new Dice(2));
        nopat.add(new Dice(5));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));

        scoresheetservice.insertScore(nopat, "14");
        assertEquals(20, scoresheetservice.scoresheet.getBigStraight());

    }

    @Test
    public void setBigStraightTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setBigStraight(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isBigStraightSet());

    }
    
    @Test
    public void setBigStraightFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setBigStraight(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "14"));

    }

    @Test
    public void setFullHouse() {
        nopat.add(new Dice(6));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.insertScore(nopat, "15");
        assertEquals(24, scoresheetservice.scoresheet.getFullHouse());

    }

    @Test
    public void setFullHouseTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setFullHouse(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isFullHouseSet());

    }
    
    @Test
    public void setFullHouseFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setFullHouse(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "15"));

    }

    @Test
    public void setChance() {
        nopat.add(new Dice(6));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.insertScore(nopat, "16");
        assertEquals(24, scoresheetservice.scoresheet.getChance());

    }

    @Test
    public void setChanceTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        assertEquals(false, scoresheetservice.scoresheet.isChanceSet());
        scoresheetservice.setChance(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isChanceSet());

    }
    
    @Test
    public void setChanceFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setChance(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "16"));

    }

    @Test
    public void setYatzy() {
        nopat.add(new Dice(6));
        nopat.add(new Dice(6));
        nopat.add(new Dice(6));
        nopat.add(new Dice(6));
        nopat.add(new Dice(6));

        scoresheetservice.insertScore(nopat, "17");
        assertEquals(50, scoresheetservice.scoresheet.getYatzy());

    }

    @Test
    public void setYatzyTrue() {
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(1));
        nopat.add(new Dice(4));
        nopat.add(new Dice(6));

        scoresheetservice.setYatzy(nopat);
        assertEquals(true, scoresheetservice.scoresheet.isYatzySet());

    }
    
    @Test
    public void setYatzyFalse() {
        nopat.add(new Dice(2));
        nopat.add(new Dice(4));
        nopat.add(new Dice(4));
        nopat.add(new Dice(3));
        nopat.add(new Dice(5));

        scoresheetservice.setYatzy(nopat);
        assertEquals(false, scoresheetservice.insertScore(nopat, "17"));

    }

}
