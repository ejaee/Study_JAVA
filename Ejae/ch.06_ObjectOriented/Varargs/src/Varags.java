public class Varags {
    public static void main(String[] args) {

        String[] strArr = {"100", "200", "300"};

        System.out.println(concatenate("-", strArr));
        // system.out.println(concatenate("-", new String[] {"100", "200", "300"})); 가능
        // system.out.println(concatenate("-", {"100", "200", "300"})); 불가능
        // >> 두 오버로딩된 메서드가 구분되지 않아 에러가 발생
        // 가능한 가변인자를 사용한 메서드는 오버로딩 하지 않는것이 좋다

        System.out.println(concatenate(strArr));
    }

    // overloading concatenate
    static String concatenate(String delim, String... args) {
        String result = "";

        for (String str : args)
            result += str + delim;

        return result;
    }

    static String concatenate(String... args) {
        return concatenate ("", args);
    }
}