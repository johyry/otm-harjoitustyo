
package yatzy.domain;

import java.util.Random;

     /**
     * Class represents a single dice.
     * 
     *  
     */

public class Dice {
    private int value;
    
    public Dice(int value) {
        this.value = value;
    }
    
    public Dice() {
        
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Method for throwing dice.
     *  @return random number between 1 and 6.
     */

    public int throwDice() {
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
        return value;
    }
}
