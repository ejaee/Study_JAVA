// dont run

public class StaticBlock {

    Static int[] arr = new int[10];

    static {
        for (int i = 0; i < 10; i++)
            arr[i] = (int)(Math.random() * 10) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(:"arr[" + i + "] = " + arr[i]);
    }
}