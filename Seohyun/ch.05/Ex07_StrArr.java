public class Ex07_StrArr {
    public static void main(String[] args) {
        String[] names = {"kang", "ji", "ye"};

        for (int i = 0; i < names.length; i++) {
            System.out.println("names: " + names[i]);
        }

        names[1] = "seo";
        names[2] = "hyun";

        //향상된 for문
        for (String str : names)
            System.out.println("new names: " + str);
    }
}
