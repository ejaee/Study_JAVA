public class Ex02_ArrCopy {
    public static void main(String[] args) {
        char[] abc = { 'A', 'B', 'C', 'D'};
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc); //char형이니까 값이 잘 출력됨.
		System.out.println(num);

        //abc+num 배열 만들기
        char[] result = new char[abc.length + num.length];
        System.out.println(result); //''
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.out.println(result); //'ABCD'
        System.arraycopy(num, 0, result, abc.length, num.length);
        System.out.println(result); //'ABCD0123456789'

        //num에 abc복사
        System.arraycopy(abc, 0,  num, 0, abc.length);
        System.out.println(num); //'ABCD456789'

        //num에 장난치기
        System.arraycopy(num, 5, num, 6, 4);
        System.out.println(num);
    }
}
