import java.util.Arrays;
//헷갈리는 연산자
public class Ex06_ArrayUp {
    public static void main(String[] args) {
        int[] numArr  = new int[10];
		int[] counter = new int[10];

		for (int i=0; i < numArr.length ; i++ ) {
			numArr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(numArr[i] + " ");
		}
		System.out.println();

        //카운터 배열에 인덱스 위치의 값을 증가 시켜서 numArr의 갯수를 저장
		for (int i=0; i < numArr.length ; i++ ) {
			System.out.println(Arrays.toString(counter));
            counter[numArr[i] - 1]++;
		}

		for (int i=0; i < numArr.length ; i++ ) {
			System.out.println( (i + 1) + "의 개수 :"+ counter[i]);
		}
    }
}
