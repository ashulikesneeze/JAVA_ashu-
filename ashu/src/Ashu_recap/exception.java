package Ashu_recap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exception {

	public static void main(String[] args) {
		int num1 =1, num2 = 0;
		int res = 0;
		try {
			res = num1 /num2;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번지로 배열에 접근");
		}catch(ArithmeticException e) {
			//printStackTrace() : 예외가 발생된 정보들을 콘솔에 출력하는 메소드
			e.printStackTrace();
			//getMessage() : 예외 정보를 간단히 문자열로 알려주는 메소드
			System.out.println(e.getMessage());
			System.out.println("0으로 나눔");
		}catch(Exception e) {
			System.out.println("모든 예외 처리");
		}
		
		System.out.println("포로그램 종료");
		
		Scanner scan = new Scanner(System.in);
		int num3, num4;
		char op;
		double result = 0.0;
		
		System.out.println("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 4) : ");
		try {
			num3 = scan.nextInt();
			op = scan.next().charAt(0);
			num4 = scan.nextInt();
			
			switch(op) {
			case '+': result = num3 + num4; break;
			case '-': result = num3 - num4; break;
			case '*': result = num3 * num4; break;
			case '%': result = num3 % num4; break;
			case '/': result = num3 / (double)num4; break;
			}
			System.out.println("" + num3 + op + num4 + "=" + result);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다.");
		}
		catch(InputMismatchException e) {
			System.out.println("입력을 잘못 하였습니다.");
		}
		catch(Exception e) {
			System.out.println("예외발생");
		}
		scan.close(); 
   }
}
