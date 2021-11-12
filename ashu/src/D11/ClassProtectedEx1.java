package D11;

public class ClassProtectedEx1 {

	public static void main(String[] args) {
		C c =new C();
		c.a = 1; //모두 접근 
		c.b = 2;
		c.c = 3;
		// c.d = 4; //해당 클래스만 접근 가능.
	}

}

class P{
	public int a;
	protected int b;
	int c;
	private int d;
}
class C extends P {
	public C() {
		a = 1; //모두 접근
		b = 2; //같은 패키지면서 자식
		c = 3; //같은 패키지 
		d = 4; //P클래스가 아니기 때문에 불가능 
	}
}