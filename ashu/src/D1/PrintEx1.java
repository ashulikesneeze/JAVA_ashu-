package D1;

public class PrintEx1 {

	public static void main(String[] args) {
		//println 메소드 : 콘솔에 값을 출력하고 마지막에 엔터를 쳐줌 
		//print 메소드 : 콘솔에 값을 출력함.
		System.out.println("Hello!!");
		System.out.println("Hello!!");
		System.out.print("Hello??");
		System.out.print("Hello??");
		System.out.println();//enter
		
		/*System.out.println( 변수명);
		 *System.out.println( "변수명 : " + 변수명);
		 */
		int num1 = 10;
		System.out.println(num1);
		System.out.println("num1 =" + num1);
		
		int num2 = 20;
		char operator = '+';
		// 계획 : 10 + 20 =30으로 출력
		// 결과 : 73=1020으로 출력
		
		System.out.println(num1 + operator + num2 + "=" + num1 + num2);
		System.out.println(""+num1 + operator + num2 + "=" + (num1 + num2));
	}

}
