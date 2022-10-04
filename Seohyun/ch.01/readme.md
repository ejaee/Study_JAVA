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

