import java.util.Scanner;

public class EX03_Switch2 {
    public static void main(String[] args) {
        int user = 0;
        int com;
        
        System.out.print("가위 바위 보 중 하나를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        String what = scanner.nextLine();
        while (user == 0) {
            System.out.println(what);
            if (what == "가위") {
                System.out.println("가위입력함!!!!!!!!");
                user = 1;
            } else if (what == "바위") {
                user = 2;
            } else if (what == "보") {
                user = 3;
            } else {
                System.out.print("잘못 입력하셨습니다. 다시 입력하세요: ");
                what = scanner.nextLine();
            }
            System.out.printf("user: %d 입니다.", user);
        }
        com = (int)(Math.random() * 3) + 1;

        switch(user - com) {
            case 0:
                System.out.println("컴퓨터랑 비겼습니다. 별거없네;");
            case -1: case 2:
                System.out.println("당신은 졌습니다. 우우~");
            case -2: case 1:
                System.out.println("당신이 이겼습니다. 쯧");
            
        }
        scanner.close();
    }
}
