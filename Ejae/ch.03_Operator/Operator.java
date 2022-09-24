class Operator {
	public static void main(String[] args) {
		
		System.out.println("논리 연산자");
		// x || y 에서 x가 참이면 y를 보지 않아도 참이다 
		// 논리 연산자는 왼쪽에서 오른쪽으로 읽는다
		// 즉, || 의 경우 참일 확률이 높은 것을 왼쪽에 두면 효율적이다 
		// 마찬가지로 && 는 거짓일 확률이 높은 것을 왼쪽에 두면 효율적이다
		
		System.out.println("비트 연산자");
		// '|' == or 하나라도 1이면 1
		// '&' == and 다 1로 같을 때 1
		// '^' == xor(eXclusive OR) 서로 다를 때 1
		
		System.out.println("'|' 특정 비트의 값을 바꿀 때 사용");
		// 0xAB | 0xAF -> 0xAF 마지막 4bit를 F로 변환 
		
		System.out.println("'&' 특정 비트의 값을 뽑아낼 때 사용");
		// 0xAB & 0xF -> 0xB 마지막 4bit를 F로 변환 
		// 마지막 4bit가 무엇인지 알아내는 용도로도 쓰임
		
		System.out.println("'^' 특정 비트의 값을 바꿀 때 사용");
		// 두번 사용하면 원래 값으로 돌아오므로 암호화, 복호화용도로도 쓰임 
		
		// 비트 연산의 결과를 2진수로 출력하는 메서드 
		// toBinaryString
		/* ==================================================== */
		int x = 0xAB;
		int y = 0xF;
		
		System.out.printf("x = %#X \t\t%s\n", x, toBinaryString(x));
		System.out.printf("y = %#X \t\t%s\n", y, toBinaryString(y));
		
		System.out.printf("%#X | %#X = %#X \t%s\n",x, y, x|y, toBinaryString(x|y));
		System.out.printf("%#X & %#X = %#X \t%s\n",x, y, x&y, toBinaryString(x&y));
		System.out.printf("%#X ^ %#X = %#X \t%s\n",x, y, x^y, toBinaryString(x^y));

		
		
		/* ==================================================== */
		
		// 쉬프트 연산자 << >>
		// 8 << 2 0001000 을 왼쪽으로 2칸 이동 -> 0100000
		// >> 는 부호를 유지하기 위해 음수는 1, 양수는 0을 채운다 
		// 쉬프트 연산의 좌측 피연산자는 산술변환이 적용되어
		// int 보다 작을 경우 int type로 자동변환, 연산결과도 int type 
		// 쉬프트 연산자는 다른 이항연산자와는 달리, 피연산자의 타입을 일치시킬 필요가 없다 
		// 즉 우측 피연산자는 산술변환이 일어나지 않는
		System.out.println();
		System.out.println("x << n은 x * 2^n의 결과와 같다");
		System.out.println("x >> n은 x / 2^n의 결과와 같다");
		
		// int 타입의 32bit의 경우 결국 제자리로 돌아오기 때문에 아무일도 일어나지 않는다
		System.out.printf("x = %#X \t\t%s\n", x, toBinaryString(x));
		System.out.printf("x >> 32 %#X \t\t%s\n", x >> 32, toBinaryString(x >> 32));
		System.out.printf("x << 32 %#X \t\t%s\n", x << 32, toBinaryString(x << 32));
		System.out.println();
		System.out.println("곱셈/ 나눗셈 연산보다 쉬프트 연산 속도가 더 빠르다");
		System.out.println("곱셈/ 나눗셈 연산이 쉬프트 연산 속도보다 가독성이 좋다");
		
		// 각 자리 하나씩 얻기 
		int hex = 0xABCD;
		int mask = 0xF;
		
		System.out.println();
		System.out.printf("hex = %#X\n", hex);
		System.out.printf("%X\n", hex & mask);
		hex = hex >> 4;
		System.out.printf("hex >> 4\n", hex);
		System.out.printf("%X\n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("hex >> 4\n", hex);
		System.out.printf("%X\n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("hex >> 4\n", hex);
		System.out.printf("%X\n", hex & mask);
		
		System.out.println();
		
		
		/* ==================================================== */
		// 삼항 연산자 
		int x1 = 10, y1 = -10, z1 = 0;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		absX = x1 >= 0 ? x1 : -x1;
		absY = y1 >= 0 ? y1 : -y1;
		absZ = z1 >= 0 ? z1 : -z1;
		
		// 중첩 삼항연산자 
		signX = x1 > 0 ? '+' : (x1 == 0 ? ' ' : '-');
		signY = y1 > 0 ? '+' : (y1 == 0 ? ' ' : '-');
		signZ = z1 > 0 ? '+' : (z1 == 0 ? ' ' : '-');
		
		System.out.printf("x = %c%d\n", signX, absX);
		System.out.printf("y = %c%d\n", signY, absY);
		System.out.printf("z = %c%d\n", signZ, absZ);

	}
	// 10진수를 2진수로 만드는 메서
	static String toBinaryString(int x){
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		// Integer 클래스의 toBinaryString -> 10진수를 2진수로 
		return tmp.substring(tmp.length() - 32);
		// 문자열을 자르는 메서드 : str.substring(start) 
		// 문자열.substring(index) -> index 부터 반
		
		// 또다른 문자열 자르는 메서드 참고 : str.substring(start, end)
		
	}
}