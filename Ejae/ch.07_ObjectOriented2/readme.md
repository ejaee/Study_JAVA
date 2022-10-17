# 객체 지향 프로그래밍2

## 상속 (inheritance)

_기존의 클래스를 재사용하여 새로운 클래스를 작성한다_


선언
```java
class Parent {
    int age;
}

class Child extends Parent {

}
```

c와 유사성
```c
struct Parent {
    int age;
}

struct Child {
    struct Parent;
}
```

`생성자`와 `초기화 블럭`은 상속되지 않는다

`멤버`만 상속된다

자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다

조상 클래스 하나만 수정하면 되므로 작업이 간단해진다

_코드의 중복을 최소화_

[CaptionTvTest](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/CaptionTvTest/src/Main.java)

---


- 상속이외에 클래스를 재사용하는 방법, `포함(Composite)관계`

    _한 클래스의 멤버변수로 다른 클래스 타입의 참조 변수를 선언_

    ```java
    class Point {
        int x;
        int y;
    }
    /*
    class Circle {
        int x;
        int y;
        int r;
    }
    */
    class Circle {
        Point c = new Point();
        int r;
    } // c 구조체와 동일한 방식
    ```

---

- 상속과 포함관계를 구별하는 방법

    
    ~은 ~이다 -> `상속관계`를 맺기
    ```java
    class Circle extends Point {
        int r;
    }
    ```
    
    ~은 ~를 가지고 있다 -> `포함관계`를 맺기
    ```java
    class Circle {
        Point c = new();
        int r;
    }
    ```
    위 예시에서는 `Circle`이 원점을 가지고 있으므로,

    `포함관계`가 더 옳다

    _상속의 예 : `스포츠카`는 `자동차`이다_


[DrawShape](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/DrawShape/src/Main.java)

[DeckTest](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/DeckTest/src/Main.java)


- 단일 상속

    _C++는 여러 조상 클래스로부터 상속받는 것이 가능하지만 java는 단일 상속만 가능_

- Object 클래스

    _모든 클래스 상속계층도의 최상위에 있는 조상클래스_

    다른 클래스로부터 상속 받지 않는 모든 클래스들을 자동적으로 Object 클래스로부터 상속받게 한다

    상속 시킨 class의 조상클래스도 Object 이므로 모든 클래스의 조상클래스는 Object 가 된다

    ```java
    class Tv -> class Tv extends Object {
        ...
    }
    ```

## 오버라이딩

- 오버라이딩

    _override == overwrite_

    조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것

    ```java
    class Point {
        int x;
        int y;

        String getLocation() {
            return "x : " + x + ", y : " + y;
        }
    }

    class Point3D extends Point {
        int z;

        String getLocation() {
            return "x : " + x + ", y : " + y + ", z : " + z;
        }
    }
    ```

    Point에서 상속받은 getLocation()은 3차원에 맞지 않으므로

    자신에 맞게 수정하여 오버라이딩 한 예시

- 오버라이딩의 조건

    _메서드의 내용만을 새로 작성하는 것_

    메서드의 선언부는 조상과 `완전 일치`해야한다

    예외적으로 `접근 제어자(access modifier)`와 `예외(exception)`는 제한된 조건 하에 다르게 변경이 가능하다

    > 위 개념 배웠을 때 다시 학습하기 p341

- 오버로딩 vs 오버라이딩

    오버로딩 -> 기존에 없는 새로운 메서드를 정의

    오버라이딩 -> 상속받은 메서드 내용을 변경

- super

    자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수

    조상 클래스에 선언된 멤버변수와 같은 이름의 멤버 변수를 자손 클래스에서 중복 정의가 가능하다

    메서드 역시 super로 호출이 가능하다

    오버라이딩한 경우에 super를 사용한다

[super](https://github.com/ejaee/Study_JAVA/tree/main/Ejae/ch.07_ObjectOriented2/super)

- super()

    _조상 클래스의 생성자를 호출하는데 사용_

    조상 클래스의 호출은 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다

    그렇지 않으면 컴파일러는 생성자의 첫줄에 `super()`를 자동적으로 추가한다

    이때 생성자를 만들면서 기본생성자가 없다면 문제가 발생한다

    생성한 생성자의 매개변수에 맞게 super(1, 2)로 호출하면 된다

[super2](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/super2/src/Main.java)

```java
    class Point{
        int x;
        int y;

        Point(int x, int y) {
            /**/
            this.x = x;
            this.y = y;
        }
    }

    /**/ 부분에서 컴파일러가 super()를 실행시키는데
    super()는 Object()를 의미한다
```

- 패키지(package)

    _클래스의 묶음_

    클래스 또는 인터페이스르 포함시킬 수 있다

    같은 이름의 클래스 이더라도 패키지로 구분하여 충돌을 피할 수 있다

    클래스의 실제 이름은 다음과 같다

    ```java
    String -> java.lang.String
    ```
    _java.lang 패키지에 속한 String 패키지_

    패키지는 폴더이다

    패키지 폴더 안에 클래스를 컴파일해서 생성된 클래스 파일들이 있다

    패키지 폴더 안에 하위 패키지 폴더가 있다

    `rt.jar(runtime)`는 클래스 파일들을 압축한 파일을 말한다

    런타임을 실행할때 필요한 클래스들을 묶어둔 파일

    _java9부터 module 개념이 생기면서 없어졌다_

    패키지는 소스파일의 첫 번째 문장으로 단 한번 선언

    _c에서 헤더파일..._

    패키지 선언이 없으면 이름없는 패키지에 속한다(default package)


- import

    클래스를 사용할 때 `패키지 아름을 생략`할 수 있다

    import 미사용
    ```java
    class ImportTest {
        java.util.Data today = new java.util.Data();
    }
    ```

    import 사용
    ```java
    import java.util.Date;

    class ImportTest {
        Data today = new Date();
    }
    ```
    
    원래는 String이나 sout에서 import를 사용해야하나,

    자주 사용하는 클래스는 생략하도록 만들었다

    ```java
    import 패키지명.클래스;

    import 패키지명.*; (* : 모든 class)
    ```

    import문은 컴파일에게 알려주는 정보이므로 프로그램의 성능에 영향이 없다

    ```java
    import java.util.* -> 가능

    import java.* -> 불가능 (java pack의 모든 class라는 뜻이 된다)
    ```

    ```java
    import java.util.Data

    import java.sql.Data

    패키지명이 같을 경우에는 사용 시 구분해주어야 한다

    java.util.Data today = new java.util.Data();
    ```

    static 멤버를 사용할 때 클래스 이름을 생략할 수 있다

    ```java
    import static java.lang.Integer.*;
    -> Integer클래스의 모든 static 멤버(s멤버, s메서드)
    -> Integer를 생략하고 사용이 가능

    import static java.lang.Math.random; // 괄호 안붙임
    import static java.lang.System.out;

    //  System.out.println(Math.random());
    ->  out.println(random());
    ```

- 제어자(modifier)

    _클래스와 클래스 멤버에 부가적인 의미 부여_

    `접근제어자` 와 
    
    ```java
    public, protected, (default), private

    택 1
    ```
    
    `그 외` 로 나뉜다

    ```java
    static, final, abstract ...

    중복 가능
    ```

    static (클래스의, 공통적인)

    _객체 생성 없이 사용 가능_

    -   static 멤버변수 (cv)
        
        모든 인스턴스에 공통적으로 사용되는 클래스 변수

        클래스 변수는 인스턴스를 생성 않고도 사용 가능

        클래스가 메모리에 로드될 때 생성

    -   static 메서드

        인스턴스를 생성하지 않고도 호출이 가능

        static 메서드 내에서는 `인스턴스 멤버(iv)`들, `인스턴스 메서드(im)` 직접 사용 불가

        > iv 멤버들을 객체를 만들고 나서야만 사용이 가능하기 때문에

    final

    -   final class ...

        변경될 수 없는 클래스

        확장될 수 없는 클래스 (조상 불가)

    -   final 메서드

        오버라이딩 재정의 불가

    abstract

    ```java
    sbstract class AbstractTest {   // 추상 클래스
        abstract void move();       // {}가 없음
                                    // 추상 메서드라 부름
    }

    추상 메서드를 가지고 있는 클래스를 추상 클래스라고 한다
    ```

    _미완성 메서드를 가진 미완성 클래스_

    미완성 설계도라 제품 생산이 불가

    ```java
    AbstractTest a = new AbstractTest() -> error
    ```
    추상클래스를 상속 받아서 완전한(구상) 클래스를 만든 후에 객체 생성이 가능

-   접근 제어자

    `public` -> 접근 제한이 전혀 없다

    `private` -> 같은 클래스 내에서만 접근이 가능하다

    `protected` -> 같은 패키지 내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다

    class에는 `public`만 붙일 수 있다

    멤버들에는 `4개 모두` 가능하다
<img width="600" alt="Screen Shot 2022-10-13 at 4 30 31 PM" src="https://user-images.githubusercontent.com/87407504/195553416-91f0ce18-a9ca-4ec0-bd36-aaed56fb31e6.png">

<img width="600" alt="Screen Shot 2022-10-13 at 4 33 30 PM" src="https://user-images.githubusercontent.com/87407504/195553440-0b57720c-cc92-4f5f-b2e4-d41ef3d3dc0c.png">


[access_modifier](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/access_modifier/src/Main.java)

[access_modifier2](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/acces_modifier2/src/Main.java)

외부로부터 데이터를 보호하기 위해 접근 제어자를 사용한다

이를 `캡슐화` 라고 한다

```java
public class Time {
    private int hour;   // 외부에서 직접 접근 못하도록 한다
    private int minute;
    private int second;

    public int getHour() { return hour;}
    public void setHoir(int hour) {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }
    // 메서드로 간접 겁근화
    // 즉, 캡슐화
}
```

또한 내부적으로만 사용되는 부분을 감추기 위한 용도이기도 하다

> command + opt + m (메서드 추출)

[acess_modifier_encapsulation](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/acess_modifier_encapsulation/src/Main.java)


- 다형성(polymorphism)

    _여러 가지 형태를 가질 수 있는 능력_

    `조상 타입 참조 변수로 자손 타입 객체를 다루는 것`

    ```java
    class Tv {
        boolean power();
        int channel;

        void power()    {power = !power;}
        void channelUp  {++channel;}
        void channelDown    {--channel;}
    }

    class SmartTv extends Tv {
        String text;

        void caption() { \* comment *\};
    }
    ```

    에서 일반적인 형태는
    
    ```java
    Tv a = new Tv();
    SmartTv a = new SmartTv();
    ```

    다형성은 타입의 불일치

    ```java
    Tv a = new SmartTv();
    ```
    `조상 타입 참조 변수로 자손 타입 객체를 다루는 것`

    1. `SmartTv a = new SmartTv();`

        SmartTv 제품을 SmarTv 리모컨으로 컨트롤

        리모컨 객체의 멤버는 총 5 + 2 개

        리모컨 버튼이 7개인 셈

    2. `Tv a = new SmartTv();`

        SmartTv 제품을 Tv 리모컨으로 컨트롤

        Tv 객체의 기능은 5개이므로 5가지 기능만 사용이 가능

    ```java
    SmartTv a = new Tv(); ERROR
    ```
    
    참조변수의 타입이 참조변수가 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 개수를 결정한다

- 참조변수의 형변환

    _사용할 수 있는 멤버의 개수를 조절하는 것_

    조상 자손 관계의 참조변수는 서로 형변환 가능

    ```java
    class Car {};
    class FireEngine extends Car {};
    class Ambulance extends Car {};

    FireEngine f = new FireEngine();

    Car c = (Car)f;                 // OK (생략가능)
    FireEngine f = (FireEngine)c;   // OK (생략불가)
    Ambulance a = (Ambulance)f      // ERROR
    ```

[Casting](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/Casting/src/Main.java)

- instanceof 연산자

    _형변환 가능 여부를 확인하는데 사용_

    가능하면 true 반환

    형변환은 조상과 자손끼리만 가능

    ```java
    void doWork(Car c) {
        if (c instanceof FireEngine) {
            FireEngine fe = (FireEngine)c;
            fe.water();
        }
    }
    ```
    매개변수에는 `다형성`이 되므로

    `모든 자손 클래스`가 다 들어올 수 있다

    형제관계인 클래스끼리는 형변환이 되면 안되므로 `istanceof` 연산자로 확인

    형변환이 가능하다는 것이지

    [정리]

    -   참조변수의 형변환을 하는 이유

        변경을 통해 사용할 수 있는 멤버의 갯수를 조절하기 위해

        형변환을 하더라도 가리키는 객체도 그래도로 값도 그대로이다

        형을 맞추기위해 형변환하는 것일 뿐

- 다형성의 장점

    1. 다형적 매개변수

        매개변수가 참조형이면 메서드 호출시, 자신과 같은 타입 또는 자손 타입의 인스턴스를 넘길 수 있다

        ```java
        // 부모
        class Product {
            int price;
            int bounsPoint;
        }

        // 자손
        class Tv extends Product{}
        class Computer extends Product{}
        class Audio extends Product{}
        
        Class Buyer {
            int money = 1000;
            int bounsPoint = 0;
        }

        void buy(Tv t) {
            money -= t.price;
            bonusPoint += t.bonusPoint;
        }
        
        buy의 매개변수로 new Tv(); 를 넣어 살 수 있다

        다른 물건을 사고 싶다면?

        void buy(Computer c) {
            money -= t.price;
            bonusPoint += t.bonusPoint;
        }
        
        이렇게 하면 오버로딩 (이름 같, 매개변수 다)

        메서드 하나로 여러 물건을 살 수 있다!

        매개변수 tv t에 computer, audio 모든 것을 넣을 수 있다!
        ```

        [polymophism](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/polymorphism/src/Main.java)

        하나의 매개변수에 모든 상품을 적용시킬 수 있다

    2. 하나의 배열로 여러종류 객체 다루기(저장 가능)

        조상 타입의 배열에 자손들의 객체를 담을 수 있다

        ```java
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        Product p[] = new Product[3];
        p[0] = new Tv();
        p[1] = new computer();
        p[2] = new Audio();
        ```
        다형성으로 인해 자식들을 모두 저장할 수 있다

        [polymophism2](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/polymorphism2/src/Main.java)

        참고) 가변배열 Vector `11장`
        ```java
        public class Vector extends AbstractList
                        implements List, Cloneable, java.io.Serializable{
                            protected Object elementData[];
                            ...
        }
        ```

- 추상 클래스(abstract class)

    _미완성 메서드를 갖고 있는 클래스_

    미완성 설계도

    ```java
    // 추상클래스(미완성클래스)
    abstract class Player { 
        // 추상메서드
        abstract void play(int pos);
        abstract void stop(); 
    }

    abstract는 {}가 필요없다.
    ```

    abstract class를 보면 아 안에 abstract 메서드가 있겠구나

    인스턴스 생성이 불가

    ```java
    Player p = new Player(); //ERROR
    ```

    그러면 이걸 왜 쓰나?

    다른 클래스 작성에 도움을 주기워해(?)

    상속을 통해 추상 메서드를 완성

    ```java
    class AudioPlayer extends Player {
        void play(int pos) {/* comment*/ };
        void stop() {/* comment*/ };
    }
    ```
    자손 class에서 {}를 구현하였으므로

    인스턴스 생성이 가능

    ```java
    AudioPlayer ap = new AudioPlayer();

    Player ap = new AudioPlayer(); // 다형성 가능
    Player는 추상 클래스인데 어떻게?

    Player는 리모컨 버튼만 제공하므로 몸통이 없어도 무방하다
    ```

    추상 메서드는 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 사용된다!

    ```java
    두개 다 구현한 경우
    class AudioPlayer extends Player {
        void play(int pos) {/* comment*/ };
        void stop() {/* comment*/ };
    }
    
    일부만 구현했음
    abstract class AudioPlayer extends Player {
        void play(int pos) {/* comment*/ };
    }    
    ```

    [실질적인 예]
    ```java
    abstract class Player {
        // iv
        boolean pause;
        int currentPos;

        Player() {
            pause = false;
            currentPos = 0;
        }

        기기마다 플레이 방식이 다르다
        자손마다 방식이 다르기때문에 abstract 처리

        abstract void play(int pos);
        abstract void stop();

        구현안되어있으니까 상속을 받으면 내가 구현해야하구나하고 인지

        // 인스턴스 메서드
        void play() {
            play(currentPos); // 자손이 구현하여 호출이 가능
        }
    }
    ```

    상속을 통해 자손이 {} 구현을 완성하고

    자손 객체 생성하면

    추상메서드 사용이 가능하다

[abstract_player](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/abstract_player/src/Main.java)

- 추상 클래스의 작성

    추상 클래스 예시

    유닛별로 공중, 지상, 해상 move가 각각 다르게 움직여야할 경우

    <img width="848" alt="Screen Shot 2022-10-14 at 8 22 15 PM" src="https://user-images.githubusercontent.com/87407504/195842123-dabf7d1b-d5cc-419c-8376-7af4d46015fe.png">


    배열에 담은 형태
    
    <img width="848" alt="Screen Shot 2022-10-14 at 8 26 24 PM" src="https://user-images.githubusercontent.com/87407504/195842112-bdc3cfbd-045c-4c5f-8da3-884e3103c8ac.png">


    [abstract_unit](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/abstract_unit/src/Main.java)

- 인터페이스(interface)

    _추상 메서드의 집합_

    구현된 없이 전혀 없는 설계도. 껍데기(모든 멤버가 public)

    기능적으로 상수, static aptjem, 디폴트 메서드가 JDK 1.8에서 추가되었음

    추상 클래스와의 비교

    - 일반 클래스인데 추상 메서드르르 가지고 있는 것
    - 일부가 미완성이다

    인터페이스

    - 완전히 아무것도 없고 추상 메서드만 가지고 있는 것
    - 멤버변수를 가질 수 없다

    ```java
    interface 인터페이스이름 {
        // 상수
        public static final 타입 상수이름 = 값;
        // 추상메서드
        public abstract 메서드이름;

        변수(iv, cv)는 가질 수 없다

        int CLOVER = 1;
        // public static final int CLOVER = 1;
        -> -> interface에서는 항상 모든 변수가 public이고 abstract이므로 생략 가능

        public abstract String getCard();
        String getCard();
        // public abstract String getCard();
        -> interface에서는 항상 모든 메서드가 public이고 abstract이므로 생략 가능
    }
    ```
    모든 interface의 멤버는 public

    메서드가 전부가 추상 메서드

    `pulbic` `static` `final` `abstract`는 생략이 가능

- 인터페이스의 상속

    인터페이스의 조상은 인터페이스만 가능

    Object가 최고 조상 아님

    ```java
    interface Movable /* extends Object 안들어감*/{
    void move (int x, int y);
    }

    다중 상속이 가능

    interface Fightable extends Movable, Attackable {}
    
    추상메서드는 충돌해도 문제가 없기 때문에 
    다중 상속이 문제가 안된다

    구현부에 충돌이 발생하는데 
    인터페이스의 추상 메서드는 구현이 없으니까
    다중 상속이 가능
    ```

- 인터페이스의 구현

    인터페이스에 정의된 추상 메서드를 완성하는 것

    미완성 설계도이므로 객체를 못 만든다

    ```java
    class 클래스이름 implements 인터페이스이름 {
        
    }

    상속을 통해 완성

    추상클래스는 extends를 사용하지만

    인터페이스는 implements(구현)를 사용
    ```

    ex)
    ```java
    interface Fightable {
        void move(int x, int y);
        void attack(Unit u);
    }

    class Fighter implements Fightable {
        public void move(int x, int y){/* ... */}
        public void attack(Unit u){/* ... */}
    }

    abstract class Fighter implements Fightable {
        public void move(int x, int y){/* ... */}

        // 안보이지만
        // public abstract void attack(Unit u)
    }
    하나만 구현했으면 당연히 abstract
    ```

    추상클래스와 인터페이스는 extends 와 implements의 차이일 뿐

    추상메서드를 가지고 있다는 공통점이 있다

    추상 클래스 구현
    ```java
    class AudioPlayer extends Player {
        void play(int pos){/* ... */}
        void stop(){/* ... */}
    }

    ```

    interface 구현
    ```java
    class Fighter implements Fightable {
        public void move(int x, int y){/* ... */}
        public void attack(Unit u){/* ... */}
    ```

    인터페이슨 iv를 가질 수 없다

    오직 `추상메서드`(또는 상수, static 메서드, 디폴트 메서드)만 가진다

- 인터페이스를 이용한 다형성

    인터페이스도 구현 클래스의 부모로 친다

    ```java
    class Fighter extends Unit implements Fightable {
        public void move(int x, int y){/* ... */}

        public void attack(Fightable f){/* ... */}
        매개변수는 인터페이스를 구현한 것들만 들어올 수 있다

        Unit u = new Fighter();
        조상 - 자손 객체

        Fightable f = new Fighter();
        인터페이스도 가능
    }
    ```
    매개변수의 타입이 인터페이스인 경우가 어떤 의미인가

    -> 인터페이스를 구현한 클래스의 인스턴스만 가능하다는 뜻

    인터페이스를 메서드의 리턴타입으로 지정할 수 있다

    ```java
    Fightable method() {
        Fighter f = new Fighter();
        return f;
    }

    class Fighter extends Unit implements Fightable {
        public void move(int x, int y) {/* ... */}
        public void attack(Fightable f) {/* ... */}
    }

    매개변수에 fightable f = method();
    즉, fightable f = new Fighter();
    ```
    [interface_fighter](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/interface_fighter/src/Main.java)

- 인터페이스의 장점

    _두 객체 간의 연결, 대화, 소통을 돕는 중간 역할을 한다_

    _선언과 구현을 분리시킬 수 있다_

    ```java
    class B {
        public void method() {
            sout("methodInB");
        }
    }

    를 선언과 구현으로 분리시키면

    껍데기
    interface I {
        public void method();
    }

    알맹이
    class B implements I {
        public void method() {
            sout("methodInB");
        }
    }
    ```

    선언과 구현이 분리되어 있으면 변경에 용이

    알맹이만 다른것으로 바꿀 수 있다

    A가 B를(에) 사용(의존)한다

    A : 인터페이스, B : 구현 class

    1. 인터페이스가 없을 경우

        ```java
        class A {
            public void methodA(B b) {
                b.methodB;
            }
        }

        class B {
            public void methodB() {
                sout("methodB()");
            }
        }

        class InterfaceTest {
            public static void main(String args[]) {
                A a = new A();
                a.methodA(new B())
            }
        }
        ```

    2. 인터페이스가 있을 경우

        ```java
        class A {
            public void methodA(I i) {
                i.methodB;
            }
        }

        interface I {void methodB(); }
        
        class B implements I {
            public void methodB() {
                sout("methodB()");
            }
        }

        추가 가능
        class C implements I {
            public void methodB() {
                sout("methodB() in C");
            }
        }
        ```
        A를 변경하지 않아도 된다

    [interface_test](https://github.com/ejaee/Study_JAVA/blob/main/Ejae/ch.07_ObjectOriented2/interface_test/src/Main.java)

    1. 개발 시간을 단축할 수 있다

        A가 B에 의존하려면 B가 완성되어야 한다

        interface가 있으면 A는 껍데기 I만 있으면 된다

    2. 변경에 유리한 유연한 설계가 가능하다

    3. 표준화가 가능하다

    4. 서로 관계 없는 클래스끼리 관계를 맺어줄 수 있다

        <img width="848" alt="Screen Shot 2022-10-17 at 2 30 09 PM" src="https://user-images.githubusercontent.com/87407504/196097318-4e56340e-4ddd-4de7-82c1-393c82dc2f30.png">

        <img width="848" alt="Screen Shot 2022-10-17 at 2 33 32 PM" src="https://user-images.githubusercontent.com/87407504/196097352-7a69ca35-3453-4dcf-b335-241aca9dd1d4.png">


        매개변수에 인터페이스가 들어가 있는 것은

        해당 인터페이스가 구현된 class만 들어올 수 있다는 뜻

- 디폴트 메서드와 static 메서드

    인터페이스에 디폴트 메서드, static 메서드 추가 가능 (JDK1.8 부터)

    차후에 interface에 새로운 추상메서드를 추가한다면

    interface를 implements 하는 class마다 해당 추가 추상메서드를 구현해줘야하는 문제가 발생한다

    이에대한 해결책이 `디폴트 메서드`

    ```java
    문제
    interface MyInterface {
        void method();
        void newMethod();
        추상메서드가 추가되면 위에 언급한 문제가 발생한다
    }

    해결
    interface MyInterface {
        void method();
        default void newMethod() {}
        몸통이 있는 메서드를 입력할 수 있다
    }
    ```
    기존에 인터페이스가 추상메서드만 가지게 된 이유는

    기존의 메서드와의 `충돌` 때문이었다

    그런데 default 메서드로 인한 충돌문제가 생긴다

    이에 대한 해결책은

    1. `여러 인터페이스`의 `디폴트 메서드` 간의 충돌

        인터페이스를 구현한 클래스에서 디폴트 메서드를 `오버라이딩`

    2. `디폴트 메서드`와 `조상 클래스`의 메서드 간의 충돌

        조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다

        조상 클래스의 메서드가 `우선`된다

    외운다는 느낌 보다는 직접 오버라이딩 하면 된다

    