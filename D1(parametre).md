github.com/stajun2/java_jik


github-login

D drive: Java / Java_ashu

gibhub desktop

oracle-java D:WJAVAWashu-17.0.1W

Eclipse 

*when you fetch others:

github fetch -> eclipse (file -> open project ->directory)

* 연동하기: Github screen에서 code copy 

  ​                  Github Desktop: file -> clone repository -> URL paste

  ​                  Eclipse: file -> directory 

  ​

* Spring Framework : eclipse -> help -> Eclipse Marketplace -> sts -> 2nd 3. version

  ​

  ctrl + N -> spring -> spring legacy -> untick use default loction / Srping MVC project -> kr.green.spring 

  ​

  Tomcat website -> 9 version ->  core zip download -> 압축해제 -> D: Java folder로 copy/paste

  ​

  ctrl + N -> server -> Tomcat 9 -> right click -> run as -> run on server -> finish

  ​

  file open project -> directory -> D: spring_ashu 

  ​

* Window -> preference -> general -> workspace -> UTF-8

  ​

* https://stajun.tistory.com/ 

* web.xml 파일수정 -> 32번째 줄 

* home2.jsp -> <!DOCTYPE html> 위에 jsp 파일 인코딩 설정 code copy and paste 

* spring gitignore website ->  copy all -> D: gitignore open with note -> paste (leave pom.xml)

* website: localhost:8080/spring/ 







 class A {

}

class B extends A {

public B () {

생성자 super();

​            this();

​	}

}



interface : 다중 상속 가능 spring에서 클래스 형변환 overriding a lot 

interface Name {

// 추상메소드들;

//상수;

/디폴트 메소드들;

}

class Name implements InterfaceName {

//인터페이스의 추상메소드를 overriding

}



collection : single data - list<className1> set<className1>

Map : plural data - <key(ID:replica x), value(pw:replica o)











# clone(클론)

- 온라인 저장소에 있는 파일들을 내 PC로 복사(복제)

# commit(커밋)

- 내 PC에서 수정된 이력을 내 PC에 기록

# push(푸쉬)

- 내 PC에 수정된 이력들을 온라인 저장소에 업데이트

# pull(풀)

- 온라인 저장소에 있는 내용으로 내 PC를 업데이트



# 변수

- 데이터를 저장하는 공간

- 데이터를 관리하기 위해 필요

- 기본 자료형 (8가지)

  - 실제 값을 관리하는 변수

  - 참 / 거짓 : **boolean**

  - 문자 :

     char

    , 문자열이 아닙니다.

    - 문자는 한글자, '로 시작하고 '로 닫음
    - 문자열은 0글자 이상, "로 시작하고 "로 닫음
    - '1'는 문자 1이고, "1"은 문자열 1로 다름
    - '123'은 에러, "123"은 가능
    - ''은 에러(빈 문자는 없음), ""은 가능
    - 문자는 기본 자료형이고, 문자열은 참조 변수
    - 문자를 나타내는 char는 언어마다 크기가 다름. 자바에서는 2바이트, C언어에서는 1바이트

  - 정수 : byte(1), short(2),int(4),long(8)

    - 크기 차이 => 표현 범위
    - byte(8) : -128~127
    - short(16) : -2의15제곱 ~ 2의15제곱-1
      - -32 * 1000 ~ 32 * 1000
    - int(32) : -2의31제곱 ~ 2의 31제곱-1
      - -2 * 1000 * 1000 * 1000 ~ 2 * 1000 * 1000
    - long(64) : -2의63제곱~ 2의63제곱-1
    - 정수는 엄청 큰 숫자가 아니면 일반적으로 int를 많이 씀

  - 실수 : float, double

    - 크기 차이 => 표현 범위, 정확성
    - float은 소수점 6자리까지 정확, 끝에 float형을 나타내는 f,F를 붙여야 함
    - double은 소수점 15자리까지 정확
    - 1.1234567890123456과 1.1234567890123456f 가 있을 때
      - 1.1234567890123456는 두번째 5까지는 정확하고, 두번째 6부터는 맞을 수도 있고 틀릴수도 있다
      - 1.1234567890123456f는 첫번째 6까지는 정확하고, 첫번째 7부터는 맞을 수도 있고 틀릴수도 있다
    - 실수는 일반적으로 double을 많이 씀

# 변수 선언 및 초기화

```
자료형 변수명; //변수를 선언
변수명 = 초기값; //위에서 변수를 선언한 후 초기화를 나중에 함
자료형 변수명 = 초기값; //변수 선언과 동시에 초기화
```

- 변수를 선언할 때 관리하는 데이터의 종류를 생각한 후 자료형을 결정한 후 진행해야 한다.

# 변수명 작성 규칙(필수) 교재 p.40

1. 변수명 시작은 숫자가 올 수 없다.
2. 변수명은 영어, 숫자, _, $, 한글 가능. 한글은 잘 사용하지 않음. 공백 불가능
3. 변수명은 대소문자를 구분한다.
   - num1 과 Num1은 다른 변수
4. 변수명은 중복 사용이 불가능
5. 길이 제한은 없다.
6. _는 변수명이 안됨
7. 키워드(예약어)는 사용할 수 없다
   - 키워드(예약어)는 기능이 미리 지정된 단어로, 일반적으로 단어 색상이 다름
   - 대표적으로 기본 자료형

# 변수명 작성 관례(선택)

1. 변수명은 의미 있게 만든다.
   - int a; 보다는 int age;가 의미가 명확
2. 변수명은 소문자로 작성하고, 여러 영어 단어로 이루어진 경우 두번째 단어부터 첫글자만 대문자로 씀(카멜 표기법)
   - 학생 성적 => double studentScore;
3. 클래스명은 첫글자를 대문자로 작성함.
4. 상수명은 모두 대문자로 씀. 여러 단어로 이루어진 경우 _로 구분
   - 강의 최대 인원 => final int MAX_STUDENT_COUNT = 20;
5. 강사는 자주 사용하는 변수는 줄여씀
   - 개수를 의미하는 변수를 쓸때 count보다는 cnt로, 임시로 쓸 변수인 경우 temporary보다는 tmp로 사용

# 여러 변수를 선언하는 방법

```
// 자료형이 같은 경우 ,를 이용하여 한번에 쓸 수 있다.
자료형 변수명1, 변수명2;
자료형 변수명3;
자료형 변수명4;
자료형 변수명5, 변수명6 = 초기값, 변수명7, 변수명8 = 초기값;
```

```
int num1, num2; //정수형 변수 num1, 정수형 변수 num2
int num3, num4 = 0, num5 = 1, num6;// 정수형 변수 num3과 num6는 초기화 하지 않고, num4는 0으로, num5는 1로 초기화
```

# 메모리 크기

- bit : 0 또는 1을 저장
- 1byte : 8bit
- 1KByte : 1024byte
- 1MByte : 1024KByte
- 1GByte : 1024MByte

# 표현 범위

- 1bit로 표현 가능 범위 : 2
- 2bit로 표현 가능 범위 : 4
- nbit로 표현 가능 범위 : 2의 n제곱
- 1byte로 표현 가능 범위 : 2의 8제곱 => 256가지
  - 0~255
  - -128~127

# 진수

- 10진수 : 0~9까지의 숫자로 표현할 수 있는 수
- 2진수 : 0,1로 표현할 수 있는 수
- 8진수 : 0~7가지의 숫자로 표현할 수 있는 수
- 16진수 : 10 => a, 11 => b, 12=>c, 13=>d, 14=>e, 15=>f
- 10(10) = 1010(2) = 12(8) = a(16)
- 11(2) = 3(10)
- 11(8) = 9(10)
- 11(16) = 17(10)

# 기본 자료형과 참조 자료형

- 기본 자료형 변수는 실제 값을 저장하는 변수
- 참조 자료형 변수는 주소를 저장하는 변수