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
		
	}

}
