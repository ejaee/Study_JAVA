// acess_modifier의 MyParent를 상속해보자

import pkg1.MyParent;

class MyChild extends MyParent {
    public void printMembers() {
//        System.out.println(prv); ERROR
//        System.out.println(dft); ERROR
        System.out.println(prt); // OK
        System.out.println(pub); // OK
    }
}

// ERROR 발생

// 1. acess_modifier의 MyParent는 dft 이므로 같은 패키지 내에서만 사용이 가능하다
// 따라서 public class로 수정해야한다
// 2. 한 소스파일 내에서는 public class가 하나만 존재 해야한다
// 따라서 기존의 public class Main을 class로 수정한다

// public class와 소스파일 이름을 일치시켜야 한다

public class Main {
    public static void main(String[] args) {
//        System.out.println(prv); ERROR
//        System.out.println(dft); ERROR
//        System.out.println(prt); ERROR: 자손이 아니다 다릌 패키지의 다른클래스이므로 ERROR
        System.out.println(pub); // OK

    }
}