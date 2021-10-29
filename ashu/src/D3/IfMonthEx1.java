package D3;

import java.util.Scanner;

public class IfMonthEx1 {

	public static void main(String[] args) {
		/*월을 입력받아 마지막 날 출력
		 * 31 (1,3,5,7,8,10,12) 30 (4,6,9,11) 28 (2)
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("월을 정수로 입력해주세요 : ");
		int month = scan.nextInt();
	
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || 
				month == 10 || month == 12) {
			System.out.println(month + "월의 마지막날은" + "31일 입니다.");	
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "월의 마지막날은" + "30일 입니다.");
		}
		else if(month == 2){
			System.out.println(month + "월의 마지막날은" + "28일 입니다.");	
		}
		else {
			System.out.println("입력이 잘못했습니다.");
	}
		scan.close();
	}

}
