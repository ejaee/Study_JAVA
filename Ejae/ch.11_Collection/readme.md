# 컬렉션 프레임웍 (collection framework)

### 컬렉션

- 여러 객체를 모아 놓은 것

### 프레임웍

- 표준화, 정형화된 체계적인 프로그래밍 방식

### 컬렉션 프레임웍

- 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식

    객체(데이터)를 다룬다 : 저장, 삭제, 검색, 정렬...

### 컬렉션 클래스

- 다수의 데이터를 저장할 수 있는 클래스

    Vector, ArratLis, HashSet...

## 컬렉션 프레임웍의 핵심 인터페이스

1. List

- 순서가 있다
- 중복을 허용한다
- ex) 대기자 명단


2. Set

- 집합
- 순서가 없다
- 중복을 허용하지 않는다
- ex) 양의 정수집합, 소수의 집합


3. Map

- 키와 값의 쌍으로 이루어진 데이터의 집합
- ex) id-passwd, 02-서울
- 저장 순서가 없다
- 키는 중복 허용 안한다
- 값은 중복 허용 한다

List와 Set의 공통부분을 뽑아서 컬렉션 interface를 정의했다

## ArrayList

List 인터페이스를 구현하므로 저장 순서가 유지되고 중복을 허용한다

데이터의 저장공간으로 배열을 사용한다

배열 안에는 객체(Object)가 저장된다

## ArrayList의 메서드

생성자

- ArrayList()
- ArrayList(Collection c)
  - c 컬렉션을 ArrayList 로 변환
- ArrayList(int initialCapacity)
  - 배열의 크기를 설정


### add

- add(Object o)
  - 객체를 List에 저장한다

- add(int index, Object element)
  - 특정 index에 element 객체를 저장한다

- addAll(Collection c)
  - c 컬렉션이 가지는 요소를 그대로 저장한다

- addAll(int index, Object element)
  - 위치를 지정할 수 있다

### remove

- remove(Object o)
  - 특정 객체를 삭제한다

- remove(int index)
  - 특정 위치의 객체를 저장할 수 있다
  - 헷갈리는 사항
    ```java
    autoBoxing을 조심하자

    list1.indexOf(new integer(1));
    숫자 1의 index 번호를 반환한다
    list1.indexOf(1);
    숫자 1의 index 번호를 반환한다(autoBoxing o)

    remove(new Integer(1))
    숫자 1을 배열에서 삭제한다
    remove(1)
    index 1번째 값을 지운다(autoBoxing x)
    ```

- removeAll(Collection c)
  - 컬렉션 내의 객체를 모두 삭제한다

- clear()
  - ArrayList 내에 존재하는 모든 객체를 삭제한다


- list1.retainAll(list2)
    - list2 와 곂치는 부분만 남기고 나머지는 삭제한다
    ```java
    list1: [1, 0, 2, 3, 4, 5]
    list2: [0, 2, 4, AA, B, C]

    list1.retainAll(list2)

    list1: [0, 2, 4]
    ```

### indexOf

- indexOf(Object o)
  - 객체의 위치를 반환, 없으면 -1 을 반환한다
  - autoBoxing 이 가능하다
    ```java
    list1.indexOf(new integer(1));

    list1.indexOf(1);
    ```

- lastIndexOf(Object o)
  - 뒤에서부터 찾는다

- contains(Object o)
  - 객체가 포함되었는지 확인한다
    ```java
    list1.containsAll(list2)

    -> list1 이 list2 의 모든 요소를 가지고 있는가
    ```
- get(int index)
  - 값을 얻고 싶을경우 사용한다

- set(int index, Object element)
  - index 위치의 객체를 element로 수정한다

indexOf 만 보면 값을 가져온다고 헷갈릴 수 있는데

Property, getter setter 를 생각해보자

### etc

- subList(int fromIndex, int tolndex)
  - from <= < to 객체들을 뽑아와 새로운 arrayList를 만든다
  - 이때 생성되는 List는 읽기 전용이므로 값을 저장하기 위해서는 따로 new 를 해줘야한다
    ```java
    ArrayLisy list = new ArrayList(list.subList(1, 4));
    ```
- toArray()
  - ArrayList가 가지고 있는 객체 배열을 반환한다

- toArray(Object[] a)

- isEmpty()
  - 비어있는지 확인한다

- trimToSize()
  - 빈 공간을 제거한다

- size()
  - ArrayList에 저장된 객체의 개수를 반환한다


## ArrayList 에 저장된 객체의 삭제 과정

1. remove(index)
2. [index] = [idex + 1] 붙여넣기
3. [size-1] = null
4. size--

삽입은 index + 1 씩 붙여넣고 

index 자리에 값을 추가한다

_붙여넣는 과정에서 많은 작업이 발생한다_

- 흔히 실수하는 경우: 앞에서부터 삭제한다

    ```java
    for (int i = 0; i < list.size; i++) {
        list.remove(i);
    }
    ```

- 올바른 삭제: 맨 뒤에서부터 삭제한다

    ```java
    for (int i = list.size() - 1; i >= 0; i--) {
        list.remove(i);
    }
    ```
    붙여넣기도 발생하지 않기 때문에 성능도 좋다

    






## HashMap

_map 인터페이스 구현_

데이터를 키와 값의 쌍으로 저장

- 순서 없다
- 키는 중복 허용하지 않는다
- 값은 중복 허용한다

Hashtable은 옛날 버전(동기화가 되어있음)

순서를 유지해야하는 경우 `LinkedHashMap` 클래스 사용

### HashMap의 키와 값

`해싱 기법`으로 데이터를 저장

데이터가 많아도 `검색이 빠르다`

```java
HashMap map = new Hashmap();
map.put("Id_1", "123");
map.put("Id_2", "456");
map.put("Id_2", "789");

[저장 상태]

Id_1 | 123 -> entry
Id_2 | 789
```

### 해싱

어떤 키값을 주면 해당 배열의 인덱스를 알려준다

즉 키를 받아 저장위치(해쉬코드)를 알려준다

즉 해쉬함수를 이용해서 데이터를 저장하고 읽어오는 것

다시말해 `해시함수`로 `해시테이블`에 데이터를 `저장`, `검색`

`해시테이블`은 `배열`과 `링크드리스트`가 조합된 형태

- 배열 : 접근성
- 링크드리스트 : 변경에 유리



## 주요 메서드

### Object put(Object key, Object value)

- key와 value를 저장

### void putAll(Map m)

- m을 모두 저장

### Object remove(Object key)

- key 삭제

### Object replace(Object key, Object value)

- 기존에 저장된 key에 새로운 값을 저장

### Set entrySet()

- entry 쌍들로 이루어진 Set을 얻을 수 있음

### Set keySet()

- key값만 가져옴

### Collection values()

- value값만 가져옴

### Object get(Object key)

- key값을 넣으면 해당하는 값을 가져옴

### Object getOrDefault(Object key, Object defaultValue)

- 없는 key을 넣었을때 두번째 매개변수가 반환됨

### boolean containsKey(Object key)

- 해당 key가 있는지 확인

### boolean containsValue(Object Value)

- 해당 value가 있는지 확인

