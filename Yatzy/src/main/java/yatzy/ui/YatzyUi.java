package yatzy.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.domain.Dice;
import yatzy.domain.ScoreSheetService;
import yatzy.domain.Scoresheet;
import yatzy.domain.User;
import yatzy.domain.YatzyService;

public class YatzyUi {

    private Scanner scanner;

    private YatzyService yatzyService;

    public YatzyUi(Scanner scanner) throws Exception {
        this.scanner = scanner;

        
        yatzyService = new YatzyService();
    }

    public void mainMenu() throws Exception {

        while (true) {
            System.out.println("");
            System.out.println("Welcome to Yatzy!\n"
                    + "Log in (1)\n"
                    + "Create new user (2)\n"
                    + "List existing users (3)\n"
                    + "Exit (4)");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                logIn();
            } else if (input.equals("2")) {
                createNewUser();
            } else if (input.equals("3")) {
                printUsers();
            } else if (input.equals("4")) {
                break;
            }

        }

    }

    private void userScreen() throws Exception {

        while (true) {
            System.out.println("");
            System.out.println("Welcome to User Screen " + yatzyService.getLoggedIn() + "!\n"
                    + "Single player game (1)\n"
                    + "Two player game (2)\n"
                    + "Statistics (3)\n"
                    + "Log out (4)");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                singlePlayerGame();
            } else if (input.equals("2")) {

            } else if (input.equals("3")) {

            } else if (input.equals("4")) {
                mainMenu();
            }
        }

    }

    private void logIn() throws Exception {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        if (yatzyService.login(username)) {
            System.out.println("Logging in succesful.");
            userScreen();

        } else {
            System.out.println("Username doesn't exist.");
        }
    }

    private void createNewUser() throws Exception {

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        if (name.length() <= 2 || username.length() <= 2) {
            System.out.println("Username or name too short.");
        } else if (yatzyService.createUser(username, name)) {
            System.out.println("New user succesfully created.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void printUsers() throws Exception {
        yatzyService.printUsers();
    }

    private void printDices(List<Dice> dices) {

        for (int a = 0; a < 5; a++) {
            System.out.print(dices.get(a).getValue() + " ");
        }

        System.out.println("");
    }

    private void singlePlayerGame() throws Exception {

        System.out.println("");
        System.out.println("Welcome to Single Player Game " + yatzyService.getLoggedIn() + "!");
        System.out.println("");

        for (int i = 0; i < 18; i++) {
            System.out.println();
            yatzyService.printScoresheet();
            System.out.println("");
            System.out.println("Turn: " + (i + 1));
            List<Dice> dices = yatzyService.firstThrow();
            printDices(dices);

            System.out.println("Throw again (1)\n"
                    + "Insert score to scoresheet (2)");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Dices you want to hold: (example input: 1 4 5)");
                input = scanner.nextLine();
                dices = yatzyService.throwDices(dices, input);
            } else if (input.equals("2")) {
                System.out.println("Insert the number of cell in the scoresheet");
                input = scanner.nextLine();
                yatzyService.insertScore(dices, input);
                continue;
            }

            printDices(dices);

            System.out.println("Throw again (1)\n"
                    + "Insert score to scoresheet (2)");

            input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Dices you want to hold: (example input: 1 4 5)");
                input = scanner.nextLine();
                dices = yatzyService.throwDices(dices, input);
            } else if (input.equals("2")) {
                System.out.println("Insert the number of cell in the scoresheet");
                input = scanner.nextLine();
                yatzyService.insertScore(dices, input);
                continue;
            }

            printDices(dices);

            System.out.println("Insert the number of cell in the scoresheet ");
            input = scanner.nextLine();
            yatzyService.insertScore(dices, input);
            

        }

    }

}
