package D16;

import java.util.*;

public class ExbListImportant2 {

		public static void main(String[] args) {
			/*메뉴
			 * 1. 학생정보추가
			 * 2. 전체 학생정보 출력
			 * 3.프로그램 종료 
			 */	
			ArrayList<ExbStudentImportant> stdList = new ArrayList<ExbStudentImportant>();
			Scanner scan = new Scanner(System.in);
			//이 위치에서 menu를 만들어야 함 
			int menu;
			
			do {
				//메뉴 출력
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				//선택된 메뉴에 따라 동작 실행
				switch(menu) {
				//학생 정보 추가 기능
				case 1:	inputStudent(scan, stdList);	break;
				//전체 학생 정보 출력 기능
				case 2:	printStudentList(stdList);		break;
				//remove : boolean obj 적용으로 있으면 삭제 없음 false! 
				//전제조건 : equals로 overriding 사전에 해놓아서 가능 
				case 3:	break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
			}while(menu != 3);
			
			System.out.println("프로그램을 종료합니다.");
			
			scan.close();
		}
		
		public static ExbStudentImportant inputStudent(Scanner scan) {
			System.out.println("학생 정보를 입력하세요.");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			System.out.print("이름 : ");
			scan.nextLine();
			String name = scan.nextLine();
			System.out.println("성적을 입력하세요.");
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();
			ExbStudentImportant std 
				= new ExbStudentImportant(grade, classNum, num, name, kor, eng, math);
			return std;
		}
		public static void inputStudent(Scanner scan, ArrayList<ExbStudentImportant> stdList) {
			ExbStudentImportant std = inputStudent(scan);
			stdList.add(std);
		}
		public static void printStudentList(ArrayList<ExbStudentImportant> stdList) {
			Iterator<ExbStudentImportant> it = stdList.iterator();
			while(it.hasNext()) {
				ExbStudentImportant tmp = it.next();
				System.out.println(tmp);
			}
		}
		public static void printMenu() {
			System.out.println("메뉴");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 전체 학생 정보 출력");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
		}
	}

	
			
					