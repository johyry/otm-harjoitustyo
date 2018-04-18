package yatzy.domain;

public class Statistics {

    private double totalOnes;
    private double totalTwos;
    private double totalThrees;
    private double totalFours;
    private double totalFives;
    private double totalSixes;
    private double totalUpperSection;
    private double totalBonus;
    private double totalOnePair;
    private double totalTwoPair;
    private double totalThreeOfAKind;
    private double totalFourOfAKind;
    private double totalSmallStraight;
    private double totalBigStraight;
    private double totalFullHouse;
    private double totalChance;
    private double totalYatzy;
    private double totalLowerSection;
    private double totalTotal;

    private int totalGames;

    private double averageOnes;
    private double averageTwos;
    private double averageThrees;
    private double averageFours;
    private double averageFives;
    private double averageSixes;
    private double averageUpperSection;
    private double averageBonus;
    private double averageOnePair;
    private double averageTwoPair;
    private double averageThreeOfAKind;
    private double averageFourOfAKind;
    private double averageSmallStraight;
    private double averageBigStraight;
    private double averageFullHouse;
    private double averageChance;
    private double averageYatzy;
    private double averageLowerSection;
    private double averageTotal;

    public void setTotalOnes(double totalOnes) {
        this.totalOnes = totalOnes;
    }

    public void setTotalTwos(double totalTwos) {
        this.totalTwos = totalTwos;
    }

    public void setTotalThrees(double totalThrees) {
        this.totalThrees = totalThrees;
    }

    public void setTotalFours(double totalFours) {
        this.totalFours = totalFours;
    }

    public void setTotalFives(double totalFives) {
        this.totalFives = totalFives;
    }

    public void setTotalSixes(double totalSixes) {
        this.totalSixes = totalSixes;
    }

    public void setTotalUpperSection(double totalUpperSection) {
        this.totalUpperSection = totalUpperSection;
    }

    public void setTotalBonus(double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public void setTotalOnePair(double totalOnePair) {
        this.totalOnePair = totalOnePair;
    }

    public void setTotalTwoPair(double totalTwoPair) {
        this.totalTwoPair = totalTwoPair;
    }

    public void setTotalThreeOfAKind(double totalThreeOfAKind) {
        this.totalThreeOfAKind = totalThreeOfAKind;
    }

    public void setTotalFourOfAKind(double totalFourOfAKind) {
        this.totalFourOfAKind = totalFourOfAKind;
    }

    public void setTotalSmallStraight(double totalSmallStraight) {
        this.totalSmallStraight = totalSmallStraight;
    }

    public void setTotalBigStraight(double totalBigStraight) {
        this.totalBigStraight = totalBigStraight;
    }

    public void setTotalFullHouse(double totalFullHouse) {
        this.totalFullHouse = totalFullHouse;
    }

    public void setTotalChance(double totalChance) {
        this.totalChance = totalChance;
    }

    public void setTotalYatzy(double totalYatzy) {
        this.totalYatzy = totalYatzy;
    }

    public void setTotalLowerSection(double totalLowerSection) {
        this.totalLowerSection = totalLowerSection;
    }

    public void setTotalTotal(double totalTotal) {
        this.totalTotal = totalTotal;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public double getTotalOnes() {
        return totalOnes;
    }

    public double getTotalTwos() {
        return totalTwos;
    }

    public double getTotalThrees() {
        return totalThrees;
    }

    public double getTotalFours() {
        return totalFours;
    }

    public double getTotalFives() {
        return totalFives;
    }

    public double getTotalSixes() {
        return totalSixes;
    }

    public double getTotalUpperSection() {
        return totalUpperSection;
    }

    public double getTotalBonus() {
        return totalBonus;
    }

    public double getTotalOnePair() {
        return totalOnePair;
    }

    public double getTotalTwoPair() {
        return totalTwoPair;
    }

    public double getTotalThreeOfAKind() {
        return totalThreeOfAKind;
    }

    public double getTotalFourOfAKind() {
        return totalFourOfAKind;
    }

    public double getTotalSmallStraight() {
        return totalSmallStraight;
    }

    public double getTotalBigStraight() {
        return totalBigStraight;
    }

    public double getTotalFullHouse() {
        return totalFullHouse;
    }

    public double getTotalChance() {
        return totalChance;
    }

    public double getTotalYatzy() {
        return totalYatzy;
    }

    public double getTotalLowerSection() {
        return totalLowerSection;
    }

    public double getTotalTotal() {
        return totalTotal;
    }

    public double getAverageOnes() {
        return averageOnes;
    }

    public double getAverageTwos() {
        return averageTwos;
    }

    public double getAverageThrees() {
        return averageThrees;
    }

    public double getAverageFours() {
        return averageFours;
    }

    public double getAverageFives() {
        return averageFives;
    }

    public double getAverageSixes() {
        return averageSixes;
    }

    public double getAverageUpperSection() {
        return averageUpperSection;
    }

    public double getAverageBonus() {
        return averageBonus;
    }

    public double getAverageOnePair() {
        return averageOnePair;
    }

    public double getAverageTwoPair() {
        return averageTwoPair;
    }

    public double getAverageThreeOfAKind() {
        return averageThreeOfAKind;
    }

    public double getAverageFourOfAKind() {
        return averageFourOfAKind;
    }

    public double getAverageSmallStraight() {
        return averageSmallStraight;
    }

    public double getAverageBigStraight() {
        return averageBigStraight;
    }

    public double getAverageFullHouse() {
        return averageFullHouse;
    }

    public double getAverageChance() {
        return averageChance;
    }

    public double getAverageYatzy() {
        return averageYatzy;
    }

    public double getAverageLowerSection() {
        return averageLowerSection;
    }

    public double getAverageTotal() {
        return averageTotal;
    }

    


    public void calculateAveragesFromTotals() {
        averageOnes = totalOnes / totalGames;
        averageTwos = totalTwos / totalGames;
        averageThrees = totalThrees / totalGames;
        averageFours = totalFours / totalGames;
        averageFives = totalFives / totalGames;
        averageSixes = totalSixes / totalGames;
        averageLowerSection = totalLowerSection / totalGames;
        averageBonus = totalBonus / totalGames;
        averageOnePair = totalOnePair / totalGames;
        averageTwoPair = totalTwoPair / totalGames;
        averageThreeOfAKind = totalThreeOfAKind / totalGames;
        averageFourOfAKind = totalFourOfAKind / totalGames;
        averageSmallStraight = totalSmallStraight / totalGames;
        averageBigStraight = totalBigStraight / totalGames;
        averageFullHouse = totalFullHouse / totalGames;
        averageChance = totalChance / totalGames;
        averageYatzy = totalYatzy / totalGames;
        averageLowerSection = totalLowerSection / totalGames;
        averageTotal = totalTotal / totalGames;

    }

    public void printAverages() {
        System.out.println("Following statistics are average per game on " + getTotalGames() + " games: \n\n"
                + "1: Ones: " + getAverageOnes() + "\n"
                + "2: Twos: " + getAverageTwos() + "\n"
                + "3: Threes: " + getAverageThrees() + "\n"
                + "4: Fours: " + getAverageFours() + "\n"
                + "5: Fives: " + getAverageFives() + "\n"
                + "6: Sixes: " + getAverageSixes() + "\n"
                + "7: Upper Section Total: " + getAverageUpperSection() + "\n"
                + "8: Bonus: " + getAverageBonus() + "\n"
                + "9: One Pair: " + getAverageOnePair() + "\n"
                + "10: Two Pair: " + getAverageTwoPair() + "\n"
                + "11: Three of a Kind: " + getAverageThreeOfAKind() + "\n"
                + "12: Four of a Kind: " + getAverageFourOfAKind() + "\n"
                + "13: Small Straight: " + getAverageBigStraight() + "\n"
                + "14: Big Straight: " + getAverageBigStraight() + "\n"
                + "15: Full House: " + getAverageFullHouse() + "\n"
                + "16: Chance: " + getAverageChance() + "\n"
                + "17: Yatzy: " + getAverageYatzy() + "\n"
                + "18: Lower Section total: " + getAverageLowerSection() + "\n"
                + "19: Total: " + getAverageTotal());
        System.out.println();
    }
    
    public void printTotals() {
        System.out.println("Following statistics are total scores on all " + getTotalGames() + " games: \n\n"
                + "1: Ones: " + getTotalOnes() + "\n"
                + "2: Twos: " + getTotalTwos() + "\n"
                + "3: Threes: " + getTotalThrees() + "\n"
                + "4: Fours: " + getTotalFours() + "\n"
                + "5: Fives: " + getTotalFives() + "\n"
                + "6: Sixes: " + getTotalSixes() + "\n"
                + "7: Upper Section Total: " + getTotalUpperSection() + "\n"
                + "8: Bonus: " + getTotalBonus() + "\n"
                + "9: One Pair: " + getTotalOnePair() + "\n"
                + "10: Two Pair: " + getTotalTwoPair() + "\n"
                + "11: Three of a Kind: " + getTotalThreeOfAKind() + "\n"
                + "12: Four of a Kind: " + getTotalFourOfAKind() + "\n"
                + "13: Small Straight: " + getTotalBigStraight() + "\n"
                + "14: Big Straight: " + getTotalBigStraight() + "\n"
                + "15: Full House: " + getTotalFullHouse() + "\n"
                + "16: Chance: " + getTotalChance() + "\n"
                + "17: Yatzy: " + getTotalYatzy() + "\n"
                + "18: Lower Section total: " + getTotalLowerSection() + "\n"
                + "19: Total: " + getTotalTotal());
        System.out.println();
    }

}
