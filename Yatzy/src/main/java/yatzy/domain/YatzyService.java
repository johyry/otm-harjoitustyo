package yatzy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yatzy.dao.Database;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;

public class YatzyService {

    private List<User> usersLoggedIn;
    private List<ScoreSheetService> scoreSheetServices;
    private UserService userService;

    public YatzyService() throws Exception {
        userService = new UserService();
        usersLoggedIn = new ArrayList<>();
        scoreSheetServices = new ArrayList<>();
    }

    // USERSERVICE SERVICES
    public List<User> login(String username) throws Exception {
        User user = userService.logIn(username);

        if (user == null) {
            return null;
        }

        usersLoggedIn.add(user);
        scoreSheetServices.add(new ScoreSheetService(user));
        
        

        return usersLoggedIn;
    }

    public boolean createUser(String username, String name) throws Exception {
        if (userService.createUser(username, name)) {
            return true;
        } else {
            return false;
        }

    }

    public void printAllExistingUsers() throws Exception {
        
        userService.printAllExistingUsers();

    }

    

    // AFTER LOGGED IN SERVICES
    public void printScoresheet(User user) {
        ScoreSheetService scoresheetService = findScoreSheetService(user);
        scoresheetService.printScoreSheet();
    }

    public List<Dice> firstThrow() {
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dices.add(new Dice());
            dices.get(i).throwDice();
        }
        return dices;
    }

    public List<Dice> throwDices(List<Dice> dices, String input) {
        String[] hold = input.split(" ");
        Map<Integer, Integer> holdOrNot = new HashMap<>();
        holdOrNot.put(1, 0);
        holdOrNot.put(2, 0);
        holdOrNot.put(3, 0);
        holdOrNot.put(4, 0);
        holdOrNot.put(5, 0);

        for (String hold1 : hold) {
            switch (hold1) {
                case "1":
                    holdOrNot.put(1, 1);
                    break;
                case "2":
                    holdOrNot.put(2, 1);
                    break;
                case "3":
                    holdOrNot.put(3, 1);
                    break;
                case "4":
                    holdOrNot.put(4, 1);
                    break;
                case "5":
                    holdOrNot.put(5, 1);
                    break;
            }
        }

        for (int i = 0; i < dices.size(); i++) {
            if (holdOrNot.get(i + 1) == 0) {
                dices.get(i).throwDice();
            }
        }

        return dices;
    }
    
    public boolean insertScore(User user, List<Dice> dices, String input) {
        ScoreSheetService scoresheetService = findScoreSheetService(user);
        if (scoresheetService.insertScore(dices, input)) {
            return true;
        } else {
            return false;
        }

    }

    private ScoreSheetService findScoreSheetService(User user) {
        for (ScoreSheetService service : scoreSheetServices) {
            if (service.getUser().equals(user)) {
                return service;
            }
        }
        return null;
    }

    

}
