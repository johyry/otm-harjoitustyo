package yatzy.ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        YatzyUi yatzy = new YatzyUi(scanner);
        yatzy.mainMenu();
    }
}
