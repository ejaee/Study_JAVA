public class Ex04_For1 {
    //for문 사용해보기
    public static void main(String[] args) {
        for(int i = 2; i < 10; i++) {
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%d X %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
