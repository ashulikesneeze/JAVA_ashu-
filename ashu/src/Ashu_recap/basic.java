package Ashu_recap;

public class basic {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		char operator = '+';
		System.out.println("" + num1 + operator + num2 + "=" + (num1 + num2));
		
		int score = 88;
		boolean isA = score <= 100 && score >= 90;
		System.out.println(score + "점은 A학점인가?" + isA);
		
		char isB = ((score <= 90) && (score >= 80)) ? 'Y' : 'N';
		System.out.println(score + "점은 B학점인가?" + isB);
		
		boolean driverLicense = true, registrationCard = true;
		boolean testOk =  driverLicense || registrationCard;
		System.out.println("시험응시가능?" + testOk);
		
		int num3 = 11;
		String isOdd = num3 % 2 != 0 ? "Yes" : "No";
		System.out.println(num3 + "은 홀수인가요?" + isOdd);
		
		switch(num3 % 2) {
		case 0:
			System.out.println(num3 + "는 짝수");
			break;
		default: 
			System.out.println(num3 + "는 홀수");
		}
		
		//1 to 10 짝수구하기
		int i;
		System.out.println("---method1--");
		for(i=1 ; i <= 10 ; i++) {
			if(i%2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.println("---method2--");
		for(i=2 ; i <= 10 ; i= i+2) {
				System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("---method3--");
		for(i=1 ; i <= 5 ; i++) {
				System.out.print(2*i + " ");
		}
		System.out.println();
		
		
		
		//a to z method 1 & method 2 
		for( ; i<26 ; i++) {
			System.out.print((char)('a' +i));
		}
		System.out.println();
		
		
		char ch;
		for(ch ='a'; ch <= 'x'; ch++) {
			System.out.print(ch);
		}
		
		
		//5 to 1 method 1 & 2
		for(i=5 ; i>=1 ; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(i=0; i<5; i++) {
			System.out.print(5-i + " ");
		}
		
		//eg: 4321 -> 1234
		int num4 = 1234;
		for( ; num4 != 0 ; num4 = num4 /10) {
			System.out.print(num4 % 10);
		}
		
		
		//2 to 100 모든 소수 출력
		int num5 = 2;
		int count=0;
		while(num5 <= 100) {
			i=1;
			count=0;
			while(i<=num5) {
				if(num5 %i == 0) {
					count++;
				}
				i++;
			}
			if(count==2) {
				System.out.print(num5 + " ");
			}
			num5++;
		}
		
		
		//multiple table method1 & 2
		int num6 =6;
		while(i<=9) {
			System.out.println(num6 + "x" + i + "=" + (num6*i));
			i++;
		}
		
		while(i<=9) {
			System.out.println(num6 + "x" + i + "=" + (num6*i++));
		}
		
	}

}
