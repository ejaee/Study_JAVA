class MyParent {
    private     int prv; // 같은 클래스
                int dft; // 같은 패키지
    protected   int prt; // 같은 패키지 + 자손(다른 패키지)
    public      int pub; // 접근제한 없음.

    public void printMembers() {
        System.out.println(prv); // OK
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

public class Main {
    public static void main(String[] args) {
        MyParent p =new MyParent();
//        System.out.println(p.prv);  ERROR
        System.out.println(p.dft);
        System.out.println(p.prt);
        System.out.println(p.pub);
        System.out.println("Hello world!");
    }
}