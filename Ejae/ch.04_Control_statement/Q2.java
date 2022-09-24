import java.util.*;

public class Q2 {
    public static void main(String[] args) {

        int total_cost ,cost;
        int count , item_num, sum = 0;

        Scanner sc = new Scanner(System.in);
        total_cost = sc.nextInt();
//        sc = new Scanner(System.in);
        count = sc.nextInt();

        while (count-- > 0)
        {
//            sc = new Scanner(System.in);
            cost = sc.nextInt();
            item_num = sc.nextInt();
            sum += cost * item_num;
        }
        if (sum == total_cost)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
// 입력을 받을 때마다 c에서 scanf 하듯,
// System.in을 주고 입력값을 받는 줄 알았다.
