package D6;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx2 {

	public static void main(String[] args) {
		/* 숫자 야구 게임
		 * 컴퓨터가 랜덤으로 1~9사이의 중복되지 않은 세 수르 선택하고,
		 * 사용자는 컴퓨터가 선택한 세 수를 맞추는 게임
		 */
		//사용자가 컴퓨터 숫자 3개를 입력
		int [] computer = new int[3];
		Scanner scan = new Scanner(System.in);
		System.out.print("컴퓨터 : ");
		//computer[0] = scan.nextInt();
		//computer[1] = scan.nextInt();
		//computer[2] = scan.nextInt();
		for(int i = 0; i<computer.length; i++) {
			computer[i] = scan.nextInt();
		}
		
		//사용자가 세 수를 무한으로 입력 받음
	
		int [] user = new int[3];
		
		while(true) {
		System.out.print("사용자 : ");
		for(int i = 0; i<user.length; i++) {
			user[i] = scan.nextInt();
		}
		//computer[0] = scan.nextInt();
		//computer[1] = scan.nextInt();
		//computer[2] = scan.nextInt();
		
		//Strike 갯수를 계산하여 출력
		//컴텨:   1 3 2
		//사용자 : 1 2 3 
		int strike = 0, ball = 0;
		/*if(computer[0] == user[0]) {
			strike++;
		}	
		if(computer[1] == user[1]) {
			strike++;
		}	
		if(computer[2] == user[2]) {
			strike++;
		}	
		}*/
		
		for(int i = 0; i<computer.length; i++) {
			if(computer[i] == user[i]) {
				strike++;
			}
		}
		//볼의 갯수를 계산하여 볼의 갯수를 출력
		for(int i=0; i<computer.length; i++) {
			for(int j=0; j<user.length; j++) {
				//computer[i], user[j]
				//strike 경우 생략
				if(i == j ) {
					continue;
				}
				if(computer[i] == user[j]) {
					ball++;
				}
			}
		}
		//strike가 경우는 xS
		//볼이 있는 경우는 xB
		//스트라이크와 볼이 없는 경우 30가 출력되도록 작성 
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("30");
		}
		System.out.println();
		
		//3S면 반복문 종료 
		if(strike == 3) {
			System.out.println("You got it! Good job!!");
			break;
		}
		}
		scan.close();
	}

}
