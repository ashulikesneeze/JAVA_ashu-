package D12;

public class ExaTestEx2 {

	public static void main(String[] args) {
		/* 사각형과 타원을 여러개 저장할 수 있는 배열을 만들어 보세요
		 * 사각형과 타원을 합쳐서 최대 10개까지 저장한는 배열 
		 */
		ExaShape list [] = new ExaShape [10];
		//타원 1개와 사각형 2개를 생성하여 배열에 저장 
		//클래스 형변환, 자식 => 부모클래스로 형변환, 자동클래스 형변환
		list[0] = new ExaEllipse(0,0,10,10);
		list[1] = new ExaRect(10,10,20,20);
		list[2] = new ExaRect(10,20,20,30);
		//저장된 도형들을 그려보세요.(콘솔에 출력)
		//반복문을 이용하여 배열에 저장된 도형들을 콘솔에 출력해보세요(print()이용)
		/* NullPointException : 객체가 없는데 객체의 기능을 사용하려고 할 떼 발생 
		 * 객체가 없다 ==> null
		 */
		for(int i = 0; i<list.length; i++) {
			/*10개의 배열중 3개만 쓰였기 때문에 NullPointException occur
			 *참조변수는 null로 초기화가 되기 때문에 
			 *도형이 없으면 아무것도 안하고 넘어간다고 if문을 사용하여 출력
			 */
			if(list[i] != null) {
				list[i].print();
			}
		}
		/*저장된 도형이 타원이면 testE()를 호추하고, 사각형이면 testR()을 호출하세요
		 * 반복문 이용 */
		for(ExaShape tmp : list) {
			if(tmp != null) {
				//tmp.print();
				//도형이 타원이면 testE()를 호출하고, 사각형이면 testR()을 호출
				if(tmp instanceof ExaEllipse) {
					//도형 tmp를 타원으로 형변환 시킨 후 textE()를 호출
					((ExaEllipse)tmp).testE();
				}
				//도형이 사각형이면 testR()ㄹ 호출 
				else if(tmp instanceof ExaRect) {
					ExaRect r = (ExaRect)tmp;
					r.testR();
				}
			}
		}
	}
	/* 메소드에서 매개변수의 다형성을 확인하기 위한 문제 
	 * 기능 : 매개변수가 사각형이면 사각형이라고 출력하고, 
	 * 도형이면 도형이라고 출력, 원이면 원이라고 출력하는 메소드 
	 * 매개변수 : 사각형 또는 타원 또는 도형 =>
	 * 리턴타입 : void 
	 * 메소드명 : print 
	 */
	public static void print(ExaShape shape) {
		if(shape instanceof ExaRect) {
			System.out.println("사각형");
		}else if(shape instanceof ExaEllipse) {
			System.out.println("타원");
		}else {
			System.out.println("도형");
		}
	}

}
