package D17;

import java.util.*;


public class ExcSetBaseball {

	public static void main(String[] args) {
		/*1-9사이의 중복되지 않은 랜덤한 수 3개를 저장하여 숫자야구게임을 
		 * 만들때, 중복되지 않은 랜덤한 수 3개를 만드시오! 
		 */
		List<Integer> com = new ArrayList<Integer>();
		Set<Integer> tmp = new HashSet<Integer>();
		int min =1, max=9;
		while(tmp.size() < 3) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			boolean isAdd = tmp.add(r);
			//isAdd가 true이면 중복이 되지 않아 tmp에 추가된 경우이기
			//때문에 이때 리스트에 추가 
			if(isAdd) {
				com.add(r); 
			}
		}
		System.out.println(tmp);
		System.out.println(com);
	}
	
}
