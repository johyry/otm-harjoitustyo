
package yatzy.domain;

import java.util.Random;


public class Dice {
    private int value;

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public int throwDice() {
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
        return value;
    }
}
