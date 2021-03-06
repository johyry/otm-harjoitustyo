package yatzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import yatzy.domain.Scoresheet;
import yatzy.domain.Statistics;

/**
 * This class is responsible of handling statistics with database.
 */

public class FileStatisticsDao implements StatisticsDao {

    private Database database;

    public FileStatisticsDao(Database database) {
        this.database = database;
    }
    
    /**
     * Inserts one scoresheet into statistics
     * 
     * @param userId as INT
     * @param scoresheet object
     * 
     * 
     */

    @Override
    public void insertStatistics(int userId, Scoresheet scoresheet) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO statistics VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setObject(1, userId);
        stmt.setObject(2, scoresheet.getOnes());
        stmt.setObject(3, scoresheet.getTwos());
        stmt.setObject(4, scoresheet.getThrees());
        stmt.setObject(5, scoresheet.getFours());
        stmt.setObject(6, scoresheet.getFives());
        stmt.setObject(7, scoresheet.getSixes());
        stmt.setObject(8, scoresheet.getUpperSectionTotal());
        stmt.setObject(9, scoresheet.getBonus());
        stmt.setObject(10, scoresheet.getOnePair());
        stmt.setObject(11, scoresheet.getTwoPair());
        stmt.setObject(12, scoresheet.getThreeOfAKind());
        stmt.setObject(13, scoresheet.getFourOfAKind());
        stmt.setObject(14, scoresheet.getSmallStraight());
        stmt.setObject(15, scoresheet.getBigStraight());
        stmt.setObject(16, scoresheet.getFullHouse());
        stmt.setObject(17, scoresheet.getChance());
        stmt.setObject(18, scoresheet.getYatzy());
        stmt.setObject(19, scoresheet.getLowerSectionTotal());
        stmt.setObject(20, scoresheet.getTotal());

        stmt.executeUpdate();
        stmt.close();
        connection.close();

    }
    
    /**
     * Finds users statistics from db
     * 
     * @param userId as int
     * 
     * @return Statistics object
     */

    @Override
    public Statistics getStatistics(int userId) throws SQLException {
        Statistics statistics = new Statistics();
        int index = 0;

        Connection connection = database.getConnection();
        
        PreparedStatement stmt;

        if (userId != -1) {
            stmt = connection.prepareStatement("SELECT * FROM statistics where user_id = ?");
            stmt.setObject(1, userId);
        } else {
            stmt = connection.prepareStatement("SELECT * FROM statistics");

        }
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            statistics.setTotalOnes(rs.getInt("ones") + statistics.getTotalOnes());
            statistics.setTotalTwos(rs.getInt("twos") + statistics.getTotalTwos());
            statistics.setTotalThrees(rs.getInt("threes") + statistics.getTotalThrees());
            statistics.setTotalFours(rs.getInt("fours") + statistics.getTotalFours());
            statistics.setTotalFives(rs.getInt("fives") + statistics.getTotalFives());
            statistics.setTotalSixes(rs.getInt("sixes") + statistics.getTotalSixes());
            statistics.setTotalUpperSection(rs.getInt("uppersectiontotal") + statistics.getTotalUpperSection());
            statistics.setTotalBonus(rs.getInt("bonus") + statistics.getTotalBonus());
            statistics.setTotalOnePair(rs.getInt("onepair") + statistics.getTotalOnePair());
            statistics.setTotalTwoPair(rs.getInt("twopair") + statistics.getTotalTwoPair());
            statistics.setTotalThreeOfAKind(rs.getInt("threeofakind") + statistics.getTotalThreeOfAKind());
            statistics.setTotalFourOfAKind(rs.getInt("fourofakind") + statistics.getTotalFourOfAKind());
            statistics.setTotalSmallStraight(rs.getInt("smallstraight") + statistics.getTotalSmallStraight());
            statistics.setTotalBigStraight(rs.getInt("bigstraight") + statistics.getTotalBigStraight());
            statistics.setTotalFullHouse(rs.getInt("fullhouse") + statistics.getTotalFullHouse());
            statistics.setTotalChance(rs.getInt("chance") + statistics.getTotalChance());
            statistics.setTotalYatzy(rs.getInt("yatzy") + statistics.getTotalYatzy());
            statistics.setTotalLowerSection(rs.getInt("lowersectiontotal") + statistics.getTotalLowerSection());
            statistics.setTotalTotal(rs.getInt("total") + statistics.getTotalTotal());
            statistics.setTotalGames(statistics.getTotalGames() + 1);

        }
        
        statistics.calculateAveragesFromTotals();

        rs.close();
        stmt.close();
        connection.close();

        return statistics;
    }


}
