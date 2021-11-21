package D18;

public class ExdInnerClass {

	public static void main(String[] args) {
		A.InnerB b = new A.InnerB(); 
		//static이 없는 경우는 객체 만들기가 어렵다. 
		A a = new A();
		A.InnerD d = a.new InnerD();

	}

}
class A{ 
	public class InnerD {

	}
	//static이 없으면 밖에서 사용하기 매우 불편하다 
	public static class InnerB {
		
	}
	private class InnerC {
		public int num = 10;
	}
	public void test() {
		InnerC c = new InnerC();
		
		
	}
}