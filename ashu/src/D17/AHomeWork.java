package D17;

import java.util.*;

public class AHomeWork {

	public static void main(String[] args) {
		/* day17 패키지의 ExbScore와 ExbStudent 클래스를 이용하여 학생 성적을 관리하는 
		프로그램을 만드세요.
		기본 기능
		- 학생 정보 추가
		- 학생 정보 출력(전체, 개인)
		- 학생 정보 수정
		- 학생 정보 삭제
		- 프로그램 종료
		- 유의 사항
		  - 학생 정보 추가시 기존에 있는 학생(학년, 반, 번호가 일치하는 학생)인 경우 학생 정보를
		    추가하지 않음
		    */
		
		ArrayList<AStudent> stdList = new ArrayList<AStudent>();
		Scanner scan = new Scanner(System.in);
		int menu;
		
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴선택
				menu = scan.nextInt();
				//선택된 메뉴에 따라 동작 실행 
				switch(menu) {
				//학생 정보 추가 기능 
				case 1: inputStudent(scan, stdList); break;
				//전체 학생 정보 출력 기능 
				case 2: printStudentList(stdList); break;
				//특정 학생 삭제 기능
				case 3: 
					if(deleteStudent(stdList, scan)) {
						System.out.println("학생 정보가 지워졌습니다.");
					}else {
						System.out.println("입력하신 학생와 일치하는 정보가 없습니다.");
					}
					break;
				case 4: 
					if(modifyStudent(scan, stdList)) {
						System.out.println("학생 정보가 바뀌었습니다.");
					}else {
						System.out.println("학생정보를 찾을 수 없습니다.");
					}
					break;
				case 5: break;
				default:
					System.out.println("틀린 메뉴입니다.");
					}
			} catch(InputMismatchException e) {
				System.out.println("입력을 제대로 해주세요.");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != 5); 
		
		System.out.println("메뉴작업을 끝냅니다.");
		scan.close();
	}
		
	private static boolean deleteStudent(ArrayList<AStudent> stdList, Scanner scan) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void printStudentList(ArrayList<AStudent> stdList) {
		// TODO Auto-generated method stub
		
	}

		//스캐너를 사용하여 학생정보와 성적을 입력받아 알려주는 방법
		public static AStudent inputStudent(Scanner scan) {
			System.out.println("각각의 학생의 정보를 알려주세요.");
			System.out.println("학년 : ");
			int grade = scan.nextInt();
			System.out.println("학반 : ");
			int classNum = scan.nextInt();
			System.out.println("번호 : ");
			int num = scan.nextInt();
			System.out.println("이름 : ");
			scan.nextLine();
			ArrayList<AScore> scoreList = new ArrayList<AScore>();
			String name = scan.nextLine();
			System.out.println("과목 : ");
			String subjectTitle = scan.nextLine();
			System.out.println("학년 : ");
			grade = scan.nextInt();
			System.out.println("학기 : ");
			int semester = scan.nextInt();
			System.out.println("성적을 입력해 주세요.");
			System.out.println("성적 : ");
			int point = scan.nextInt();
	
			//문제제기 : 1. Astudent와 AScore의 공통적인 객체 int grade 자동적으로 합쳐짐? 아님 처리해야함?
	    	//         2. 배열 순서 바꾸고 싶을때 : subjectTitle, grade, semester, classNum, num, name, point 
			//객체 생성
			AScore score = new AScore(subjectTitle, grade, semester, point);
			scoreList.add(score);
			return new AStudent(grade, classNum, num, name, scoreList);
		}
		//스캐너를 이용해 입력받은 정보들을 주어진 리스트에 넣어주는 방법 
		public static void inputStudent(Scanner scan, ArrayList<AStudent> stdList) {
			 AStudent std = inputStudent(scan);
			 stdList.add(std);
		}
		
		//학생 리스트가 주어지면 하나씩 꺼내서 tmp에 저장후 출력하는 방법 
		public static void printStudent(ArrayList<AStudent> stdlist) {
			Iterator<AStudent> it = stdlist.iterator();
			while(it.hasNext()) {
				AStudent tmp = it.next();
				System.out.println(tmp);
			}			
		}
		public static void printMenu() {
			System.out.println("메뉴입니다.");
			System.out.println("학생정보 추가를 원하면 1 : ");
			System.out.println("전체 학생 정보 출력을 원하면 2 : ");
			System.out.println("학생 정보 수정을 원하면 3 : ");
			System.out.println("학생 정보 삭제을 원하면 4 : ");
			System.out.println("프로그램 종료를 원하면 5 : ");
			System.out.println("메뉴를 선택해 주세요.");
		}
		
		//1. 스캐너를 이용하여 수정할 학생 정보 학년, 반, 번호를 입력받고,
		//2. 입력받을 학생 정보를 주어진 리스트에 수정 내용을 넣어,
		//3. 수정이 됐는지 안됐는지 알려주는 방법
		public static boolean modifyStudent(Scanner scan, ArrayList<AStudent> stdList) {
			System.out.println("학생 정보가 필요합니다.");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			
			//특정 학생 정보가 0이상 번지에 있으면 이름 성적을 입력받음 
			AStudent std = new AStudent(grade, classNum, num, "", new ArrayList<AScore>());
			int index = stdList.indexOf(std);
			if(index >= 0) {
				System.out.print("이름 : ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.print("성적 :");
				int point = scan.nextInt();
				
				//객체 추가 후 복사값넣고 주소는 따로 보관할 수 있도록
				//AStudent 클래스의 equals을 오버라이딩한 후,
				//indexOf와 set을 사용하여 리스트에 수정함 
				//std = newAStudent(grade, classNum, num, name);
				stdList.set(index, std);
				return true;
			}
			//없으면 끝
			return false;
		}
		
		 
			
		
		

}
