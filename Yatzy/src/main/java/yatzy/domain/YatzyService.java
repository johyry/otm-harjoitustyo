package yatzy.domain;

import java.util.ArrayList;
import java.util.List;
import yatzy.dao.FileUserDao;
import yatzy.dao.UserDao;

public class YatzyService {

    private UserDao userDao;
    private User loggedIn;
    private ScoreSheetService scoresheetService;

    public YatzyService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(String username) throws Exception {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;
        scoresheetService = new ScoreSheetService(user);

        return true;
    }

    public boolean createUser(String username, String name) throws Exception {
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, name);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void printUsers() throws Exception {
        List<User> users = userDao.getAll();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
        }

    }

    // AFTER LOGGED IN SERVICES
    public void printScoresheet() {
        System.out.println(this.scoresheetService.getScoreSheet());
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

        for (int i = 0; i < 5; i++) {
            if (i < hold.length && !hold[i].equals(i)) {
                dices.get(i).throwDice();
            }
        }

        return dices;
    }
    
    public void insertScore(List<Dice> dices, String input) {
        
    }

    public User getLoggedIn() {
        return this.loggedIn;
    }

}
