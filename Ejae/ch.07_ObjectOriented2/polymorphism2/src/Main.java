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

    // Plus
    Product[] cart = new Product[10];   // 장바구니 역할
    int i;
    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        // Plus
        cart[i++] = p;
        System.out.println(p + "을/를 구입하셨습니다.");
    }
    void summary() {
        int sum = 0;
        String itemList = "";

        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null)
                break;
            sum += cart[i].price;
            itemList += cart[i] + ", ";
            // cart[i] == cart[i].toString
            // 추상형의 이름을 문자열로 사용하면 자동으로 .toString으로 사용된다고 생각하자
        }
        System.out.println();
        System.out.println("=========================================");
        System.out.println("구입하신 물품의 총금액은 " + sum + " 만원 입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}


public class Main {
    public static void main(String[] args) {
        Buyer b = new Buyer(); // cart 생성

        System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점 입니다.");

        b.buy(new Tv1());
        b.buy(new Computer());

        System.out.println();
        System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점 입니다.");

        b.summary();
    }
}