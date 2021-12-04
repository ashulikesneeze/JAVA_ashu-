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
		
		
		switch(operator) {
		case '+':
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1+ num2));
			break;
		case '-': 
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1- num2));
			break;
		case '*':
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1* num2));
			break;
		case '/':
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1/(double) num2));
			break;
		case '%':
			System.out.println(num1 + " " + operator + " " + num2 + "=" + (num1% num2));
			break;
		default:
			System.out.println(operator + "는 산술연산자가 아닙니다.");
		}
			
			
		System.out.print("월을 입력하세요(1~12) : ");
		int month = scan.nextInt();
		
		if(month == 1|| month ==3 || month == 5 || month ==7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + "월은 31일 까지 있습니다.");
		}
		else if(month == 2) {
			System.out.println(month + "월은 28일까지 있습니다.");
		}
		else if(month ==4 || month==6 || month==9 || month==11 ) {
			System.out.println(month + "월은 30일까지 있습니다.");
		}
		else {
			System.out.println("입력을 잘못했습니다.");
		}
		
		
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println(month + "월은 31일 까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		case 4,6,9,11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		default:
			System.out.println("입력을 잘못했습니다.");		
		}
		
		//입력받은 정수가 소수인지 아닌지 
		System.out.print("정수를 입력하세요 : ");
		int num3 = scan.nextInt();
		int i, count;
		for(i=1, count=0; i<=num3; i++) {
			if(num3 % i==0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println(num3 + "는 소수");
		}
		else {
			System.out.println(num3 + "는 소수가 아님");
		}
		switch(count) {
		case 2: System.out.println(num3 + "은 소수");  break;
		default: System.out.println(num3 + "는 소수가 아님");
		}
		scan.close();	
		
	}

}
