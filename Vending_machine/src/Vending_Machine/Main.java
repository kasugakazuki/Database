package Vending_Machine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("自動販売機シミュレーター");
		
		sqlcon SQLCON=new sqlcon();
		SQLCON.connect();
		
		SQLCON.selectsql();
			
			System.out.print("追加:1、更新:2>>");
			Scanner scanner=new Scanner(System.in);
			int str=scanner.nextInt();
			//scanner.close();
			if(str==1) {
				SQLCON.insertsql();
				SQLCON.selectsql();
				
			}else if(str==2) {
				SQLCON.updatesql();
				SQLCON.selectsql();
			}
		
		
		
	}

}
