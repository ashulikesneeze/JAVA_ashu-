package Ashu_recap;

import java.util.Arrays;
import java.util.Scanner;

public class exception2 {

	public static void main(String[] args) {
		/* 정수 5개짜리 배열에 정수를 5개 입력받아 저장한 후 
		 * 원하는 번지에 정수를 수정하는 코드를 작성하세요
		 * 예외처리를 이용
		 * 수정할 번지와 수정할 정수를 입력:  0 5
		 * 수정할 번지와 수정할 정수를 입력:  6 8
		 * 잘못된 번지입니다 
		 * 수정할 번지와 수정할 정수를 입력:  -1 7
		 * 프로그램을 종료합니다 
		 */
		int [] arr = new int [5];
		//수정할 번지와 수정할 정수 
		int index = 0, value = 0;
		Scanner scan = new Scanner(System.in);
		//순서체크 밑에랑 arr, scan 
		inputArray(arr, scan);
		do {
			//try & catch는 usually 밖에 묶어두지만 
			//본인이 원하는 상황에 따라 {안에도! 
			//지금의 경우는 에러가 뜨더라도 반복문 가동을 위해 안에 
			try{
			System.out.print("수정할 번지와 수정할 정수를 입력하세요 : ");
			index = scan.nextInt();
			value = scan.nextInt();
			//normally index >=0 && index <= arr.length
			if(index >=0) {
				arr[index] = value;
			}
			System.out.println(Arrays.toString(arr));
			}
			catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("잘못된 배열 번지에 접근했습니다. : " + index);
			}
		}
		while(index >= 0); 
		System.out.println("프로그램 종료!!");
		System.out.println(Arrays.toString(arr));
	}	
	public static void inputArray(int arr[],Scanner scan) {
		//배열이 없으면 예외발생 
		if(arr == null) {
			throw new NullPointerException("배열이 만들어지지 않았습니다."); 
		}
		if(scan == null) {
			throw new NullPointerException("스캐너가 만들어지지 않았습니다."); 
		}
		System.out.print("정수를 " +arr.length+ "개를 입력하세요 : "); 
		//배열의 크기만큼 반복하여 정수를 입력받아 저장 
		for(int i =0; i<arr.length; i++) { 
			arr[i] = scan.nextInt();
			
		}
	}	
}	
	