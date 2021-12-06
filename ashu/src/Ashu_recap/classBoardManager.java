package Ashu_recap;

import java.util.Scanner;

public class classBoardManager {

	private class2_board1 []boardList;
	private int count;
	private Scanner scan;
	
	public classBoardManager(Scanner scan) {
		this(10,scan);
	}
	
	
	public classBoardManager(int size, Scanner scan) {
		this.scan = scan;
		if(size > 10) {
			boardList = new class2_board1[size];
		}else {
			boardList = new class2_board1[10];
		}
	}
	
	//게시글 등록 가능 
	public void insertBoard() {
		scan.nextLine(); 
		System.out.print("title: ");
		String title=scan.nextLine();
		System.out.print("contents: ");
		String contents =scan.nextLine();
		System.out.print("author: ");
		String writer = scan.next();
		System.out.print("date: ");
		String date = scan.next();
		
		boardList[count] = new class2_board1(count+1, title, contents, date, writer);
		count++;	
	}
	
	//게시글 조회 가능 
	public void displayBoard() {
		System.out.print("board num for search : ");
		int num=scan.nextInt();
		if(num <= count) {
			if(boardList[num-1] == null) {
				System.out.println("no longer availabe board");
			}
			else {
				boardList[num-1].updateViews();
				boardList[num-1].print();
			}
		}
	}
	
	//게시글 수정 가능 
	public void modifyBoard() {
		System.out.print("board num : ");
		int num = scan.nextInt();
		if(boardList[num-1] == null) {
			System.out.println("unable to modify");
		}
		else {System.out.print("title: ");
		String title = scan.nextLine();
		System.out.print("contents: ");
		String contents = scan.nextLine();
		if(num <= count) {
			boardList[num-1].modify(title, contents);
			}
		}
	}
	//게시글 삭제 기능 
	public void deleteBoard() {
		System.out.print("board num : ");
		int num = scan.nextInt();
		if(num <= count) {
			boardList[num-1] = null; 
		}
	}
}
