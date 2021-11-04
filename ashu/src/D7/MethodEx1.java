package D7;

public class MethodEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/* 기능 : 두 정수의 합을 구하는 method 
	 * parameter:  two integers => int num1, int num2
	 * int num1 , num2 X it has to be individual statement 
	 * return type : sum of the two integers
	 * method name: sum 
	 */

		int num = sum(1,2);
		System.out.println(num);
		System.out.println(sum(1,2));
		int a=1, b=2;
		System.out.println(sum(a,b));
	}
	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	/*기능 : 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 두 정수
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sum2
	 */
		
	public static void sum2(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
	}
	
}
