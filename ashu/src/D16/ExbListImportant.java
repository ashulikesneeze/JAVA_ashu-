package D16;

import java.util.*;

public class ExbListImportant {

	public static void main(String[] args) {
		/* 각각 리스트를 만들어 관리 방법! 번지가 같으면 같은 학생이라는 가정필요
		 */
		ArrayList<Integer> korList = new ArrayList<Integer>();
		ArrayList<Integer> engList = new ArrayList<Integer>();
		ArrayList<Integer> mathList = new ArrayList<Integer>();
		
		//국어,영어, 수학을 같이 다룰 수 있는 클래스를 만들어서 활용하는 방법
		ArrayList<ExbStudentImportant> stdList = new ArrayList<ExbStudentImportant>();
		Scanner scan = new Scanner(System.in); 
		
		//학생 정보를 입력받고, 계속할건지를 물어봐서 y라고 대답하면 continue, 아님 종료
		char next = 'y'; 
		
		while(next == 'y' || next =='Y') {
			//방법1 : 첫번째 inputStudent 메소드 이용
			ExbStudentImportant std = inputStudent(scan);
			stdList.add(std);
			
			System.out.print("학생 정보를 더 입력하겠습니까? ");
			next = scan.next().charAt(0); 
		}
		
		printStudentList(stdList);
		
		scan.close();
	}
	
	/*function : Scanner를 이용하여 학생 정보와 성적을 입력 받아 입력받은 학생 
	 *           정보를 알려주는 메소드
	 *parameter : Scanner => Scanner scan
	 *return type : 입력받은 학생 정보 => ExbStudent 
	 *Title : inputStudent          
	 */
	public static ExbStudentImportant inputStudent(Scanner scan) {
			System.out.print("학생 정보를 입력하세요.");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			System.out.print("이름 : ");
			/*nextLine()을 이용하는 경우 앞에서 Scanner를 통해 입력받은 값 중
			 * 엔터가 사라지지 않은 경우에 실제 사용하려는 nextLine()앞에 
			 * nextLine() 한번 더 입력해야 함 
			 */
			scan.nextLine();
			String name = scan.nextLine(); 
			System.out.print("성적을 입력하세요.");
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("수학 : ");
			int eng = scan.nextInt();
			System.out.print("영어 : ");
			int math = scan.nextInt();
			
			//ExbStudent std = new Ex 타이핑 후 ctr + space 자동 완성 기능 
			ExbStudentImportant std = new ExbStudentImportant(grade, classNum, num, name, kor, eng, math);
			return std; 
	}
	/* function : Scanner를 이용하여 학생 정보와 성적을 입력받아 입력받은 학생 정보를
	 *            주어진 리스트에 넣어주는 메소드 
	 * parameter : Scanner, 주어진 리스트 => Scanner scan, ArrayList<ExbStudent> stdList
	 * return type : void
	 * Title : inputStudent         					
	 */
	//overloading inputStudent(scan)
		public static void inputStudent(Scanner scan, ArrayList<ExbStudentImportant> stdList) {
			ExbStudentImportant std = inputStudent(scan);
			stdList.add(std); 	
	}
	/* function : 학생 리스트가 주어지면 주어진 학생 정보들을 출력하는 메소드 
	 * parameter : 학생 리스트 => ArrayList<ExbStudent> stdList
	 * return type : void 
	 * title : printStudentList  
	 */
	public static void printStudentList(ArrayList<ExbStudentImportant> stdList) {
		//very important : 리스트에서 하나씩 꺼내서 tmp에 저장 
			Iterator<ExbStudentImportant> it = stdList.iterator();
				while(it.hasNext()) {
					ExbStudentImportant tmp = it.next(); 
					System.out.println(tmp);
				}
		}
	}
