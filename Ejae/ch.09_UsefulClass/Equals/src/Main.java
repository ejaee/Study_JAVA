// equals() 에 대한 학습
// equals를 통해 iv값을 비교하고 싶다면 오버라이딩 해줘야한다
public class Main {

  public static void main(String[] args) {

    Value v1 = new Value(10);
    Value v2 = new Value(10);

    System.out.println(v1.equals(v2)); //true
  }
}

class Value {

  int value; // 원래 이름이 this.value

  Value(int value) {
    this.value = value;
  }
  // 오버라이딩을 통해 주소가 아닌 값을 비교하도록 수정
  public boolean equals(Object obj) {
//    return this == obj; 주소비교
    if (!(obj instanceof Value)) { // instanceof -> obj 객체가 Value 클래스 타입인가?
      return false;
    }
//    Value v = (Value) obj; obj는 Value 자료형이 아니므로 캐스팅
//    return this.value == ((Value)obj).value; // 괄호에 주의
    return value == ((Value)obj).value; // this 생략이 가능. value와 가까운게 뭔지 생각해보면 쉽다
    // 인스턴스변수와 가까운 매개변수에 지역변수 value가 없으니까 this.value == value
  }
}
