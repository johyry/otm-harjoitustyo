package yatzy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreSheetService {

    private User user;
    private Scoresheet scoresheet;

    
    public ScoreSheetService(User user) {
        this.user = user;
        
        this.scoresheet = new Scoresheet(user);

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

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 2) {
                scoresheet.setOnePair(sorted.get(i) * i);
                break;
            }
        }

    }

    public void setTwoPair(List<Dice> dices) { //testaa
        Map<Integer, Integer> sorted = sortDice(dices);

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 2) {
                for (int a = i - 1; a > 0; a--) {
                    if (sorted.get(a) >= 2) {
                        scoresheet.setTwoPair(i * 2 + a * 2);
                    }
                }
            }
        }
    }

    public void setThreeOfAKind(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 3) {
                scoresheet.setThreeOfAKind(sorted.get(i) * i);
                break;
            }
        }
    }

    public void setFourOfAKind(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) >= 4) {
                scoresheet.setOnePair(sorted.get(i) * i);
                break;
            }
        }

    }

    public void setSmallStraight(List<Dice> dices) {

    }

    public void setBigStraight(List<Dice> dices) {

    }

    public void setFullHouse(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) == 3) {
                for (int a = 6; a > 0; a--) {
                    if (sorted.get(a) == 2) {
                        scoresheet.setFullHouse(i * 3 + a * 2);
                    }

                }
            }
        }

    }

    public void setChance(List<Dice> dices) {
        scoresheet.setChance(dices.get(0).getValue() + dices.get(1).getValue() + dices.get(2).getValue() + dices.get(3).getValue() + dices.get(4).getValue());
    }

    public void setYatzy(List<Dice> dices) {
        Map<Integer, Integer> sorted = sortDice(dices);

        for (int i = 6; i > 0; i--) {
            if (sorted.get(i) == 5) {
                scoresheet.setYatzy(50);
            }
        }
        
    }
    
    public String getScoreSheet() {
        scoresheet.calculateTotals();
        return "Scoresheet:\n"
                + "1: Ones: " + scoresheet.getOnes() + "\n"
                + "2: Twos: " + scoresheet.getTwos()+ "\n"
                + "3: Threes: " + scoresheet.getThrees()+ "\n"
                + "4: Fours: " + scoresheet.getFours()+ "\n"
                + "5: Fives: " + scoresheet.getFives() + "\n"
                + "6: Sixes: " + scoresheet.getSixes() + "\n"
                + "7: Upper Section Total: " + scoresheet.getUpperSectionTotal() + "\n"
                + "8: Bonus: " + scoresheet.getBonus() + "\n"
                + "9: One Pair: " + scoresheet.getOnePair()+ "\n"
                + "10: Two Pair: " + scoresheet.getTwoPair() + "\n"
                + "11: Three of a Kind: " + scoresheet.getThreeOfAKind() + "\n"
                + "12: Four of a Kind: " + scoresheet.getFourOfAKind() + "\n"
                + "13: Small Straight: " + scoresheet.getSmallStraigt() + "\n"
                + "14: Big Straight: " + scoresheet.getBigStraight() + "\n"
                + "15: Full House: " + scoresheet.getFullHouse() + "\n"
                + "16: Chance: " + scoresheet.getChance() + "\n"
                + "17: Yatzy: " + scoresheet.getYatzy()+ "\n"
                + "18: Lower Section total: " + scoresheet.getLowerSectionTotal() + "\n"
                + "19: Total: " + scoresheet.getTotal();
                
                
    }

}
