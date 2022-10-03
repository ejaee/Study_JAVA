import java.util.Scanner;

public class Variable {
    public static void main(String[] args) {
        String myname = "seohyun";
        System.out.println("My name is " + myname);

        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String yourname = input.nextLine();
        System.out.println("Ah your name is " + yourname + "!!");

        System.out.println("Then how old are you?");
        int age = Integer.parseInt(input.nextLine());
        System.out.printf("yeah~ %d years old right?", age);
    }
}
