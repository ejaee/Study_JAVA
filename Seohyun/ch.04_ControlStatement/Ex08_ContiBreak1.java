public class Ex08_ContiBreak1 {
    //continue, break 사용하기
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            if (i % 3 == 0)  
                continue; //반복문의 현재 단계 중단 (12457810출력)
                //break;  //반복문 전체 중단 (12출력)
            System.out.println(i);
        }
    }
}
