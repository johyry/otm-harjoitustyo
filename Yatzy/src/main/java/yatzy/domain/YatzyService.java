package yatzy.domain;

import java.sql.SQLException;
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
    private StatisticsService statisticsService;
    
    /**
     * This class is the main class of the software.
     */

    public YatzyService() throws Exception {
        Database database = new Database("jdbc:sqlite:usersAndStatistics.db");
        database.init();

        userService = new UserService(database);
        statisticsService = new StatisticsService(database, userService);

        usersLoggedIn = new ArrayList<>();
        scoreSheetServices = new ArrayList<>();
    }

    /**
     * Method logs in an user to the software. It also creates a scoresheetservice for user.
     * It return a list of all users logged in.
     *
     * @param   username   User gives username
     * 
     * @return list of users logged in
     */
    public List<User> login(String username) throws Exception {

        User user = userService.logIn(username);

        if (user == null) {
            return null;
        }

        usersLoggedIn.add(user);
        scoreSheetServices.add(new ScoreSheetService(user));

        return usersLoggedIn;
    }

    /**
     * Method for creating user
     *
     * @param   username   
     * @param   name       
     * 
     * @return true if succesfull
     */
    
    public boolean createUser(String username, String name) throws Exception {
        if (userService.createUser(username, name)) {
            return true;
        } else {
            return false;
        }

    }
    
     /**
     * Method for printing all existing users in database
     *  
     */

    public void printAllExistingUsers() throws Exception {

        userService.printAllExistingUsers();
    }

    /**
     * Method for printing single users score sheet
     * 
     * @param user user object
     *  
     */
    
    public void printScoresheet(User user) {
        ScoreSheetService scoresheetService = findScoreSheetService(user);

        scoresheetService.printScoreSheet();
    }
    
    /**
     * Method for first throw of the turn
     *  
     *  @return List<Dice> list of dices
     */

    public List<Dice> firstThrow() {
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dices.add(new Dice());
            dices.get(i).throwDice();
        }
        return dices;
    }
    
    /**
     * Method for throwing dices with a possibility to give input to hold certain dices
     * 
     * @param dices
     * @param input defines dices to be held
     *  
     * @return List<Dice> list of dices
     */

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

    /**
     * Method for inserting score to players scoresheet
     * 
     * @param user
     * @param dices
     * @param input number of the row of the scoresheet
     * 
     * @return true if succesfull
     *  
     */
    
    public boolean insertScore(User user, List<Dice> dices, String input) {
        ScoreSheetService scoresheetService = findScoreSheetService(user);
        if (scoresheetService.insertScore(dices, input)) {
            return true;
        } else {
            return false;
        }

    }
    
    /**
     * Method for finding users scoresheetservice
     * 
     * @param user
     * 
     * @return scoresheetservice
     *  
     */

    private ScoreSheetService findScoreSheetService(User user) {
        for (ScoreSheetService service : scoreSheetServices) {
            if (service.getUser().equals(user)) {
                return service;
            }
        }
        return null;
    }
    
    
    public List<User> getUsersLoggedIn() {
        return usersLoggedIn;
    }
    
    /**
     * Method for calculating the winner of the game
     *  
     * @return String returns user and the score
     */

    public String getWinner() {
        int bestScore = 0;
        User user = null;

        for (ScoreSheetService service : scoreSheetServices) {
            if (service.scoresheet.getTotal() > bestScore) {
                user = service.getUser();
                bestScore = service.scoresheet.getTotal();
            }
        }

        return user + " with score of: " + bestScore;

    }

    public void printAllStatistics() throws SQLException {
        statisticsService.printAllStatistics();

    }

    public boolean printUserStatistics(String input) throws Exception {
        int id = userService.findUserId(input);
        if (id == -1) {
            return false;
        } else {
            statisticsService.printUserStatistics(id);
            return true;
        }
    }

    public void saveStatistics() throws Exception {
        
        for (int i = 0; i < usersLoggedIn.size(); i++) {
            User user = usersLoggedIn.get(i);
            
            statisticsService.insertScoresheetToStatistics(user, findScoreSheetService(user).scoresheet);
            
        }
        
    }

}
