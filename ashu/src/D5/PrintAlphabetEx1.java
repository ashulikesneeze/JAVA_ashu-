package D5;

public class PrintAlphabetEx1 {

	public static void main(String[] args) {
		/* zyx...cba
		 * 
		 */
		int i = 0; 
		for(; i<26 ; i++) {
			//method1 
			System.out.print((char)('z' - i));
		}
		System.out.println();
		i = 0;
		while(i<26) {
			System.out.print((char)('z' - i));
		i++;
		}
	}

}
