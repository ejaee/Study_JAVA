import java.util.*; // Scanner가 포함된 java 패키지

public class Q1_star1 {
    public static void main(String[] args) {
        int idx = 0, jdx, input_max;
        Scanner scanner = new Scanner(System.in); // Scanner 클래스를 활용해 입력 받기
        input_max = scanner.nextInt(); // scanner 입력값을 int로 변환

        while (++idx < input_max + 1) {
            jdx = 0;
            while (++jdx < idx + 1)
                System.out.print("*");
            System.out.println();
        }
    }
}

/*

    char를 입력 받을 때는 >> System.in.read

    char ch;
    ch = (char)System.in.read();
    System.out.println(ch);

 */

/*

    char를 여러개 입력 받을 때는 >> next.Line

    char a, b;
    String str;
    Scanner sc = new Scanner(System.in);
    str = sc.nextLine();
    a = str.charAt(0);
    b = str.charAt(2);
    System.out.println(a + " " + b);
    sc.close();

 */