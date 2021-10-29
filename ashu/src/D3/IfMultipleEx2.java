package D3;

import java.util.Scanner;

public class IfMultipleEx2 {

	public static void main(String[] args) {
		/* 정수를 입력받고,
		 * 2의배수이면 2의 배수라고 출력, likewise 3,6, else 2,3,6의 배수가 아닙니다
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력해 주세요 : ");
		int num1 = scan.nextInt();
		
		if(num1%6 == 0) {
			System.out.println("6의 배수입니다.");
		}
		else if(num1%2 == 0) {
			System.out.println("2의 배수입니다.");
		}
		else if(num1%3 == 0) {
				System.out.println("3의 배수입니다.");
		
		}else{
			System.out.println("2,3,6의 배수가 아닙니다.");
			
		

	}
		scan.close();
	}

}
