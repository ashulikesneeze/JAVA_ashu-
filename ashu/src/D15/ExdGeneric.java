package D15;

import java.util.ArrayList;
	import java.util.HashMap;

	public class ExdGeneric {

		public static void main(String[] args) {
			ExdData<Integer> data1 = new ExdData<Integer>(10);
			ExdData<Double> data2 = new ExdData<Double>(1.23);
			ExdData<Double> data3 = new ExdData<Double>(3.14);
			data1.print();
			data2.print();
			//if(data1 == data2) //에러 발생. 비교할 수 없어서
			if(data3 == data2) {
				System.out.println("비교 가능하고 같은 객체");
			}else {
				System.out.println("비교 가능하고 다른 객체");
			}
			//밑에 두 예제에서 보면 overriding 으로 멤버변수를 지정해야 하는 이유 
			data2.test(data3);
			data2.test(data1);
		}
	}