package Ashu_recap;

import java.util.Scanner;

public class public_class_title {

	public static void main(String[] args) {
		/*  class title { 
		 * 1. 멤버변수 : private / protected int ___;
		 *            default: 접근제한자를 생략한 경우 (같은 package에 있으면 사용가능) 
		 * 2. getter/ setter : 정보변경 할 수 있게
		 * 3. 생성자 만들기! 쉽게 초기화 할 수 있게
		 *    constructor using field 
		 *    - 기본 생성자 : 초기화
		 *    - 생성자 오버로딩 :밖에서 알려준 정보로 대체 초기화  
		 *                   super(); this.x = x; 
		 * 4. @override toString : 멤버변수들을 문자열로 쉽게 확인하기 위해서
		 *     or printInfo를 따로 만들어 줌   
		 */
		
		// 국어, 영어, 수학 성적을 관리하기 위한 클래스를 만들고,
		// 학생 3명의 성적을 관리하기  위한 배열을 만드시오 
		
		Score score[] = new Score[3];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<score.length; i++) {
			System.out.print("name : ");
			String name = scan.next();
			System.out.print("Math : ");
			int math = scan.nextInt();
			System.out.print("Kor : ");
			int kor = scan.nextInt();
			System.out.print("Eng : ");
			int eng = scan.nextInt();
			
			score[i] = new Score(math, kor, eng, name);
		}
		for(Score tmp :score) {
			tmp.printInfo();
		}
		scan.close();
	}

}

class Score {
	private int kor, eng,math;
	private String name;
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Score() {} 
	public Score(int kor, int eng, int math, String name) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", name=" + name + "]";
	}
	
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("kor : " + kor);
		System.out.println("math : " + math);
		System.out.println("eng : " + eng);
	}
}
