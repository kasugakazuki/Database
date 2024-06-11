package Vending_Machine;

import java.util.Scanner;

public class EventSelect {
	
	public int eventselect() {
		System.out.println("あなたは購入者ですか?管理者ですか?\n購入者なら1を、管理者なら2を選択してください");
		
		
		int number;
		buyer buy=new buyer();
		administrator ad=new administrator();
		
		while(true) {
			System.out.print(">>");
			Scanner scanner=new Scanner(System.in);
			number = scanner.nextInt();
			
			
			if(number==1) {
				System.out.println("購入者モードに移行します\n\n");
				
				break;
			}else if(number==2) {
				System.out.println("管理者モードに移行します\n\n");
				
				break;
			}else{
				System.out.println("1か2の選択でお願いします。");
			}
			
			scanner.close();
		}
		return number;
		
		
		
		
	}
	
	

}
