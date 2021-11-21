package D18;

import java.util.Calendar;

public class ExaCalendar {

	public static void main(String[] args) {
		// 현재 시간을 기준으로 객체를 만들어서 넘겨줌 
		//Calendar는 요일, 년, 월, 일 확인할 때
		//Calendar는 외부에서 객체를 만들지 못하고, 내부적으로 만들어서 주기 떄문에 
		//new 연산자가 아닌 getInstance() 메소드를 이용함 
		Calendar cal = Calendar.getInstance();
		
		//Calendar의 get 메소드를 이용하여 년, 월, 일, 요일 등의 정보를 가져올 수 있다 
		//월은 0부터 시작, 요일은 일요일부터 시작, 일요일이 1 
		//HOUR은 1~12, HOUR_OF_DAY은 1~24
		//opposite to get, is set!!
		cal.set(Calendar.HOUR_OF_DAY, 14);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		Calendar cal2 = Calendar.getInstance();
		System.out.println(cal2.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
	}
}
