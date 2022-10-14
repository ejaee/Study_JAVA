abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() {/* 현재 위치에 정지*/}
}

class Marine extends Unit {
    void move(int x, int y) {
        System.out.println("Marine이 지상좌표(" + x + ", " + y + ") 로 이동합니다");
    }
    void stimPack() {/* 스팀팩을 사용합니다 */}
}

class Tank extends Unit {
    void move(int x, int y) {
        System.out.println("Tank가 산간좌표(" + x + ", " + y + ") 로 이동합니다");
    }
    void mode() {/* 모드를 변경합니다 */}
}

class Dropship extends Unit {
    void move(int x, int y) {
        System.out.println("Dropship이 해상좌표(" + x + ", " + y + ") 로 이동합니다");
    }
    void drop() {/* 드랍 합니다 */}
}

public class Main {
    public static void main(String[] args) {
        Unit[] group = { new Marine(), new Tank(), new Dropship() };
//        위 코드는 아래 네 줄을 한 줄로!
//        Unit[] group = new Unit[3];
//        group[0] = new Marine();
//        group[1] = new Tank();
//        group[2] = new Dropship();
        // Unit -> Object로 바꾸면 :42 에서 Object.move 부분에서 ERROR
        // Object 라는 리모컨에 move 라는 버튼이 없다


        // group의 타입은 Unit[]
        // group[i]의 타입은 Unit
        for(int i = 0; i < group.length; i++)
            group[i].move(100, 200);
        // group은 참조변수, 리모콘
        // 참조변수를 모아둔 것이 Unit 객체 배열
    }
}