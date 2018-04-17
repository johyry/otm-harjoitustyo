package yatzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import yatzy.domain.Scoresheet;

public class FileStatisticsDao implements StatisticsDao {

    private Database database;

    public FileStatisticsDao(Database database) {
        this.database = database;
    }

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

    @Override
    public List<Integer> getStatistics(int userId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageTotalScore(int userId) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT total FROM statistics WHERE user_id = ?");
        stmt.setObject(1, userId);

        ResultSet rs = stmt.executeQuery();

                
        double sum = 0;
        int index = 0;
        double average = 0;
        
        while (rs.next()) {
            sum += rs.getInt("total");
            index++;
            System.out.println(rs.getInt("total"));
        }
        
        average = sum / index;
        
        return average;

    }

}
