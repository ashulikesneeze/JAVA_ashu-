### 새 URL에 작업을 하는 경우

1.컨트롤러에 새 URL을 담당하는 메소드를 생성

2-1.컨트롤러에서 화면을 전달하는 경우  : jsp 파일 생성

2-2. 다른 URL로 보내는 경우  : jsp파일을 생성하지 않음

3.컨트롤러가 서비스에게 일을 시킴 

4.서비스에 메소드를 등록

- 컨트롤러에서 에러 나는 부분에 마우스 호버하여 create method를 클릭하여 등록 

5.서비스 임플에 에러나는 부분에 마우스 호버하여 add unimplemented을 클릭하여 등록 

6.서비스가 다오에게 일을 시킴 

7.다오에 메소드를 등록 

-   서비스임플에 에러나는 마우스 호버하여 create method를 클릭하여 등록 


-   등록된 메소드의 매개변수에 @Param을 붙임 

8.Mapper에 쿼리문 추가 

- 7번에 등록된 메소드와 이름이 같게 id를 지정 




**setViewName****("/경로/파일명");

setViewName("/redirect:/이동할url");

- 이전에 전달받은 정보를 이동할 url에 전송할 필요가 없으면 redirect

setViewName("/forward:/이동할url");

- 이전에 전달받은 정보를 이동할 url에 전송할 필요가 있으면 forward



1. 멤버 **interceptor** 만들고 


2. servlet-context.xml 에 두 코드 

- <beans:bean id="memberInterceptor" 

	class="kr.green.spring.interceptor.MemberInterceptor"></beans:bean>

- <interceptor>

	        <mapping path="/board.register"/>
	         <mapping path="/board.modify"/>
	          <mapping path="/board.delete"/>
	        <beans:ref bean="memberInterceptor"/>
	    </interceptor>
3. 실행 테스트 해보기 