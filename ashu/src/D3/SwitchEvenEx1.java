package D3;

public class SwitchEvenEx1 {

	public static void main(String[] args) {
		//정수의 홀 짝 여부
		int num = 10;
		switch(num % 2) {
		case 0:
			System.out.println(num + "는 짝수");
		break;
		default:
			System.out.println(num + "는 홀수");
			}
	}

}
