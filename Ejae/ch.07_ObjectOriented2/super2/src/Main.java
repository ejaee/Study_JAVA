class Point {
    int x, y;

    Point(int x, int y) {
//        super(); -> public Object() {...}
        this.x = x;
        this.y = y;
    }
    String getLocation() {
        return "x = " + x + ", y = " + y;
    }
}

class Point3D extends Point{
    int z;

    Point3D() {
        this(100, 200, 300);
    }
    Point3D(int x, int y, int z) {
        super(x, y);
//        super();
//        컴파일러가 자동적으로 생성자 첫 줄에 super()를 수행한다
//        Point 클래스에 기본생성자가 정의되어 있지 않다면 컴파일 에러가 발생한다
//        Point() 기본생성자를 추가하고
//        super(); this.x = x; this.y = y; this.z = z; 하던가
//        Point(int x, int y)를 호출하고 this.z = z; 하던가
        this.z = z;
    }
    String getLocation() {
        return super.getLocation() + ", z = " + z;
    }
}

public class Main {
    public static void main(String[] args) {
        Point3D p3 = new Point3D();
        Point3D p33 = new Point3D(1, 2, 3);
        System.out.println(p3.getLocation());
        System.out.println(p33.getLocation());
    }
}