public class Operator {
    public static void main(String[] args) {

        int x = 0xAB;
		int y = 0xF;
		
        // 비트 논리 연산자
        System.out.println("-----------비트 논리 연산자-----------");
		System.out.printf("x = %#X \t\t%s\n", x, Integer.toBinaryString(x));
		System.out.printf("y = %#X \t\t%s\n", y, Integer.toBinaryString(y));
	
		System.out.printf("%#X | %#X = %#X \t%s\n",x, y, x|y, Integer.toBinaryString(x|y));
		System.out.printf("%#X & %#X = %#X \t%s\n",x, y, x&y, Integer.toBinaryString(x&y));
		System.out.printf("%#X ^ %#X = %#X \t%s\n",x, y, x^y, Integer.toBinaryString(x^y));

        // 비트 이동 연산자
        System.out.println("-----------비트 이동 연산자-----------");
        System.out.printf("x = %#X \t\t%s\n", x, Integer.toBinaryString(x));
        System.out.printf("x >>  4 %#X \t\t%s\n", x >> 32, Integer.toBinaryString(x >> 4));
		System.out.printf("x <<  4 %#X \t\t%s\n", x << 32, Integer.toBinaryString(x << 4));
		System.out.printf("x >> 32 %#X \t\t%s\n", x >> 32, Integer.toBinaryString(x >> 32));
		System.out.printf("x << 32 %#X \t\t%s\n", x << 32, Integer.toBinaryString(x << 32));
	
    }
}
