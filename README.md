# 정원영(202530127)
- [1120 강의](#11월20일-강의)
- [1106 강의](#11월06일-강의)
- [1031 강의](#10월-31일-강의)
- [1030 강의](#10월-30일-강의)
- [1002 강의](#10월-2일-강의)
- [0925 강의](#9월-25일-강의)
- [0918 강의](#9월-18일-강의)
- [0911 강의](#9월-11일-강의)
- [0904 강의](#9월4일-강의)

<br>

# (11월27일 강의)
## MouseEvent 객체 활용
마우스 포인터,컴포넌트 내 상대 위치: ``` int getX() int getY()```

## Mouse 이벤트와 MouseListener, MouseMotionListener
  - mouseClicked() : 마우스가 눌러진 위치에서 떼어질 때 호출
  - mouseReleased() : 마우스가 눌러진 위치에서 그대로 항상 호출
  - mouseDrageed() : 마우스가 드래그 되는 동안 계속 호출
### 메소드 호출 순서
mousepressed() -> mouseRelease() -> mouseClicked()


## 난수 함수
난수 함수로 나온 값은 1보다ㄴ 작은 값

## 가상 키와 입력된 키 판별
- key Event 객체
  - 입력된 키 정보를 가진 이벤트 객체
  - KeyEvent 객체의 메소드로 입력된 키 판별
- KeyEvent 객체의 메소드로 입력된 키 판별



## 유니코드(unicode) 키
- 유니코드 키의 특징
  1. 국제 산업 표준
  2. 전세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
  3. 문자들에 대해서만 키 코드 값 정의 : A~Z ,a~z 0~9, ! @ & 등
- 문자가 아닌 키 일 경우 플랫폼에 따라 다르다.
- int keyEvent.getKeyCode()
  - 유니코드 키 포함
  - 모든 키에 대한 정수형 키 코드 리턴
  - 가상키 값과 비교
  가상 키 값은 KeyEvent 클래스에 상수로 선언

## keyListener
  - 응용프로그램에서 KeyListener를 상속받아 키 리스너 구현
  - KeyListener의 3개의 메소드
    1. 키를 누르는 순간
    2. 누른 키를 떼는 순간
    3. 누른 키를 떼는 순간(Unicode키 경우) 


## Key 이벤트와 포커스
- 키 입력시, 다음 key 이벤트 발생
  - 키를 누르는 순간
  - 누른 키를 떼는 순간
  - 누른 키를 떼는 순간(Unicode키 경우)
- 키 이벤트를 받을 수 있는 조건
  - 모든 컴포넌트
  - 현재 포커스(focus)를 가진 컴포넌트가 `키 이벤트 독점`
- 포커스(focus)
  - 키 이벤트를 독점 하는 권한 : 컴포넌트, 응용프로그램
  - 자바 플랫폼 마다 설정 방법 다를수 있음
  - 컴포넌트에 포커스 설정 방법
  ```java
  component.setFocusable(true);
  component.
  ```

## 어댑터 클래스
- 이벤트 리스너 구현에 따른 부담요소
  - 추상 메소드를 모두 구현 해야한다.
- 어댑터 클래스
  - 리스너의 모든 메소드를 단순 리턴하도록 만든 클래스(JDK에서 제공해준다.)
- 추상 메소드는 리스너X
## 익명 클래스로 이벤트 리스너 작성
- 익명 클래스(anonymous class) : 이름 없는 클래스
  - (클래스 선언 + 인스턴스 생성)을 한번에 달성
```java
new 익명클래스의 슈퍼클래스이름(생성자인자들) {
  익명클래스의 멤버 구현
}
```
- 간단한 리스너의 경우 익명 클래스 사용 추천
  매소드의 개수가 1,2개인 리스너에 주로 사용한다.

## 이벤트 리스너 작성 방법
[ 3가지 방법]
- 독립 클래스로 작성
  - 이벤트 리스너를 완전한 클래스로 작성
  - 이벤트 리스너를 여러 곳에서 사용할 때 적합
- 내부 클래스로 작성
  - 클래스 안에 멤버 처럼 클래스 작성
  - 이벤트 리스너를 특정 클래스에서만 사용할 때 쓰면 좋다.
- 익명 클래스로 작성
  - 클래스의 이름 없이 간단히 리스너 작성
  - 클래스 만들 필요 없는 간단한 경우에 사용
---
1. 이벤트와 이벤트 리스터 선택
  - 버튼 클릭을 처리하고자 하는 경우
    - 이벤트 : Action 이벤트, 이벤트 리스너 : ActionListener
2. 이벤트 리스너 클래스 작성 : ActionListener 인터페이스 구현
```java
class MyActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JButton b = (Jbutton)e.getSoure();
    if(b.getText().equals("Action")) {
      b.setText("액션");
    else b.setText("Action");
    }
  }
}
```
3. 이벤트 리스트 등록
- 이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
- component.addXXXListener(listener)
  - xxx : 이벤트 명, listener : 이벤트 리스너 객체
```java
MyActionListener listener = new MyActionListener();
btn.addActionListener(listener);
```

# (11월20일 강의)

## 이벤트 객체
### 이벤트 객체
- 발생한 이벤트에 관한 `정보를 가진 객체`
- 이벤트 리스너에 전달됨 : 이벤트 리스너 코드가 발생한 이벤트에 대한 `상황을 파악`할 수 있게 함
### 이벤트 객체가 포함하는 정보
- 이벤트 종류와 이벤트소스
- 이벤트가 발생한 화면촺표 및 컴포넌트 내 좌표
- 이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
- 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
- 키의 코드 값과 문자 값
- 체크박스. 라이오 버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태

### 이벤트 소스를 알아내는 메소드 : Obaject getSourece()
- 발생한 이벤트의 소스 컴포넌트 리턴
- Object 타입으로 리턴하므로 캐스팅하여 사용
- 모든 이벤트 객체에 대해 적용

## 자바 스윙 프로그램에서 이벤트 처리 과정
1. 이벤트 발생 
2. 이벤트 객체 생성
3. 응용프로그램에 작성된 이벤트 작성
4. 이벤트 리스너

## 이벤트 기반 프로그래밍
- 이벤트의 발생에 의해 `프로그램 흐름이 결정`되는 방식
  - 이벤트가 발생하면 이벤트를 처리하는 루틴(`이벤트 리스너`) 실행
  - 실행될 코드는 이벤트의 발생에 의해 전적으로 결정
- 반대되는 개념 : 배치 실행(batch porgramming)
  - 프로그램의 `개발자가 프로그램의 흐름을 결정`하는 방식
### 이벤트 종류
- 사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누름 등
- 센서로부터의 입력, 네트워크로부터 데이터 송수신
- 다른 응용프로그램이나 다른 스레드로부터의 메시지

### 이벤트 기반 응용 프로그램
- 각 이벤트마다 처리하는 리스터 코드 보유

### GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
- GUT 라이브러리 종류 : c++ 의 MFC, C# GUI, Visual Basic, X window, Android 등
- 자바의 AWT와 Swing


## 컴포넌트의 절대 위치와 크기 설정
- 배치 관리자가 없는 컨테이너에 컴포넌트를 삽입 할 때
  - 절대 크기와 위치 설정
  - 서로 겹칠수 있다.

- 컴포넌트의 크기와 위치 설정 매소드
```java
void setSize(int width, int height) // 버튼 크기를 100 * 40dmfh wlwjd
void setLocation(int x ,int y) // 버튼 위치를 (50,50)으로 지정
void setBounds(int x,int y,int width, int height) // 패널 내 (50,50)에 100 * 40 크기의 버튼 출력

```


## 배치 관리자가 없는 컨테이너
- 필요한 경우
 - 응용 프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는경우
    1. 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
    2. 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우
    3. 
## GridLayout 생성자
- 생성자
  - GridLayout()
  - GridLayout(int rows, int cols)
  - GridLayout(int rows,int cols,int hGap,int vGap)
    - rows :
    - 

## BorderLayout 생성자와 add() 메소드
- 생성자
  - BorderLayout()
  - BorderLayout(int hGap, int vGap)
    - hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위 (디폴트 : 0)
    - vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위 (디폴트 : 0)


## BorderLayout 배치관리자
- 배치 방법
  - 컨테이너 공간을 5 구역으로 분할, 배치 : 동, 서, 남, 북, 중앙

- 배치 방법
  - add(Component comp,int index)

## FlowLayout의 생성자
- 생성자
```java
FlowLayout()
FlowLayout(int align, int hGap,int vGap);
```
##FlowLayout 배치 관리자
- 배치 방법
  - 컴포넌트를 컨테이너 내에 왼쪽에서 오른쪽으로 배치
  - 다시 위에서 아래로 

## 컨테이너에 새로운 배치 관리자 설정
- 컨테이너에 `새로운 배치관리자 설정`
  - setLayout(LayoutManager lm) 메소드 호출 : lm을 새로운 배치 관리자로 설정

### 사례
JPanel 컨테이너에 BorderLayout 배치 관리자를 설정하는 예
```java
JPanel p = new JPanel();
p.setLayout(new BorderLayout());
```
컨텐트팬의 배치관리자를 FlowLayout 배치관리자로 설정
```java
Container c = frame.getConentPane();
c.setLayout(new FlowLayout());
```
### 오류 !
```java
c.setLayout(FLowLayout);
```

## 컨테이너와 디폴트 배치관리자
- 컨테이너의 디폴트 배치관리자 : 컨테이너 생성시 자동으로 생성되는 배치 관리자


## 배치 관리자 대표 유형 4가지
- Flowlayout 배치 관리자
  - 컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치
  - 배치할 공간이 없으면 아래로 내려와서 반복한다.
- BorderLayout 배치 관리자
  - 컨테이너의 공간을 동, 서, 남, 북, 중앙의 5개 영역으로 나눔
  - 5개 영역 중 응용프로그램에서 지정한 영역에 컴포넌트 배치
- GridLayout 배치 관리자

- CardLayout 배치 관리자



## 컨테이너와 배치, 배치관리자 개념
- 컨테이너의 배치 관리자
  - 컨테이너마다 하나의 배치관리자 존재
  - 컨테이너에 부착되는 컴포넌트의 위치와 크기 결정
  - 컨테이너의 크기가 변경되면, 컴포넌트의 위치와 크기 재설정

## Swing 응용프로그램의 종료
- 응용 프로그램 내에서 스스로 종료하는 방법
  - 언제 어디서나 무조건 종료 ```System.exit(0);
### x를 눌러서 끄면?
- 백그라운드에서 돌아가고 있다.
## JDK5.1 이후 스타일
다만 배경색, 투명도, 보더 등은 자동으로 위임되지 않기 때문에 getContentPane().을 사용해야합니다

## FlowLayout의 배치 관리자
- 순서대로 부착


# (11월 13일 강의)

## Swing 프레임
- 스윙 프레임 : 모든 스윙 컴포넌트를 담는 최상위 컨테이너

- 스윙 프레임(JFrame) 기본 구성
  - 프레임 : 스윙 프로그램의 기본 틀
  - 메뉴바 : 메뉴들이 부착되는 공간
## 컨테이너와 컴포넌트
### 컨테이너
- 다른 컴포넌트를 포합할 수 있는 GUI 컴포넌트 : java.awt.Container 상속

### 컴포넌트
- 컨테이너에 포함되어야 화면에 출력 가능
- 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
- 모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Component
- 스윙 컴포넌트가 상속받는 클래스 : javax.swing.Jcomponent

### 최상위 컴포넌트
- 다른 컨테이너에 포함되지 않고도 화면에 출력 되며, 독립적으로 존재 가능한 컨테이너


## 자바의 GUI
- [Swing 패키지]
- AWT 기술을 기반
- 모든 AWT 기능 +추가된 풍부하고 화려한 고급 컴포넌트
- 순수 자바 언어로 구현
- AWT 컴포넌트 이름 앞에 J자를 덧 붙임
- 운영 체제 부담 줄려줌

## 자바의 GUL(Graphical User Interface)
- GUI : 사용자가 편리하게 입출력 할 수 있도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력 받을 수 있도록 지원하는 사용자 인터페이스
- 자바 언어에서 GUT 응용프로그램 작성 : `AWT`와 Swing 패키지에 강력한 GUT 컴포넌트 제공.

### AWT 패키지
- 최근에는 거의 사용 x
- 운영 체제가 직접 그려서 속도가 빠르다.


## String 활용
- 스트링 비교, equals() 와 compareTo() -> 스트링 비교에 == 연산자 절대 사용금지
- equals() : String이 같으면 true, 아니면 false 리턴
```java
String java = "Java";
if(java.equals("java")) // ture
```
## int compareTo(String anotherString)
- 문자열이 같으면 0 리턴
- anotherString 보다 먼저 나오면 음수 리턴
- anotherString 보다 나중에 나오면 양수 리턴
```java
String java ="Java";
String cppp = "c++";
int res= java.compareTo(cpp);
if(res == 0) System.out.println("the same");

```
## 스트링 리터널과 new String()
- 스트링 리터럴
  - 자바 가상 기께 내부에서 리터럴 테이블에 저장되고 관리됨
  - 응용프로그램에서 공유됨
  - 스트링 리터럴 사례) `String s = "Hello";`
- new String()으로 생성된 스트링
  - 스트링 객체는 힙에 생성
  - 스트링은 공유되지 않음


## String의 생성과 특징
- String 클래스는 문자열을 나타냄
- 스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨
- 스트링 객체의 생성 사례


## 박싱과 언방식
- 박싱   : 기본 타입의 값을 Wrapper 객체로 변환하는 것
- 언박식 : Wrapper 객체에 들어 있는 기본 타입의 값을 뺴내는 것. 박싱의 반대
- 자동 박싱과 자동 언박싱 : 1.5부터 자동
```java
Integer ten = 10;
int n = ten;
```

## warpper 활용
- wrapper 객체로 부터 기본 타입 값 알아내기
- 문자열을 기본 데이터 타입으로 변환
- 기본 타입을 문자열로 변환

## warpper 객체 생성
- 기본 타입의 값으로 warpper 객체 생성
``` java
Integer i = Integer.valueOf(10);
Character c = Character.valueOf('c');
Double f = Double.valueOf(3.14);
Boolean b = Boolean.valueOf(true);
```
- 문자열로 warpper 객체 생성
``` java
Integer i = Integer.valueOf("10");
Double f = Double.valueOf("3.14");
Boolean b = Boolean.valueOf("false");
```
- Float 객체는 Double 타입의 값으로 생성가능
``` Java
Float f = Float.valueOf((double) 3.14);
```


## 객체 비교(==) 와 equals() 메소드
- == 연산자 : 객체 레퍼런스 비교
- boolean equals(object obj)
  - 두 객체의 내용물 비교
  - 객체의 내용물을 비교하기 위해 클래스의 멤버로 작성
# (11월06일 강의)
## 테크페어 사진
![my_image](my_pair_image.jpg)
## 객체속성
- hashCode()
- getClass()
- toString()-
## Object 클래스
- 모든 자바 클래스는 반드시 Object를 상속 받도록 자동 컴파일


## JDK의 주요 패키지
### java.lang
- 스트링, 수학 함수, 입출력 등 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스
- 자동으로 import 됨 - import 문 필요 없음
### java.util
- 날짜, 시간, 벡터, 해시맵 등과 같은 다양한 유틸리티 클래스와 인터페이스 제공
### java.io
- 키보드, 모니터, 프린터, 디스크 등에 입출력을 할 수 있는 클래스와 인터페이스 제공
### java.awt
- GUI 프로그램을 작성하기 위한 AWT 패키지
### javax.swing
- GUI 프로그래밍을 작성하기 위한 스윙 패키지
## 자바 모듈화의 목적
- 자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함
- 컴퓨터 시스템의 불필요한 부담 감소
  - 세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
  - 소형 IOT 장치에도 자바 응용프로그램이 실행되고 성능을 유지하게 함

## 자바 플랫폼의 모듈화
- 자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭. JAVA SE(Java API) 포함.
- 자바 API의 모든 클래스가 여러 개의 모듈로 재구성 됨
- 모듈 파일은 JDK의 Java.base 모듈이 패키지와 클래스들로 풀림


## 모듈 개념
- java9 에 등장
- 패키지와 이미지등의 리소스를 잠은 컨테이너
- 모듈 파일(.jmod) 저장


## package의 운영 방법
- 패키지 이름은 도메인 기반으로 시작
- 충돌 방지 / 모쥴별 분리 가능
- 디렉토리 구조와 package 선언을 정확히 일치 해야 합니다.
- import는 필요한 만큼만, * 전체 import는 피하는 것이 좋다.


## java package 생성
com/foo/test/ 이런식으로 디렉터리 관리
com.foo.test <- 이런식으로 접근한다.


## 디폴트 패키지
- package 선언문이 없는 자바 소스
- 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속 시킴 -> package 선언문이 없으면 실행
- 디폴트 패키지 -> 현재 디렉터리
## 패키지 만들기
- 클래스 파일이 저장되는 위치 : 패키지로 선언된 디렉터리에 저장
## import문
- 다른 패키지에 작성된 클래스 사용

### 다른 패키지에 작성된 클래스 사용
```java
java.utill.Scanner scanner = new java.util.Scanner(System.in);
```
### 필요한 클래스만 import
```java
import java.util.Scanner;

Scanner scanner = new java.util.Scanner(System.in);
```
### 패키지 전체를 import
```java
import java.utill.*;

javascanner = new java.util.Scanner(System.in);
```


---
.jmod 압축을 풀면 여러 패키지가 있다`

## 패키지 개념과 필요성
- 여러명이 자바 응용프로그램을 개발하는 경우, 동일한 이름의 클래스가 존재 가능성이 있다. -> 합칠때 오류 발생 가능성이 있다.
- 개발자가 서로 다른 데렉터리로 코드 관리하여 해결한다.

## 자바의 패키지와 모듈로
- 패키지(package)
    - 서로 관련된 클래스와 인터페이스를 컴파일한 `클래스 파일들을 묶어 놓은 디렉터리`
    - 하나의 응용프로그램은 `한 개 이상의 패키지`로 작성
    - jar파일로 압축 가능
- 모듈
    - 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    - 하나의 모듈을 하나의 `.jmod` 파일에 저장
  - 모듈화 도입
  - java 9 부터 도입
  - 자바 api의 모든 클래스들을 패기지 기반에서 모듈들로 완전히 재구성
  - 응용프로그램의 모듈화 : 클래스 -> 패키지 -> 모듈 로 만들었다.

- 모듈화의 목적
  - 
# (10월 31일 강의)
5강 끝
## 인터페이스 구현
- 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
  - implements 키워드 사용
  - 여러 개의 인터페이스 동시 구현 가능



## 인터페이스 상속
- 인터페이스 간에 상속 가능
  - 인터페이스를 상속하여 확장된 인터페이스 작성 가능
  - extends 키워드로 상속 선언

- 인터페이스 다중상속 허용 

## 인터페이스의 구성요소들 특징
- 상수 : public만 허용, public static final 생략
- 추상 매소드 : public abstract 생략 가능

- defalut 메소드 : 
    - 인터페이스에 코드가 작성된 메소드
    - 인터페이스를 구현하는 클래스에 자동 상속
    - public 접근 지정만 허용. 생략 가능
- private 메소드 :
    - 인터페이스 내에 메소드 코드가 작성되어야 함
    - 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능
- static 메소드 : public, private 모두 지정 가능. 생략하면 public
- 인터페이스의 객체 생성 불가
```java
new PhonInterface(); // 오류. 인터페이스 PhoneInterface 객체 생성 불가
```
- 인터페이스 타입의 레퍼런스 변수 선언 가능
```java
PhoneInterface galaxy; // galaxy는 인터페이스에 대한 레퍼런스 변수
```

## 인터페이스의 필요성
- 소프트웨어를 규격화된 모듈로 만듬
- 엔터페이스가 맞는 모듈을 조립 하듯이 응용프로그램을 작성 하기 위해서

### 자바의 인터페이스
- 클래스가 구현해야 할 메소들이 있다.

## 추상 클래스의 목적
- 상속을 위한 슈퍼 클래스로 활용하는 것
- 서브 클래스에서 추상 메소드 구현
- 다형성 실현

## 추상 클래스의 상속과 구현
- 추상 클래스 상속
    - 추상 클래스를 상속 받으면 추상 클래스가 됨
    - `서브 클래스도 abstract로 선언` 해야함
    ```java
    abstract class A {
      abstract public int add(int x,int y);
    }
    abstract class B extends A {
      public void show() { System.out.println("B");}
    }
 
    A a = new A(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
    B b = new B(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
    ```

- 추상 클래스 구현
    - 서브 클래스에 슈퍼 클래스의 추상 메소드 구현 (오버 라이딩)
    - 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님
```java
class C extends A {
  public int add(int x, int y) {return x+y;}
  public void show() {System.out.print;n("C");}

  C c = new C(0);
}
```
## 추상 클래스의 인스턴스 생성 불가
- 추상 클래스는 온전한 클래스가 아니기 때문에 `인스턴스를 생성할 수 없음`
```java
JComponent p; // 오류 없음. 추상 클래스의 레퍼런스 선언
p = new JComponent(); // 컴파일 오류. 추상 클래스 인스턴스 생성불가
Shape obj = new Shape(); // 컴파일 오류. 추상 클래스 인스턴스 생성불가
```

## 추상 클래스
- 추상 메소드(abstract method)
  - abstract로 선언된 메소드, `메소드의 코드는 없고 원형만 선언`
  ```java
  abstract public String getName();
  abstract public String fail() {return "Good Bye";}
  ```
- 추상 클래스(abstract class)
  - 추상 메소드를 가지며, abstract로 선언된 클래스
  - 추상 메소드 없이, abstract로 선언 한 클래스
```java
abstract class Shape {
  public Sgape() { ... }
  public void edit { ... }
  
  abstract public void draw(); // 추상 메소드
}
```
```java
// 추상 메소드 없는 추상 클래스
abstract class JComponet {
  String name;
  public void load(String name) {
    this.name = name;
  }
}
```


## 오버로딩과 오버 라이딩
### 오버로딩
- 선언 : 같은 클래스나 상속 관계에서 동일한 이름의 메소드 중복작성
- 관계 : 동일한 클래스 내 혹은 상속 관계
- 목적   : 이름이 같은 여러개의 메소드를 중복 선언하여 사용의 편리성 향상
- 조건   : 메소드 이름은 반드시 동일함. 메소드의 인자의 개수나 인자의 타입이 달라야 성립
- 바인딩 : 정적 바인딩. 컴파일 시에 중복된 메소드 중 호출되는 메소드 결정
### 메소드 오버 라이딩
- 선언 : 서브 클래스에서 슈퍼 클래스에 있는 메소드와 동일한 이름의 메소드 재작성
- 관계   : 상속 관계
- 목적   : 슈퍼 클래스에 구현된 메소드를 무시하고 서브 클래스에서 새로운 기능의 메소드를 재정의 하고 함
- 조건   : 메소드의 이름, 인자의 타입, 인자의 개수. 인자의 리턴 타입 등이 모두 동일하여야 성립
- 바인딩 : 동적 바인딩, 실행 시간에 오버라이딩된 메소드 찾아 호출

## super 키워드로 슈퍼 클래스의 멤버 접근
- 슈퍼 클래스의 멤버를 접근할 때 사용되는 레퍼런스 super.슈퍼 클래스의 멤버
- 서브 클래스에서만 사용
- 슈퍼 클래스의 필드 접근
- 슈퍼 클래스의 메소드 호출시 super로 이루어지는 메소드 호출 : 정적 바인딩

## 동적 바인딩
- SuperObject(임시 키워드) 하나만 있는 응용프로그램의 경우 혹은 상속받은 경우 모두 종적 바인딩을 한다.[ 오버라이딩 메소드가 항상 호출 된다.]
 
## 오버라이딩의 목적, 다형성 실현
- 오버라이딩으로 다형성 실현
- 하나의 인터페이스(같은 이름)에 서로 다른 구현
- 슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현
- 사례 : Shape의 draw() 메소드를 Line, Rect, Circle에서 오버라이딩하여 다르게 구현



## 서브 클래스 객체와 오버라이딩된 메소드 호출
- 오버라이딩 한 메소드가 실행됨을 보장
```java
class A {
  void f() {
    Sytem.out.println("A의 f() 호출");
  }
}

class B extends A {
  void f() {
    Sytem.out.println("B의 f() 호출");
  }
}

```


## 메소드 오버라이팅(method Overriding)의 개념
- 서브 클래스에서 `슈퍼 클래스의 메소드 중복 작성`
- 슈퍼 클래스이 메소드 무력화. 항상 서브 클래스에 오버라이딩한 메소드가 실행 되도록 보장됨
- `메소드 무시하기`로 번역되기도 함
- 오버라이딩 조건
    - 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수. 리턴 타입) 동일하게 작성
## instanceof 연산자 사용
- 레퍼런스가 가리키는 객체의 타입 식별 : 연산의 결과는 true/false의 불린 값으로 반환
```java
Person p = new Professor();
if(p instanceof Person) // true
if(p instanceof Student) // false, Student를 상속받지 않기 때문
if(p instanceof Researcher) // true
if(p instanceof Professor) // true
```

## 업캐스팅 레퍼런스로 객체 구별
- 업캐스팅 된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
- 슈퍼 클래스는 `여러 서브 클래스에 상속` 되개 떄문

- p가 가르키는 객체가 어떤건지 잘 알수가 없다.
```java
Person p = new Person();
Person p = new Student();
PErson p = new Pfofessor();

```


## 다운 캐스팅
- 슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 `업캐스팅 된 것을 다시 원래대로 되돌리는 것`
- 반드시 명시적 타입 변환 지정
```java
class Person { }

class student extends Person { };

Person p = new Student("이재문"); // 업 캐스팅
Student s = (Student)p; // 다운 캐스팅

```


- 실제로는 여러 자식 클래스를 하나의 부모 타입으로 다루기 위해 사용
```java
Person[] people = new Person[3];
people[0] = new Student("홍길동");  
people[1] = new Student("김영희");
people[2] = new Person("이순신");
```

# (10월 30일 강의)

## 업 캐스팅(upcasting) 개념
- 하위 클래스의 레퍼런스는 상위 클래스를 가리킬 수 없지만, 상위 클래스의 레퍼런스는 하위 클래스를 가리킬 수 있다
- 서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
- 슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상  
``` java
class Person { } // 슈퍼 클래스
class Student extends Person { }

Person p;
Student s = new Student();
p = s;// 업 캐스팅
```

## super()로 슈퍼 클래스의 생성자 명시적 선택
- super() : 서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 호출
<br>
사용방식
<br>
- super(parameter);
- 인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출

## 서브 클래스의 매개 변수를 가진 생성자에 대해서도 슈퍼 클래스의 기본 생성자 자동선택
- 개발자가 서브 클래스의 생성자에 대해 슈퍼 클래스의 생성자를 명시적으로 선택하지 않은경우
## 서브 클래스와 슈퍼 클래스의 생성자 선택
- 슈퍼 클래스와 서브 클래스 : `각각 여러개의 생성자 작성 가능`
- 서브 클래스의 객체가 생성될 때 : 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행
- 서브 클래스의 생성자와 슈퍼 클래스의 생성자 결정되는 방식
1. 개발자의 명시적 선택
    - 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
    - super() 키워드를 이욯아여 선택
2. 컴파일러가 기본 생성자 선택
    - 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
    - 컴파일러가 
### 컴파일러에 의해 슈퍼 클래스의 기본 생성자가 묵시적 선택
- 개발자가 서브 클래스의 생성자에 대해 슈퍼 클래스의 생성자를 명시적으로 선택하지 않은 경우 : 서브 클래스의 기본 생성자에 대해 컴파일러는 자동으로 슈퍼 클래스의 기본 생성자와 짝을 맺음
  
## 서브 클래스 / 슈퍼 클래스의 생성자 호출과 실행
- 서브 클래스의 객체가 생성될 때 : 슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행
- 호출 순서                      : 서브 클래스의 생성자 먼저 호출   -> 슈퍼 클래스 생성자 호출
- 실행 순서                      : 슈퍼 클래스의 생성자가 먼저 실행 -> 서브 클래스의 생성자 실행
```java
class A {
  public A() {
    System.out.println("생성자A");
  }
}
class B extends A {
  public B() {
    System.out.println("생성자B");
  }
}
class C extends B {
  public C() {
    System.out.println("생성자C");
  }
public class Con {
  public static void main() {
    C c;
    c = new C();
  }
}
}
```
생성자 호출 순서 : C -> B -> A
생성자 실행 순서 : A -> B -> C
실행 결과 :
```
생성자A
생성자B
생성자C
```

## 슈퍼 클래스의 멤버에 대한 서브 클래스의 접근
- 슈퍼 클래스의 private 멤버   : 서브 클래스에서 접근 x
- 슈퍼 클래스의 디폴트 멤버    : 서브 클래스가 동일한 패키지에 있을 때 접근 O
- 슈퍼 클래스의 public 멤버    : 서브 클래스는 항상 접근 가능
- 슈퍼 클래스의 protected 멤버 : 같은 패키지 내의 모든 클래스 접근 허용, 패키지 여부와 상관없이 서브 클래스는 접근 가능

## 자바 상속 특징
- 클래스 다중 상속 불허
  - 하나의 클래스가 둘 이상의 부모 클래스를 동시에 상속 받는 것
- 인터페이스(interface)의 다중 상속 허용.
  - 다중 상속과 유사한 기능 제공
- 모든 `자바 클래스는 묵시적으로 Object 클래스를 상속 받음`
- `java.lang.Object`클래스는 모든 클래스의 슈포 클래스
## c++ 상속 특징
- 클래스 다중 상속 가능
  - 다중 상속으로 멤버가 중복 생성되는 문제가 있다. (다이아몬드 상속)
  - 모호성 문제 : 두 부모 클래스에 동일한 이름의 멤버가 존재 할 경우, 어떤 부모의 멤버를 호출 해야할지 모호 해짐

## 서브 클래스 객체의 모양
- 슈퍼 클래스 객체와 서브 클래스의 객체는 별개
- 서브 클래스 객체는 슈퍼 클래스 멤버 포함
서브 클래스에서 슈퍼 클래스 멤버를 접근 할수 있다.
서브클래스에서 슈퍼 클래스 의 변수는 접근 불가.


## 상속(inheritance)의 필요성
- 상속을 이용해서 중복되는 데이터 값들을 모와서 상속 시킨다.
### 클래스 상속과 객체
- 상속 선언 : extends 키워드 사용
- 부모 클래스를 물려받아 자식 클래스를 확장한다는 의미
- 부모 클래스 : 슈퍼 클래스(super class)
- 자식 클래스 : 서브 클래스 (sub class)

### class 상속
- ()

---
## final 클래스와 메소드
- class - 더 이상 클래스 상속 불가능
- final - 더 이상 오버라이딩 불가능 

``` java
public class User {
    // 한 번 값 정하면 못 바꿈
    private final String name = "원영";
    private final int age = 20;

    public void printInfo() {
        System.out.println(name + " / " + age);
    }
}
```
## static 메소드의 제약 조건 
- static 메소드는 오직 static 멤버만 접근 가능
- non-static 메소드는 static 접근 가능
- static 메소드는 this 사용불가



# 중간 시험범위
ot ~ 1002 강의 까지

# (10월 2일 강의)


## break
- 반복문 하나를 즉시 벗어날 때 사용. 하나의 반복문만 벗어남.
- 중첩 반복의 경우 안쪽 반복문의 break문이 실행되면 안쪽 반복문만 벗어남

## 배열 (array)
자체적으로 자료구조 할수 있다.
- 인덱스와 인덱스에 `대응하는 데이터`들로 이루어진 자료구조로 `한 번에 많은 메모리 공간 선언`
- `같은 타입의 데이터`들이 `순차적으로 저장`되는 공간으로 `인덱스를 이용하여 원소데이터 접근`
- `반복문을 이용하여 처리`하기에 적합한 자료 구조
- 배열 인덱스 : 0 부터 시작


```java
int intArray [];
[배열 타입] [배열에 대한 레퍼런스 변수] [배열선언]
```

```java
int Array = new int [5];
[배열에 대한 레퍼런스] [배열생성] [타입] [원소 개수]
```

### 배열 선언 및 생성 디테일
- 배열은 선언과 생성의 두단계 필요 : 선언과 동시에 생성할 수 있다
  - int intArray [] or int[] intArray;
  - int intArray[5] <- 오류 크기를 지정함
- 배열 선언 : 배열의 이름 선언(배열 레퍼런스 변수 선언)
- 배열 생성 : 배열 공간 할당 받는 과정
- 배열 초기화 : 배열 생성과 값 초기화

### 배열 인덱스와 배열 원소 접근
- 배열 인덱스는 0부터, 크기는 1부터 이다.
- -인덱스는 없다.
- 배열 생성 후 접근 : 레퍼런스만 선언 하면 안돼고 배열 생성 후 접근 해야한다.
``` java
int arr[];
arr[1] = 8; <- 오류 발생

int arr = new int[5];
```

### 레퍼런스 치환과 배열 공유
- 레퍼런스 치환으로 레퍼런스가 하나의 배열 공유
``` java
int arr = new int[5];
int myArr = arr; <- 레퍼런스 치환으로 배열 공유
```
포인터로 둘이 같은 메모리 주소를 보고 있다.   


## 배열의 크기 length 필드
- 자바의 배열은 객체로 처리
- 배열의 크기는 배열 객체의 length 필드에 저장

## 배열과 for - each 문
- for-each 문 배열이나 나열(enumeration)의 원소를 순차 접근하는데 유용한 for 문

## 2차원 배열
- 2차원 배열 선언
  - `int arr[][]; or int[][]`
- 2차원 배열 생성
  - `int arr = new int[2][5];`
- 2차원 배열 선언 + 생성
  - `int arr = new int[2][5]`

### 2차원 배열의 length 필드
- i.length : 2차원 배열의 행의 개수이므로 2개
- i[n].length : n번째 행의 열의 개수

## 메소드(함수)의 배열 리턴
- 배열의 레퍼런스만 리턴되며, 배열 전체가 리턴되는 것이 아니다.
- 메소드의 리턴 타입
  - 리턴 타입에 배열의 크기를 지정하지 않음
  - 리턴하는 배열 타입과 리턴 받는 배열 타입 일치

## 자바의 예외 처리
- 어떤 수를 0으로 나누기 시 에외 발생

### try-catch-finally 문
- 예외 처리 : 발생한 예외에 대해 개발자가 작성한 프로그램 코드에서 대응하는 것
- try-catch-finally문 사용
``` java
try {
  실행문
}
catch(처리할 예외 타입 선언) {

}
finally {
finally 블록문
}

```
### 예외 - 클래스 사례
- 배열의 범위를 벗어나 원소를 접근하는 예외 처리
<br>

# (9월 25일 강의)

## 반복문
  
### for 
- 조건 횟수가 정해져 있을때  
- 조건식이 `참`인 동안 반복 실행
```
for(초기문; 조건식;반복후 작업) {
  작업문
}
```
### while
- 조건 횟수가 정해져 있지 않을 때
- 조건식이 `참`인 동안 반복 실행
``` java
while(조건) {
  작업문
}
```

### while
- 조건 횟수가 정해져 있지 않을 때
- 조건식이 `참`인 동안 반복 실행
- 작업문은 한 번 반드시 실행
``` java
do{
  작업문
}while(조건)
```

### 중첩 반복
  - 반복문이 다른 반복문을 내포하는 구조
  ``` java
  예시
  for(int i =0;i<10;i++) {
    for(int j=0;j<10;j++)
  }
  ```

## switch 문
 - case의 비교값과 일치하면 해당 case의 실행문장 수행
 - break를 만나면 switch문을 벗어남
 - case의 비교 값과 일치하는 것이 없으면 default 문 실행
 - default문은 생략 가능
 ``` java
 기본 구조

 switch(조건) {
  case 값1 :
    break;
  case 값2 :
    break;
  default :
    break;
 }
 ```
### case 문의 값
  - 문자, 정수, 문자열 리터럴( JDK 1.7부터 )만 허용
  - 실수 리터럴은 허용되지 않음
  ``` java
  예시
  case '+' :
  case 1   : 
  case '예':
  case '2' :
  ```


## 조건문

### 단순 if문
  - if의 괄호 안에 조건식
  - 실행문장이 단일 문장인 경우 둘러싸는 {, } 생각 가능

### if - else 문
``` java
if(조건) {
  실행문장 1
}
else{
  실행문장2
}
```
- 조건식이 true면 실행문장1, false이면 실행문장2 실행

### 다중 if - else 문
  - 다중 if 문
  - 조건문이 너무 많은 경우, switch 문 사용 권장  
  ``` java
  if(조건1){
  } 
  else if(조건2) {

  } 
  else
  ```

## 대입연산자 , 비교 연산 ,논리 연산
[0918 강의 참조](#연산자)
- 대입  
  - `=` : 대입  
  - `*=` : 곱 후 대입  
  - `/=` : 나눈 후 대입  
  - `+=` : 더한 후 대입  
  - `-=` : 뺀 후 대입  
  - `&=` : 비트 AND 후 대입  
  - `^=` : 비트 XOR 후 대입  
  - `|=` : 비트 OR 후 대입  
  - `<<=` : 왼쪽 시프트 후 대입  
  - `>>=` : 오른쪽 시프트 후 대입  
  - `>>>=` : 부호 무시 오른쪽 시프트 후 대입  
  
- 비교  
  - `>` : 크다  
  - `<` : 작다  
  - `>=` : 크거나 같다  
  - `<=` : 작거나 같다  
  - `==` : 같다 (값 비교)  
  - `!=` : 같지 않다  


- 논리  
  - `&&` : 논리 AND (그리고)  
  - `||` : 논리 OR (또는)  
  - `!` : 논리 NOT (부정)  
  - `^` : 논리 XOR (배타적 OR) 

## D2coding
  손으로 코딩하던 시절 여러 규칙들이 있었다.


## 삼항연산자
  3 개의 피 연산자로 구성된 연산자
  <br>
  opr1?opr2:opr3 -> opr1이 결과가, true면 opr2, false면 opr3
  <br>
  if~else을 조건연산자로 간결하게 표현 가능

## 비트연산
  어떨때 쓸거 같다는 느낌
  1. 데이터 압축 및 최적화
  2. 해싱 및 암호화
  3. 빠른 연산


# (9월 18일 강의)
## 자바의 특징
- 가비지 콜렉터(Garbage Collector, GC)
- 실기간 응용프로그램에 부적합
- 자바는 안전
- 프로그램 작성 쉬움
- 실행 속도 개선을위한 JIT 컴파일러 사용
    1. 바이드 코드를 인터프리터 방식 실행
    2. 기계어 보다 느림

## 코드 
1. 소스코드
    - `.java` 코드
    - 사람이 읽을 수 있는 고수준 언어 (High-Level Languag)
2. 바이코드
    - `.class` 코드
    - Java 컴파일러(javac)가 소스코드를 변환한 중간 코드
    - `JVM`이 실행 해야함 -> cpu가 실행 X
    - JIT 컴파일러가 기계어로 변환 실행
3. 기계어
    - cpu가 직접 실행 가능 - 0과 1의 이진 코드
    - 운영체제(os)와 cpu 아키텍처(intel , arm 등)에 따라 다름
    - 16진수 형태의 기계어

## 기본 구조
주석 / 클래스 생성/  main() 메서드/ 메서드 / 메소드 호출 / 변수 선언 / 문장 ; / 출력

### 식별자

- **정의** - 클래스 , 변수, 상수, 메소드에 붙이는 이름

- 유니코드 사용 가능, 한글 사용 가능 -> 한글 사용은 좋지 않다. 

- 자바의 언어 키워드는 식별자로 사용 불가

- 식별자의 첫 번째 문자로 숫자는 사용불가

- `_` , `$`를 식별자 첫번째 문자로 사용 할수는있다. 허나 일반적으로는 사용 안함

- 불릿 리터럴 `(true , false)`과 널 리터럴`(null)`은 식별자로 **사용불가**

- 길이 제한 없음

- 대소문자 구별 : `barChart` 와  `bahrchart`는 다른 식별자

## 데이터 타입
- 문자열은 기본 타입x, string 클래스로 문자열 표현

- 리터럴 : -> int a = `10` 에서 10 을 의미

- 문자열이나 문자열과 다른 자료형의 리터럴을 + 연산을 할 경우 결과는 문자열로 반환
- 객체를 참조하는 변수 유형, 힙(Heap) 영역에 저장된 객체의 메모리 주소를 가르킴
    - 기본 자료형은 스택 영역에 저장
- 객체를 참조 하지 않을 때 null 값을 가질수 있다.

- 일반적으로 `레퍼런스`라고 부른다.
## 참조 자료형 (Reference Type)
- 포인터는 임의의 메로리 주소를 저장 , 참조 자료형은 주소를 저장 X
- JVM이 해당 주소로 안내
- 객체를 참조하는 변수 휴형


## 메모리 관리
- jvm 이 관리 해준다.

## 메모리 구조

- 힙( heap - FIFO) 영역은 프로그래머가 직접 공간을 할당, 해제하는 메모리 공간, jvm이 담당
- 스택(stack - LIFO) 영역은 프로그램이 자동으로 사용하는 임시 메모리 영역
- 힙이 스택을 침범하는 경우를 힙 오버 플로우라고 한다. 
    - 스택이 힙을 침범하는 경우를 스택 오버 플로우

## 상수 선언
- final 키워드 사용
- 선언할 때 초기값 지정
- 실행 중 값 변경 불가능

## var 키워드
- type을 생략하고 변수 선언 
- 지역 변수에만 선언 가능 , class 필드에서는 사용할 수 없다.
    - 지역 변수 : 메소드 내부에 선언되는 변수.
    - 클래스 필드 : 클래스 내부에 선언되는 변수, 객체 생성과 함께 만들어지는 변수 
- 기본적으로는 명시적 자료형을 쓰는 것이 좋다


## print
- `System.out.print();`
- `System.out.println();`
- `System.out.printf();`


## 타입 변환
- 원래 타입보다 큰 타입으로 자동 변환
- 강제 변환
## java의 키 입력 
- System.in vs. Scanner
### Sysytem.in
- 키보드와 연결된 자바의 표준 입력 스트림
- 입력되는 키를 `바이트(문자 아님)로 리턴하는 저수준 스트림`
- 직접 사용하면 `바이트를 문자나 숫자로 변환하는 많은 어려움 있음`
### java.utill.Scanner
- 객체를 생성해서 사용
- 키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴
- 입력되는 키 값을 공백으로 구분되는 토큰 단위로 읽음
- 공백 문자 : `'/t' '/r' '/n' '' '/f'`(페이지 나누기, 폼 피드, 프린트 에서 사용)

## Scanner 주요 메서드
이런게 있다~

## 연산자
- 증감  
  - `++` : 변수 값을 1 증가  
  - `--` : 변수 값을 1 감소  

- 산술  
  - `+` : 더하기  
  - `-` : 빼기  
  - `*` : 곱하기  
  - `/` : 나누기  
  - `%` : 나머지  

- 시프트  
  - `>>` : 오른쪽 시프트 (부호 유지)  
  - `<<` : 왼쪽 시프트  
  - `>>>` : 오른쪽 시프트 (부호 무시, 0으로 채움)  

- 비교  
  - `>` : 크다  
  - `<` : 작다  
  - `>=` : 크거나 같다  
  - `<=` : 작거나 같다  
  - `==` : 같다 (값 비교)  
  - `!=` : 같지 않다  

- 비트  
  - `&` : 비트 AND  
  - `|` : 비트 OR  
  - `^` : 비트 XOR  
  - `~` : 비트 NOT  

- 논리  
  - `&&` : 논리 AND (그리고)  
  - `||` : 논리 OR (또는)  
  - `!` : 논리 NOT (부정)  
  - `^` : 논리 XOR (배타적 OR)  

- 조건  
  - `? :` : 조건 연산자 (삼항 연산자)  

- 대입  
  - `=` : 대입  
  - `*=` : 곱 후 대입  
  - `/=` : 나눈 후 대입  
  - `+=` : 더한 후 대입  
  - `-=` : 뺀 후 대입  
  - `&=` : 비트 AND 후 대입  
  - `^=` : 비트 XOR 후 대입  
  - `|=` : 비트 OR 후 대입  
  - `<<=` : 왼쪽 시프트 후 대입  
  - `>>=` : 오른쪽 시프트 후 대입  
  - `>>>=` : 부호 무시 오른쪽 시프트 후 대입  
  
<br>

# (9월 11일 강의)

Pascal Case 
camelCase
cabab-case
Snaek_case

서블릿(servlet) - Backend

<br>

# (9월4일 강의)
# Markdwon 문법

## HTML에서 `<h1>` ~ `<h6>`

# 글자 크기  
## 글자 크기
### 글자 크기
#### 글자 크기
##### 글자 크기
###### 글자 크기

# 문자 강조
*이탤릭체*  
**굵은 문자**

수평선
***

# 리스트 
* 언오더드 리스트
* 언오더드 리스트
* 언오더드 리스트
    * 언오더드 리스트
    * 언오더드 리스트
    * 언오더드 리스트
        * 언오더드 리스트
        * 언오더드 리스트
        * 언오더드 리스트

1. 오더드리스트
1. 오더드리스트
1. 오더드리스트


``` java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
인라인 코드는 `버튼`이나 코드 조각을 강조할 때 사용

Vs Code에서 터미널을 열려면 `Ctrl` + `~`


# 링크

## 외부 링크
[구글 접속](https://google.com "구글 주소")

## 내부 링크
[링크 라벨](#markdwon-문법 "markdwon-문법")

# 그림 삽입
![git 로고](./git.png);
```
java1
├─ java-1
│  ├─ bin
│  │  ├─ App.class
│  │  └─ Hello.class
│  ├─ lib
│  └─ src
│     ├─ App.java
│     ├─ D0925
│     │  ├─ D0925.java
│     │  ├─ D0925_DoWhile.java
│     │  ├─ D0925_for.java
│     │  ├─ D0925_if.java
│     │  ├─ D0925_switch.java
│     │  └─ D0925_while.java
│     ├─ D1002
│     │  ├─ ArrayExample.java
│     │  ├─ ArrayExample2.java
│     │  ├─ BreakExample.java
│     │  ├─ ForEachExample.java
│     │  ├─ InputException.java
│     │  └─ ReturnArray.java
│     ├─ D1030
│     │  ├─ ClassInheritance.java
│     │  ├─ Ex51ColorPointEx.java
│     │  └─ Ex52ColorPointEx.java
│     ├─ D1031
│     │  ├─ Ex53Instaneof.java
│     │  ├─ Ex54.java
│     │  └─ Ex55.java
│     ├─ D1106
│     │  ├─ Hello.java
│     │  └─ ObjectPro.java
│     ├─ D1113
│     │  └─ EX63Equals.java
│     ├─ D1120
│     │  ├─ Ex82ContentPaneEx.java
│     │  ├─ Ex85.java
│     │  └─ Ex86.java
│     ├─ Foo.java
│     ├─ Hello.class
│     ├─ Hello.java
│     └─ UseSanner.java
├─ my_pair_image.jpg
└─ README.md

```
```
java1
├─ java-1
│  ├─ bin
│  │  ├─ App.class
│  │  └─ Hello.class
│  ├─ lib
│  └─ src
│     ├─ App.java
│     ├─ D0925
│     │  ├─ D0925.java
│     │  ├─ D0925_DoWhile.java
│     │  ├─ D0925_for.java
│     │  ├─ D0925_if.java
│     │  ├─ D0925_switch.java
│     │  └─ D0925_while.java
│     ├─ D1002
│     │  ├─ ArrayExample.java
│     │  ├─ ArrayExample2.java
│     │  ├─ BreakExample.java
│     │  ├─ ForEachExample.java
│     │  ├─ InputException.java
│     │  └─ ReturnArray.java
│     ├─ D1030
│     │  ├─ ClassInheritance.java
│     │  ├─ Ex51ColorPointEx.java
│     │  └─ Ex52ColorPointEx.java
│     ├─ D1031
│     │  ├─ Ex53Instaneof.java
│     │  ├─ Ex54.java
│     │  └─ Ex55.java
│     ├─ D1106
│     │  ├─ Hello.java
│     │  └─ ObjectPro.java
│     ├─ D1113
│     │  └─ EX63Equals.java
│     ├─ D1120
│     │  ├─ Ex82ContentPaneEx.java
│     │  ├─ Ex85.java
│     │  └─ Ex86.java
│     ├─ Foo.java
│     ├─ Hello.class
│     ├─ Hello.java
│     └─ UseSanner.java
├─ my_pair_image.jpg
└─ README.md

```