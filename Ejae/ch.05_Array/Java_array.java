import java.util.*;

class Java_array {
	public static void main(String[] args) {
		
		// int 5개를 저장할 수 있는 배열을 생성
		int[] arr1 = new int[5]; 
		int arr2[] = new int[5];
		String[] arr3 = new String[5];
		String arr4[] = new String[5];
		// new -> 배열의 타입과 길이를 지정하는 연산자 
		// 각 배열의 공간에 자동적으로 0으로 초기화된다 
		
		int[] arr5 = new int[0]; // 길이가 0인 배열도 생성이 가능 
				
		// strlen(arr) == arr.length
		System.out.println("arr1의 길이는 length을 통해 구한다 -> " + arr1.length);
		System.out.println();
		
		// 배열의 초기화
		/* ============================================== */
		int[] arr6 = new int[] {50, 60, 70, 80, 90}; // 길이가 자동으로 반영된다
		int[] arr7 = {50, 60, 70, 80, 90}; // 생략이 가능 
	//	arr7 = {50, 60, 70, 80, 90} 불가. (선언과 생성을 따로하는 경우는 생략 불가능) 
	//	이후 매서드를 다룰 때 배운다
		
		int[] arr8 = {}; // 길이가 0인 배열이 만들어진다 
		
		int[] arr9 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr9)); // 배열의 요소를 반환하는 메서드 
		System.out.println(arr9); // [type@addr 형식으로 출력 ([I@73a8dfcc) 
		// [I -> 1차원 int 배열 
		// @~ -> (실제 주소가 아닌) 16진수 내부 주소
		
		 // 예외적으로 println 메서드가 char 배열일 때 요소들이 출력된다 
		char[] chArr1 = {'a', 'b', 'c', 'd', 'e'};
		System.out.println(chArr1);
		
		// 배열의 복사 
		/* ============================================== */
		// System.arraycopy(num, 0, newNum, 0, num.length);
		// num[0]에서 newNum[0]으로 num.length개의 데이터를 복사 
		char[] abc = {'a', 'b', 'c'};
		char[] num = {'0', '1', '2', '3', '4'};
		System.out.println();
		System.out.println(abc);
		System.out.println(num);
		char[] result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result); // abc01234 
		
		// 배열의 활용
		/* ============================================== */
		System.out.println();
		System.out.println("섞기");
		
		int[] numArr = new int[10];
		
		for (int i = 0; i < numArr.length; i++)
			numArr[i]= i; // 배열을 0 ~ 9 숫자로 초기화 
		
		for (int i = 0; i < numArr.length; i++) {
			int n = (int)(Math.random() * 10);
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		// 중복된 값이 나오더라도 단순히 배열의 순서를 바꾸는 것이므로 문제엑스 
		// 난수생성기로 받는 값을 index로 사용하기 때문 
		
		for (int i = 0; i < numArr.length; i++)
			System.out.print(numArr[i]);
		
		/* ============================================== */
		System.out.println();
		System.out.println();
		System.out.println("정렬 전");
		
		int[] numArr2 = new int[10];
		
		for (int i = 0; i < numArr2.length; i++)
			System.out.print(numArr2[i] = (int)(Math.random() * 10));
		System.out.println();
		
		for (int i = 0; i < numArr2.length - 1; i++) {
			boolean changed = false; // 자리바꿈 발생했는지 확인하는 flag
			
			// 버블정렬 (오른쪽으로 가장 큰 값을 셋팅하면서 정렬)
			for (int j = 0; j < numArr2.length - 1 - i; j++) {
				if (numArr2[j] > numArr2[j + 1]) {
					int tmp3 = numArr2[j];
					numArr2[j] = numArr2[j+1];
					numArr2[j+1] = tmp3;
					changed = true;
				}	
			}
			if (!changed) break;
			System.out.println();
			
			for (int k = 0; k < numArr2.length; k++)
				System.out.print(numArr2[k]);
			System.out.println();
		}
		/* ============================================== */
		// 배열의 구성요소 갯수를 세는 방법 -> index에 배열 값으로 활용하기
		System.out.println();
		
		int[] numArr4 = new int[10];
		int[] counter = new int[10];
		
		for (int i = 0; i < numArr4.length; i++) {
			numArr4[i]= (int)(Math.random() * 10);
			System.out.print(numArr4[i]);
		}
		System.out.println();
		
		for (int i = 0; i < numArr4.length; i++)
			counter[numArr4[i]]++;
		for (int i = 0; i < numArr4.length; i++)
			System.out.println(i +"의 개수 :"+ counter[i]);
	}
			
		
	
}