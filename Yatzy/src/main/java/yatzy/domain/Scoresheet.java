/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.domain;

/**
 *
 * @author johyry
 */
public class Scoresheet {
    private User user;
    
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int upperSectionTotal;
    private int bonus;
    
    private int onePair;
    private int twoPair;
    private int threeOfAKind;
    private int fourOfAKind;
    private int smallStraight;
    private int bigStraight;
    private int fullHouse;
    private int chance;
    private int lowerSectionTotal;
    private int yatzy;
    
    private int total;
    
    public Scoresheet(User user) {
        this.user = user;
    }
    
    public void calculateTotals() {
        setUpperSectionTotal();
        setBonus();
        setLowerSectionTotal();
        setTotal();
    }
 
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public int getThrees() {
        return threes;
    }

    public void setThrees(int threes) {
        this.threes = threes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getUpperSectionTotal() {
        return upperSectionTotal;
    }

    public void setUpperSectionTotal() {
        this.upperSectionTotal = ones + twos + threes + fours + fives + sixes;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus() {
        if (upperSectionTotal >= 63) {
            bonus = 50;
        }
    }

    public int getOnePair() {
        return onePair;
    }

    public void setOnePair(int onePair) {
        this.onePair = onePair;
    }

    public int getTwoPair() {
        return twoPair;
    }

    public void setTwoPair(int twoPair) {
        this.twoPair = twoPair;
    }

    public int getThreeOfAKind() {
        return threeOfAKind;
    }

    public void setThreeOfAKind(int threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
    }

    public int getSmallStraigt() {
        return smallStraight;
    }

    public void setSmallStraigt(int smallStraigt) {
        this.smallStraight = smallStraigt;
    }

    public int getBigStraight() {
        return bigStraight;
    }

    public void setBigStraight(int bigStraight) {
        this.bigStraight = bigStraight;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
    public int getYatzy() {
        return yatzy;
    }

    public void setYatzy(int yatzy) {
        this.yatzy = yatzy;
    }
    
    public int getLowerSectionTotal() {
        return lowerSectionTotal;
    }
    
    public void setLowerSectionTotal() {
        lowerSectionTotal = onePair + twoPair + threeOfAKind + fourOfAKind + smallStraight + bigStraight + fullHouse + chance + yatzy;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = lowerSectionTotal + upperSectionTotal + bonus;
    }
    
    
    
}
