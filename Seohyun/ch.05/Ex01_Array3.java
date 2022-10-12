public class Ex01_Array3 {
    //배열에 새로운 배열 넣으면 크기 변경됨!
    public static void main(String[] args) {
		int[] arr = new int[5];

		for(int i = 0; i < arr.length; i++) 
			arr[i] = i + 1;

		System.out.println("변경전 - arr.length:" + arr.length);	
		for(int i = 0; i < arr.length; i++) 
			System.out.printf("arr[%d]: %d%n", i, arr[i]);	

		int[] tmp = new int[arr.length * 2 - 3]; //크기 = 10 - 3

		for(int i = 0; i < arr.length; i++) 
			tmp[i] = arr[i];

		arr = tmp;  // tmp에 저장된 값을 arr에 저장한다.
		System.out.println("변경후 - arr.length:" + arr.length);	
		for(int i = 0; i < arr.length; i++) 
			System.out.printf("arr[%d]: %d%n", i, arr[i]);
    }
}
