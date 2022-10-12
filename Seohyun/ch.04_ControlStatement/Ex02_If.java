import java.util.*;
//if문 사용해보기
public class Ex02_If {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';

        System.out.printf("점수를 입력하세요.>");
        Scanner scanner = new Scanner(System.in);
        score = Integer.parseInt(scanner.nextLine());

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else
            grade = 'F';

        System.out.println("당신의 학점은 " + grade + "입니다.");
        scanner.close();
    }
}