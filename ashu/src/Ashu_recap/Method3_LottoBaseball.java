package Ashu_recap;

import java.util.Arrays;
import java.util.Scanner;

public class Method3_LottoBaseball {

	public static void main(String[] args) {
		int min =1, max = 45;
		int [] lotto = randomArray(min, max, 6);
		int bonus = createBonus(min, max, lotto);
		
		System.out.println("당첨번호 : " + Arrays.toString(lotto));
		System.out.println("보너스번호 : " + bonus);
		
		Scanner scan = new Scanner(System.in);
		int [] user = new int[6];
		System.out.print("선택번호 : ");
		for(int i =0; i<user.length; i++) {
			user[i] = scan.nextInt();
		}
		scan.close();
		
		rank(lotto,bonus,user); 
		
		
		//baseball
		int [] com = new int [3];
		int min2 = 1, max2 =9;
		com = randomArray(min2,max2,3);
		System.out.println(Arrays.toString(com));
		int user2[] = new int[3];
		int strike=0, ball=0; 
		
		do {
			System.out.print("사용자 : ");
			inputArray(user2, scan);
			
			strike = getStrike(com, user2);
			
			ball = getBall(com, user2);
			
			printResult(strike, ball);
			
		}while(strike != 3);
		
		System.out.println("정답입니다. 프로그램을 종료합니다.");
	}
	
	public static int [] randomArray(int min, int max, int size) {
		int []arr = new int [size];
		for(int count =0; count<size;) {
			int random = (int)(Math.random()*(max-min+1)+min);
			if(!containsArray(arr, random, count)) {
				arr[count++] = random;
			}
		}
		return arr;
	}

	private static boolean containsArray(int[] arr, int num, int n) {
		n = arr.length < n ? arr.length : n;
		for(int i =0; i<n; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	/* 기능 : min, max, arr size 주어지면 랜덤 수 생성 후 배열에 있는 지 없는지 확인 후
	 *       없으면 해당 수를 알려주는 메소드 
	 * 매개변수 : int min, int max, int []arr
	 * 리턴타입 : int 
	 * 메소드명 :createBonus 
	 */
	public static int createBonus(int min, int max, int []arr) {
		int bonus = 0;
		while(true) {
			bonus = (int)(Math.random()*(max-min+1)+min);
			if(containsArray(arr, bonus, arr.length)) {
				continue;
			}
			break;
		}
		return bonus;
	}
	
	
	/* 기능 : 당첨번호 확인 - 두배열이 주어지면 두배열에서 일치하는 정수의 갯수를 알려주는 메소드
	 * 매개변수 : int []arr1, int []arr2
	 * 리턴타입 : int 
	 * 메소드명 :check 
	 */
	public static int check(int []arr1, int []arr2) {
		int count=0;
		for(int tmp : arr1) {
			//배열 arr2에서 배열 arr1에서 꺼낸 tmp가 있으면 count를 1 증가
			if(containsArray(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count; 
	}
	
	
	/* 기능 : 당첨 등수 출력 - 로또 번호와 사용자 번호 이용
	 * 매개변수 : int []lotto, int bonus, int []user
	 * 리턴타입 : void
	 * 메소드명 :rank
	 */
	public static void rank(int []lotto, int bonus, int []user) {
		int count = check(lotto, user);
		String result = "";
		switch(count) {
		case 6: result = "you won!! congrats!"; break;
		case 5:
			result=containsArray(user, bonus, user.length) ? "2nd place!!" : "3rd place!!";
			break;
		case 4: result = "4th place!!";   break;
		case 3: result = "5th place!!";   break;
		default: result = "sorry!!"; 
		}
	}
	
	//Baseball game
	public static int [] randomArray2(int min2, int max2, int size2) {
		int []arr2 = new int [size2];
		for(int count =0; count<size2;) {
			int random = (int)(Math.random()*(max2-min2+1)+min2);
			if(!containsArray(arr2, random, count)) {
				arr2[count++] = random;
			}
		}
		return arr2;
	}
	public static int getStrike(int []com, int []user2) {
		int count = 0;
		for(int i = 0; i<com.length; i++) {
			if(com[i] == user2[i]) {
				count++;
			}
		}
		return count; 
	}
	public static int getBall(int []com, int []user2) {
		int count = 0;
		for(int tmp : com) {
			if(containsArray(user2, tmp, user2.length)) {
				count++;
			}
		}
		return count - getStrike(com,user2);
	}
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("THREE OUT!!");
		}
		System.out.println();
		}
	public static void inputArray(int []arr, Scanner scan) {
		for(int i =0; i<arr.length; i++) {
			arr[i] = scan.nextInt(); 
		}
	}

}
