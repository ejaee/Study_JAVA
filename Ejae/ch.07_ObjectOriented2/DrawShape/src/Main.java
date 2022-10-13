class   Shape {
    String color = "black";
    void draw() { // :48 오버라이딩
        System.out.printf("[color = %s]\n", color);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point() {
//        this(0, 0);
    }
    String getXY() {
        return "(" + x + ", " + y + ")";
    }
}

class Circle extends  Shape { // 원형은 도형(Shape)이다 -> 상속
    Point center; // 원은 점(Point)을 가지고 있다 -> 포함
    int r;

    Circle() {
        this(new Point(0, 0), 100);
    }
    Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }

    void draw() {
        System.out.printf("[center = (%d, %d), r = %d, color = %s]\n", center.x, center.y, r, color);
    }
}

class Triangle extends Shape { // 삼각형은 도형(Shape)이다 -> 상속
    Point[] p = new Point[3];

    Triangle(Point[] p){
        this.p = p;
    }

    void draw() {
        System.out.printf("[p1 = %s, p2 = %s, p3 = %s, color = %s]\n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
    }
}

public class Main {
    public static void main(String[] args) {
        Point[] p = {   new Point(100, 100),
                        new Point(140, 50),
                        new Point(200, 100)
                    };
        Triangle t = new Triangle(p);

        Circle  c = new Circle(new Point(150, 150), 50);
        /*
        :61
        Point p = new Point(150, 150);
        circle c = new Circle(p, 50);
        를 합친 코드
         */

        t.draw();
        c.draw();
    }
}

// Shape의 draw()와 Circle의 draw()가 곂친다 - >Circle 클래스의 draw()가 호출되는데,
// 이를 `오버라이딩`이라 하며 이후 배울 내용