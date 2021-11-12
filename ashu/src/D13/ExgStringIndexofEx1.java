package D13;

public class ExgStringIndexofEx1 {

	public static void main(String[] args) {
		/* int indexOf(int ch) : ch가 몇번지에 있는지 알려주는 메소드로
		 * 없으면 -1을 알려줌 
		 * int indexOf(String str) : str가 몇번지에서 시작하는지 알려주는 메소드로
		 * 없으면 -1을 알려줌 
		 * int indexOf(int ch, int from) : from 번지부터 검색하여 
		 * ch가 몇번지에 있는지 알려주는 메소드로 없으면 -1을 알려줌 
		 * int indexOf(String sth, String from) : from 번지부터 검색하여
		 * str이 몇번지에서 시작하는지 알려주는 메소드로 없으면 -1을 알려줌 
		 * int lastIndexOf(int ch) : 마지막부터 검색해서 ch가 몇번지에 있는지 
		 * 알려주는 메소드로 없으면 -1
		 * 
		 * contains는 있는지 여부를! indexOf는 위치를 알려준다 
		 */
		String str = "Hello world";
		System.out.println(str.indexOf("w"));
		System.out.println(str.indexOf("wo"));
		// str에 1이 몇개 있는지 확인하는 예제
		 int index = 0;
		 int count = 0;
		 do {
			 index = str.indexOf('l',index);
			 if(index >= 0) {
				 count++;
				 index++;
			 }
		 }while(index != -1);
		 System.out.println("1의 갯수 : " + count);
	}

}
