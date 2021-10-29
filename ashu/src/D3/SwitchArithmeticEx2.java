package D3;

import java.util.Scanner;

public class SwitchArithmeticEx2 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산자에 맞는 결과를 출력
		 * 예) 두 정수와 산술 연산자를 입력하세요 : 1 + 2
		 * 1 + 2 = 3
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		System.out.println("" + num1 + "" + operator + " " + num2);
		switch(operator) {
		case '+':
			System.out.println(num1 + "" + operator + "" + num2 + " = "
			+ (num1 + num2));
		break;
		case '-':
			System.out.println(num1 + "" + operator + "" + num2 + " = "
			+ (num1 - num2));
		break;
		case '/':
			System.out.println(num1 + "" + operator + "" + num2 + " = "
			+ (num1 / num2));
		break;
		case '%':
			System.out.println(num1 + "" + operator + "" + num2 + " = "
			+ (num1 % num2));
		break;
		case '*':
			System.out.println(num1 + "" + operator + "" + num2 + " = "
			+ (num1 * num2));
		break;
		default:
			System.out.println(operator + "는 잘못된 연산자입니다");
			}
		scan.close();
	}

}
