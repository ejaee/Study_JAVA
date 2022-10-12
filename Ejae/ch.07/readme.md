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