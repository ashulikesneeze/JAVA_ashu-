package D5;

public class PrintAlphabetEx2 {

	public static void main(String[] args) {
		/* a        시작 : a  끝 : a
		 * ab       시작 : a  끝 : b
		 * abc      시작 : a  끝 : c
		 * abcd     시작 : a  끝 : d
		 * abc...z
		 * 반복횟수 : ch는 a부터 z까지 1씩 증가
		 * 규칙성 : a부터 ch까지 출력 후 엔터
		 *           반복횟수: ch2는 a부터 ch까지 1씩 증가
		 *           규칙성: ch2를 출력
		 *           Enter
		 */
		char ch, ch2;
		for(ch = 'a' ; ch <= 'z'; ch++ ) {
			for(ch2='a'; ch2<=ch ; ch2++) {
				System.out.print(ch2);
			}
		
			System.out.println();
		}
	}

}
