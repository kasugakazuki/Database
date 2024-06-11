package Vending_Machine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class sqlcon {
	
Connection con;
	
	public void connect(){
		String DBname="vending_machine";
		String URL="jdbc:mySQL://localhost/"+DBname;
		
		String username="root";
		String pass="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(URL,username,pass);
			
			System.out.println("データベースに接続成功");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("エラー");
			System.out.println(e);
		}
		
	}
	
	public void selectsql() {
		
		try {
			PreparedStatement stmt=null;
			ResultSet rs=null;
			
			String GodsIdselectsql="select*from goods";
			
			//SQL実行
			stmt= con.prepareStatement(GodsIdselectsql);
			
			//実行結果取得
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("GoodsID");
				String name=rs.getString("GoodsName");
				int price=rs.getInt("Price");
				int remain=rs.getInt("Remain");
				
				System.out.println("id:"+id+"\nname:"+name+"\nprice:"+price+"\nremain:"+remain+"\n");
			}
			
		}catch(SQLException e) {
			System.out.println("エラー");
			System.out.println(e);
		}
		
	}
	
	public void insertsql() {
		try{
			Scanner scan;
			System.out.print("追加する商品名>>");
			scan= new Scanner(System.in);
			String name=scan.nextLine();
			
			System.out.print("\n追加する商品の値段>>");
			scan= new Scanner(System.in);
			int price=scan.nextInt();
			
			System.out.print("\n追加する商品の残数>>");
			scan= new Scanner(System.in);
			int remain=scan.nextInt();
			
			String insertsql="insert into goods(GoodsName,Price,Remain) values('"+name+"',"+price+","+remain+")";
			
			ResultSet RS=null;
			PreparedStatement stmt=null;
			stmt=con.prepareStatement(insertsql);
			int IN;
			IN=stmt.executeUpdate();
			
			scan.close();
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void updatesql() {
		try {
			Scanner UPscan;
			System.out.print("変更する商品名>>");
			UPscan=new Scanner(System.in);
			String name=UPscan.nextLine();
			
			System.out.print("\n追加する商品の値段>>");
			UPscan= new Scanner(System.in);
			int price=UPscan.nextInt();
			
			System.out.print("\n追加する商品の残数>>");
			UPscan= new Scanner(System.in);
			int remain=UPscan.nextInt();
			
			String updatesql="update goods set GoodsName='"+name+"',Price="+price+",Remain="+remain+" where GoodsName='"+name+"'";
			ResultSet RS=null;
			PreparedStatement stmt=null;
			stmt=con.prepareStatement(updatesql);
			int IN;
			IN=stmt.executeUpdate();
			
			UPscan.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void conclose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
