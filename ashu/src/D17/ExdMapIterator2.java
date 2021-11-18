package D17;

import java.util.*;

public class ExdMapIterator2 {

	public static void main(String[] args) {
		// Map에서 반복문 사용 예제
		// KeySet()을 이용하여 키값들을 Set으로 만든후 Iterator(반복문)을 이용하는 방법 
		Map<String, String> map = new HashMap<String, String>();
		map.put("abc123","123123");
		map.put("qweqwe", "qweqwe");
		map.put("zzz", "zzzzzz");
		
		//Keyset() : Map에서 Key값들을 하나의 set으로 만들어 주는 메소드 
		Set<String> set = map.keySet();
		System.out.println(set);
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			//tmp 대신 key 
			String key = it.next();
			String value = map.get(key);
			System.out.println("ID : " + key + ", Password : " + value);
			
		}

	}

}
