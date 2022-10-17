abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() {
        System.out.println("stop.");
    }
}

interface Fightable { // interface의 모든 메서드는 public abstract
    void move(int x, int y); // public abstract 생략
    void attack(Fightable f); // public abstract 생략
}

class Fighter extends Unit implements Fightable {
    // public 안해주면 dft
    // public 해주어야한다 (오버라이딩 규칙:  조상(public)보다 접근 제어자가 좁으면 안된다)
    public void move(int x, int y) {
        System.out.println("[" + x +", " + y +"] 로 이동");
    }
    public void attack(Fightable f) {
        System.out.println(f+"를 공격");
    }
    // 싸울 수 있는 상대롤 불러온
    Fightable getFightable(){
        Fighter f = new Fighter();
//        Fightable f = new Fighter();
        return f; // (Fightable)f
    }
}

public class Main {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        Fightable f3 = f.getFightable();

        System.out.println();
        f.move(100, 200);
        f.attack(new Fighter());
//        Fighter f2 = new Fighter;
//        f.attack(f2);
        Fightable f2 = new Fighter();
        System.out.println();
        f2.attack(f2);

        Unit u = new Fighter();
        System.out.println();
        u.move(200, 100);
        u.stop();

    }
}