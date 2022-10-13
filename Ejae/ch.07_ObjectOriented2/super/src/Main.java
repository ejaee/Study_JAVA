class Parent {
    int x = 10;

    String getLocation() {
        return "x : " + x;
    }
}

class Child extends Parent{
    int x = 20;

    String getLocation() {
//        return "x : " + x;
        return super.getLocation() + " override";
    }
    void method() {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
        System.out.println(c.getLocation());
    }
}