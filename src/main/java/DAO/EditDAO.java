package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDAO {
    String url = "jdbc:mysql://localhost:3306/db_final_test";
    String user = "root";
    String password = "password";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    
    public void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver", e);
        }
    }

    public void disconnect() throws SQLException {
        try {
            if (statement != null) {
                statement.close();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void update(String janCode, String bookName, String bookKanaName, int price, String issueDate) 
    		throws SQLException {
        try {
            connect();
            String sql = "UPDATE book SET BOOK_NM=?, BOOK_KANA=?, PRICE=?, ISSUE_DATE=?, UPDATE_DATETIME=current_timestamp() WHERE JAN_CD=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, bookName);
            statement.setString(2, bookKanaName);
            statement.setInt(3, price);
            statement.setString(4, issueDate);
            statement.setString(5, janCode);
            statement.executeUpdate();
        } finally {
            disconnect();
        }
    }
	
}
