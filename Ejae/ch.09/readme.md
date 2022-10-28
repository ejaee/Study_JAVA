# java.lang ��Ű���� ������ Ŭ����

_java.lang ��Ű���� Ŭ�������� import�� ���̵� ����� �� �ִ�_

## Object Ŭ����

### protected Object clone()
-   protected�̹Ƿ� public���� �������̵��� �ʿ��ϴ�

### public boolean equals(Object obj)

- ��ü �ڽ�(this)�� ��ü(obj)�� ��
```java
public boolean equals(Object obj) {
    return (this == obj);
}

Value v1 = new Value(10);
Value v2 = new Value(10);

v1.equals(v2) -> false;
```
_�ּҰ� �������� ��_

[Equals]()


### public Class getClass()

_Class -> class�� ������ ������� Ŭ����_

-   Hello.java�� �������ϸ� Hello.class�� ��������µ�
-   �̶� Hello�� Class�� �����ȴ�
-   �̰��� Hello�� Ŭ���� ������ ����ִ� (���赵 ��ü)
    1.   ���赵 ��ü�� ���� ��ü ������ �����ϴ�
    2.   ��ü�� ���� ������ ���� �� �ִ�
    3.   
   _Reflection API_

## String Ŭ����

 _String Ŭ���� = ������(char[]) + �޼���(���ڿ� ����)_

 - ������ ������ �� ���� �Һ� Ŭ����

### ���ڿ��� ����

```java
String a = "a"; // 0x100�� a�ּҰ� ����Ų��
String b = "b"; // 0x200�� b�ּҰ� ����Ų��
a = a + b;      // 0x300�� a�ּҰ� ����Ų��
```
_���� �����ڸ� �̿��� ���� ������ ������ ������_

���ڿ� �����̳� ������ ��ٸ�, 

������ ���� ������ `StringBuffer`�� ��� 

-> ���� ������ ����

### ���ڿ��� ��

String str1 = "abc"�� String str2 = new String("abc"); �� ��

```java
str1 == str2 // �߸��� ��(�ּҺ�)

str1.equals(str2) // �ùٸ� ��(�����)
```

- ���ڿ� ���ͷ��� ���α׷� ����� �ڵ����� �����ȴ�

    _-> constant pool(��� �����)�� ����_

- ���ڿ� ���ͷ��� String ��ü�̴�
- ���� ������ �Ұ��ϴ�

```java
���� ������ ����,
StringBuffer?sb1?=?new?StringBuffer();

sb1 ��ü�� �����Ͽ� ����
sb1�� ��ü��� ���� �� ��������
```

### �� ���ڿ�

```java
String str = "";
char[] chArr = new char[0];
int iArr = {};
```

�� ���ڿ��� Ȱ��

- ���ڿ� ���ڿ��� �ʱ�ȭ
    ```java
    String s = null;
    String s = ""; // good

    char c = 'u0000';
    char c = ' '; // good

    String str = new String("");
    String str = ""; // good
    ```

### String(char[] value)
_������_

- �־��� ���ڿ��� ������ String �ν��Ͻ��� ����
    ```java
    char[] c = {'H', 'E', 'L', 'L', 'O'};
    String s = new String(c);

    String to char[] -> toCharArray();
    ```

### String(StringBuffer buf)
_������_

- StringBuffer to String
    ```java
    StringBuffer sb = new StringBuffer("HELLO");
    String s = new String(sb);
    ```

### char charAt(int idx)

- ���� 1�� ��ȯ

### int compareTo(String str)

- ���ڿ�(str)�� ���� ������ ��
- ������ 0, �����̸� ����, ���ĸ� ���

    ```java
    "aaa".compareTo("aaa") -> 0;
    "aaa".compareTo("bbb") -> -1;
    "bbb".compareTo("aaa") -> 1;
    ```
    _c's strcmp_

### String concat(String str)

- ���ڿ� �ڿ� �����δ�
    ```java
    s = "abcde";
    s2 = s.concat("fghi");
    ```

### boolean contains(CharSequence s)

- ������ ���ڿ�(s) ���ԵǾ����� �˻��Ѵ�
    ```java
    s = "abcdef"
    s.contains(bc) -> true;
    ```

    charSequence : �������̽�

    -   ������� Ŭ�������� ���踦 �ξ� ���
    -   StringBuffer, StringBulider, String ��� ���� ������ ����
    -   ���� ������ ������ �������� �̿��� �Ű������� ������ ������...
    -   ������ �������̽��� �Ͽ��� ���뼺�� �ο��ؼ� ����Ѵ�

### boolean endsWith(String suffix)

- ������ ���ڿ��� �������� �˻�

    ```java
    String file = "Hello.txt";
    boolean b = file.endsWith("txt") -> true
    ```

### boolean startsWith(String prefix)

  �־��� ���ڿ��� �����ϴ��� �˻�


### boolean equals(Object obj)

- ��ҹ��� �����ϰ� ���ڿ� ��
- obj�� String�� �ƴϸ� false

### boolean equalsIgnoreCase(String str)

- ��ҹ��� ���о��� ���ڿ� ��

### int indexOf(int ch)

- Ư�����ڰ� ���° �ε����� �ִ��� �˷��ش�

    ```java
    String s = "Hello";
    int idx = s.indexOf('o') ->4

    ������ -1�� ��ȯ
    ```

### int indexOf(int ch, int pos)

- pos ��ġ���� Ȯ���Ͽ� ch's index�� Ž��

### int indexOf(String str)

- �־��� ���ڿ��� �����ϴ��� Ž��

    ```java
    String s = "Hello";
    int idx = s.indexOf("el") -> 1
    ```

### int lastIndexOf(int ch)

- ������ ���������� ã�Ƽ� index�� Ž��

### int lastIndexOf(String str)

- ������ ���������� str��ã�Ƽ� index�� Ž��

### int length()

- ���ڿ��� ���̸� ��ȯ

### String[] split(String regex)
- ���ڿ��� ������ �и��ڷ� ������ ���ڿ��� ��� ��ȯ

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

- ���ڿ� ��ü�� ������ ���� �ڸ���

    ```java
    String animal = "dog,cat,bear";
    String[] arr = animal.split(",", 2);
    
    -> arr[0] = "dog";
    -> arr[1] = "cat,bear";
    ```

### String subString(int begin)
### String subString(int begin, int end)

- ������ġ���� ����ġ ������ ���Ե� ���ڿ��� ��´�

### String trim()

- ���ڿ��� ���� ���� ������ �� ������ ���� ����� ��ȯ

    ```java
    String s = "   Hello    World   "
    String s1 = s.trim();

    -> s1 = "Hello    World 
    ```

### valueOf

- �⺻���� String���� ��ȯ

    ```java
    String b = String.valueOf(true); -> b = "true"
    String c = String.valueOf('a'); -> c = "a"
    String i = String.valueOf(100); -> i = "100"
    
    value + "" = "true" �� �����ѵ� ������ valueOf�� �� ����
    ```

    _���� : ������ > ����_

## join()�� StringJoiner

### join()

_���� ���ڿ� ���̿� �����ڸ� �־ ����_
    
```java
String str = "dog,cat,bear";
String[] arr = str.split(",");

string[] arr2 = string.join("-", arr);
str -> "dog-cat-bear"
```

### ���ڸ� ���ڿ��� �ٲٴ� ���

```java
int num = 100;
String str1 = num + ""; -> "100" // ��
String str2 = String.valueOf(num); -> "100" // �ӵ�
```

### ���ڿ��� ���ڷ� �ٲٴ� ���
```java
int i = Integer.parseInt("100");
int i = Integer.valueOf("100");
Integer i = Integer.valueOf("100");
```

## StringBuffer class

_���ڿ��� �����ϰ� �ٷ�� ���� class_

���ڿ��� ������ ������ �����ϴ� ��쿡 ���

- String�� �ٸ��� ������ �����ϴ�

    ```java
    StringBuffer sb = new StringBuffer("abc");
    ```

- ���ڿ� ���̱� .append()

    ```java
    sb.append("de"); -> abcde
    ```

�迭�� ���� ������ �Ұ��ϴ�

StringBuffer�� ������ ���ڿ��� ���̸� ����ؼ� ������ ũ��� ���� �ؾ��Ѵ�

```java
StringBuffer sb = new StringBuffer("abc");
sb.append("abc");
sb.append("123");

sb.append("abc").append("123"); �� ��� ����
```

StringBuffer�� String�� �ٸ��� `equals()`�� �������̵� �Ǿ����� �ʴ�

-> toString���� ��ȯ �� ��



