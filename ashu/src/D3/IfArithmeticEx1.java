package D3;

import java.util.Scanner;

public class IfArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술연사자(+,-,*,/,%) 중 하나를 입력하여 입력한 연산자가 +이면
		 * 두 정수의 합을 출력하는 코드를 작성하세요
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		System.out.println("" + num1 + "" + operator + " " + num2);
		if(operator == '+') {
			System.out.println(num1 + " " + operator + " " + num2 + " = "
				+ (num1 + num2));
		
		}else if(operator == '-') {
			System.out.println(num1 + " " + operator + " " + num2 + " = "
					+ (num1 - num2));
			
		}else if(operator == '*') {
			System.out.println(num1 + " " + operator + " " + num2 + " = "
					+ (num1 * num2));
		}else if(operator == '/') {
			System.out.println(num1 + " " + operator + " " + num2 + " = "
					+ ((double)num1 / num2));
		}else if(operator == '%') {
			System.out.println(num1 + " " + operator + " " + num2 + " = "
					+ (num1 % num2));
		}else{
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		
		System.out.print("정수를 입력하세요: ");
		int num3 = scan.nextInt();
		System.out.println("입력된 정수는 " + num3 + " 입니다.");

		System.out.print("정수를 입력하세요: ");
		int num4 = scan.nextInt();
		System.out.println("입력된 정수는 " + num4 + " 입니다.");
		
		
		int total = num3 + num4;
		System.out.println("합은 " + total + " 입니다.");		
		}
		scan.close();
	}

}
