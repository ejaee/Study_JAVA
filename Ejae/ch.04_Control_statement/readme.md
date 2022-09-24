## contents

- [input by Java](#**input-by-Java**);
    - [Q1](#Q1);
    - [Q2](#Q2);


# **input by Java**


`Scanner`
```java
java에서 키보드로 입력을 받는 방법 >> Scanner Class

Scanner 객체 생성

Scanner 객체명 = new Scanner(System.in)

> import.java.util.Scanner가 필요
> 프로그램의 class명 윗줄에 필요

```

`System.in`
```java
키보드에서 사용자로부터 키 입력을 받기 위해서 사용된다
```

`Scanner method`
```java

String next() // 입력 값 문자열 타입으로 변환
byte nextByte() // 입력 값 byte 타입으로 변환
short nextShort() // 입력 값 short 타입으로 변환
int nextInt() // 입력 값 int 타입으로 변환
long nextLong() // 입력 값 long 타입으로 변환
float nextFloat() // 입력 값 float 타입으로 변환
double nextDouble() // 입력 값 Double 타입으로 변환
String nextLine() // 입력 받은 라인 전체를 문자열 타입으로 변환 '\n' 포함
```

- Scnaaer는 사용가자 입력하는 값을 공백으로 구분하여 읽는다
  > 공백 (is_space)
- 문자열 입력 후 Enter

## Q1
_issue : 타입 별로 입력 받는 방법_

## 1. 입력을 한 줄로 받을 경우

### int 입력 시

`nextInt` 를 사용

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {

   //int를 입력 받을 때는 nextInt 메서드를 이용한다.
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a+" "+b);
	}
}
```

> input : 10 20
> output : 10 20

### 하나의 char 입력 시

`(char)System.in.read`

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {

		//char를 입력 받을 때는 (char)System.in.read 메서드를 이용한다.
		char ch;
		ch = (char)System.in.read();
		System.out.println(ch);
	}
}
```

> input : A
> output : A

### 여러개의 char 입력 시

`nextLine`

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {

        //char를 여러개 입력 받을 때는 nextLine 메서드를 이용한다.
		char a, b;
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		a = str.charAt(0);
		b = str.charAt(2);
		System.out.println(a+" "+b);
		sc.close();

        }

}
```

> input : A B
> output : A B

`charAt()` ?

```
Scanner에는 char 타입으로는 입력이 불가하고 String 타입으로 입력을 받을 수 있다

일반 사용자가 데이터 입력 시 문자 하나만 입력하는 경우는 드물기 때문인 것으로 추정되는데,

이로인해 char 타입을 사용할 수 없다는 문제가 발생한다

때문에 Scanner에 String 타입으로 입력 받은 후

charAt()를 통해 char 타입 사용을 가능하게 한다

String으로 저장된 문자열 중에 한 글자만 선택해서 char 타입으로 변환

charAt(index_num)을 통해 사용
```

[사용 예시]

```java
String str = new String();

char c = ' ';

str = "안녕하세요";

c = str.charAt(0);

System.out.println(c);
// output : 안
```

[참고 사이트](https://colossus-java-practice.tistory.com/31)

## 2. 입력을 여러 줄로 받을 경우

### int를 받을 경우 두 줄로 입력 받아도 문제 없다

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {

		//int를 받을 경우 두 줄로 입력 받아도 문제가 전혀 업다.
				Scanner sc = new Scanner(System.in);
				int a,b;
				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println(a+" "+b);
				//nextShort, nextLong, nextDouble, nextFloat 등이 있다.
	}
}
```

> input : 10
> input : 20
> output : 10 20

### 문자를 받을 경우 두 줄로 입력 시 문제가 발생한다

_첫 input 이후 엔터를 누르는 순간 \n 값이 두번째 input으로 들어가기 때문_

[문제 발생 코드]

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {
	char a1,b1;
		a1 = (char)System.in.read();
		b1 = (char)System.in.read();
		System.out.println(a1+" "+b1);
		}
}
```

[기대 값]

> input : A
> input : B
> output : A B

[실제 값]

> input : A
> output : A

`nextLine`를 통해 문자 여러 줄을 받는다
```
문자를 한 줄 씩 읽어서 처리하는 메서드
```

`next()` : 

개행 문자를 무시하고 입력 받음, 

즉 엔터를 누를 경우 그 전까지만 입력 받음

`nextLine()` : 

한 줄 단위로 입력 받기 때문에 개행문자도 한 줄로 인식

[개선한 코드]

```java
public class StandardIO {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String str;
		char a, b;
		str = sc.nextLine();
		a = str.charAt(0);
		str = sc.nextLine();
		b = str.charAt(0);
		System.out.println(a+" "+b);

               }
}
```

> input : A
> input : B
> output : A B

## 3. 입력 받을 개수가 가변적인데 그 사이에 공백이 있을 경우

### 공백이 포함된 문자열을 입력받는 경우

[해당 사이트 참조](https://limkydev.tistory.com/170)


## Q2

### new Scanner(System.in)은 한번만

위 글에서 `입력을 여러 줄로 받을 경우`의 `int를 받을 경우 두 줄로 입력 받아도 문제 없다`에 속하는 부분으로,

여러개의 nextInt()로 입력 값을 받아 변환할 수 있는 것 같다.

:ballot_box_with_check: Scanner(System.in) 한번을 통해 nextInt()가 올때마다 입력값을 어떻게 받아오는 걸까?
