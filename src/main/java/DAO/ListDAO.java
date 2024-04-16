package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ListDAO {

	String url  = "jdbc:mysql://localhost:3306/db_final_test";
	String user = "root";
	String password= "password";
	Connection conection=null;
	
	public void conect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conection = DriverManager.getConnection(url,user,password);
	}
	public ArrayList<HashMap<String,String>> select() throws Exception{
		PreparedStatement statement =null;
		ResultSet rs = null;
		String sql= "select * from book ";
		ArrayList<HashMap<String, String>> rows= new ArrayList<HashMap<String, String>>();
		conect();
		statement=conection.prepareStatement(sql);
		rs=statement.executeQuery();
		while(rs.next()) {
			HashMap<String, String> columns = new HashMap<String,String>();
			String janCode=rs.getString("JAN_CD");
			columns.put("janCode", janCode);
			String isbnCode=rs.getString("ISBN_CD");
			columns.put("isbnCode", isbnCode);
			String bookName=rs.getString("BOOK_NM");
			columns.put("bookName", bookName);
			String bookKanaName=rs.getString("BOOK_KANA");
			columns.put("bookKanaName", bookKanaName);
			String price=rs.getString("PRICE");
			columns.put("price", price);
			String issueDate=rs.getString("ISSUE_DATE");
			columns.put("issueDate", issueDate);
			String createDateTime=rs.getString("CREATE_DATETIME");
			columns.put("createDateTime", createDateTime);
			String updateDateTime=rs.getString("UPDATE_DATETIME");
			columns.put("updateDateTime", updateDateTime);
			rows.add(columns);
			}
		return rows;
		}
}
