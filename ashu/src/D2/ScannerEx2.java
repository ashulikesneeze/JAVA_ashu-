package D2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
	/*콘솔에서 두 정수를 입력받아 입력받은 정수들의 합을 구하는 코드를 작성하세요. */
	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int num1 = scan.nextInt();
		System.out.println("입력된 정수는 " + num1 + " 입니다.");

		System.out.print("정수를 입력하세요: ");
		int num2 = scan.nextInt();
		System.out.println("입력된 정수는 " + num2 + " 입니다.");
		
		scan.close();
		
		int total = num1 + num2;
		System.out.println("합은 " + total + " 입니다.");
	
	
		int num3, num4;
		System.out.print("두 정수를 입력하세요(예:1 2) : ");
		Scanner Scan = new Scanner(System.in);
		
		num3 = scan.nextInt();
		num4 = scan.nextInt();
		
		int result1 = num3 +num4;
		double result2 = num3 / (double)num4;
		
		System.out.println(num3 + " + " + num4 + " = " + result1);
		System.out.println(num3 + " + " + num4 + " = " + result2);
		scan.close();
	}

}
