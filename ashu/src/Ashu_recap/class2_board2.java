package Ashu_recap;

import java.util.Scanner;

import D10.Board;

public class class2_board2 {

	public static void main(String[] args) {
		
		class2_board1 [] boardList = new class2_board1[10];
		
		//게시글 관리 프로그램 
		int menu = 0;
		//현재까지 저장된 게시글 갯수 
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		do {
			menu = printMenu(scan);
			String title, contents, writer, date;
			int num;
			
			switch(menu) {
			case 1: 
				scan.nextLine();
				System.out.print("title: ");
				title=scan.nextLine();
				System.out.print("contents: ");
				contents =scan.nextLine();
				System.out.print("author: ");
				writer = scan.next();
				System.out.print("date: ");
				date = scan.next();
				
				//게시글을 생성한 후, 입력받은 정보들로 초기화를 하고, 
				//초기화된 게시글은 내가 원하는 배열의 번지에 저장 
				boardList[count] = new class2_board1(count+1, title, contents, date, writer); 
				
				//저장된 게시글 하나 증가
				count++;
				break; 
				
			case 2: 
				System.out.print("search with board num : ");
				num = scan.nextInt();
				if(num <= count) {
					//게시글 삭제여부를 확인해서 삭제된 게시글이면 
					//삭제되었습니다라고 출력하고, 아니면 게시글 조회
					if(boardList[num-1] == null) {
						System.out.println("no longer available board");
					}
					else {
						//조회수 증가
						boardList[num-1].updateViews();
						//게시글 조회
						boardList[num-1].print();
					}
				}
				break; 
			
			case 3:
				System.out.print("board num : ");
				num = scan.nextInt();
				if(boardList[num-1] == null) {
					System.out.println("unable to modify");
				}
				else { 
					//게시글 번호에서 입력한 엔터 처리
					scan.nextLine();
					System.out.print("title: ");
					title = scan.nextLine();
					System.out.print("contents: ");
					contents = scan.nextLine();
					if(num <= count) {
						boardList[num-1].modify(title, contents);
					}
				}
				break;
				
			//해당 게시글을 삭제하면 삭제된 위치에 null을 넣어 삭제 처리
			case 4: 
				System.out.print("board num: ");
				num = scan.nextInt();
				if(num <= count) {
					boardList[num-1] = null;
				}
				break;
			case 5: break;
			default: 
				System.out.println("wrong number");
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
