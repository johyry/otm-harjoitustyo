
package yatzy.dao;

import java.sql.SQLException;
import java.util.List;
import yatzy.domain.Scoresheet;


public interface StatisticsDao {
    
    void insertStatistics(int userId, Scoresheet scoresheet) throws SQLException;
    
    List<Integer> getStatistics(int userId) throws SQLException;
    
    double getAverageTotalScore(int userId) throws SQLException;
    
    
}
