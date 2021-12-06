package Ashu_recap;

import java.util.Scanner;

public class classBoardManager2 {

	public static void main(String[] args) {
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		classBoardManager bm = new classBoardManager(scan); 
		
		do {
			menu = printMenu(scan);
			
			switch(menu) {
			case 1: bm.insertBoard();   break;
			case 2: bm.displayBoard();  break;
			case 3: bm.modifyBoard();   break;
			case 4: bm.deleteBoard();   break;
			case 5: break;
			default: System.out.println("wrong number");
			}
		}while(menu != 5);
		System.out.println("terminate programme");
	}
	
	public static int printMenu(Scanner scan) {
		System.out.println("Menu");
		System.out.println("1. board registration");
		System.out.println("2. board search");
		System.out.println("3. board amendment");
		System.out.println("4. baord delete");
		System.out.println("5. terminate programme");
		System.out.print("choose menu 1 to 5: ");
		int menu =scan.nextInt();
		return menu; 
	}
}
