package D5;

public class WhileContinueEx1 {

	public static void main(String[] args) {
		/* 1~10사이의 홀수를 while문을 이용하여 출력하는 예제
		 * 
		 */
		//방법1
	int i = 1; //이미 선언되어있는 변수여서 int i = 0은 unacceptable
	while(i <= 10) {
		if(i % 2 == 0) {
			i++;
			continue;
		}
		System.out.print(i + " ");
		i++;
	}
	System.out.println();
	//방법2
	i = 0;
	while( i < 10) {
		i++;
		if(i % 2 == 0) {
			continue;
		}
		System.out.print(i + " ");
	}
	}

}
