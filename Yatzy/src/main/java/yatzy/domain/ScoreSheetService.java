package yatzy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreSheetService {

    private User user;
    public Scoresheet scoresheet;

    public ScoreSheetService(User user) {
        this.user = user;
        this.scoresheet = new Scoresheet(user);

    }

    public User getUser() {
        return user;
    }

    private Map<Integer, Integer> sortDice(List<Dice> dices) {
        Map<Integer, Integer> sorted = new HashMap<>();
        sorted.put(1, 0);
        sorted.put(2, 0);
        sorted.put(3, 0);
        sorted.put(4, 0);
        sorted.put(5, 0);
        sorted.put(6, 0);

        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i).getValue() == 1) {
                sorted.put(1, sorted.get(1) + 1);
            } else if (dices.get(i).getValue() == 2) {
                sorted.put(2, sorted.get(2) + 1);
            } else if (dices.get(i).getValue() == 3) {
                sorted.put(3, sorted.get(3) + 1);
            } else if (dices.get(i).getValue() == 4) {
                sorted.put(4, sorted.get(4) + 1);
            } else if (dices.get(i).getValue() == 5) {
                sorted.put(5, sorted.get(5) + 1);
            } else if (dices.get(i).getValue() == 6) {
                sorted.put(6, sorted.get(6) + 1);
            }
        }

        return sorted;
    }

    public void setOnes(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setOnes(sorted.get(1));
    }

    public void setTwos(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setTwos(sorted.get(2) * 2);
    }

    public void setThrees(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setThrees(sorted.get(3) * 3);
    }

    public void setFours(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setFours(sorted.get(4) * 4);
    }

    public void setFives(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setFives(sorted.get(5) * 5);
    }

    public void setSixes(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        scoresheet.setSixes(sorted.get(6) * 6);
    }

    public void setOnePair(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 2) {
                scoresheet.setOnePair(2 * i);
                pointsOrNot = true;
                break;
            }
        }
        if (!pointsOrNot) {
            scoresheet.setOnePair(0);
        }
    }

    public void setTwoPair(List<Dice> dices) { //testaa
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 2) {
                for (int a = i - 1; a > 0; a--) {
                    if (sorted.get(a) >= 2) {
                        scoresheet.setTwoPair(i * 2 + a * 2);
                        pointsOrNot = true;
                    }
                }
            }
        }

        if (!pointsOrNot) {
            scoresheet.setTwoPair(0);
        }
    }

    public void setThreeOfAKind(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 3) {
                scoresheet.setThreeOfAKind(sorted.get(i) * i);
                pointsOrNot = true;
                break;
            }
        }

        if (!pointsOrNot) {
            scoresheet.setThreeOfAKind(0);
        }
    }

    public void setFourOfAKind(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 4) {
                scoresheet.setFourOfAKind(sorted.get(i) * i);

                pointsOrNot = true;

                break;
            }
        }

        if (!pointsOrNot) {
            scoresheet.setFourOfAKind(0);
        }

    }

    public void setSmallStraight(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);


        if (sorted.get(1) <= 1 && sorted.get(2) <= 1 && sorted.get(3) <= 1 && sorted.get(4) <= 1 && sorted.get(5) <= 1) {
            scoresheet.setSmallStraight(15);
        } else {


            scoresheet.setSmallStraight(0);
        }
    }

    public void setBigStraight(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);


        if (sorted.get(2) <= 1 && sorted.get(3) <= 1 && sorted.get(4) <= 1 && sorted.get(5) <= 1 && sorted.get(6) <= 1) {
            scoresheet.setBigStraight(20);
        } else {

            scoresheet.setBigStraight(0);

        }
    }

    public void setFullHouse(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) == 3) {
                for (int a = 6; a > 0; a--) {
                    if (sorted.get(a) == 2) {
                        scoresheet.setFullHouse(i * 3 + a * 2);
                        pointsOrNot = true;
                    }

                }
            }
        }

        if (!pointsOrNot) {
            scoresheet.setFullHouse(0);
        }

    }

    public void setChance(List<Dice> dices) {
        scoresheet.setChance(dices.get(0).getValue() + dices.get(1).getValue() + dices.get(2).getValue() + dices.get(3).getValue() + dices.get(4).getValue());
    }

    public void setYatzy(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);
        boolean pointsOrNot = false;

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) == 5) {
                scoresheet.setYatzy(50);
                pointsOrNot = true;
            }
        }

        if (!pointsOrNot) {
            scoresheet.setYatzy(0);
        }

    }

    public void printScoreSheet() {
        scoresheet.calculateTotals();
        System.out.println("Scoresheet of: " + getUser() + "\n"
                + "1: Ones: " + getOnes() + "\n"
                + "2: Twos: " + getTwos() + "\n"
                + "3: Threes: " + getThrees() + "\n"
                + "4: Fours: " + getFours() + "\n"
                + "5: Fives: " + getFives() + "\n"
                + "6: Sixes: " + getSixes() + "\n"
                + "7: Upper Section Total: " + scoresheet.getUpperSectionTotal() + "\n"
                + "8: Bonus: " + scoresheet.getBonus() + "\n"
                + "9: One Pair: " + getOnePair() + "\n"
                + "10: Two Pair: " + getTwoPair() + "\n"
                + "11: Three of a Kind: " + getThreeOfAKind() + "\n"
                + "12: Four of a Kind: " + getFourOfAKind() + "\n"
                + "13: Small Straight: " + getSmallStraigt() + "\n"
                + "14: Big Straight: " + getBigStraight() + "\n"
                + "15: Full House: " + getFullHouse() + "\n"
                + "16: Chance: " + getChance() + "\n"
                + "17: Yatzy: " + getYatzy() + "\n"
                + "18: Lower Section total: " + scoresheet.getLowerSectionTotal() + "\n"
                + "19: Total: " + scoresheet.getTotal());

                
                


    }

    public boolean insertScore(List<Dice> dices, String input) {
        switch (input) {
            case "1":
                if (scoresheet.isOnesSet()) {
                    return false;
                }
                setOnes(dices);
                return true;
            case "2":
                if (scoresheet.isTwosSet()) {
                    return false;
                }
                setTwos(dices);
                return true;
            case "3":
                if (scoresheet.isThreesSet()) {
                    return false;
                }
                setThrees(dices);
                return true;
            case "4":
                if (scoresheet.isFoursSet()) {
                    return false;
                }
                setFours(dices);
                return true;
            case "5":
                if (scoresheet.isFivesSet()) {
                    return false;
                }
                setFives(dices);
                return true;
            case "6":
                if (scoresheet.isSixesSet()) {
                    return false;
                }
                setSixes(dices);
                return true;
            case "9":
                if (scoresheet.isOnePairSet()) {
                    return false;
                }
                setOnePair(dices);
                return true;
            case "10":
                if (scoresheet.isTwoPairSet()) {
                    return false;
                }
                setTwoPair(dices);
                return true;
            case "11":
                if (scoresheet.isThreeOfAKindSet()) {
                    return false;
                }
                setThreeOfAKind(dices);
                return true;
            case "12":
                if (scoresheet.isFourOfAKindSet()) {
                    return false;
                }
                setFourOfAKind(dices);
                return true;
            case "13":
                if (scoresheet.isSmallStraightSet()) {
                    return false;
                }
                setSmallStraight(dices);
                return true;
            case "14":
                if (scoresheet.isBigStraightSet()) {
                    return false;
                }
                setBigStraight(dices);
                return true;
            case "15":
                if (scoresheet.isFullHouseSet()) {
                    return false;
                }
                setFullHouse(dices);
                return true;
            case "16":
                if (scoresheet.isChanceSet()) {
                    return false;
                }
                setChance(dices);
                return true;
            case "17":
                if (scoresheet.isYatzySet()) {
                    return false;
                }
                setYatzy(dices);
                return true;
            default:
                return false;
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOnes() {
        int x = scoresheet.getOnes();
        if (x == 0 && scoresheet.isOnesSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getTwos() {
        int x = scoresheet.getTwos();
        if (x == 0 && scoresheet.isTwosSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getThrees() {
        int x = scoresheet.getThrees();
        if (x == 0 && scoresheet.isThreesSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getFours() {
        int x = scoresheet.getFours();
        if (x == 0 && scoresheet.isFoursSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getFives() {
        int x = scoresheet.getFives();
        if (x == 0 && scoresheet.isFivesSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getSixes() {
        int x = scoresheet.getSixes();
        if (x == 0 && scoresheet.isSixesSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getOnePair() {
        int x = scoresheet.getOnePair();
        if (x == 0 && scoresheet.isOnePairSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getTwoPair() {
        int x = scoresheet.getTwoPair();
        if (x == 0 && scoresheet.isTwoPairSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getThreeOfAKind() {
        int x = scoresheet.getThreeOfAKind();
        if (x == 0 && scoresheet.isThreeOfAKindSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getFourOfAKind() {
        int x = scoresheet.getFourOfAKind();
        if (x == 0 && scoresheet.isFourOfAKindSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getSmallStraigt() {
        int x = scoresheet.getSmallStraight();
        if (x == 0 && scoresheet.isSmallStraightSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getBigStraight() {
        int x = scoresheet.getBigStraight();
        if (x == 0 && scoresheet.isBigStraightSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getFullHouse() {
        int x = scoresheet.getFullHouse();
        if (x == 0 && scoresheet.isFullHouseSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getChance() {
        int x = scoresheet.getChance();
        if (x == 0 && scoresheet.isChanceSet()) {
            return "-";
        }

        return Integer.toString(x);
    }

    public String getYatzy() {
        int x = scoresheet.getYatzy();
        if (x == 0 && scoresheet.isYatzySet()) {
            return "-";
        }

        return Integer.toString(x);

    }
    
    


}
