import java.util.Arrays;
//Arrays.toString 쓰기위해서
public class Ex01_Array1 {
    //array 알아보기
    public static void main(String[] args) {
        int[] score = new int[5];

        score[0] = 50;
        score[1] = 60;
        score[2] = 70;
        score[3] = 80;
        score[4] = 90;
        for (int i = 0; i < 5; i++) {
            System.out.print(score[i] + " ");
        }
        System.out.println(); // 50 60 70 80 90
        System.out.println(Arrays.toString(score)); // [50, 60, 70, 80, 90]
    }
}
