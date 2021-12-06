package Ashu_recap;

public class class2_board1 {

	private int num, views;
	private String title, contents, date, writer;
	
	public class2_board1(int num, String title, String contents, String date, String writer) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
	}
	
	//일반적으로 멤버변수를 변경만 하는 기능들은 리턴타입이 void 
	//게시글 제목, 내용을 수정하는 기능 
	public void modify(String title, String contents) {
		this.title=title; this.contents=contents; 
	}
	
	//게시글을 조회하는 기능(게시글 정보 출력)
	public void print() {
		System.out.println("num : " + num);
		System.out.println("title : " + title);
		System.out.println("contents : " + contents);
		System.out.println("writer : " + writer);
		System.out.println("date : " + date);
		System.out.println("views : " + views);
	}
	
	//조회수 1증가하는 기능 
	public void updateViews() {
		views++;
	}
}
