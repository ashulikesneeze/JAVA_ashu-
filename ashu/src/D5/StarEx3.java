package D5;

public class StarEx3 {

	public static void main(String[] args) {
		/*     * i=1 space=4 *=1 Enter
		 *    ** i=2 space=3 *=2 Enter
		 *   *** i=3 space=2 *=3 Enter
		 *  **** i=4 space=1 *=4 Enter
		 * ***** i=5 space=0 *=5 Enter   
		 */
		/* 반복횟수: i는 1부터 5까지 1씩 증가
		 * 실행문: space (5 - i) 출력하고, *을 i개 출력하고, 엔터
		 *      반복횟수: j는 1부터 i까지 1씩 증가
		 *      실행문 : 공백을 출력
		 *      반복횟수: j는 1부터 i까지 1씩 증가
		 *      실행문 : *을 출력
		 *      엔터를 출력
		 */
		int num = 5,i,j;
		for(i =1; i<=num; i++) {
			for(j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
	}

	}
}
