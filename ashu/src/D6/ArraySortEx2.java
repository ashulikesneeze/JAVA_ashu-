package D6;

import java.util.Arrays;

public class ArraySortEx2 {

	public static void main(String[] args) {
		// 다음과 같은 배열이 있을 때 정렬하는 코드를 작성하세요.
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		// 버블정렬 : 옆에 있는 값과 비교하여 정렬하는 방법 (ineffective)
		//1, 10, 9, 3, 6, 2, 3, 4
		//1, 9, 3, 6, 2, 3, 4, 10  1
		//1, 3, 6, 2, 3, 4, 9, 10  2
		//1, 3, 2, 3, 4, 6, 9, 10  3
		//1, 2, 3, 3, 4, 6, 9, 10  4
		//1, 2, 3, 3, 4, 6, 9, 10  5
		//1, 2, 3, 3, 4, 6, 9, 10  6 
		//1, 2, 3, 3, 4, 6, 9, 10  7
		
		//Arrays.sort(num); //오름차순
		Arrays.sort(num, 0, 5);//0번지부터 5번지까지 오른차순으로 정렬
	
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
	}
}
