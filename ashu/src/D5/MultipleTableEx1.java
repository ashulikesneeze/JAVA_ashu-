package D5;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/*2단에서 9단까지 출력
		 * 
		 */
		int num = 2, j;//1. 초기화
		j = 1;
		while(num <=9){
		j= 1;
		while(j <= 9 ) {//2.조건식
			System.out.println(num + " x " + j + " = " + num*j);//실행문- 3.실행문
			j++;//실행문- 4.증감식
		}	
		num++;//without falling into loophole
		}
	}
}
