package Ashu_recap;

import java.util.Arrays;

public class method2_sumAndrandomArray {

	public static void main(String[] args) {
		int num = sum1(1,2);
		System.out.println(num);
		
		sum2(4,5);
		
		sumAll1(1,10);
		int begin =1, end = 10;
		
		System.out.println(begin + "부터" + end + "까지 합 : " + sumAll2(begin,end));
		int sum = sumAll2(1,10) + sumAll2(21,30);
		System.out.println("1부터 10까지의 합과 21에서 30까지의 합을 더한 값 : " + sum);
		
		
		int size=6, min=1, max=45;
		int arr[] = randomArray(min, max, size);
		System.out.println(Arrays.toString(arr));

	}
	
	
	/* 기능 : 두 정수의 합을 알려주는 메소드 
	 * 매개변수 : int num1, int num2
	 * 리턴타입 : int 
	 * 메소드명 : sum1
	 */
	public static int sum1(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	
	/* 기능 : 두 정수의 합을 콘솔에 출력 
	 * 매개변수 : int num1, int num2
	 * 리턴타입 : void 
	 * 메소드명 : sum2
	 */
	public static void sum2(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
	}
	
	/* 기능 : begin to end 합을 콘솔에 출력 
	 * 매개변수 : int begin, int end 
	 * 리턴타입 : void
	 * 메소드명 : sumAll1
	 */
	public static void sumAll1(int begin, int end) {
		int sum =0;
		for(int i = begin; i <= end; i++) {
			sum+= i;
		}
		System.out.println(begin + "부터" + end + "까지 합 : " + sum);
	}
	
	/* 기능 : begin to end 합을 알려주는 메소드 
	 * 매개변수 : int begin, int end
	 * 리턴타입 : int 
	 * 메소드명 : sumAll2 
	 */
	public static int sumAll2(int begin, int end) {
		int sum=0;
		for(int i = begin; i <= end; i++) {
			sum+=i;
		}
		return sum; 
	}
	
	/* 기능 : 베열의 크기가 주어지면 주어진 배열의 크기만큼 btw min & max
	 *       랜덤 수를 생성 저장 후 만들어진 배열을 알려주는 메소드 
	 * 매개변수 : int min, int max, int size
	 * 리턴타입 : int []
	 * 메소드명 : randomArray 
	 */
	public static int [] randomArray(int min, int max, int size) {
		int []arr = new int[size];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		return arr;
	}
}
