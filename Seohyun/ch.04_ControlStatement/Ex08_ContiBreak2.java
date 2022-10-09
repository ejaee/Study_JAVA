import java.util.Scanner;

public class Ex08_ContiBreak2 {
    public static void main(String[] args) {
        int menu = 0;
        int num = 0;

        Scanner scanner = new Scanner(System.in);
        outer: //while문에 이름 지어줌.
        while(true) {
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.print("원하는 메뉴(1~3)를 선택하세요. 종료를 원하시면 0번을 입력하세요: ");
            menu = Integer.parseInt(scanner.nextLine());

            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                break outer;
            } else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴를 잘못 선택하셨습니다.");
                continue outer;
            }

            inner: for(;;) { //while(true)랑 같은거
                System.out.print("계산 할 값을 입력하세요. 계산 종료를 원하시면 0번 전체 종료를 원하시면 99번을 입력하세요: ");
                num = Integer.parseInt(scanner.nextLine());
                
                if (num == 0)
                    break inner;
                if (num == 99) {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    break outer;
                }    
                switch (menu) {
                    case 1:
                        System.out.println("result = " + (num * num));
                        break;
                    case 2:
                        System.out.println("result = " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result = " + Math.log(num));
                        break;
                }
            }
        }
    }
}
