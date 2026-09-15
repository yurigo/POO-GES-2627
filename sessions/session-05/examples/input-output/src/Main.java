import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Welcome to the Java program.");
        System.out.println("");
        System.out.println("");
//        System.out.println("xxxx");
//        System.out.println(345 + "\n" +678);

        Scanner sc = new Scanner(System.in);

        System.out.print("Cuántos años tienes?");

        String variable = sc.next();
        int variable = sc.nextInt();
        Integer sadf = 56;

        System.out.println("Tienes " + variable + " años.");
    }



}
