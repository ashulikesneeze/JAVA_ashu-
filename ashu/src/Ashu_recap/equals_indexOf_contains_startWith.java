package Ashu_recap;

public class equals_indexOf_contains_startWith {

	public static void main(String[] args) {
		/* 5명의 이름을 배열에 저장하고, 성이 홍씨인 사람을 검색하는 코드 작성 
		 * contains 홍이라는 글자가 있는지 없는지 
		 * startsWith 홍이라는 글자로 시작하는지 
		 * indexOf 홍이라는 글자가 0번지에 있는지 
		 */
		String [] names = new String[5];
		names[0] = "하이마라미";
		names[1] = "케이시하이마";
		names[2] = "리빙봉";
		names[3] = "하이마리프렉스";
		names[4] = "케이시제임스";
		
		//startsWith
		for(String name : names) {
			if(name.startsWith("리")) {
				System.out.println(name + "은 리씨입니다.");
			}else {
				System.out.println(name + "은 리씨가 아닙니다.");
			}
		}
		System.out.println("----------------------");
		
		//indexOf
		for(String name : names) {
			if(name.indexOf("리")==0) {
				System.out.println(name + "은 리씨입니다.");
			}else {
				System.out.println(name + "은 리씨가 아닙니다.");
			}
		}
		/*하이마라는 이름이 있는지 확인
		equals를 제외한 indexOf, contains, startsWith, endsWith들은 추가작업 필요*/
		int count = 0; 
		String search = "하이마";
		for(String name : names) {
			if(name.equals(search)) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는" + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		
		//indexOf 
		count =0;
		for(String name : names) {
			if(name.indexOf(search) == 0 && name.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는" + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		
		//startsWith, endsWith
		count = 0;
		for(String name : names) {
			if(name.startsWith(search) && name.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는" + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		
		//contains
		count = 0;
		for(String name : names) {
			if(name.contains(search) && name.length() == search.length()) {
				count++;
			}
		}
		if(count != 0) {
			System.out.println(search + "는" + count + "명 있습니다.");
		}else {
			System.out.println(search + "는 없습니다.");
		}
		
		
		/*확장자를 포함한 파일명을 5개 배열에 저장하고,
		 * 저장된 파일에 이미지 파일이 있는지 확인하는 코드 작성 
		 * 이미지 확장자 : jpg, bmp, gif, png
		 */
		
		String fileNames []
				= {"test1.jpg", "test2.bmp", "test3.gif", "test4.png", "test5.exe"};
		String imgSuffixString = "jpg, bmp, gif, png";
		String [] imgSuffixArray = imgSuffixString.split(", ");
		
		for(String fileName : fileNames) {
			if(checkSuffix(imgSuffixArray, fileName)) {
				System.out.println(fileName + "은 이미지입니다.");
			}else {
				System.out.println(fileName + "은 이미지가 아닙니다.");
			}
		}
	}
	
	/* function: 확장자들과 파일명이 주어지면, 해당 파일이 확장자에 맞는지 알려주는 메소드
	 * parameter:  확장자들, 파일명 => String[]suffixArray, String fileName
	 * return type: boolean
	 * method title: checkSuffix
	 */
	public static boolean checkSuffix(String[] suffixArray, String fileName) {
		for(String suffix : suffixArray) {
			if(fileName.endsWith(suffix)) {
				return true;
			}
		}
		return false; 
	}
}
