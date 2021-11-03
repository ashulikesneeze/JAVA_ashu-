package D6;

public class ArrayMultiDimentionEx2 {

	public static void main(String[] args) {
		/* 한 학년의 성적을 관리하기 위한 이차원 배열을 선언 및 생성.
		 * 한 학년은 최대 10반까지 있고, 한반에 최대 30명 배치.
		 * 성적은 정수.
		 */
		int [][]score = new int[10][30];
		//1반의 30번의 성적을 80으로 입력
		score[0][29] = 80;
		//고등학교 모든 학년 학생의 성적을 관리하기 위한 배열 선언.
		int [][][] highScore = new int[3][10][30];

	}

}
