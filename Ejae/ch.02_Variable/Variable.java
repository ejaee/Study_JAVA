import java.util.Scanner;

class Variable { 
	public static void main(String[] args) {
		final int CONSTANT_A = 5;	// final을 통해 변수 선언

		System.out.println("final int constant_a:"+CONSTANT_A);
		
		int octNum = 10;
		int hexNum = 0x10;
		int binNum = 0b0;
		
		long big1 = 100000000000L;
		long big2 = 100_000_000_000L;
		
		long hex1 = 0xFFFFFFFFFFFFFFFFL;
		long hex2 = 0xFFFF_FFFF_FFFF_FFFFL;
		
		float pi = 3.14f;
		double rate1 = 1.618d;
		double rate2 = 1.618;
	
		char ch = 'a';
		String name1 = "Java"; // String type
		// String은 class이다 
		// 일반적으로는 객체를 생성하는 연산자 new와 함께 사용된다
		String name2 = new String("Java"); // String 객체 생성
		
		String name3 = "Ja" + "va";
		// String(name4) + non_string(2.0) -> casting to string 
		String name4 = name3 + 2.0; 
		// 방법 : 7 + "" 를 통해 casting이 가능 
		
		/* ============================================ */
		
		// 2.3 print
		
		System.out.println("println : 값을 그대로 출력" ); // 자동 '\n' 
		System.out.printf("printf : 값 변환이 가능\n"); // like C lang 
		
		// 정수를 2진 문자열로변환 Integet.toBinaryString(binNum)
		System.out.printf("정수를 2진 문자열로 변환 %s", Integer.toBinaryString(3));
		
		
		// 2.4 Scanner
		// 화면에서 입력받기... import java.util.*; 필요
		
		// 클래스 객체 생성 
		Scanner scanner = new Scanner(System.in);
		// nextLine() 입력대기 상태에 있다가 Enter를 누르면 입력 내용이 문자열로 변환 
		System.out.print("정수를 입력하시오.>");
		String input = scanner.nextLine(); // 입력받은 내용을 input에 저장 
		int num = Integer.parseInt(input); // 입력받은 내용을 int 타입 값으로 변환 
		// int num = scanner.nextInt();를 통해 정수를 입력받아 바로 저장 가능
		// 여러 번 입력받을 경우에는 부적절 
		
		System.out.println("input = " + input);
		System.out.printf("num = %d\n", num);
		// 숫자가 아닌 문자를 입력한다면 변환과정 Integer.parseInt()에서 Error 

	} 
}