package D13;

public class ExgStringEx1 {

	public static void main(String[] args) {
		/* 문자열 String 객체 생성 방법
		 * 1. ""를 이용하여 생성
		 * 2. new 연산자를 이용하여 생성
		 * */
		//Str1 과 Str3은 같은 주소의 'Hi'를 공유
		//Str2는 B지점의 Hi라는 문자열을 사용 
		String str1 = "Hi";
		String str2 = new String("Hi");
		String str3 = "Hi";
		
		System.out.println("str1과 str2의 주소가 같다?" + (str1 == str2));
		System.out.println("str1과 str3의 주소가 같다?" + (str1 == str3));
		System.out.println("str2과 str3의 주소가 같다?" + (str2 == str3));
		
		System.out.println("-----------------------");
		
		System.out.println("str1과 str2의 문자열이 같다?" + str1.equals(str2));
		System.out.println("str1과 str3의 문자열이 같다?" + str1.equals(str3));
		System.out.println("str2과 str3의 문자열이 같다?" + str2.equals(str3));
	}

}
