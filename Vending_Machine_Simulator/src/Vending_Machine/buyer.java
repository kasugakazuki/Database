package Vending_Machine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class buyer {
	
	public void buy(){
		String selectqsl="select*from goods";
		
		sqlconnect sqlcon=new sqlconnect();
		sqlcon.connect();
		
		ResultSet rs=null;
		rs=sqlcon.SelectSQL(selectqsl);
		
		try {
			while(rs.next()) {
				int GoodsID=rs.getInt("GoodsID");
				String GoodsName=rs.getString("GoodsName");
				int GoodsPrice=rs.getInt("Price");
				int GoodsRemain=rs.getInt("Remain");
				
				if(GoodsRemain!=0) {
					System.out.println("商品名:"+GoodsName+"\n値段:"+GoodsPrice+"\n");
				}
				
				
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		
		System.out.println("お金を入れてください(例10円>>16)");
		Scanner scanner;
		
		int coinsum;
		
		while(true) {
			coinsum=0;
			System.out.print("10円>>");
			scanner=new Scanner(System.in);
			int tenCoin=scanner.nextInt();
			coinsum+=(10*tenCoin);
			
			System.out.print("\n50円>>");
			scanner=new Scanner(System.in);
			int fiftycoin= scanner.nextInt();
			coinsum+=(50*fiftycoin);
			
			System.out.print("\n100円>>");
			scanner=new Scanner(System.in);
			int one_hundredcoin= scanner.nextInt();
			coinsum+=(100*one_hundredcoin);
			
			System.out.print("\n500円>>");
			scanner=new Scanner(System.in);
			int five_hundredcoin= scanner.nextInt();
			coinsum+=(500*five_hundredcoin);
			
			System.out.print("\n1000円>>");
			scanner=new Scanner(System.in);
			int one_thousandcoin= scanner.nextInt();
			coinsum+=(1000*one_thousandcoin);
			
			System.out.println("\n投入累計金額:"+coinsum);
			System.out.println("確定しますか(Yes:1、No:2)");
			scanner=new Scanner(System.in);
			int flag= scanner.nextInt();
			if(flag==1) {
				break;
			}else {
				System.out.println("再入力してください\n");
			}
			
		}
		
		System.out.println("購入できる商品はこれらです。");
		
		sqlconnect selectsql=new sqlconnect();
		selectsql.connect();
		String SelectSQL="select*from goods where Price <="+coinsum;
		ResultSet Rset=selectsql.SelectSQL(SelectSQL);
		
		try {
			while(Rset.next()) {
				int GoodsID=rs.getInt("GoodsID");
				String GoodsName=rs.getString("GoodsName");
				int GoodsPrice=rs.getInt("Price");
				int GoodsRemain=rs.getInt("Remain");
				
				if(GoodsRemain!=0) {
					System.out.println("商品名:"+GoodsName+"\n値段:"+GoodsPrice+"\n");
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
