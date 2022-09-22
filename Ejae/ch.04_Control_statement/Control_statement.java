import java.nio.channels.NonWritableChannelException;
import java.util.*;

class Control_statement {
	
	// switch 일반적인 형태
	
	/*

	switch (정수 또는 문자열) {
		case value1 : 

			break;
		case value2 : 

			break;
		case value3 : 

			break;
		default :  // like case

	 */

	/* 조건문과 case의 조건들

	level = 2;
	const_case_4 = 4;
	case_5 = 4;
	
	switch (level) {
		case 3(정수 상수만 가능) : 

			삭제 권한 부여;
		case 2 : 

			쓰기 권한 부여;
		case 1 : 

			읽기 권한 부여;
		case const_case_4(상수로, 가능) : 

	//	case case_5(변수이므로 불가) :
			...


	=> 쓰기와 읽기 권한이 부여된다
	 
	 */

	/* 연속적인 사용이 가능
	
	switch (month)	{
	
		case 3:
		case 4:
		case 5:
			System.out.println("spring.");
			break;
		case 6:
		
		...
		
	}
	
	 */

	/*	난수 생성기를 활용한 가위 바위 보 게임
	
	난수생성 Math.random() // 0.0 <=, < 1.0 사이의 범위에 속하는 double 값을 반환
	Math.random() * 3 + 1 => 1 <= < 4 의 값을 얻을 수 있음 
	 
	 */
	
}

class Ex01	{
	public static void main (String[] args)	{
		
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력.>");
		
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		int com = (int)(Math.random() * 3) + 1; // 난수 생성
		String input_str;
		String com_str;
		
		if (user == 1)
			input_str = "가위";
		else if (user == 2)
			input_str = "바위";
		else
			input_str = "보";
		if (com == 1)
			com_str = "가위";
		else if (com == 2)
			com_str = "바위";
		else
			com_str = "보";
		
		System.out.println("당신은 " + input_str + " 입니다.");
		System.out.println("저는 " + com_str + " 입니다.");
		
		switch(user - com)	{
			case 2: case -1:
				System.out.println("당신이 졌습니다.");
				break;
			case 1: case -2:
				System.out.println("당신이 이습니다.");
				break;
			case 0:
				System.out.println("비겼습니다.");
			//	break; 생략가능
		}
		
		/* 문자열에 인덱스로 접근하여 char를 받아오는 메서드 
		
		String number = "12345";
		
		number.charAt(4); // 4번째 인덱스 '5'를 나타냄  
		
		 */
		
		// for (;;){ ... } for문 무한 반복문
			
		/* 향상된 for문
		
		for(타입 변수명 :  배열 또는 컬렉션 타입) {
			//	반복할 문장 
		}
		 
		 */
		
		System.out.println("\nex) 향상된 for문");
		
		int[] arr = {10, 20, 30, 40, 50};
		
		for (int tmp : arr)
			System.out.println(tmp);
		// == for (i = 0; i < arr.length; i++)
		
		System.out.println("\nex) 0이 입력될 때 까지 받고 싶다면");
		
		int nb1;
		int sum2 = 0;
		boolean flag = true;
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("숫자 입력하기 (끝내려면 0 입력)");
		while (flag)	{
			System.out.println(">>");
			
			String tmp_str = scanner2.nextLine();
			nb1 = Integer.parseInt(tmp_str);
			
			if (nb1 != 0) { // if (!nb1) 이 안된다?!
				sum2 += nb1;
			}
			else {
				flag = false;
			}
		}
		System.out.println("합계: " + sum2);

		/* do - while문
		
		do {
			// 조건식의 연산결과가 참일 때 수행될 문장들을 적음 
		} while (조건식);
		>> 최소 한번 실행
		>> 맞을 때까지 반복
		 
		 */
		
		System.out.println("\nex) 난수생성기에 의한 수를 맞출 때까지 입력");
		
		int input3 = 0, answer3 = 0;
		
		answer3 = (int)(Math.random() * 100) + 1;
		Scanner scanner3 = new Scanner(System.in);
		
		do {
			System.out.print("1과 100 사이의 정수를 입력하시오.>");
			input3 = scanner3.nextInt();
			
			if(input3 > answer3) {
				System.out.println("더 작은 수 입니다.");
			} else if(input3 < answer3) {
				System.out.println("더 큰 수 입니다.");
			}
		} while (input3 != answer3);
		
		System.out.println("정답입니다.");
	
		// 2-6 이름붙은 반복문
	
		Loop1 : for (int idx = 2; idx <= 9; idx++)	{
				for(int jdx = 1; jdx <= 9; jdx++)	{
					if (jdx == 5)
						break Loop1; 	// Loop1 for문 밖으로 이동 
					//	break; 			// System.out.println();로 이동 
					//	continue Loop1; // Loop1 for문 밖으로 이동
					//	continue;		// System.out.println();로 이동
					System.out.println(idx + "*" + jdx + " = " + idx*jdx);
			}
			System.out.println();
		}
	
	}
}
	
	