package Vending_Machine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	

	public static void main(String[] args) {
		
		ResultSet rs=null;
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("自走販売機シミュレーター\n\n");
		
		sqlconnect sqlcon=new sqlconnect();
		sqlcon.connect();
		
		System.out.println("商品ラインナップ!!\n-------------------------");
		String GoodsselectSQL="select*from goods";
		
		rs=sqlcon.SelectSQL(GoodsselectSQL);
		try {
			while(rs.next()) {
				String GoodsName=rs.getString("GoodsName");
				int GoodsPrice=rs.getInt("Price");
				
				System.out.println("商品名:"+GoodsName+"\n値段:"+GoodsPrice+"\n");
				
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		EventSelect eventSelect=new EventSelect();
		buyer buy=new buyer();
		int num=eventSelect.eventselect();
		if(num==1) {
			buy.buy();
		}else if(num==2) {
			
		}

		
		

	}

}
