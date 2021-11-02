package D5;

public class doWhileEx1 {

	public static void main(String[] args) {
		/*do while문으로 Hello 5번
		 * 
		 */
	int i = 1;
	do {
		System.out.println("Hello");
		i++;
	}while(i<=5);
	/*정수의 초기값이 10 시작해서 1씩 증가하면서 5보다 작거나 같은 정수를 출력
	 * 
	 */
	System.out.println("for문을 이용 ");
	for(i=10; 1 <= 5; i++) {
		System.out.println(i + " ");
	}
	System.out.println();
	System.out.println("do while문을 이용");
	i = 10;
	do {
		System.out.println(i + " ");
		i++;
	}while(i<=5);
	}

}
