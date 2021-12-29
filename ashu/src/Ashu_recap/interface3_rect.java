package Ashu_recap;

public class interface3_rect extends interface2_shape {
	
	@Override
	public void draw() {
		System.out.println("사각형");
	}

	public interface3_rect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
}
