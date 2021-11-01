package D4;

import java.util.Scanner;

public class ForGCDEEx1 {

	public static void main(String[] args) {
		/*두 정수의 최대 공약수를 구하는 코드를 for문을 이용하여 작성.
		 * 약수: 나누어서 떨어지는 수
		 * 12의 약수: 1 2 3 4 6 12 
		 * 8의 약수: 1 2 4 8 
		 * 공약수: 공토으로 있는 약수
		 * 8과 12의 공약수: 1 2 4 
		 * 최대 공약수: 4 
		 * 반복횟수: i는 1부터 num1까지 1씩 증가
		 * 규칙성: i가 num1의 약수이고, i가 num2의 약수이면 i를 출력
		 */
		
	Scanner scan = new Scanner(System.in);
	System.out.print("정수를 입력하세요 : ");
	int num1 = scan.nextInt();
	int i, count;
	for(i =1, count = 0; i <= num1 ; i++ ) {
	 if(num1 % i == 0) {
		count++; //++count; //count = count + 1; //count +=1;
	 }
	 
	}
	if(count == 2) {
		System.out.println(num1 + "은 소수");2
	}
		else {
			System.out.println(num1 + "은 소수가 아님");
		}
	switch(count) {
	case 2: System.out.println(num1 + "은 소수");     break;
	default:System.out.println(num1 + "은 소수가 아님");break;
	
	}

		}
	}
