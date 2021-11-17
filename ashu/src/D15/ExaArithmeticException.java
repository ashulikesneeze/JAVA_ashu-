package D15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExaArithmeticException {
	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드 작성.
		// 단, 메소드를 이용하고, 예외처리.
		/*function : 
		 * return type:int num1, int num2, char op
		 * return : 
		 * title: ArithmeticException
		 */	
	Scanner scan = new Scanner(System.in);
	int num1, num2;
	char op;
	double res = 0.0;
	
	System.out.println("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 4) : "); 
	try {
	num1 = scan.nextInt();
	op = scan.next().charAt(0);
	num2 = scan.nextInt();
	res = arithmetic(num1, op, num2);
	System.out.println(""+num1+op+num2+"="+res);
	}catch(ArithmeticException e) {
		System.out.println("0으로 나눌 수 없습니다.");
	}catch(InputMismatchException e) {
		System.out.println("입력을 제대로 하세요.");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	scan.close();
	}
   public static double arithmetic(int num1, char op, int num2) throws Exception {
		double res=0.0; 
			switch(op) {
			//break; 쓰려면 return 대신 res=
			case '+': return num1 + num2;
			case '-': return num1 - num2;
			case '*': return num1 * num2;
			case '/': return num1 / (double)num2;
			case '%': return num1 % num2;
			//throw new Exception 치면 빨간줄이 뜨면서 자동으로 fix (throw...)뜬다 
			default:  throw new Exception("잘못된 연산자입니다.");
			}
	} 
	
}





