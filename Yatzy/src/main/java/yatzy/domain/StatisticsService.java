package yatzy.domain;

import java.sql.SQLException;
import yatzy.dao.Database;
import yatzy.dao.FileStatisticsDao;
import yatzy.dao.StatisticsDao;


/**
 *
 * This class is responsible of handling statistics with DAO class.
 */
public class StatisticsService {

    private StatisticsDao statisticsDao;
    private UserService userService;

    public StatisticsService(Database database, UserService userService) {
        statisticsDao = new FileStatisticsDao(database);
        this.userService = userService;
    }

    
    /**
     * Method for inserting scoresheet into statistics
     *  
     */

    public void insertScoresheetToStatistics(User user, Scoresheet scoresheet) throws Exception {
        int id = userService.findUserId(user.getUsername());

        statisticsDao.insertStatistics(id, scoresheet);

    }
    
    /**
     * Method for printing all statistics in database
     *  
     */
    
    public void printAllStatistics() throws SQLException {
        int id = -1;
        Statistics statistics = statisticsDao.getStatistics(id);
        
        statistics.printAverages();
        statistics.printTotals();
        
    }
    
    /**
     * Method for printing single users statistics from db
     * 
     * @param userid
     *  
     */
    
    public void printUserStatistics(int userId) throws SQLException, Exception {
        Statistics statistics = statisticsDao.getStatistics(userId);
        
        statistics.printAverages();
        
        statistics.printTotals();
        
        
    }
    
    


}
