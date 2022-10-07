class Product {
    static int count;
    int serialNum;

    {
        ++count;
        serialNum = count;
    }
    // 생성자가 하나 밖에 없기 때문에 인스턴스 블럭 대신,
    // Product 클래스의 생성자를 사용해도 되지만
    // 크드 의미상 모든 생성자에서 공통으로 수행되어야하는 내용이므로 인스턴스 블럭을 사용

    // 만약 static int count -> Int count 인스턴스 변수일 경우 0으로 매번 초기화된다

//    public Product() {}; 기본생성자 생략가능
}

class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        System.out.println("제품 p1의 일련변호는 " + p1.serialNum + " 입니다.");
        System.out.println("제품 p2의 일련변호는 " + p2.serialNum + " 입니다.");
        System.out.println("제품 p3의 일련변호는 " + p3.serialNum + " 입니다.");
        System.out.println("제품의 총 개수는 " + Product.count + "개 입니다.");
    }
}