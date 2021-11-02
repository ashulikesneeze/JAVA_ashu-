package D5;

public class PrintNumEx1 {

	public static void main(String[] args) {
		/* 1 2 3
		 * 4 5 6
		 * 7 8 9
		 */
		int i,j;
		
		/*for(i =1; i<=3; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(i =4; i<=6; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(i =7; i<=9; i++) {
			System.out.print(i+" ");
		}*/
		for(i =1; i<=9; i++) {
			System.out.print(i+" ");
			//i가 3의 배수이면 엔터 출력
			if( i % 3 == 0) {
				System.out.println();
			}
		}
		for(i = 1; i<=3; i++) {
			for(j = 3*i -2; j <= 3*i; j++) {
				System.out.print(j + " " );
			}
			System.out.println();
		}
	}
	for(i =1; i<=3; i++) {
		System.out.print(i+" ");
	}
}
