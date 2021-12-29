package Ashu_recap;

public abstract class interface2_shape implements interface1_draw {

	protected int left, right, top, bottom;
	
	@Override
	public void resize(int width, int height) {
		right = left + width;	bottom = top + height;		
	}

	@Override
	public void move(int x, int y) {
		int width = right - left, height = bottom - top;
		left = x;			top = y;
		right= x + width;	bottom = y + height;
	}

	public interface2_shape(int x1, int y1, int x2, int y2) {
			left  = x1 > x2 ? x2 : x1;
			right = x1 > x2 ? x1 : x2;
			top   = y1 > y2 ? y2 : y1;
			bottom= y1 > y2 ? y1 : y2;
		}
	
	
}
