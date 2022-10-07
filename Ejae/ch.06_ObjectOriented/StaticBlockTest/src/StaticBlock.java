// 클래스 초기화 블럭을 활용하여 약간의 복잡한 초기화 작업 수행하기
class StaticBlock {
    static int[] arr = new int[10];
    // 명시적 초기화를 통해 배열을 생성

    static {
        System.out.println("start static{ }");
        for (int i = 0; i < 10; i++)
            arr[i] = (int)(Math.random() * 10) + 1;
    }
    // 클래스 초기화 블럭을 이용해서 배열 값들을 채우기

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println("arr[" + i + "] = " + arr[i]);
    }
}