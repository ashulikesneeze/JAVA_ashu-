### 화면<=>컨트롤럴  class <=> 서비스 interface <=> 다오 interface

​     interface는 구현구가 핑요함 :                     service imp(class)                                   mapper(xml) 

​                                                                                                                    src>main>resources> mappers                                                                  

​           vo(class)                                       vo(class)                                         vo(class)

 

//DAO : data access object 

//vo : value object 

"browser setting: window > preferences > web browser > use external > chrome"

server 항목을 볼 수 있게 (1server에 1 project)**  *localhost:8080/test1*

eclipse에서 project만들때 ctrl+N > spring > spring legacy project > spring MVC project 

1. window > showView > other > server > open 
2. ctrl + N  server Apache Tomcat 9 
3. package  선택 right click -> run as -> run on server -> localhost 선택후 server한개 선택



**한글인코딩** *내숭이 블로그 복붙을 위해*  *https://stajun.tistory.com/*

1.web.xml 파일수정 
 src > main > webapp > web-inf> web.xml 
</web-app>위에 복붙  

2.STS 인코딩 설정
Window > preferences > workspace > text file encoding > UTF-8 

3.jsp 파일 인코딩 설정

src > main > webapp > web-inf> views > home.jsp
<%@ page session="false" %> 지우고 복붙 

<!DOCTYPE html> 추가 



**Tiles 연동** *템플릿 설정하기* 

1. 타일즈 의존성 추가 (pom.xml) : 젤 밑 target 밑에
   - 5.1.8. version 

- 15번째 줄 <org.apache.tiles-version>3.0.8</org.apache.tiles-version> 복붙


   - pom.xml 파일 안 `<dependencies>` 태그 안에 의존성 추가 : </dependencies> 앞에 복붙\





**View Resolver 등록 (servlet-context.xml)**  

spring_ashutest > src/main/java > kr.green.test1.controller로 이름 바꿔줌 

src > main > webapp > web-inf > spring > appServlet > 

젤 밑 base-package 부분  "kr.green.test1.controller"를  "kr.green.test1.*" 로 바꿈 

servlet-context.xml에 다음 코드를 추가 복붙 

   ​

3. **타일즈 설정 추가** 

WEB-INF > spring 폴더에 tiles-def.xml 파일 생성 후 다음 코드 붙여넣기

: 1번들은 지워줌 



4. **기본 레이아웃 설정** 

   ![](./캡처.PNG)

- *baselayout* 

<html>위에 <!DOCTYPE html> 복붙 

빨간줄 지워줌  & container 지움 

타이틀 밑에 복붙 (head다운로드받은거)

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

첨부파일 (footer, header, head) 다운로드 받아 복붙 

- <h1>헤더</h1>



- window > preferences > en 타입후  > css file/html/jsp > Korean > UTF-8



**controller로 가서** 

return "/main/home"; 수정해줌 

/main/home 으로 접속 하여 테스트 한 후, value = "/"로 바꾸어줌 

![](D:\JAVA_ashu\JAVA_ashu-\spring_ashu\controller.PNG)



### 각종 패키지 생성 

- Service package


- Dao package


- VO package 

  ​

# **DB연동하기** 

**의존성 추가하기**

- MyBatis 연동에 필요한 의존성을 pom.xml에서 dependencies 태그 안에 추가 후 저장

**MyBatis 관련 정보 설정하기** 

- spring>appServlet > root-context.xml 에서  source 옆 Namespaces 로 감 

​       : aop, beans, context, jdbc, mybatis 5항목 체크 

- 예시복사 후 </beans>위에 붙여넣기 한 후 수정 

         value="jdbc:mysql://localhost:3306/community?useSSL=false&amp;serverTimezone=Asia/Seoul">
    </property>
    <property name="username" value="root"></property>
    <property name="password" value="cjgreen"></property>
    </bean> 


## DB연동 테스트

- src/main/resources에서 mappers 폴더 생성 

  MemberMapper.xml 파일 생성 후 MyBatis 연동 확인하기 밑 코드 복 붙 후 

  <mybatis-spring:scan base-package="kr.green.test1.dao"/>

  이름 바꾸고 <select> email 부분 지워주기 


- controller 위에 ctrl + N  후 package 선택 후 controller 지우고 dao

   & service & vo 붙여 3개의 패키지 생성 


- sevice 패키지 선택 후 ctrl + N 후 interface 타입 후 MemberService 생성 


- sevice 패키지 선택 후 ctrl + N 후 class 에서 MemberServiceImp 생성 후 

  public class MemberServiceImp implements MemberService{

- dao 패키지 선택 후 ctrl + N 후 interface 타입 후 MemberDAO 생성 

  ​


**VO class 만들기** : *비닐봉투와 같은 역할* 

- vo 패키지(.vo) 먼저 만든 후,  class 이름 맨 뒤에 VO를 붙여 만든다 


- table을 보고 객체 만듬 private String me_id; 등등
- pom.xml 에서 lombok 의존성 추가 후 VO 클래스가서 @Data 추가 


- getter/ setter &@toString 생성 


- member folder 생성 후 login.jsp : name 에 맞는 객체 이름으로 넣어주고 




컨트롤러에 멤버변수로 MemberService 추가 @Autowired 이용 

서비스임프에 @Autowired

​                           MemberDAO memberDao; 

​                        & @Service 추가

**서버를 재가동하여 에러가 안나는지 테스트** 



### 컨트롤러/서비스/다오/메퍼에 샘플 코드 추가 및 테스트 

DB에 샘플 데이트 추가 

- 컨트롤러 샘플 코드


- ```
  @RequestMapping(value= "/")
  public ModelAndView openTilesView(ModelAndView mv) throws Exception{
      mv.setViewName("/main/home");
      //아래 코드는 연동 확인후 지울 코드
      //qwe는 샘플 데이터에 있는 회원아이디
      MemberVO user = memberService.test("qwe");
      System.out.println(user);
      return mv;
  }
  ```


- 서비스 샘플 코드

  - ```
    MemberVO test(String id);
    ```

- 서비스임플 샘플 코드

  - ```
    @Override
    public MemberVO test(String id) {
        return memberDao.test(id);
    }
    ```

- 다오 샘플 코드

  - ```
    MemberVO test(@Param("id")String id);
    ```

- 매퍼 샘플 코드

  - ```
      <select id="test" resultType="kr.green.green.vo.MemberVO">
      	select * from member where me_id = #{id}
      </select>
      ```
    ```

    ```



### 8. 회원가입 기능 구현(비밀번호 암호화 적용)

- [github.com/st8324/Docs](https://github.com/stajun2/java_jik/blob/main/5.SPRING/github.com/st8324/Docs) 참고

  header.jsp 회원가입 링크 추가 

  컨트롤러에서 회원가입 화면을 보여줄수 있는 메소드를 추가 

  - /signup에 GET방식
  - 보여줄 화면은 /member/signup.jsp로 설정 

  회원가입 화면파일을 생성

  -  회원가입 화면을 구성

  컨트롤러에 회원가입을 처리하는 메소드를 추가 

  - /signup에 POST방식
  - 일을 다 처리한 후, 메인페이지(/)로 이동을 시킴 
  - 회원가입이 정상적으로 진행되지 않으면 회원가입페이지(/signup)으로 이동

  컨트롤러에 화면에서 전달한 회원정보를 받아서 확인 

  - 매개변수를 추가 (ModelAndView mv, MemberVO user)

    그리고 확인 System.out.println(user);

  - 생일과 관련해서 에러가 발생할 수 있음

    - 원인 : 화면에서는 yyyy-mm-dd로 된 문자열을 전송하는데 생일이 Date클래스로 되어 있으면 자동으로 변환이 안됨. String이 Date로 형변환이 안됨.

    - 해결방안 : setMe_birth(String date)로 setter를 수정하여 문자열로 된 날짜를 Date로 변환하는 코드를 작성해야 함

    - ```
      public void setMe_birth(String me_birth) {
          SimpleDateFormat format;
          try {
              format = new SimpleDateFormat("yyyy-MM-dd");
              this.me_birth = format.parse(me_birth);
          } catch (ParseException e) {
              e.printStackTrace();
          }
      }
      ```

  - 화면에 input tag/textarea tag/select tag 등에 name을 MemberVO의

    매개변수와 같게 설정 

  컨트롤러에서 회원정보를 서비스에게 주면서 회원가입하라고 시킴 

  -  이때 서비스는 회원가입 진행 후 가입이 성공했는지 아닌지 컨트롤러에게 

    알려줌(리턴타입)

  서비스에 회원가입 메소드 추가 

  - 컨트롤러에서 에러나는 부분 마이스 호버 create method...

  서비스 임플에 회원가입 기능을 구현 

  - 비밀번호 암호화을 함 
  - 다오에게 회원가입 정보를 전달하면서 가입하라고 시킴 

  다오에 회원가입 메소드 추가 

  - 서비스임플에서 에러나는 부분 호버 후 create method...
  - @Param("이름")을 매개변수 앞에 추가 

  매퍼에 쿼리문 구현 

  - id에 다오에 추가한 메소드명을 입력

  - 쿼리문 구현

    매개변수로 넘어오는 값은 #{}를 이용하고, 넘겨주는 값이 정수나 문자열이 아니면 #{객체명.멤버변수명}으로 호출

    ​

#### 로그인 기능 구현(Interceptor를 이용하여 로그인 유지 적용)

https://github.com/st8324/Docs/blob/master/spring%20framework/Interceptor%EB%A5%BC%20%EC%9D%B4%EC%9A%A9%ED%95%9C%20%EC%9C%A0%EC%A0%80%20%EC%A0%95%EB%B3%B4%20%EC%84%B8%EC%85%98%EC%97%90%20%EC%A0%80%EC%9E%A5%ED%95%98%EA%B8%B0.md

* servlet-context 

    <mapping path="/login"/>

header.jsp에 링크 추가 

컨트롤러에서 메소드 추가 및 구현 

로그인 화면 구성 : form tag & name 설정

로그인 시도시 컨트롤러에서 회원정보가 잘 오는지 확인

서비스와 서비스 임플에 코드를 구현 : 비밀번호를 확인 

다오에 메소드 추가 

매퍼에 쿼리문 추가 : resultType 설정 시 오타 조심 

문서 참고하여 로그인 유지 

로그인 시 화면에서 로그인 메뉴와 회원가입 메뉴 안보이게 처리

로그인 시 화면에서 로그아웃 메뉴 보이도록 처리 



10. 로그아웃 기능 구현 

  로그아웃 링크 추가 

  컨트롤러에 로그아웃 코드 구현 

  ​

11. ##### 인터셉터를 이용하여 회원만 게시글 등록/수정/삭제가 되도록 처리

- github.com/st8324/Docs
- 다음 URL에 대해 회원만 접근하도록 인터셉터를 생성 후 처리(MemberInterceptor)
  - /board/register
  - /board/modify
  - /board/delete

12. ##### 인터셉터를 이용하여 비회원만 로그인/회원가입이 되도록 처리

- 다음 URL에 대해 로그인 하지않은 비회원만 접근하도록 인터셉터를 생성 후 처리(GuestInterceptor)
  - /login
  - /signup 

13. #### 게시글 리스트 확인 구현 

- URL:/board/list

- 게시글 링크 등록

  header.jsp에서  <c:if>  안에 넣으면 안됨 회원과 비회원 다 볼 수 있기 때문에   

  	<li class="nav-item">
  	        	<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시글</a>
  	      	</li>

- **컨트롤러,서비스,서비스임플,다오,매퍼 만들고** 

  @Controller 추가 

  imp @Service 추가 

  mapper에서 멤버매퍼 복붙 후 보드매퍼로 한 후 코드 지우고 

  <mapper namespace="spring.green.green.dao.BoardDAO">

- **연결부분** 

  - Autowired를 이용하여 멤버변수 설정 
    - 컨트롤러에 멤버변수로 서비스를 설정
    - 서비스임플에 멤버변수로 다오를 설정 


  - 컨트롤러에 게시글 리스트 확인하는 메소드 등록 및 구현 

    List<BoardVO> list; 한 후 보드VO 클래스 만들고 

    서비스에게 일을 시킨다 

    List<BoardVO> list; boardService.getBoardList();  create 클릭 저장 하고

    확인 후 주석처리 

    System.out.println(list);

  - 서비스와 서비스 임플에 게시글 가져오는 메소드 등록 및 구현 

  - 다오와 매퍼에 게시글 가져오는 메소드 등록 및 쿼리문 작성 


- 확인 




#### 14.게시글 상세확인 

- /board/detail 

  컨트롤러에 추가 

  	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
  	public ModelAndView boardDetailGet(ModelAndView mv) {	
  		mv.setViewName("/board/detail");
  		return mv;
  	}
  후 detail.jsp 만든후 화면 확인 


- 게시글 리스트에서 게시글 제목 클릭했을때 넘어갈 수 있도록 링크를 수정 

  list.jsp 

  <a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">


- 컨트롤러에서 해당 메소드 처리하는 코드 등록 및 구현

   @RequestMapping(value="/board/detail", method=RequestMethod.GET)
   	public ModelAndView boardDetailGet(ModelAndView mv, Integer bd_num) {	
   		System.out.println(bd_num);
   		mv.setViewName("/board/detail");
   		return mv;
   	}
     콘솔에 번호가 찍히는지 확인 후 sysout 지우고 

- 서비스/서비스 임플에서 메소드 등록 및 구현 

  @RequestMapping(value="/board/detail", method=RequestMethod.GET)

  	public ModelAndView boardDetailGet(ModelAndView mv, Integer bd_num) {	
  		BoardVO board = boardService.getBoardList(bd_num);
  		//확인
  		System.out.println(board);
  		//확인한 값을 화면에 전달 
  		mv.addObject("board",board);
  		mv.setViewName("/board/detail");
  		return mv;
  	}
  서비스에게 일을 시킨다 입력과 출력을 확인 

  마우스 호버 create 저장 후 임플로 가서 코드 입력 

  	@Override
  	public BoardVO getBoardList(Integer bd_num) {
  		if(bd_num == null || bd_num <= 0)
  		return null;
  		
  		return boardDao.selectBoard(bd_num); 
  	}
  마우스호버 후 create 

  ​

- 다오/매퍼에서 메소드 등록 및 구현 

  : 이미 만들어져있는걸 사용할때는 다오/매퍼가 생략될 수 있다

  ​

  @Param("bd_num")추가 

  BoardVO selectBoard(@Param("bd_num")Integer bd_num);

  ​

  다오 메소드에 리턴타입이 있으면 매퍼에 select문으로 만들어 줌 

  예) BoardVO면 select

  다오 메소드에 리턴타입이 없거나(void) 또는 int이면 update, insert, delete문으로

  만듬. 단, int라고 해서 무조건은 아님.

  <select id="selectBoard" resultType="spring.green.green.vo.BoardVO">

  ```
  select * from board where bd_num = #{bd_num} and bd_del = 'N'
  </select>
  ```
  detail.jsp에서 확인

  <body>
  ${board}
  </body>

- 게시글 상세 화면 구현 

  ​

15. ### 게시글 등록

    - /board/register

    - 게시글 리스트에서 게시글 등록 버튼을 추가 

      - 등록 버튼 클릭하면 /board/register로 이동 

    - 게시글 등록 화면 구현(get)

      - 컨트롤러에 해당 URL을 담당하는 메소드 등록 및 코드 구현

      - 기본 등록화면 jsp생성

      - 게시글 등록 화면 구현

        : form태크 이용하고 method는 post로 

    - 게시글 등록 기능 구현(post)

      - 테스트 시 로그인을 꼭 해야 테스트 가능 

      - 컨트롤러에 게시글 등록하는 메소드 등록 및 코드 구현 

        - 게시글 등록 후 완료되면 /board/list로 이동하도록 처리

        @RequestMapping(value="/board/register", method=RequestMethod.POST)

        	public ModelAndView boardRegisterPOST(ModelAndView mv) {	
        		mv.setViewName("redirect:/board/list");
        		return mv;
        	}
        redirect를 넣어줘야 게시글이 등록이 저장됨 

        - 화면에서 입력한 게시글이 오는지 확인

        @RequestMapping(value="/board/register", method=RequestMethod.POST)

        	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board) {	
        		System.out.println(board);
        		mv.setViewName("redirect:/board/list");
        		return mv;
        	}
        register.jsp에 제목과 내용 name지정을 안하면 null이 콘솔창에 뜸 

        - 로그인한 사용자 정보를 확인

        @RequestMapping(value="/board/register", method=RequestMethod.POST)

        	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board, HttpServletRequest request) {	
        		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
        		System.out.println(user);
        		mv.setViewName("redirect:/board/list");
        		return mv;
        	}
        - 서비스에게 일을 시킴

        @RequestMapping(value="/board/register", method=RequestMethod.POST)

        	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board, HttpServletRequest request) {	
        		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
        		//나중 공지사항 위해서 
        		board.setBd_type("일반");
        		boardService.registerBoard(board, user); 
        		mv.setViewName("redirect:/board/list");
        		return mv;
        	}@RequestMapping(value="/board/register", method=RequestMethod.POST)
        서비스/ 서비스 임플에 메소드 등록 및 구현

        - 게시글 제목이 있는지 확인

      - 다오/매퍼에 메소드 등록 및 쿼리 구현

        - insert문을 이용

16. ### 게시글 수정

    - /board/modify

    - 게시글 상세에서 게시글 수정 버튼을 추가 

      작성자와 로그인한 유저가 같은 경우만 보이도록 작성

    - 게시글 수정화면(get)

      - 컨트롤러에 메소드 등록 및 코드 구현

      - 게시글 수정 화면 jsp 생성

      - 컨트롤러에서 수정할 게시글 번호 확인

        이때, detail.jsp에 링크 주소에 번호가 있어야 한다 

        <a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">


      - 컨트롤러에서 회원정보 확인
      - 서비스에게 게시글 가져오라고 시킴
      - 게시글의 작성자와 회원  있으면 수정화면으로 이동
      - 게시글이 없으면 게시글 상세로 이동 
    
      @RequestMapping(value="/board/modify", method=RequestMethod.GET)
    
      	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
      		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
      		BoardVO board = boardService.getBoard(bd_num); 
      		//a != null && : 꼭 넣어줘야 함! 코드의 안정성을 높여준다
      		//A가 거짓이면 B를 체크하지 않음! 없을시, nullpointexception이 뜬다 
      		if(user != null && board != null &&
      				user.getMe_id().equals(board.getBd_me_id())) {
      			mv.addObject("board", board);
      			mv.setViewName("/board/modify");
      		}else {
      			mv.addObject("bd_num", bd_num);
      			mv.setViewName("redirect:/board/detail");
      		}
      		return mv;
      	}
      - 가져온 게시글 정보를 게시글 수정화면에 출력 
    
        modify.jsp: form tag이용 method는 post
    
    - 게시글 수정 기능 구현 (post)
    
      	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
      	public ModelAndView boardModifyPOST(ModelAndView mv, BoardVO board) {
      		System.out.println(board);
      		mv.setViewName("redirect:/board/detail");
      		return mv;
      	}	
      modify.jsp 에서 
    
      <input type="hidden" name="bd_num" value="${board.bd_num}">
    
      ```
      <button class="btn btn-outline-success col-12">등록</button>
      ```
    
      - 컨트롤러에서 메소드 등록 및 코드 구현 
    
        - 수정을 다하면 게시글 상세로 이동 
        - 수정된 게시글 정보 확인
        - 로그인한 회원 정보 확인
        - 서비스에게 수정하라고 시킴 
    
        @RequestMapping(value="/board/modify", method=RequestMethod.POST)
    
        	public ModelAndView boardModifyPOST(ModelAndView mv, BoardVO board
        			,HttpServletRequest request) {
        		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
        		boardService.modifyBoard(board,user);
        		mv.setViewName("redirect:/board/detail");
        		return mv;
        	}	
    
      - 서비스/서비스 임플에 메소드 등록 및 구현 
    
        젭속한 회원이 작성자인지 확인하여 일치하면 게시글 수정
    
      - 다오/매퍼에 메소드 등록 및 쿼리 구현
    
        수정된 게시글 정보를 DB에 업데이트 



### 17. 게시글 삭제

- /board/delete
- 게시글 상세에서 삭제 버튼을 추가
  - 작성자만 보이도록 작업
  - 버튼을 클릭하면 삭제 링크로 이동하도록 작업
  - 수정버튼 참고
- 컨트롤러에서 메소드 등록 및 코드 구현
  - get방식으로 등록
  - 삭제를 다하면 /board/list로 이동
  - 삭제할 게시글 번호를 확인
  - 로그인한 회원을 확인
  - 서비스에게 삭제하라고 시킴
    - 필요한 매개변수 설정을 잘 해야함
- 서비스/서비스 임플에 메소드 등록 및 구현
  - 유효한 번호인지 확인
    - 유효하지 않으면 삭제 종료
  - 번호와 일치하는 게시글 가져옴
  - 게시글이 없으면 삭제 종료
  - 게시글이 있으면 게시글 작성자와 로그인한 회원 아이디가 같은지 확인
    - 같으면 게시글 삭제
    - 다오에게 해당 게시글의 bd_del 속성을 Y로 수정하라고 시킴
- 다오/매퍼에 메소드 등록및 쿼리를 구현
  - 다오에 메소드 등록 후 @Param
  - update 쿼리문 작성




**첨부파일 연동하기** : https://github.com/st8324/Docs >젤 밑 파일 업로드 기능추가

register/ modify.jsp 파일 가서 enctype="multipart/form-data" 추가 

controller가서 /register 파트에서 List<MultipartFile> files 추가

utils 패키지생성 후 UploadFileUtils 클래스 생성 후 복붙 



### 18. 첨부파일 추가

- 기존 게시글에 첨부파일 등록하는 기능을 추가

  - 업로드를 위한 의존성 추가. pom.xml

    - ```
      <dependency>
          <groupId>commons-fileupload</groupId>
          <artifactId>commons-fileupload</artifactId>
          <version>1.3.2</version>
      </dependency>
      ```

  - servlet-context.xml에 업로드 크기 설정

    - ```
      <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
          <!-- 업로드 최대 크기 10Mb -->
          <beans:property name="maxUploadSize" value="10485760"></beans:property>
      </beans:bean>
      ```

  - 패키지 생성 및 UploadFileUtils 클래스 추가

    - 기본패키지명.utils 패키지 생성

    - ```
      public class UploadFileUtils {
      	public static String uploadFile(String uploadPath, String originalName, byte[] 	
      			fileData)throws Exception{
      		UUID uid = UUID.randomUUID();
      		String savedName = uid.toString() +"_" + originalName;
      		String savedPath = calcPath(uploadPath);
      		File target = new File(uploadPath + savedPath, savedName);
      		FileCopyUtils.copy(fileData, target);
      		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
      		return uploadFileName;
      	}
      	
      	private static String calcPath(String uploadPath) {
      		Calendar cal = Calendar.getInstance();
      		
      		String yearPath = File.separator+cal.get(Calendar.YEAR);
      		String monthPath = yearPath + File.separator 
                  + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
      		String datePath = monthPath + File.separator 
                  + new DecimalFormat("00").format(cal.get(Calendar.DATE));
      		makeDir(uploadPath, yearPath, monthPath, datePath);
      		
      		return datePath;
       
      	}
      	private static void makeDir(String uploadPath, String... paths) {
      		if(new File(paths[paths.length-1]).exists())
      			return;
      		for(String path : paths) {
      			File dirPath = new File(uploadPath + path);
      			if( !dirPath.exists())
      				dirPath.mkdir();
      		}
      	}
      	private static String makeIcon(String uploadPath, String path, String fileName)
              	throws Exception{
      		String iconName = uploadPath + path + File.separator + fileName;
      		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
      	}
      }
      ```

1. 게시글 등록할 때 첨부파일 기능 추가

   - register.jsp에 form태그 속서으로 enctype을 추가하고 값을 설정

     - `enctype="multipart/form-data"`

     - ```
       <form method="post" enctype="multipart/form-data">
           <!-- 화면 구현부는 생략 -->
       </form>
       ```

   - register.jsp에 첨부파일을 선택할 수 있도록, input태그를 추가

     - `<input type="file" name="xxx">`

     - ```
       <div class="form-group">
           <label>첨부파일</label>
           <input type="file" class="form-control" name="files">
           <input type="file" class="form-control" name="files">
           <input type="file" class="form-control" name="files">
       </div>
       ```

   - 컨트롤러에서 첨부파일을 받을 수 있도록 매개변수를 추가

     - /board/regitser, post에 추가

     - ```
       //이름은 register.jsp에 있는 name과 일치해야 함
       List<MutipartFile> files
       ```

   - 컨트롤러에서 서비스에게 시킨 게시글 등록 기능에 첨부파일을 추가

   - 서비스에 게시글 등록 메소드를 수정. 첨부파일을 매개변수로 추가

   - 서비스임플에 첨부파일을 매개변수로 추가

   - 게시글을 등록하고 나서 등록된 게시글의 게시글 번호를 가져오도록 xml수정

     - BoardMapper.xml에 다음 코드를 추가

     - ```
       <insert id="insertBoard" 
       	useGeneratedKeys="true"
           keyProperty="board.bd_num" 
           parameterType="kr.green.green.vo.BoardVO">
       ```

     - keyProperty

       - board : 다오에서 정한 이름. 다오에서 @Param("xxx") 이 부분에서 xxx에 해당
       - bd_num: VO의 기본키 이름

     - parameterType

       - 현재 진행중인 프로젝트의 패키지명과 VO명을 가져오면 됨.

   - 서비스 임플에 첨부파일 등록 기능

     - 반복문을 이용하여 첨부파일이 있으면 서버에 업로드하고, 다오에게 첨부파일을 등록하도록 시킴
     - 서비스임플에 첨부파일 경로를 멤버변수로 추가
       - 실제 폴더 경로
     - FileVO 생성
       - 테이블 속성 이름과 vo 멤버 변수 이름을 일치시켜야 함
       - 파일명, 경로파일명, 게시글 번호를 이용한 생성자 추가
       - 기본생성자 추가(@NoArgsConstructor)

   - 다오에 메소드 추가 및 매퍼에 쿼리문 추가

     - 매퍼에 insert문
     - 다오에 @Param 추가

2. 게시글 확인할 때 첨부파일 목록을 확인하고 클릭시 다운기능 추가

   - 컨트롤러에서 게시글 번호와 일치하는 첨부파일들을 가져오라고 서비스에게 시킴

     - /board/detail
     - 가져온 첨부파일들을 화면에 전송

   - 서비스/서비스 임플에 메소드 추가 및 구현

     - 게시글 번호가 유효하지 않으면 종료
     - 다오에게 게시글 번호와 일치하는 첨부파일을 가져오라고 시킴

   - 다오/매퍼에서 메소드 추가 및 쿼리문 구현

     - 매퍼에 select문
     - 다오에 @Param 추가

   - detail.jsp에 첨부파일 내용을 뿌려줌

     - a태그 이용
     - `<c:forEach></c:forEach>` 이용
     - 다운로드를 위해 링크 설정
       - /board/download

   - 컨트롤러에 다운로드를 위한 메소드 추가

     - 샘플 코드 참고

     - ```
       @ResponseBody
       @RequestMapping("/board/download")
       public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
       	InputStream in = null;
           ResponseEntity<byte[]> entity = null;
           String uploadPath = "D:\\JAVA_JIK\\upload";
           try{
           	String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
       	    HttpHeaders headers = new HttpHeaders();
           	in = new FileInputStream(uploadPath+fileName);

       		fileName = fileName.substring(fileName.indexOf("_")+1);
       		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       		headers.add("Content-Disposition",  "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
       	entity = new ResponseEntity<byte[]>	(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
       	}catch(Exception e) {
       		e.printStackTrace();
       		entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
       	}finally {
       		in.close();
       	}
       	return entity;
       }
       ```

3. 게시글 수정할 때 첨부파일 수정 기능 추가

   - 컨트롤러에서 첨부파일을 가져옴
     - /board/modify, GET
     - 가져온 첨부파일을 화면에 전달
   - modify.jsp에서 서버에서 보내준 첨부파일을 뿌려줌
     - a태그 아님
     - x버튼을 만듬(a태그로)
       - 클릭하면 첨부파일 내용 사라지고, input태그 file 추가
     - 첨부파일 번호를 input태그 hidden로 추가
     - 남은 첨부파일 갯수만큼 input태그 file로 추가
   - modify.jsp에 enctyp을 설정
   - 컨트롤러에서 추가된 첨부파일과 기존 첨부파일 번호를 화면에서 받아옴
     - /board/modify, POST
     - 기존 첨부파일 번호들을 확인
   - 컨트롤러에서 서비스에게 첨부파일들과 첨부파일 번호들을 같이 넘겨주면서 수정하라고 시킴
   - 기존 서비스 메소드에 매개변수 추가
   - 기존 서비스 임플 메소드에 매개변수 추가 후 첨부파일 수정 코드 구현
     - fileNums에 없는 첨부파일들 삭제 후 DB에서 삭제처리
       - DB에 삭제처리를 위해 다오에게 삭제하라고 요청
   - 다오에 메소드 추가 및 매퍼에 쿼리문 구현
     - 다오에 @Param추가
     - 매퍼에 update문 추가
     - selectFileList에 조건 추가
       - 삭제되지 않은 첨부파일만 가져오도록 수정
   - 서비스 임플에서 새로 추가된 첨부파일 등록

4. 게시글 삭제할 때 첨부파일 삭제 기능 추가

   - 서비스 임플에서 게시글 삭제 후 첨부파일도 삭제(게시글 삭제 방식에 따라 순서가 달라질 수 있다)



### 19. 게시글에 페이지네이션 적용

- [참고문서](https://github.com/st8324/Docs/blob/master/spring%20framework/Pagination.md)
- pagination 패키지, Criteria 클래스, PageMaker 클래스 추가
- /board/list에 매개변수로 Criteria 객체를 추가
- 컨트롤러가 서비스에게 게시글 가져오라고 시킬 때 현재 페이지 정보도 같이 넘겨줌
- 서비스에 있는 게시글 가져오는 메소드에 현재 페이지 정보를 매개변수로 추가
- 서비스 임플에서 다오에게 현재 페이지 정보를 추가로 줌
- 다오에 매개변수(현재페이지 정보)를 추가
- 매퍼에 limit문 추가
- 컨트롤러에서 서비스에게 총게시글(일반) 수를 알려달라고 시킴
- 가져온 게시글 수와 설정한 한 페이지네이션의 페이지수, 매개변수로 전달받은 현재 페이지 정보를 이용하여 페이지 메이커를 만듬
- 페이지 메이커를 화면에 전달
- 서비스 /서비스 임플에 메소드 추가 및 구현
- 서비스 임플에서 다오에게 type에 맞은 게시글 전체수를 가져오라고 시킴
- 다오/매퍼에 메소드 등록 및 쿼리문 구현
- select문을 이용
- list.jsp에서 페이지메이커를 이용하여 출력함



### 20. 게시글 검색 기능 적용

- /board/list.jsp에 게시글 검색창 추가
  - name 지정
  - form태그
- 매퍼에서 게시글 검색 시 검색어 반영되도록 조건 추가
  - 조건은 게시글 제목에 검색어가 포함
- /board/list.jsp에 페이지네이션 링크에 검색어 추가
- Criteria 수정
  - 멤버변수 search를 추가
  - 생성자에 search를 초기화
- 컨트롤러에서 총 게시글 수 가져올 때 현재 페이지 정보도 같이 넘겨줌
- 서비스/서비스임플에서도 게시글 수 가져올 때 페이지 정보 같이 넘겨줌
- 매퍼에 게시글수 가져오는 쿼리에 검색 조건을 추가
- ​

**summernote** : register.jsp <title> 위 

```
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
```

맨아래 </body>위

<script>

      $('[name=bd_contents]').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
    </script>


### 21. 답변 글쓰기

- detail.jsp에 답변 버튼을 추가
  - /board/register
- 컨트롤러에서 bd_ori_num를 받아서 화면에 전달
  - /board/reigster. GET
- register.jsp에 답변에 넘겨준 bd_ori_num의 값을 hidden로 추가
  - `<c:if>`를 이용하여 bd_ori_num이 null이 아닐때만 추가
- 매퍼에 bd_ori_num가 0이 아닐때 쿼리를 추가
  - insert문에. insertBoard
- 매퍼에 정렬 방법을 수정
  - select 문에. getBoardList
- 게시글 리스트에서 답변처럼 보이게 수정
  - /board/register.jsp
- 게시글 상세에서 답변인 경우 답변 버튼을 제거

### 21. 공지사항

- Criteria에 멤버변수 type을 추가
  - 생성자에 type을 "일반"으로 초기화
- 컨트롤러/서비스/서비스임플/다오 수정
  - /board/list. GET
    - 게시글 가져오는 메소드에 매개변수 type을 제거
    - 게시글 전체 갯수 가져오는 메소드에 매개변수 type을 제거
  - /board/register. POST
    - 게시글 타입을 제거
- 매퍼 수정
  - 게시글 가져오는 쿼리문에 type 대신 cri.type으로 수정
  - 게시글 전체 갯수 가져오는 쿼리문에 type 대신 cri.type으로 수정
- register.jsp 수정
  - input태그 hidden으로 게시글 타입을 설정
    - bd_type이 null이면 일반으로 값을 지정. 아니면 컨트롤러에서 넘겨 받은 값으로 지정
- header.jsp에서 공지사항 링크 수정
- list.jsp에서 글쓰기 버튼 링크 수정
- 컨트롤러 수정
  - /board/register. GET
    - url로 전달한 bd_type을 매개변수로 추가
    - 화면에 bd_type을 전달
  - /board/register. POST
    - 게시글 등록 후 리다이렉트 할 때 type값을 전달
- list.jsp 수정
  - 페이지 네이션 링크에 type을 추가
  - 검색창 안에 input태그 hidden으로 type을 추가
  - h1태그에서 게시글 부분 을 수정해서 공지사항/게시글이 보이도록 함
- detail.jsp 수정
  - 공지사항에는 답변이 불가능하도록



### 에러가 나는 경우

"모르겠는 경우, 컨트롤러부터 코드에 sysout(1)부터 ... 한후 서비스 임플 -> mapper ->

 DB 식으로 추적해봄"

"오타후 수정하고나서도 작동에 안되면, 다시 이름을 바꿔서 (baseLayout F2 & tiles-def.xml)

 작동해 본 후 작동이 되면 다시 원위치로! 특히, baseLayout.jsp와 관련하여 나는 에러" 



1. 에러 내용에 다음이 들어간 경우

   - ```
     Error creating bean with name 'homeController': Unsatisfied dependency expressed through field 'memberService';
     ```

   - 경우1 : MemberServiceImp에 @Service를 빼먹은 경우

   - 경우2 : servlet-context.xml에 base-package를 잘못 설정한 경우

2. 에러 내용에 다음이 들어간 경우

   - ```
     Error creating bean with name 'memberServiceImp': Unsatisfied dependency expressed through field 'memberDao'
     ```

   - 경우1 : root-context.xml에 mybatis-spring:scan base-package를 잘못 설정한 경우

   - 경우2 : MemberDAO를 클래스로 만든 경우

3. 에러 내용에 다음이 들어간 경우

   - ```
     Invalid bound statement (not found): kr.green.green.dao.MemberDAO.test
     ```

   - 경우1 : MemberMapper.xml에 namespace에 오타가 있는 경우

   - 경우2 : MemberMapper.xml에 id에 오타가 있는 경우

   - 경우3 : mappers 폴더의 위치가 잘못된 경우

4. 에러 내용에 다음이 들어간 경우

   - ```
     Could not resolve type alias 'kr.green.green.vo.MemberVO2'.  Cause: java.lang.ClassNotFoundException: Cannot find class: kr.green.green.vo.MemberVO2
     ```

   - 경우 : MemberMapper.xml에 resultType에 오타가 있는 경우

5. xml 파일과 관련된 에러 발생후 올바르게 수정했는데 계속 에러나는 경우

   - 원인 : 수정된 내용이 반영이 제대로 안되서
   - 해결방안 : 프로젝트 선택 후 Alt + F5를 누름

6. 에러 내용에 다음이 들어간 경우

   - ```
     Could not resolve resource location pattern [classpath:mappers/**/*Mapper.xml]: class path resource [mappers/] cannot be resolved to URL because it does not exist
     ```

   - 경우 : mappers 폴더 위치가 src/main/resources가 아니거나 폴더이름에 오타가 있는 경우

7. 404 에러 중 콘솔 창에 다음 경고가 뜨는 경우

   - ```
     WARN : org.springframework.web.servlet.PageNotFound - No mapping for GET /green/login
     ```

   - 경우1 : 컨트롤러에 URL을 담당하는 메소드를 만들지 않은 경우

   - 경우2 : 새 컨트롤러에 메소드를 제대로 만들었지만 컨트롤러 위에 @Controller를 안한 경우

8. 405 에러 중 콘솔 창에 다음 경고가 뜨는 경우

   - ```
     Request method 'POST' not supported
     ```

   - 경우 : 컨트롤러에 URL 중 POST를 담당하는 메소드를 만들지 않은 경우





controller 에서 loginGet을 되는지 안되는지 확인 

- controller: 복붙후 GET을 POST로 바꿔주고 


- @RequestMapping(value = "/login", method = RequestMethod.POST)

  public ModelAndView loginPost(ModelAndView mv, MemberVO user) {
  	System.out.println(user);
  	mv.setViewName("/member/login");
  	return mv;
  }
  "데이터를 전송하면 반드시 sysout으로 콘솔에서 확인" 

sysout 지우고



#### dao와 mapper.xml 맞춰줘야 함

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);
}

<mapper namespace="kr.green.test1.dao.MemberDAO">

	<select id="getMember" resultType="kr.green.test1.vo.MemberVO">
	select*from member where me_id = #{me_id}
	</select>
</mapper>

확인위해 MemberServiceImp로 가서 sysout

MemberVO dbUser = memberDao.getMember(user.getMe_id());

	System.out.println(dbUser);
	return null;





- views>member폴더 생성후 login.jsp 생성 


- views> layout> baseLayout.jps 에 <title> 밑에 bootstrap 4줄 복붙 





"ctrl+ space는 자동 완성 코드"   

"tiles 에서 에러가 날경우 페이지 거의 밑 쪽으로 가서 확인함"










