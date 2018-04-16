package yatzy.domain;

/**
 *
 * @author johyry
 */
public class Scoresheet {

    private User user;

    private int ones;

    
    private boolean onesSet;
    private int twos;
    private boolean twosSet;
    private int threes;
    private boolean threesSet;
    private int fours;
    private boolean foursSet;
    private int fives;
    private boolean fivesSet;
    private int sixes;
    private boolean sixesSet;
    private int upperSectionTotal;
    private int bonus;
    private int onePair;
    private boolean onePairSet;
    private int twoPair;
    private boolean twoPairSet;
    private int threeOfAKind;
    private boolean threeOfAKindSet;
    private int fourOfAKind;
    private boolean fourOfAKindSet;
    private int smallStraight;
    private boolean smallStraightSet;
    private int bigStraight;
    private boolean bigStraightSet;
    private int fullHouse;
    private boolean fullHouseSet;
    private int chance;
    private boolean chanceSet;
    private int lowerSectionTotal;
    private int yatzy;
    private boolean yatzySet;

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
        this.onesSet = true;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
        this.twosSet = true;
    }

    public int getThrees() {
        return threes;
    }

    public void setThrees(int threes) {
        this.threes = threes;
        this.threesSet = true;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
        this.foursSet = true;

    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
        this.fivesSet = true;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
        this.sixesSet = true;
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
        this.onePairSet = true;
    }

    public int getTwoPair() {
        return twoPair;
    }

    public void setTwoPair(int twoPair) {
        this.twoPair = twoPair;
        this.twoPairSet = true;

    }

    public int getThreeOfAKind() {
        return threeOfAKind;
    }

    public void setThreeOfAKind(int threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
        this.threeOfAKindSet = true;
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
        this.fourOfAKindSet = true;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public void setSmallStraight(int smallStraight) {
        this.smallStraight = smallStraight;
        this.smallStraightSet = true;
    }

    public int getBigStraight() {
        return bigStraight;
    }

    public void setBigStraight(int bigStraight) {
        this.bigStraight = bigStraight;
        this.bigStraightSet = true;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
        this.fullHouseSet = true;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
        this.chanceSet = true;
    }

    public int getYatzy() {
        return yatzy;
    }

    public void setYatzy(int yatzy) {
        this.yatzy = yatzy;
        this.yatzySet = true;
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

    public boolean isOnesSet() {
        return onesSet;
    }

    public boolean isTwosSet() {
        return twosSet;
    }

    public boolean isThreesSet() {
        return threesSet;
    }

    public boolean isFoursSet() {
        return foursSet;
    }

    public boolean isFivesSet() {
        return fivesSet;
    }

    public boolean isSixesSet() {
        return sixesSet;
    }

    public boolean isOnePairSet() {
        return onePairSet;
    }

    public boolean isTwoPairSet() {
        return twoPairSet;
    }

    public boolean isThreeOfAKindSet() {
        return threeOfAKindSet;
    }

    public boolean isFourOfAKindSet() {
        return fourOfAKindSet;
    }

    public boolean isSmallStraightSet() {
        return smallStraightSet;
    }

    public boolean isBigStraightSet() {
        return bigStraightSet;
    }

    public boolean isFullHouseSet() {
        return fullHouseSet;
    }

    public boolean isChanceSet() {
        return chanceSet;
    }

    public boolean isYatzySet() {
        return yatzySet;
    }
}