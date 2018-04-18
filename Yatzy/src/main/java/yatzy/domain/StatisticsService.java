package yatzy.domain;

import java.sql.SQLException;
import yatzy.dao.Database;
import yatzy.dao.FileStatisticsDao;
import yatzy.dao.StatisticsDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johyry
 */
public class StatisticsService {

    private StatisticsDao statisticsDao;
    private UserService userService;

    public StatisticsService(Database database, UserService userService) {
        statisticsDao = new FileStatisticsDao(database);
        this.userService = userService;
    }

    

    public void insertScoresheetToStatistics(User user, Scoresheet scoresheet) throws Exception {
        int id = userService.findUserId(user.getUsername());

        statisticsDao.insertStatistics(id, scoresheet);

    }
    
    public Statistics getAllStatistics() throws SQLException {
        
        return statisticsDao.getAverageStatistics();
    }
    
    public Statistics getUserStatistics(User user) throws SQLException, Exception {
        int id = userService.findUserId(user.getUsername());
        return statisticsDao.getAverageStatistics(id);
    }
    
    
//
//    public double averageTotalScore(User user) throws Exception {
//        int id = userService.findUserId(user.getUsername());
//        double result = statisticsDao.getAverageTotalScore(id);
//        
//        return result;
//    }

}
