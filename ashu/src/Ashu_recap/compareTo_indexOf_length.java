package Ashu_recap;

public class compareTo_indexOf_length {

	public static void main(String[] args) {
	/* equals vs compareTo
	 * equals()는 두 문자열이 같은지 다른지만 알려줌
	 * compareTo는 두 문자열이 사전순으로 어떻게 되는지 알려줌 
	 * 같으면 0, 다르면 음수, 양수 
	 * A.compareTo(B) : B가 A보다 사전순으로 앞(양수) 뒤(음수)
	 */
	String str1 = "a";
	String str2 = new String("a");
	String str3 = "c";
	System.out.println(str1.compareTo(str2));
	System.out.println(str1.compareTo(str3));
	System.out.println(str3.compareTo(str1));
	
	/*contains는 있는지 없는지 여부를, indexOf는 위치를 알려준다!
	 * int indexOf(int ch) int indexOf(String str) 
	 * int indexOf(int ch, int from) int indexOf(String sth, String from)
	 * from 번지 부터 검색하여 몇번지에 있는지 알려주는  메소드로 없으면 -1 
	 */
	String str = "Hello world";
	System.out.println(str.indexOf("w"));
	//str에 l이 몇개 있는지 확인하는 예제
	int index = 0;
	int count = 0;
	do {
		index = str.indexOf('l',index);
		if(index >= 0) {
			count++;
			index++;
		}
	}while(index != -1);
	System.out.println("l의 갯수는 : " + count);
	

	//int length() : 문자열 길이를 알려주는 메소드 
	System.out.println(str.length());
	}
}
