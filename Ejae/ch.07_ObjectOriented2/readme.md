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

[CaptionTvTest]()

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


[DrawShape]()

[DeckTest]()


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

[super]()

- super()

    _조상 클래스의 생성자를 호출하는데 사용_

    조상 클래스의 호출은 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다

    그렇지 않으면 컴파일러는 생성자의 첫줄에 `super()`를 자동적으로 추가한다

    이때 생성자를 만들면서 기본생성자가 없다면 문제가 발생한다

    생성한 생성자의 매개변수에 맞게 super(1, 2)로 호출하면 된다

[super2]()

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

[acess_modifier]()


