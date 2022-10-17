class A {
//    public void method(B b) {
    public void method(I b) {
        b.method();
    }
}

//class B {
//    public void method() {
//        System.out.println("B 클래스의 메서드");
//    }
//}

// 선언, 구현 분리
interface I {
    public void method();
}

class B implements I{
    public void method() {
        System.out.println("B 클래스의 메서드");
    }
}

class C implements I{
    public void method() {
        System.out.println("C 클래스의 메서드");
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.method(new B());  // A가 B에 의존
        // C를 쓰려면 new C()로 변경, class A 메서드의 매개변수도 변경
        // interface를 통해 A를 고치지 않아도 무방하다
        a.method(new C());
    }
}