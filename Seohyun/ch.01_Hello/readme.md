# 시작

## 🚕Java 컴파일 과정🚕

![image](https://user-images.githubusercontent.com/77817094/193726114-68b82214-74cb-40f1-a87f-d3d3c6024469.png)

1. 자바 소스코드(.java) 작성
2. 자바 컴파일러(javac)가 자바 소스코드(.java)파일을 읽어 바이트코드(.class)코드로 컴파일
	- 컴파일러에 의해 변환되는 코드의 명령어 크기가 1바이트라서 바이트 코드라고 함.
3. 컴파일된 바이트코드(.class)를 JVM의 클래스로더(Class Loader)에게 전달
4. 클래스 로더는 Dynamic Loading을 통해 필요한 클래스들을 링크하여 JVM 메모리에 올림

5. 실행엔진(Execution Engine)은 JVM 메모리에 올라온 바이트 코드들을 명령어 단위로 하나씩 가져와 실행

## 🚕JVM🚕

![image](https://user-images.githubusercontent.com/77817094/193728081-e4dde9c1-e74a-4db3-9955-2e9f29ae5acf.png)
바이트 코드로 변환된 코드들(class files)을 클래스 로더가 JVM의 메모리에 올리면 JVM의 실행엔진인 인터프리터나 JIT 컴파일러가 해석하고 실행하는 역할을 한다.

![image](https://user-images.githubusercontent.com/77817094/193727791-00ee1dfb-a8fa-4142-990b-10f1554cb8c2.png)
JVM은 자바 프로그램이 어느 운영체제(기기) 상에서도 실행될 수 있도록 하고 프로그램 메모리를 관리하고 최적화 한다.

### **특징**
* 일반 애플리케이션은 OS만 거치고 H/W로 전달되지만, 자바 애플리케이션은 H/W와 OS 위에 JVM이 있다.
* JVM은 OS에 종속적이므로 해당 OS에서 실행 가능한 JVM이 필요하다. 
* 하드웨어에 맞게 완전히 컴파일된 상태가 아니기 때문에 실행 시 해석되므로 속도가 느리다.
* JVM은 OS에 종속적이므로 해당 OS에서 실행 가능한 JVM이 필요하다.

## 🚕Java의 특징🚕

자바는 객체 지향 프로그래밍(Object Oriented Programming - oop)입니다. 
객체지향프로그래밍의 대표적 특징에는 상속,캡슐화(은닉),다형성,추상화가 있습니다. 
OOP는 4가지 특징을 활용해 코드의 재사용성을 증가하고 유지보수를 용이하게 만듭니다. 
 
⚡ 객체 지향 프로그래밍의 대표적 특징
1) 상속 (Inheritance) : 부모 클래스의 변수와 메서드를 자식 클래스가 전부 물려받는 것입니다. 
2) 캡슐화 (Encapsulation, Information Hiding) : 객체의 변수 및 메서드를 외부 객체가 함부로 건드리지 못하게 감싸는 개념입니다 . 클래스의 getter/setter 등을 통해 은닉합니다. 
3) 다형성(Polymorphism)
- Poly(다양한) + morphism(변형,변신) 의 합성어입니다. 
- 하나의 객체가 여러가지 타입을 가질 수 있는 것을 의미합니다. 
- 자바에서는 한 레퍼런스 변수가 다른 형태의 객체를 참조할 수 있음을 말합니다. 
- 오버로딩, 오버라이딩, 업캐스팅, 다운캐스팅 등의 방법이 있습니다. 
4) 추상화 (Abstraction) 
- 자바에서 공통의 속성, 기능을 묶어 이름을 붙이는 것을 의미합니다. 
- 자바에서 추상화는 추상클래스, 인터페이스를 통해 구현됩니다. 
- 추상클래스 : 추상메서드를 하나 이상 포함한 추상 클래스 
- 인터페이스 : 추상메서드만을 포함한 추상 클래스, 다중 상속 가능 
* JAVA 8부터는 인터페이스 안에 default 선언을 하면 바디가 있는 메서드도 선언이 가능합니다. 

📌 2. 자동 메모리 관리
자바에서는 JVM이 지속적으로 메모리를 감시하면서 더이상 사용되지 않는 메모리를 해제시켜 줍니다.
C/C++ 등 다른 언어의 경우 더이상 사용하지 않는 메모리는 재사용 가능하게 해제해야 합니다. 이는 개발자가 직접 메모리를 해제해야 함을 의미합니다. 그러나 자바는 Garbage Collection을 통해 메모리 관리를 자동으로 수행되기 때문에 개발자가 신경 쓸 필요가 없습니다. 만약 개발자가 직접 메모리를 해제하고 싶은 경우, System.gc();로 Garbage Collector를 호출하여 해제할 수 있습니다. 
 
 
📌 3. 운영체제에 독립적
자바는 운영체제에 독립적입니다. 이것은 무슨의미일까요? 
자바의 개발 환경과 배포환경이 다를 경우, 프로그램을 다시 컴파일 할 필요 없이 실행가능함을 의미합니다. 이는 자바가 Java Virtual Machine 위에서 돌아가기 때문입니다. Java Virtual Machine에서 별도의 Java Compiler를 통해 사용자의 코드를 Byte 코드로 변환합니다. 따라서 모든 자바 프로그램은 이론적으로 CPU나 운영체제의 종류와 무관하게 동일하게 동작합니다.

📌4. 멀티쓰레드 프로그래밍 가능
자바는 하나의 프로그램에서 여러 개의 쓰레드가 동시에 실행할 수 있는 환경을 지원합니다.  C/C++은 운영체제의 도움을 받아 멀티 쓰레드를 수행하지만, 자바는 운영체제 지원없이 멀티스레드 프로그래밍이 가능합니다. 
멀티스레드란? 여러 스레드(프로그램의 실행단위, 프로세스 내 주소공간 및 자원 공유함)를 동시에 실행시키는 응용프로그램을 작성하는 기법입니다. 장점은 프로세스 내 메모리 공유를 통해 시스템 자원 소모가 줄어든다는 점이지만, 반면에 자원을 공유하기 때문에 충돌이 일어날 수 있습니다. 
⚡ 멀티쓰레드 구현방법
1) Thread 클래스 (화이트박스 방식)
: 자바에서 스레드를 만들기 위해 Thread class 상속하여 스레드를 생성합니다.
* Thread pool : 필요시 스레드를 가져오거나 이전 코드에서 실행완료되었을 때 재사용하는 풀(Pool)
2) Runnable 인터페이스 (블랙박스 방식)
: Thread class와 같이 자바에서 스레드 실행시키는 인터페이스입니다.
: 다중상속이 지원되기 때문에 Thread clas보다 많이 쓰입니다 
 
 
📌 5. 동적 로딩(Dynamic loading)을 지원
자바는 애플리케이션이 실행될 때 모든 객체가 생성되지 않고,  객체가 필요한 시점에 클래스를 동적 로딩하여 생성합니다.
동적로딩(Dynamic Loading)은 클래스 일부 변경 시 다시 컴파일하지 않아도 되는 이점이 있습니다.또한, 비교적 적은 작업으로 처리할 수 있는 유연성을  동적로딩이 제공합니다. 반면에 그때 그때 메모리에서 불러오기 때문에 프로그램 실행 속도가 정적로딩에 비해 느립니다. (느린 속도를 해결하기 위해 static 키워드를 사용합니다)
 
⚡ 정적 로딩(Static Loading)은 무엇일까요? 
정적 로딩은 프로그램 실행 시 모든 실행파일이 메모리에 적재되어 실행되는 로딩방법입니다. 대표적으로 C언어가 있습니다. 정적로딩은 모든 파일이 메모리에 적재되어 메모리를 많이 차지하지만, 빠르게 가져와 사용할 수 있다는 장단점이 있습니다.