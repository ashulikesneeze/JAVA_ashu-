package D3;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		//90<A, 80-90 B, 70-80 C, 60-70 D, 60> F 잘못된 점수
		Scanner scan = new Scanner(System.in);
		System.out.println("점수을 정수로 입력해주세요 : ");
		int score = scan.nextInt();
		
		if(score >= 90 && score <= 100) {
			System.out.println("귀하의 점수는" + " A 입니다.");	
		}
		else if(score < 90 && score >= 80) { 
			System.out.println("귀하의 점수는" + " B 입니다.");
		}
		else if(score < 80 && score >= 70){
			System.out.println("귀하의 점수는" + " C 입니다.");	
		}
		else if(score < 70 && score >= 60){
			System.out.println("귀하의 점수는" + " D 입니다.");	
		}
		else if(score < 60 && score > 0){
			System.out.println("귀하의 점수는" + " F 입니다.");	
		}
		else {
			System.out.println("입력이 잘못했습니다.");
		scan.close();	 
		}

	}
}

