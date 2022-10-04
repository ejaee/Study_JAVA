class Data {int x;}

class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv; // 인스턴스 변수는 클래스 변수 사용이 가능
    //        static int cv2 = iv; // 클래스 변수는 인스턴스 변수 사용이 불가능
    static int cv2 = new MemberCall().iv; // 이처럼 객체를 생성해야 사용이 가능

    static void staticMethod1() {
        System.out.println(cv);
//        System.out.println(iv); // error: 클래스메서드에서 인스턴스 변수를 사용불가
        MemberCall c = new MemberCall();
        System.out.println(c.iv); // 객체를 생성하고 인스턴스변수의 참조가 가능
    }

    void instanceMethod() {
        System.out.println(cv);
        System.out.println(iv); // 인스턴스에서는 인스턴스변수 바로 사용이 가능
    }

    static void staticMethod2() {
        staticMethod1();
//        instanceMethod1(); // error: 클래스메서드에서 인스턴스메서드를 호출불가
        MemberCall c = new MemberCall();
        c.instanceMethod(); // 인스턴스를 생성한 후에야 호출이 가능

        /*
        * MemberCall c = new MemberCall();
        * int result = c.instanceMethod();
        *
        * 위 두 줄을 다음과 같이 한 줄로 가능
        *
        * int result = new MemberCall().instanceMethod()
        */
    }

    void    instanceMethod2(){
        instanceMethod(); // 모두 인스턴스 생성 없이 바로 호출이 가능
        staticMethod1();
    }

    /*
    * 인스턴스멤버간의 호출에는 아무런 문제가 없다
    * 하나의 인스턴스멤버가 존재한다는 것은
    * 인스턴스가 이미 생성되어있다는 것을 의미하기 때문
    */
}

class MyMath2 {

    long a, b;

    long add() { return a + b; }    // a, b 는 인스턴스 변수
    static long add(long a, long b) { return a + b; } // a, b 는 지역변수

}

class ObjectOriented {
    public static void main(String[] args)  {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change1(d.x);    // 기본형 매개변수를 넘긴다면
        System.out.println("After change1(d.x)");    //복사 값이 전달되고 메서드 종료 후 스택에서 사라지므로
        System.out.println("main() : x = " + d.x); // 기존의 값은 바뀌지 않는다
        System.out.println();

        change2(d);     // 참조형 매개변수를 넘긴다면
        System.out.println("After change2(d)");    // 기존의 값을 담은 메모리 주소값이 전달되로
        System.out.println("main() : x = " + d.x); // 기존의 값은 바뀐다
        System.out.println();

        int[]x = {10};

        System.out.println("main() : arr x[0] = " + x[0]);
        change3(x);     // 배열의 주소를 넘긴다면
        System.out.println("After change3(d)");    // 기존의 값을 담은 메모리 주소값이 전달되로
        System.out.println("main() : x = " + x[0]); // 기존의 값은 바뀐다


        /*
        * C와 다르지 않다
        */

//        클래스 메서드(static 메서드)와 인스턴스 메서드
//        메서드 앞에 static이 붙어 있으면 클래스 메서드
//        붙어 있지 않으면 인스턴스 메서드

        /*
        * 클래스 메서드도 객체를 생성하지 않고도 콜래스이름.메서드이름으로 호출이 가능
        * 인스턴스 메서드는 반드시 객체를 생성해야만 호출이 가능
        *
        * [참고]
        * 클래스 영역에 선언된 변수를 멤버변수
        * 멤버변수 중에 static이 붙은 것을 클래스 변수
        * 붙지 않은 것이 인스턴스 변수
        * 1. 클래스를 설계할 때 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다
        * 2. 클래스 변수는 인스턴스를 생성하지 않아도 사용 가능하다
        * 3. 클래스 메서드는 인스턴스 변수를 사용할 수 없다
        * (인스턴스가 반드시 존재해야 인스턴스 변수 사용이 가능)
        * 4. 메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다
        * (메서드 호출시간이 짧아 성능이 향상)
        *   - 클래스의 멤버 변수 중 모든 인스턴스에 공통 값을 유지해야할 경우 static을 붙인다
        *   - 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에 static을 붙일 것을 고려한다
        *
        * */

        MyMath2 m_i = new MyMath2(); // 인스턴스 생성

        m_i.a = 100L;
        m_i.b = 200L;
        System.out.println();
        System.out.println("Call: Class math " +  MyMath2.add(10L, 20L));
        System.out.println("Call: Instance math " + m_i.add());

        /* =================================================================== */

        // 같은 클래스 내의 메서드는 서로 객체의 생성이나 참조변수 없이 직접 호출이 가능하지만
        // static 메서드는 인스턴스 메서드를 호출할 수 없다
        // 3.12 예제 참고

    }

    static void change1(int x) {
        x = 1000;
        System.out.println("change() : x = " + x);
    }

    static void change2(Data d) {
        d.x = 1000;
        System.out.println("change() : d.x = " + d.x);
    }

    static void change3(int[] x) {
        x[0] = 1000;
        System.out.println("change() : x[0] = " + x[0]);
    }
}