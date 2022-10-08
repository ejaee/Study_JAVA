public class Ex04_For2 {
    //c랑 다른 for문 형식
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int sum = 0;
        //1번 방법
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //2번 방법
        for(int tmp : arr) {
            System.out.print(tmp + " ");
            sum += tmp;
        }
        System.out.println("\nsum = " + sum);
    }
}
