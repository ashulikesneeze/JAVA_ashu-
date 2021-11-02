package D5;

public class WhileMultipleTableEx1 {

	public static void main(String[] args) {
		/*while문을 이용하여 구구단 7단
		 */
		int i = 1, num = 7;//1. 초기화
		while(i <= 9 ) {//2.조건식
			System.out.println("7 x " + i + " =" + 7*i);//실행문- 3.실행문
			i++;//실행문- 4.증감식
		}
		i = 1;
		num = 6;//1. 초기화
		while(i <= 9 ) {//2.조건식
			System.out.println("6 x " + i + " =" + 6*i++);
	}
	}
}
