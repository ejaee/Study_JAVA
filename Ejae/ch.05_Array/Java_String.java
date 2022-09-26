import java.util.Scanner;

import org.w3c.dom.css.CSSImportRule;

class Java_String {
	public static void main(String[] args) {
		String[] name = new String[3]; 
		// String 배열 타입의 선언도 동일하다 
		// 참조형 변수의 기본값은 null이므로 자동 null 초기화된다 
		
		// String 배열의 초기화
		name[0] = "choi";
		name[1] = "e";
		name[2] = "jae";
		
		// 또다른 초기화 방법 
		String[] name2 = new String[] {"choi", "e", "jae"};
		// 생략 가능 
		String[] name3 = {"choi", "e", "jae"};
		// String 은 Class이다?! -> 따라서 원래 이하와 같이 new 연산자로 객체를 생성한다 
		String[] name4 = new String[3];
		name4[0] = new String("choi");
		name4[1] = new String("e");
		name4[2] = new String("jae");
		
		for(int i = 0; i < name4.length; i++)
			System.out.println("name["+i+"]:" + name4[i] );
		// 신박한 표현법 >> "name["+i+"]:" + name4[i]
		// printf로 %를 받아오지 않고 위와같이 표현할 수 있다 
		
		//strjoin이 필요없는 java 
		/* ======================================================= */
		
		char[] hex = {'C', 'A', 'F', 'E'};
//		String hex = "CAFE";
		String[] binary = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111" , "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
		
		String res1 = "";
		for(int i = 0; i < hex.length; i++)
//		for(int i = 0; i < hex.length(); i++)
		{
			if ('0' <= hex[i] && hex[i] <= '9')
//			if ('0' <= hex.charAt(i) && hex.charAt(i) <= '9')
				res1 += binary[hex[i] - '0'];
//				res1 += binary[hex.charAt(i) - '0'];
			else
				res1 += binary[hex[i] - 'A' + 10];
//				res1 += binary[hex.charAt(i) - 'A' + 10];
		}
		
		System.out.println();
		System.out.println("hex : "+ new String(hex));//CAFE
		System.out.println("binary : "+ res1);

		// 무슨 차이인가?
		System.out.println();
		System.out.println("hex : "+ hex);	//[C@73a8dfcc
		System.out.println(hex); 			//CAFE
		System.out.println("binary : "+ res1);		
		System.out.println(res1);		
		char[] charArr1 = {'a', 'b', 'c'};
		System.out.println(charArr1);
		
		// char 배열과 String 클래스 
		// char 배열이 아닌 String클래스를 이용해서 문자열을 처리하는 이유 
		// String 클래스가 char배열에 여러가지 기능을 추가하여 확장한 것 
		// 쉽게말해 String 클래스는 char 배열에 기능(메서드)을 추가한 것 
		// 결론적으로 String 클래스를 사용하는 것이 문자열을 다루기 더 편리함 
		
		// String 클래스의 차이는 String 객체는 읽을 수 있지 내용 변경이 불가함
		String str1 = "Java";
		str1 = str1 + '8'; // 문자열의 내용이 변경되는 것이 아니라 새로운 문자열이 생성되는 것
		System.out.println();
		System.out.println(str1);
		
		// String 클래스의 주요 메서드
		// char charAt(int idx) 문자열에서 해당 위치에 있는 문자를 반환
		// int length() 문자열의 길이를 반환
		// String substring(int from, int to) 문자열 해당 범위에 있는 문자열을 반환
		// boolean equals(Object obj) 문자열의 내용이 obj와 같은지 확인 
		// 		대소문자를 구분하지 않으려면 equalsIgnoreCase()
		// char[] toCharArray() 문자열을 문자배열(char[])로 변환해서 반환 
		
		// char 배열과 String 클래스의 변환
		
		char[] chArr = {'A', 'B', 'C'};
		String str2 = new String(chArr); 	// char[] -> String;
		char[] tmp1 = str1.toCharArray();	// String -> char[]
				
		// Scanner 의 nextline() 외에 커맨드 라인을 통해 입력받기
		System.out.println();
		System.out.println("커맨드 라인으로 입력받기"); 
		// argc, argv 개념 >> args 
		System.out.println("매개변수 개수 구하기 : "+ args.length);
		for (int i = 0; i < args.length; i++)
			System.out.println("args["+i+"] = "+ args[i]);
		
		// args.length 가 0이라고 말하는 것은 배열 길이 0인 배열이 만들어지는 것을 보여주는 것
		// 파라미터로 전달되는 숫자는 문자열이므로 문자열의 숫자를 숫자로 변환하기 위해서는
		int num1 = Integer.parseInt("123"); // num = 123 과 같다
		// c언어에서 atoi의 역할을 대제한다 너무편하네 
		
		// 다차원배열
		int[][] div_2 = new int [4][3];
		int div_22[][] = new int [4][3];
		int[] div_222[] = new int [4][3];
		
		// 초기화
		int[][] arr3 = new int[][] {{1, 2, 3}, {4, 5, 6}};
		int[][] arr4 = {{1, 2, 3}, {4, 5, 6}}; // 생략 가능
		int sum = 0;
		// 향상된 for문을 활용한 배열 구성요소 합 구하는 방법 
		/*
		for (자료형 한 단계 아래의 자료형 변수명 : 배열이나 컬랙션 타입 변수명){
			반복할 문장
		}
		 */
		for (int[] tmp : arr4)
			for (int i : tmp)
				sum += i;
		System.out.println("sum = "+ sum);
		
		// 가변 배열 
		// 마지막 차수 길이를 지정하지 않고 유동적인 가변 배열 구성이 가능 
		int[][] score1 = new int[5][];
		
		// 각 행마다 다른 길이의 배열 생성이 가
		score1[0] = new int[4];
		score1[1] = new int[2];
		score1[2] = new int[2];
		score1[3] = new int[3];
		score1[4] = new int[2];
		
		// 아래의 표현도 가능 
		int[][] score2 = {
				{100, 100, 100, 100}
				, {20, 20, 20}
				, {30, 30}
				, {40, 40}
				, {50, 50, 50}		
		};
		System.out.println();
		/* ============================================== */
		final int SIZE = 10;
		int x = 0, y = 0;
		
		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = {
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{1, 1, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 1, 0}//, 있어도 되네? 
		};
		
		for (int i = 1; i < SIZE; i++)
			board[0][i] = board[i][0] = (char)(i + '0');
		// 동시에 넣을 수 있구나 
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.printf("좌표 입력하시오. (종료는 00)>");
			String input3 = scanner.nextLine(); // 화면 입력받은 내용을 input에 저장
			
			if (input3.length() == 2)
			{
				x = input3.charAt(0) - '0';
				y = input3.charAt(1) - '0';
				
				if (x == 0 && y == 0)
					break;
			}
			
			if (input3.length() != 2 || x<=0 || x >= SIZE || y<=0 || y >= SIZE) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}
			
			board[x][y]= shipBoard[x-1][y-1] == 1 ? 'O' : 'X';
			for (int i = 0; i < SIZE; i++)
				System.out.println(board[i]);
			System.out.println();
		}
		// 뭐가 문제야...! 
		
		
		
		
	}
}