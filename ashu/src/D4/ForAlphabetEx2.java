package D4;
public class ForAlphabetEx2 {
i
	public static void main(String[] args) {
		/* 'a'부터 'z'까지 출력하는 코드를 for문을 이용하여 작성.
		 * 방법1 반복횟수: i는 0부터 26보다 작을때까지 1씩 증가 
		 *      규칙성: 문자 'a'+i를 출력
		 * 방법2 반복횟수: ch는 'a'부터 'z'까지 1씩 증가 
		 *      규칙성: ch를 출력
		 */
		int i = 0; 
		for(; i<26 ; i++) {
			//method1 
			System.out.print((char)('a' + i));
		}
		//method2
		char ch;
		for(ch = 'a' ; ch <= 'z'; ch++ ) {
			System.out.print(ch);
		}

	}

}