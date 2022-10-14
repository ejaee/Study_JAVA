class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv1 extends Product {
    Tv1() {
        // 조상클래스의 생성자 Product(int price)를 호출한다
        super(100);
    }
    public String toString() {return "Tv";}
}

class Computer extends Product {
    Computer() { super(200); }
    public String toString() {return "Computer";}
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println();
//        System.out.println(p.toString() + "을/를 구입하셨습니다.");
        System.out.println(p + "을/를 구입하셨습니다.");
        // p 가 무엇인가?
        // p.toString() 참조변수는 .toString()과 같다! 자동 결합연산
    }
}

public class Main {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        System.out.println("현재 남은 돈은 " + b.money + "원 입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점 입니다.");

//        Product p = new Tv1;
//        b.buy(p);
        b.buy(new Tv1()); // 위 두줄을 한줄로 만들 수 있다
        // 생성하고 바로 넘겨주면 Main 안에서 사용할 참조변수가 없다
        b.buy(new Computer());

        System.out.println();
        System.out.println("현재 남은 돈은 " + b.money + "원 입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점 입니다.");
    }
}