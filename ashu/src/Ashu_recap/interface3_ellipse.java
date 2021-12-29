package Ashu_recap;

public class interface3_ellipse extends interface2_shape {
	

	public interface3_ellipse(int x1, int y1, int x2, int y2) {
		
		super(x1,y1,x2,y2);
	}
	@Override
	public void draw() {
		System.out.println("타원");
	}
}
