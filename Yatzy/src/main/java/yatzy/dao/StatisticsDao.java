
package yatzy.dao;

import java.sql.SQLException;
import java.util.List;
import yatzy.domain.Scoresheet;
import yatzy.domain.Statistics;


public interface StatisticsDao {
    
    void insertStatistics(int userId, Scoresheet scoresheet) throws SQLException;
    
    Statistics getStatistics(int userId) throws SQLException;
    
    
//    double getAverageTotalScore(int userId) throws SQLException;
    
    
}
