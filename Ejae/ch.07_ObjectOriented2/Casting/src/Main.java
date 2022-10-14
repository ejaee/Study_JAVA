class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }
    void stop() {
        System.out.println("stop!!!");
    }

}

class FireEngine extends Car {
    void water() {
        System.out.println("water!!!");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = null;
        // car 타입의 참조변수를 null로 초기화
        FireEngine fe = new FireEngine();
        // FireEngine 인스턴스 생성(new)하고 FireEngine 타입의 참조변수가 참조하도록한다
        FireEngine fe2 = null;

        fe.water();
        car = fe;
//        car.water(); -> car type의 참조변수로는 fe의 기능을 사용할 수 없다
        fe2 = (FireEngine)car;
//        4개의 기능에서 5개를 사용하려고 한다. 위험하다. 그래서 형변환을 꼭 써야한다
        fe2.water();

    }
}