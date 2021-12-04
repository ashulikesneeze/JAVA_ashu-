package Ashu_recap;

public class method1 {

	public static void main(String[] args) {
	
		int [] arr = {3, 1, 2};
		printArray(arr);
		
		sortArray(arr);
		printArray(arr);
		
		int num1 = 12, num2 = 8;
		int result = gcd(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : "  + result);
		int result2 = lcml(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : "  + result2);
		
		int num=4;
		if(isPrime(num)) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}
		
		printChar('*',5);
		printChar('*',7);
		printChar('-',5);
	}
	
	
	/* 기능 : 정수형 배열이 주어지면 해당 배열의 모든값을 한줄로 콘솔에 출력
	 * 매개변수 : 정수형 배열 int []arr
	 * 리턴타입 : void
	 * 메소드명 : printArray
	 */
	public static void printArray(int []arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/* 기능 : 정수형 배열이 주어지면 배열을 정렬하는 메소드
	 * 매개변수 : int [] arr
	 * 리턴타입 : void
	 * 메소드명 : sortArray
	 */
	public static void sortArray(int []arr) {
		for(int i=0; i<arr.length-1;i++) {
			for(int j=0; j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp; 
				}
			}
		}
	}
	
	/* 기능 : 두 정수가 주어졌을때 두정수의 최대공약수 
	 * 매개변수 : int num1, int num2
	 * 리턴타입 : int 
	 * 메소드명 : gcd
	 */
	public static int gcd(int num1, int num2) {
		int i, gcd=0;
		for(i=1; i<=num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		return gcd; 
	}
	
	
	/* 기능 : 두 정수가 주어졌을때 두정수의 최소공배수 
	 * 매개변수 : int num3, int num4 
	 * 리턴타입 : int 
	 * 메소드명 : lcml 
	 */
	public static int lcml(int num1, int num2) {
		int i, lcml=0;
		for(i = num1; i <=num1*num2; i +=num1) {
			if(i%num2 == 0) {
				lcml= i;
			}
		}
		return lcml;
	}
	
	/* 기능 : 주어진 정수가 소수이면 참으로, 아니면 거짓으로 알려주는 메소드 
	 * 매개변수 : int num
	 * 리턴타입 :  boolean
	 * 메소드명 :  isPrime
	 */
	public static boolean isPrime(int num) {
		int count = 0;
		if(num <= 0) {
			return false;
		}
		for(int i = 1; i<=num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			return true;
		}
		return false; 
	}
	/* 기능 : 문자가 주어지면 주어진 문자를 주어진 횟수만큼 한줄에 출력하는 메소드
	 * 매개변수 : char ch, int count 
	 * 리턴타입 :  void 
	 * 메소드명 :  printChar
	 */
	public static void printChar(char ch, int count) {
		for(int i = 1; i<=count; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
