package Vending_Machine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlconnect {
	
	Connection con;
	
	public void connect(){
		String DBname="vending_machine";
		//String propaties="?characterEncoding=UTF-8&serverTimezone=JST";
		//String URL="jdbc:mySQL://localhost/"+DBname+propaties;
		String URL="jdbc:mySQL://localhost/"+DBname;
		
		String username="root";
		String pass="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(URL,username,pass);
			
			//System.out.println("データベースに接続成功");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("エラー");
			System.out.println(e);
		}
		
	}
	
	public void sqlclose() {
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public ResultSet SelectSQL(String sql) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			//SQL実行
			stmt= con.prepareStatement(sql);
			
			//実行結果取得
			rs=stmt.executeQuery();
		}catch(SQLException e) {
			System.out.println("エラー");
			System.out.println(e);
		}		
		
		return rs;
	}
	
	

}
