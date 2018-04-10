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
//        nopat.add(new Dice(1));
//        nopat.add(new Dice(1));
//        nopat.add(new Dice(1));
//        nopat.add(new Dice(4));
//        nopat.add(new Dice(6));
//
//        scoresheetservice.setOnes(nopat);

    }

}
