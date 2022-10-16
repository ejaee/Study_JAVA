# :computer: IntelliJ

## 단축키

프로젝트 창 포커스

- `cmd + 1`

프로젝트 창에서 에디터 창으로 포커스

- `ESC`

프로젝트 창 미리보기

- `Space`

에디터 창 키우기

- `shift + fn(cmd) + F12`

에디터 창 이동

- `ctrl + tab`

새 파일 생성

- `ctrl + opt + N` by editor
- `cnd + N` by project

커서 이동

- 단어 별 이동 : `opt + 이동` 
- 라인 시작/ 끝 이동 : `fn + 이동`
- 페이지 위/ 아래 : `fn + 이동`

선택 확장/ 축소

- `opt + 위/ 아래`

주석 처리

- // : `cmd + /`
- /* : `opt + cmd + /`

인덴트

- 인덴트 :`tab`
- 인덴트 취소 : `shift + tab`

자동 인덴트 (?)

- `ctrl + opt + I` (?)
- `cmd + A` 키를 통해 전체 선택 후 적용

사용처 찾기

- 찾기 : `cmd + 마우스 클릭`
- 찾기 : `opt + F7` (?)
- 빠른 찾기 : `cmd + B`

## 검색

파일 검색

- 찾기 : `cmd + F`
- 찾은 결과 이동 : `cmd + G`

경로 내 검색

- `cmd + shift + F`

전체 검색

- `shift 2번`
- 인텔리제이 기능 찾을 때 주로 검색

최근 파일 열기

- `cmd + E`

## 편리 기능

Live template

- `cmd + J` 를 통해 확인이 가능
- `psvm`
- `sout`

퀵픽스

- 에러가 난 부분에서 `opt + Enter`
- 에러 수정 (ex. import)

ERROR 코드 이슈별로 이동

- `F2`/ `shift + F2`

Import 최적화

- `ctrl + opt + O`
- 더이상 쓰이지 않는 import를 회색 라인으로 보여주느데
- 해당 import를 자동 삭제

코드 생성

- `cmd + N`
- 마우스 우클릭 generate
- getter and setter -> 변수 선택

메소드 자동완성

- override : `ctrl + O`
- implement : `ctrl + I`
- 상속 후 사용

터미널 창

- `opt + F12` (?)

구문 완성 기능

- `shift + cmd + Enter`

대체하기

- 패일 내 대체 : `cmd + R`
- 경로 내 대체 : `cmd + shift + R`

Run anything

- `ctrl 2번`

실행

- 에디터 실행 : `ctrl + R`
- 실행 : `ctrl + shift + R`

종료

- `cmd + F2`

라인 수정

- 복사 : `cmd + `D
- 삭제 : `cmd +delete`

파라미터 정보

- `cmd + P`

Quick Definition

- `opt + space`
- 선언부 미리보기

Quick Definition

- `F1`
- 어떤 메소드인지 설명만 보고싶을 때

기능 찾기

- `shift + cmd + A`

주요 단축키

- Help -> Keymap Reference

## 응용

1. 테스트 코드

    생성

    - `opt + Enter`

    테스트 코드로 이동

    - `shift + cmd + T`
    - 한번 더 누르면 복귀

    선택된 테스트 실행

    - `ctrl + shift + R`
    - 정지: `cmd + F2`

2. 리펙토링

    클래스 이동

    - `F6`

    타입 변경

    - `shift _ cmd _F6`

    시그니처 변경

    - `cmd + F6`
    - 메소드의 시그니처는 메소드의 반환값, 타입, 파라미터, 파라미터 타입등 메소드를 정의할 수 있는 요소들을 말한다
    - 한 클래스에서 동일한 메서드를 작성하는 것은 불가능 하지만
    - 오버로딩할 때 메소드명이 같아도 되는 이유는 메소드 시그니처가 다르기 때문이다

    이름 변경

    - `shift + F6`

    `ctrl + T`를 통해 리펙토링 기능들을 확인할 수 있다

3. 디버깅

    브레이크 포인트 설정

    - `cmd + F8`
    - 라인 숫자 옆에 마우스로 클릭해서 빨간 동그라미를 만들어도 된다

    브레이크 포인트 보기

    - `cmd + shift + F8`

    디버깅 모드 실행

    - `ctrl + D`
    - 에디터 실행 : `ctrl + shift + D`

    실행 라인 이동/ 다음 라인 이동

    - `F7`
    - step into (실행 라인 이동) : 메서드 안으로 이동
    - step over (다음 라인 이동) : 줄 이동

    Resume Program

    - `cmd + opt + R`
    - 다음 bp로 바로 이동하고 싶은 경우/ 끝까지 이동하고 싶은 경우

4. Git

    사용할 수 있는 Git 기능 확인

    - `ctrl + V`

5. 커스텀 단축키 활용

    shift x 2 -> Keymap에서 설정이 가능

    ex)

    whidow -> editor Tabs -> Split Right의 키를 만들 수 있다






