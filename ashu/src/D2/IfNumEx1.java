package D2;

public class IfNumEx1 {

	public static void main(String[] args) {
		// 0보다 크면 양수 0이면 0 0보다 작으면 음수
	int num =5;
	if(num > 0) {
		System.out.println(num + "는 양수");
	}else if(num == 0) {
		System.out.println(num);
	}else {
	System.out.println(num + "는 음수");
	}
}
}