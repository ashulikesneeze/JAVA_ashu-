package D17;

import java.util.*;

public class ExcSet {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		//set은 중복을 허용 안함, 순서대로 저장을 안함 
		set1.add(1); set1.add(2); set1.add(3); set1.add(1);
		System.out.println(set1); 
		int min = 1, max = 9; 
		while(set2.size() < 3) {
			int r = (int)(Math.random()*(max-min+1) + min);
			set2.add(r);
		}
		//List에서는 get을 이용하여 반복문 for(i...)를 사용할 수 있지만 
		//set에서는 Iterator를 사용하여야 한다!!
		System.out.println(set2);
		Iterator<Integer> it = set2.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
	}

}
