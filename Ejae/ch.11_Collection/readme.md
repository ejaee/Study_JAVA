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

