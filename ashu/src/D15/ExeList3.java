package D15;

import java.util.*;
//util.* : 하나로 통일할 수 있음 
//import java.util.ArrayList;
//import java.util.List;

public class ExeList3 {

	public static void main(String[] args) {
		/* 오늘의 할일을 5개 입력받아 출력하는 코드를 작성
		 * 단, 리스트를 이용 
		 * 방법1 
		 */
		ArrayList<String> todoList1 = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			System.out.println("오늘의 할일 : ");
			//String tmp = scan.nextLine();
			//todoList1.add(tmp);
			//위의 두줄을 한줄로 줄일수 있음 
			todoList1.add(scan.nextLine());
		}
		System.out.println(todoList1);
		scan.close();
	}
}

