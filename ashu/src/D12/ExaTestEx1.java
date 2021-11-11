package D12;

public class ExaTestEx1 {

	public static void main(String[] args) {
		/*
		 * ExaShape s1 = new ExaShape(0,0,10,10);
		s1.print();
		ExaShape s2 = new ExaShape(10,10,0,0);
		s2.print();
		s2.move(10,10);
		s2.print(); 
		s2.resize(20,20,3);
		s2.print();
		s2.resize(10,10,2);
		s2.print();
		*/
		ExaRect r1 = new ExaRect(0,0,10,10);
		r1.print();
		r1.move(10,10);
		r1.resize(15,20,1);
		r1.print();
	}

}
