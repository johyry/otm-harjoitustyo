package yatzy.ui;

import java.util.List;
import java.util.Scanner;
import yatzy.domain.Dice;
import yatzy.domain.User;
import yatzy.domain.YatzyService;

public class YatzyUi {

    private Scanner scanner;

    private YatzyService yatzyService;
    List<User> usersLoggedIn;

    public YatzyUi(Scanner scanner) throws Exception {
        this.scanner = scanner;

        yatzyService = new YatzyService();

    }

    public void mainMenu() throws Exception {

        while (true) {
            System.out.println("");
            System.out.println("Welcome to Yatzy!");
            printLoggedInUsers();
            System.out.println("Play Yatzy (1)\n"
                    + "Log in (2)\n"
                    + "Log out (3)\n"
                    + "Create new user (4)\n"
                    + "List existing users (5)\n"
                    + "View statistics (6)\n"
                    + "Exit (7)");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                playYatzy();
            } else if (input.equals("2")) {
                logIn();
            } else if (input.equals("3")) {
                logOut();
            } else if (input.equals("4")) {
                createNewUser();
            } else if (input.equals("5")) {
                printAllExistingUsers();
            } else if (input.equals("6")) {
                statisticsMenu();
            } else {
                break;
            }

        }

    }

    private void logIn() throws Exception {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        usersLoggedIn = yatzyService.login(username);

        if (usersLoggedIn != null) {
            System.out.println("Logging in succesful.");

        } else {
            System.out.println("Username doesn't exist.");
        }
    }

    private void logOut() {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        boolean onnistui = false;

        for (User user : usersLoggedIn) {
            if (user.getUsername().equals(username)) {
                System.out.println("Log out succesful.");
                usersLoggedIn.remove(user);
                onnistui = true;
                break;
            }
        }
        if (onnistui == false) {
            System.out.println("User not found.");
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

    private void playYatzy() throws Exception {
        if (usersLoggedIn == null) {
            System.out.println("Log in first!");

        } else {

            for (int i = 0; i < 15; i++) {

                for (int a = 0; a < usersLoggedIn.size(); a++) {
                    User user = usersLoggedIn.get(a);
                    System.out.println(user + "s turn.");

                    System.out.println();
                    yatzyService.printScoresheet(user);
                    System.out.println("");
                    System.out.println("Turn: " + (i + 1) + " of " + user);
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
                        while (true) {
                            System.out.println("Insert the number of cell in the scoresheet");
                            input = scanner.nextLine();
                            if (yatzyService.insertScore(user, dices, input)) {
                                break;
                            }

                        }
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
                        while (true) {
                            System.out.println("Insert the number of cell in the scoresheet");
                            input = scanner.nextLine();
                            if (yatzyService.insertScore(user, dices, input)) {
                                break;
                            }

                        }
                        continue;
                    }

                    printDices(dices);

                    while (true) {
                        System.out.println("Insert the number of cell in the scoresheet");
                        input = scanner.nextLine();
                        if (yatzyService.insertScore(user, dices, input)) {
                            break;
                        }

                    }

                }
            }
            System.out.println();
            System.out.println("Final scores: ");
            System.out.println();

            for (int i = 0; i < usersLoggedIn.size(); i++) {
                yatzyService.printScoresheet(usersLoggedIn.get(i));
                System.out.println();

            }
            System.out.println();
            System.out.println("Winner is: " + yatzyService.getWinner());
            yatzyService.saveStatistics();

        }

    }

    private void statisticsMenu() throws Exception {
        System.out.println("");
        System.out.println("Welcome to Statistics menu!");
        System.out.println();

        while (true) {
            System.out.println("View general statistics (1)\n"
                    + "View user based statistics (2)\n"
                    + "Exit (3)\n");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                yatzyService.printGeneralStatistics();
            } else if (input.equals("2")) {
                System.out.println();
                printAllExistingUsers();
                System.out.println();
                System.out.println("Enter the username of the user of whose statistics you would like to view.");
                input = scanner.nextLine();

                if (yatzyService.printUserStatistics(input)) {

                } else {
                    System.out.println("User not found.");
                }

            } else {
                break;
            }

        }
    }

    private void printAllExistingUsers() throws Exception {
        yatzyService.printAllExistingUsers();
    }

    private void printDices(List<Dice> dices) {

        for (int a = 0; a < 5; a++) {
            System.out.print(dices.get(a).getValue() + " ");
        }

        System.out.println("");
    }

    private void printLoggedInUsers() {
        System.out.println("Users logged in:");
        if (usersLoggedIn == null) {
            System.out.println("None");
        } else {
            for (int i = 0; i < usersLoggedIn.size(); i++) {
                System.out.println(usersLoggedIn.get(i));
            }
        }

    }

}
