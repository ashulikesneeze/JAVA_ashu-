package Ashu_recap;

//2차원 좌표 평면의 점 하나를 나타내는 클라스

public class class_point {

	private int x,y;
	
	// getter/setter 정보변동을 할 수 있게 
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	//생성자 만들기: very important
	//new로 만들어서 객체 추가 후 복사한 값을 넣은 후 주소는 따로 보관
	public class_point(class_point p) {
		x=p.x; y=p.y;
		}

	//생성자 복사 : 멤버객체의 값을 공유한는 것을 막기위해  
	public class_point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "class_point [x=" + x + ", y=" + y + "]";
	}

	
	//equals를 안쓰면 object안의 equals를 적용하여 주소를 비교하게 된다 
	//very important: contains or indexOf를 활용할때 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		class_point other = (class_point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
