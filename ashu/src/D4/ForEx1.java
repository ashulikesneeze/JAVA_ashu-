package D4;

public class ForEx1 {

	public static void main(String[] args) {
		/* for문 사용시 조심해야 하는 상황
		 * 1부터 5까지 출력하는 예제에서 발생한 실수 
		 */
	int i;
	for( i = 1 ; i<=5 ; i++ ) {
	/*원인 : for문 뒤에 ;이와서 for문의 실행문이 없는 경우
	 * 
	 */
	}
	System.out.print("1부터 5까지 출력 : " + i);
	System.out.println("int 최대값 : " + Integer.MAX_VALUE);
	System.out.println("int 최소값 : " + Integer.MIN_VALUE);
	}
}