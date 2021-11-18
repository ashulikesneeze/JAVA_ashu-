package D17;

import java.util.HashMap;
import java.util.Map;

public class ExdMap {

	public static void main(String[] args) {
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("abc123", "123123");
		userInfo.put("dfd123", "123123");
		userInfo.put("abc123", "123123425");
		System.out.println(userInfo);
		userInfo.remove("abc123");
		System.out.println(userInfo);
		System.out.println(userInfo.get("qwe123"));
		System.out.println(userInfo.containsKey("qwe123"));
	}

}
