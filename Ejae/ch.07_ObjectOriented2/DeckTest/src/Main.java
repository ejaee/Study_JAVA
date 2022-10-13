class Card {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    // indexing : 카드의 모양을 배열의 인덱스로 접근할 것임
    // final : 변하지 않으므로 상수화
    // static : 다른 class에서도 사용하므로
    int kind;
    int number;

    Card() {
        this(SPADE, 1);
    }
    //  매개변수를 받지 않을경우 기본 생성자
    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    // 매개변수를 받을 경우 this 값 초기화

    public String toString() {
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK";

        return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
    }
    // toString : 문자열 배열을 인덱스로 접근하여 값을 문자열로 접근
    //            인스턴스 정보를 문자열로 반환할 목적으로 정의
    //
    // charAt : 문자열의 n번째 문자에 접근
}

class Deck {
    final int CARD_NUM = 52;
    Card cardArr[] = new Card[CARD_NUM];
    //   Deck 클래스에서 Card 클래스 재사용 -> 포함관계
    Deck() {
        int i = 0;

        for (int k = Card.KIND_MAX; k > 0; k--) // KIND_MAX = 4
            for (int n = 0; n < Card.NUM_MAX; n++) // NUM_MAX == 13
                cardArr[i++] = new Card(k, n+1);
    }

    Card pick(int index) {
        return cardArr[index];
    }

    Card pick() {
        int index = (int)(Math.random() * CARD_NUM); // cardArr 배열은 0 - 51 이므로
        return pick(index);
    }

    void shuffle() { // 난수생성을 통해 인덱스 값을 받아 swap
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int)(Math.random() * CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Deck d = new Deck();
        // 카드 한 벌 생성
        // cardArr 배열 안에 52개의 카드가 생성
        // pick, shuffle 메서드가 있음
        Card c = d.pick(0);
        // 가장 위의 카드를 뽑기
        // Card class의 반환값을 바로 c에 전달 (사고 배우기)

        d.shuffle();;
        c = d.pick(0);
        // 섞고 맨 위의 카드를 출력
        System.out.println(c);

        /* ------------------------------------------------------------------ */

        // 왜 c를 출력하는데 문자열이 출력되는가?
        // :83 -> System.out.println(c.toString())과 같다 (좀 더 깊게 생각해보기)
        // 참조변수 출력이나 덧셈 연산자를 이용한 참조변수와 문자열의 결합에는
        // toString()이 자동적으로 호출되어 참조변수를 문자열로 대치한 수 처리한다
        // toString()은 모든 클래스의 조상인 Object 클래스에 정의되었으므로
        // 어떤 종류의 객체에 대해서도 toString()을 호출하는 것이 가능하다
    }
}
