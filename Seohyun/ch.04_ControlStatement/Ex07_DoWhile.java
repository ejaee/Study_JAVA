import java.util.Scanner;

public class Ex07_DoWhile {
    public static void main(String[] args) {
        int input = 0;
        int answer = 0;

        answer = (int)(Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("숫자를 맞춰 보시오: ");
            input = Integer.parseInt(scanner.nextLine());

            if (input > answer) {
                System.out.println("다운");
            } else if (input < answer) {
                System.out.println("업");
            }
        } while (input != answer);

        System.out.println("정답입니다~!");
        scanner.close();
    }
}
