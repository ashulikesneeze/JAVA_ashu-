package Ashu_recap;

import java.util.Scanner;

public class IfElseForSwitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.print("두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt(); 
		
		if(operator == '+') {
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1+ num2));
		}
		else if(operator == '-') {
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1- num2));
		}
		else if(operator == '*') {
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1* num2));
		}
		else if(operator == '/') {
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1/(double) num2));
		}
		else if(operator == '%') {
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1% num2));
		}
		else{
			System.out.println(operator + "는 산술연산자가 아닙니다.");
		}
		scan.close();		
	}

}
