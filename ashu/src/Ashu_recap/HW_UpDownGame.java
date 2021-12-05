package Ashu_recap;

import java.util.Scanner;

public class HW_UpDownGame {

	public static void main(String[] args) {
		int min =1, max = 100;
		int num = createNum(min, max);
		System.out.println(num);
	
		Scanner scan = new Scanner(System.in); 
		System.out.print("1에서 100사이의 정수를 입력하세요 : ");
		int user = scan.nextInt();
		
		do {
			
		check(num, user);      continue;
		
		}while(user == num); 
		
		System.out.println("정답입니다. 프로그램을 종료합니다.");

		scan.close();
	}
	/* 기능 : min, max 주어지면 랜덤 수 생성 후 해당 수를 알려주는 메소드 
	 * 매개변수 : int min, int max
	 * 리턴타입 : int 
	 * 메소드명 :createNum 
	 */
	public static int createNum(int min, int max) {
		int num = 0;
		num = (int)(Math.random()*(max-min+1)+min);
			
		return num;
	}
	
	/* 기능 : 번호 확인 - 두 정수가 주어지면 두 정수 비교 
	 * 매개변수 : int user, int num
	 * 리턴타입 : void
	 * 메소드명 :check 
	 */
	public static void check(int num, int user) {
		if(num < user) {
			System.out.println("Down!!");
		}
		if(num > user) {
			System.out.println("Up!!");
		}
		System.out.println();
	}
	
}
