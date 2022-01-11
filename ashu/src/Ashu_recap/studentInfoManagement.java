package Ashu_recap;

import java.util.*;

public class studentInfoManagement {

	public static void main(String[] args) {
		/* 학생 정보 관리 프로그램 
		 * 메뉴
		 * 1. 학생 정보 추가
		 * 2. 전체 학생 정보 출력
		 * 3. 학생 정보 삭제(삭제할 학생의 정보를 입력하여 일치하는 학생의 정보를 삭제)
		 * 4. 학생 정보 수정 
		 * 5. 프로그램 종료
		 * object 클래스의 equals()와 리스트의 remove()를 이용 
		 */
		
		ArrayList<student> stdList = new ArrayList<student>();
		Scanner scan = new Scanner(System.in);
		int menu; 
		
		do { 
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택된 메뉴에 따라 동작 실행 
			switch(menu) {
			//학생 정보 추가 기능 
			case 1: inputStudent(scan, stdList);  break;
			//전체 학생 정보 출력 기능 
			case 2: printStudentList(stdList); break;
			//특정 학생 정보 삭제 
			case 3:
				if(deleteStudent(stdList, scan)) {
					System.out.println("학생 정보를 삭제했습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			//특정 학생 정보 수정:
			//이름, 성적만 수정할건지 (선택)
			//학년, 반, 번호, 이름, 성적을 수정할건지 생각
			case 4: 
				if(modifyStudent(scan, stdList)) {
					System.out.println("학생 정보를 수정했습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			case 5: break;
			default: 
				System.out.println("잘못된 메뉴입니다.");
				}
			}while(menu != 5); 
		
		System.out.println("프로그램 종료합니다");
		
		scan.close();
		}
	
	public static E

	}

