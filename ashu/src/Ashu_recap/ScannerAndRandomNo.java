package Ashu_recap;

import java.util.Scanner;

public class ScannerAndRandomNo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수입력");
		int num1 = scan.nextInt();
		
		System.out.print("실수입력");
		double num2 = scan.nextDouble();
		
		System.out.print("문자입력");
		char ch1 = scan.next().charAt(0);
		
		//공백을 제외한 한단어
		System.out.print("단어입력");
		String str1 = scan.next();
		
		scan.nextLine();
		
		//공백을 포함한 한 라인 
		System.out.print("문장입력");
		String str2 = scan.nextLine();
		
		scan.close(); 
		
		int min=1, max=10;
		for(int i=0; i<5; i++) {
			int random = (int)(Math.random()*(max-min+1)+min);
			System.out.print(random + " ");
		}
		System.out.println();
	}

}
