package D3;

import java.util.Scanner;

public class SwitchMonthEx1 {

	public static void main(String[] args) {
		/*월을 입력받아 마지막 날 출력
		 * 31 (1,3,5,7,8,10,12) 30 (4,6,9,11) 28 (2)
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("월을 정수로 입력해주세요 : ");
		int month = scan.nextInt();
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println(month + "월의 마지막날은" + "31일 입니다.");
		break;
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월의 마지막날은" + "30일 입니다.");
		break;
		case 2:
			System.out.println(month + "월의 마지막날은" + "28일 입니다.");
		break;
		default:
			System.out.println(month + "는 잘못입력된 달 입니다");
			}
		scan.close();
	}

}

