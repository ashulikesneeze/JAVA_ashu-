### 화면<=>컨트롤럴  class <=> 서비스 interface <=> 다오 interface

​     interface는 구현구가 핑요함 :                     service imp(class)                                   mapper(xml) 

​                                                                                                                    src>main>resources> mappers                                                                  

​           vo(class)                                       vo(class)                                         vo(class)

 

//DAO : data access object 

//vo : value object 

http://www.tomonari.co.kr/#a

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

3. jsp 파일 인코딩 설정
   src > main > webapp > web-inf> views > home.jsp
   <%@ page session="false" %> 지우고 복붙 

   <!DOCTYPE html> 추가 


​

2. View Resolver 등록 (servlet-context.xml)  : controller에서 

   ​

   spring_ashutest > src/main/java > kr.green.test1.controller로 이름 바꿔줌 

   ​

   src > main > webapp > web-inf > spring > appServlet > 

   젤 밑 base-package 부분  "kr.green.test1.controller"를  "kr.green.test1.*" 로 바꿈 

   servlet-context.xml에 다음 코드를 추가 복붙 

   ​

   ​

   **Tiles 연동** *템플릿 설정하기* 

   1. 타일즈 의존성 추가 (pom.xml) : 젤 밑 target 밑에
      - 5.1.8. version 

   - 15번째 줄 <org.apache.tiles-version>3.0.8</org.apache.tiles-version> 복붙


   - pom.xml 파일 안 `<dependencies>` 태그 안에 의존성 추가 : </dependencies> 앞에 복붙\

   ​

3. **타일즈 설정 추가** 

WEB-INF > spring 폴더에 tiles-def.xml 파일 생성 후 다음 코드 붙여넣기

: 1번들은 지워줌 



4. **기본 레이아웃 설정** 

   ![](./캡처.PNG)

- *baselayout* 

<html>위에 <!DOCTYPE html> 복붙 

빨간줄 지워줌  & container 지움 

첨부파일 (footer, header, head) 다운로드 받아 복붙 

- <h1>헤더</h1>



- window > preferences > en 타입후  > css file/html/jsp > Korean > UTF-8



**controller로 가서** 

return "/main/home"; 수정해줌 

/main/home 으로 접속 하여 테스트 한 후, value = "/"로 바꾸어줌 

![](D:\JAVA_ashu\JAVA_ashu-\spring_ashu\controller.PNG)



"오타후 수정하고나서도 작동에 안되면, 다시 이름을 바꿔서 (baseLayout F2 & tiles-def.xml)

 작동해 본 후 작동이 되면 다시 원위치로! 특히, baseLayout.jsp와 관련하여 나는 에러" 



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
- src/main/resources에서 mappers 폴더 생성 

- mapper 설정 복 붙 후 패키지 이름 수정 

  <mybatis-spring:scan base-package="kr.green.test1.dao"/>


- controller 위에 ctrl + N  후 package 선택 후 controller 지우고 dao

   & service 붙여 2개의 패키지 생성 


- sevice 패키지 선택 후 ctrl + N 후 interface 타입 후 MemberService 생성 


- sevice 패키지 선택 후 ctrl + N 후 class 에서 MemberServiceImp 생성 후 

  public class MemberServiceImp implements MemberService{}

- dao 패키지 선택 후 ctrl + N 후 interface 타입 후 MemberDAO 생성 


- src/main/resources에서 cntl +N 에서 folder 후 mappers (root-context.xml 파일에서 이름 맞춤)

  없을경우 src>main>resources>mappers 로 생성 


-  root-context.xml 파일에서 이름 맞춤뒤  여기에 블로그에서 mapper 설정 

  예시쪽에서 복붙 후 코드 수정 

- mappers 패키지에서 cntrl + N 에서 xml 타입 후 MemberMapper.xml 생성 및 복붙 

    <mapper namespace="kr.green.test1.dao.MemberDAO">

"tiles 에서 에러가 날경우 페이지 거의 밑 쪽으로 가서 확인함"

- views>member폴더 생성후 login.jsp 생성 


- views> layout> baseLayout.jps 에 <title> 밑에 bootstrap 4줄 복붙 

"ctrl+ space는 자동 완성 코드"   



**VO class 만들기** : *비닐봉투와 같은 역할* 

- vo 패키지(.vo) 먼저 만든 후,  class 이름 맨 뒤에 VO를 붙여 만든다 


- table을 보고 객체 만듬 private String me_id; 등등


- getter/ setter &@toString 생성 


- login.jsp : name 에 맞는 객체 이름으로 넣어주고 




**Service package** > service (Interface) > service(class)Imp : implements .. & @Service

**Dao package** > dao(interface )



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

 *@Autowired*

	MemberService memberService; 

MemberServiceImp로 가서 @Service 넣어줌 



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














