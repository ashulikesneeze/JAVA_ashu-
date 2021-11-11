package D12;

public class ExaShape {
	//도형 클래스 : 그림판에서 그려지는 모든 도형을 대표할 수 있는 클래스 
	//day10에 Rect1, Rect2, Ellipse 클래스 참고 
	/*도형은 사각형안에 그릴 수 있고, 그 사각형은 왼쪽위의 점과 오른쪽 아래 점으로
	 * 표현할 수 있다. 
	 * 도형은 크기는 변하지 않으면서 이동시킬 수 있다.
	 * 도형은 방향은 마음대로 크기를 조절할 수 있다.
	 * 도현은 방향에 상관없이 그릴 수 있다. 
	 */
	//왼쪽위의 점, 오른쪽 아래점 
	protected int left;
	protected int top;
	protected int right, bottom;
	//매개변수 만들때, 도형을 그릴 때 대각선점 2개 필요 
	public ExaShape(int x1, int y1, int x2, int y2) {
		/* if(x1 < x2) {
		 * left = x1;
		 * right = x2;
		 * }else {
		 * left = x2;
		 * right = x1;
		 * }
		 * if(y1 < y2) {
		 * top = y1;
		 * bottom = y2;
		 * }else {
		 * top = y2;
		 * bottom = y1;
		 * }  
		 *
		 */
		left = x1 < x2 ? x1 : x2;
		right = x1 < x2 ? x2 : x1;
		top = y1 < y2 ? y1 : y2;
		bottom = y1 < y2 ? y2 : y1;
		
	}
	//도형의 너비를 계산하는 기능 
	public int getWidth() {
		return right - left;
	}
	//도형의 높이 계산하는 기능 
	public int getHeight() {
		return top - bottom;
	}
	//도형의 위치를 이동시킬 수 있다.(왼쪽 위의 점)
	public void move(int left, int top) {
		//순서가 아주 중요함
		this.right = left + getWidth();
		this.bottom = top + getHeight(); 
		this.left= left;		this.top = top;
		
	}
	//도형은 크기를 바꿀 수 있다(방향은 마음대로)
	/*direction : 1이면 우하, 2이면 좌하, 3이면 좌상, 4이면 우상
	 */
	public void resize(int width, int height, int direction) {
		if(width <= 0 || height <= 0) {
			System.out.println("잘못된 너비 또는 높이입니다.");
			return ; 
		}
		switch(direction) {
		case 1: 
			right = left + width;
			bottom = top + height;
			break;
		case 2: 
			left = right - width;
			bottom = top + height;
		 	break;
		case 3:
			left = right - width;
			top = bottom - height;
		case 4:
			right = left + width;
			top = bottom - height;
			break;
		default:
			System.out.println("잘못된 방향입니다.");
	
				
			
			
		}
	}
	//도형 그리기
	public void print() {
		System.out.println("-----도형-----");
		System.out.println("좌상점 : " + left + " , " + top);
		System.out.println("우하점 : " + right + " , " + bottom);
	}
}