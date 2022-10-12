import java.util.Arrays;

public class Ex01_Array2 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[]{100, 95, 80, 70, 60};
        int[] iArr4 = {100, 95, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd', 'e'};
        String[] strArr = {"abc", "dadada", "haha"};

        for (int i = 0; i < iArr1.length; i++)
            iArr1[i] = i + 1;
        for (int i = 0; i < iArr2.length; i++)
            iArr2[i] = (int)(Math.random() * 10 + 1);
        
        for(int i=0; i < iArr1.length;i++) {
			System.out.print(iArr1[i]+" ");	
		}
		System.out.println();						
        System.out.println(iArr2);							
		System.out.println(Arrays.toString(iArr2));
		System.out.println(iArr3);
        System.out.println(Arrays.toString(iArr3));
        System.out.println(iArr4);
        System.out.println(Arrays.toString(iArr4));
        System.out.println(chArr);
		System.out.println(Arrays.toString(chArr));
        System.out.println(strArr);
		System.out.println(Arrays.toString(strArr));
    }
}

/*
출력 결과:
1 2 3 4 5 6 7 8 9 10 
[I@73a28541
[7, 5, 4, 10, 3, 9, 4, 1, 9, 4]
[I@6f75e721
[100, 95, 80, 70, 60]
[I@69222c14
[100, 95, 80, 70, 60]
abcde
[a, b, c, d, e]
[Ljava.lang.String;@606d8acf
[abc, dadada, haha]
 */