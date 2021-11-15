package D14;

public class ExaStringEx1 {

	public static void main(String[] args) {
		/* 5명의 이름을 배열에 저장하고, 성이 홍씨인 사람을 검색하는 코드를 작성 
		 * 홍이라는 글자가 있는지? X      contains
		 * 홍이라는 글자로 시작하는지?     startsWith
		 * 홍이라는 글자가 0번지에 있는지?  indexOf
		 */
		String [] names = new String[5];
		names[0] ="하이마라미";
		names[1] ="하이마케이시";
		names[2] ="리빙봉";
		names[3] ="하이마리프렉스";
		names[4] ="케이시제임스";
		//startsWith
		for(String name : names) {
			if(name.startsWith("리")) {
				System.out.println(name + "은 리씨입니다.");
			}else {
				System.out.println(name + "은 리씨가 아닙니다.");
			}
		}
		System.out.println("-------------"
				+ "");
		//indexOf
		for(String name : names) {
			if(name.indexOf("리")==0) {
				System.out.println(name + "은 리씨입니다.");
			}else {
				System.out.println(name + "은 리씨가 아닙니다.");
			}
		}
	}

}
