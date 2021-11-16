package D15;

import java.util.ArrayList;

public class ExeList2important {

	public static void main(String[] args) {
		/* 하나의 점이 이동한 좌표를 저장하려 한다
		 */
		ExePoint pt = new ExePoint(0,0);
		ArrayList<ExePoint> moveRoute = new ArrayList<ExePoint>(); 
		moveRoute.add(new ExePoint(pt));
		pt.move(5, 5);
		//점이 5,5로 이동한 후 위치를 리스트에 저장 
		moveRoute.add(new ExePoint(pt)); 
		pt.move(10,10);
		moveRoute.add(new ExePoint(pt));
		System.out.println(moveRoute);
		System.out.println(pt + "좌표가 list에 있습니까? : " + moveRoute.contains(pt));
	}

}

class ExePoint {
	int x, y;
	
	public ExePoint(int x, int y) {
		this.x = x;    this.y =y;
	}
	//생성자 만들기 : very important 
	//new로 만들어서 객체 추가 후 복사한 값을 넣은후 주소는 따로 보관 
	public ExePoint(ExePoint p) {
		x=p.x;  y=p.y; 
	}
	public void move(int x, int y) {
		this.x =x; this.y =y;
	}
	//toString : 우리가 원하는 형태로 나오기 위해서 필요 
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	//equals를 안쓰면 object안의 equals롤 적용되여 주소를 비교하게 된다 
	//very important : contains or indexOf를 활용할때 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExePoint other = (ExePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}