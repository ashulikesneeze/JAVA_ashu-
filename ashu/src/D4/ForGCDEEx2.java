package D4;

public class ForGCDEEx2 {

	public static void main(String[] args) {
		/*두 정수의 최대 공약수를 구하는 코드를 for문을 이용하여 작성.
		 * 약수: 나누어서 떨어지는 수
		 * 12의 약수: 1 2 3 4 6 12 
		 * 8의 약수: 1 2 4 8 
		 * 공약수: 공토으로 있는 약수
		 * 8과 12의 공약수: 1 2 4 
		 * 최대 공약수: 4 
		 * 반복횟수: i는 1부터 num1까지 1씩 증가
		 * 규칙성: i가 num1의 약수이고, i가 num2의 약수이면 gcd 변수에 i를 저장
		 * 반복문 종료 후 : gcd를 출력
		 */
		int num1 = 12, num2 = 8;
		int i , gcd = 0;
		for(i = 1 ; i <= num1 ; i++ ) {
		  if(num1 % i == 0 && num2 % i == 0) {
			  //첫번째 공약수: 1, gcd에 1을 저장. gcd가 0에서 1로 바뀜
			//첫번째 공약수: 2, gcd에 2을 저장. gcd가 1에서 2로 바뀜
			//첫번째 공약수: 4, gcd에 4을 저장. gcd가 2에서 4로 바뀜
			  gcd = i;
		}
	}
	System.out.println(num1 + "과 " + num2 + "의 최대 공약수: " + gcd);
	}
}



