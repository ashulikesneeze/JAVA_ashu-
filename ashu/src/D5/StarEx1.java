package D5;

public class StarEx1 {

	public static void main(String[] args) {
		/* ***** i=1 *=5
		 * ***** i=2 *=5
		 * ***** i=3 *=5
		 * ***** i=4 *=5
		 * ***** i=5 *=5
		 * *반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 5번씩 출력 후 엔터를 출력
		 * 반복횟수 : j는 1부터 5까지 1씩 증가 
		 * 규칙성 : *을 출력
		 * 반복문 종료 후 : 엔터를 출력
		 */
	int i, j;
	for(i=1; i<=3; i++) {
		for(j=1; j<=5; j++) {
			System.out.print("*");
		}
		System.out.println();//enter 역할
	}
	//*****출력이 됨
	//i, j=1;
	//for(i=1; i<=3; i++) {
		//for(; j<=5; j++) {
			//System.out.print("*");
		//}
		//System.out.println();//enter 역할
	//}
	

	}

}
