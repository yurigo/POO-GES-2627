import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido al programa de cálculo de IMC");

        System.out.println("Ingresa tu peso en kilogramos:");
        Scanner sc = new Scanner(System.in);
        int peso = sc.nextInt();

        System.out.println("Ingresa tu altura en metros:");
        float altura = sc.nextFloat();

        Person person = new Person(peso, altura);

        IMCCalculator calculator = new IMCCalculator();
        float imc = calculator.calculate(person);

        System.out.println("Tu IMC es: " + imc);
        String classification = calculator.classify(imc);
        System.out.println("Clasificación: " + classification);

    }
}
