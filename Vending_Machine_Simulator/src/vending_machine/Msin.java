package vending_machine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Msin {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("自動販売機シミュレーター");
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String sql="select*from goods";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mySQL://localhost/vending_machine","root","");
			System.out.println("接続成功");
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
		}catch(ClassNotFoundException e){
			System.out.println("JDBCドライバのロードでエラーが発生しました");
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
		}finally {
			try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("データベースへのアクセスでエラーが発生しました。");
            }
		}
		

	}

}
