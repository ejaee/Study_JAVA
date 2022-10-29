# java.lang 패키지와 유용한 클래스

_java.lang 패키지의 클래스들은 import문 없이도 사용할 수 있다_

## Object 클래스

### protected Object clone()
-   protected이므로 public으로 오버라이딩이 필요하다

### public boolean equals(Object obj)

- 객체 자신(this)과 객체(obj)를 비교
```java
public boolean equals(Object obj) {
    return (this == obj);
}

Value v1 = new Value(10);
Value v2 = new Value(10);

v1.equals(v2) -> false;
```
_주소가 같을때만 참_

[Equals]()


### public Class getClass()

_Class -> class의 정보를 담기위한 클래스_

-   Hello.java를 컴파일하면 Hello.class가 만들어지는데
-   이때 Hello의 Class가 생성된다
-   이곳에 Hello의 클래스 정보를 담고있다 (설계도 객체)
    1.   설계도 객체를 동해 객체 생성이 가능하다
    2.   객체애 대한 정보를 얻을 수 있다
    3.   
   _Reflection API_

## String 클래스

 _String 클래스 = 데이터(char[]) + 메서드(문자열 관련)_

 - 내용을 변경할 수 없는 불변 클래스

### 문자열의 변경

```java
String a = "a"; // 0x100를 a주소가 가리킨다
String b = "b"; // 0x200를 b주소가 가리킨다
a = a + b;      // 0x300를 a주소가 가리킨다
```
_덧셈 연산자를 이용한 문자 결합은 성능이 떨어짐_

문자열 결합이나 변경이 잦다면, 

내용이 변경 가능한 `StringBuffer`를 사용 

-> 내용 변경이 가능

### 문자열의 비교

String str1 = "abc"와 String str2 = new String("abc"); 의 비교

```java
str1 == str2 // 잘못된 비교(주소비교)

str1.equals(str2) // 올바른 비교(내용비교)
```

- 문자열 리터럴은 프로그램 실행시 자동으로 생성된다

    _-> constant pool(상수 저장소)에 저장_

- 문자열 리터럴도 String 객체이다
- 내용 변경이 불가하다

```java
내용 변경을 위해,
StringBuffer?sb1?=?new?StringBuffer();

sb1 객체를 생성하여 관리
sb1은 객체라는 점을 잘 생각하자
```

### 빈 문자열

```java
String str = "";
char[] chArr = new char[0];
int iArr = {};
```

빈 문자열의 활용

- 문자와 문자열의 초기화
    ```java
    String s = null;
    String s = ""; // good

    char c = 'u0000';
    char c = ' '; // good

    String str = new String("");
    String str = ""; // good
    ```

### String(char[] value)
_생성자_

- 주어진 문자열을 가지는 String 인스턴스를 생성
    ```java
    char[] c = {'H', 'E', 'L', 'L', 'O'};
    String s = new String(c);

    String to char[] -> toCharArray();
    ```

### String(StringBuffer buf)
_생성자_

- StringBuffer to String
    ```java
    StringBuffer sb = new StringBuffer("HELLO");
    String s = new String(sb);
    ```

### char charAt(int idx)

- 문자 1개 반환

### int compareTo(String str)

- 문자열(str)과 사전 순서로 비교
- 같으면 0, 이전이면 음수, 이후면 양수

    ```java
    "aaa".compareTo("aaa") -> 0;
    "aaa".compareTo("bbb") -> -1;
    "bbb".compareTo("aaa") -> 1;
    ```
    _c's strcmp_

### String concat(String str)

- 문자열 뒤에 덧붙인다
    ```java
    s = "abcde";
    s2 = s.concat("fghi");
    ```

### boolean contains(CharSequence s)

- 지정된 문자열(s) 포함되었는지 검사한다
    ```java
    s = "abcdef"
    s.contains(bc) -> true;
    ```

    charSequence : 인터페이스

    -   관계없는 클래스들을 관계를 맺어 사용
    -   StringBuffer, StringBulider, String 모두 공통 조상이 없다
    -   공통 조상이 있으면 다형성을 이용해 매개변수를 받으면 되지만...
    -   없으로 인터페이스로 하여금 공통성을 부여해서 사용한다

### boolean endsWith(String suffix)

- 지정된 문자열로 끝나는지 검사

    ```java
    String file = "Hello.txt";
    boolean b = file.endsWith("txt") -> true
    ```

### boolean startsWith(String prefix)

  주어진 문자열로 시작하는지 검사


### boolean equals(Object obj)

- 대소문자 구분하고 문자열 비교
- obj가 String이 아니면 false

### boolean equalsIgnoreCase(String str)

- 대소문자 구분없이 문자열 비교

### int indexOf(int ch)

- 특정문자가 몇번째 인덱스에 있는지 알려준다

    ```java
    String s = "Hello";
    int idx = s.indexOf('o') ->4

    없으면 -1을 반환
    ```

### int indexOf(int ch, int pos)

- pos 위치부터 확인하여 ch's index를 탐색

### int indexOf(String str)

- 주어진 문자열이 존재하는지 탐색

    ```java
    String s = "Hello";
    int idx = s.indexOf("el") -> 1
    ```

### int lastIndexOf(int ch)

- 오른쪽 끝에서부터 찾아서 index를 탐색

### int lastIndexOf(String str)

- 오른쪽 끝에서부터 str를찾아서 index를 탐색

### int length()

- 문자열의 길이를 반환

### String[] split(String regex)
- 문자열을 지정된 분리자로 나누어 문자열을 담아 반환

    ```java
    String animal = "dog,cat,bear";
    String[] arr = animal.split(",");

    -> arr[0] = "dog";
    -> arr[1] = "cat";
    -> arr[2] = "bear";
    ```
    _c's char **split_

    _regular expression_

### String[] split(String regex, int limit)

- 문자열 전체를 지정된 수로 자른다

    ```java
    String animal = "dog,cat,bear";
    String[] arr = animal.split(",", 2);
    
    -> arr[0] = "dog";
    -> arr[1] = "cat,bear";
    ```

### String subString(int begin)
### String subString(int begin, int end)

- 시작위치부터 끝위치 범위에 포함된 문자열을 얻는다

### String trim()

- 문자열의 왼쪽 끝과 오른쪽 끝 공백을 없앤 결과를 반환

    ```java
    String s = "   Hello    World   "
    String s1 = s.trim();

    -> s1 = "Hello    World 
    ```

### valueOf

- 기본형을 String으로 변환

    ```java
    String b = String.valueOf(true); -> b = "true"
    String c = String.valueOf('a'); -> c = "a"
    String i = String.valueOf(100); -> i = "100"
    
    value + "" = "true" 도 가능한데 성능이 valueOf가 더 좋다
    ```

    _참고 : 가독성 > 성능_

## join()과 StringJoiner

### join()

_여러 문자열 사이에 구분자를 넣어서 결합_
    
```java
String str = "dog,cat,bear";
String[] arr = str.split(",");

string[] arr2 = string.join("-", arr);
str -> "dog-cat-bear"
```

### 숫자를 문자열로 바꾸는 방법

```java
int num = 100;
String str1 = num + ""; -> "100" // 편리
String str2 = String.valueOf(num); -> "100" // 속도
```

### 문자열을 숫자로 바꾸는 방법
```java
int i = Integer.parseInt("100");
int i = Integer.valueOf("100");
Integer i = Integer.valueOf("100");
```

## StringBuffer class

_문자열을 저장하고 다루기 위한 class_

문자열을 가지고 조작을 많이하는 경우에 사용

- String과 다르게 수정이 가능하다

    ```java
    StringBuffer sb = new StringBuffer("abc");
    ```

- 문자열 붙이기 .append()

    ```java
    sb.append("de"); -> abcde
    ```

배열은 길이 변경이 불가하다

StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성 해야한다

```java
StringBuffer sb = new StringBuffer("abc");
sb.append("abc");
sb.append("123");

sb.append("abc").append("123"); 로 사용 가능
```

StringBuffer는 String과 다르게 `equals()`가 오버라이딩 되어있지 않다

-> toString으로 변환 후 비교



