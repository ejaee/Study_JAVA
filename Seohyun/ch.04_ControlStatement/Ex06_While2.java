public class Ex06_While2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while ((sum += ++i) <= 100) { //증감연산자 먼저 실행
            System.out.printf("%d - %d %n", i, sum); 
            //%n == 줄바꿈, 자바에선 이거 써주는게 좋음.
        }
    }
}
