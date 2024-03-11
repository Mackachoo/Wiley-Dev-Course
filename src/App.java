import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("=================================");
        System.out.println("=       Simple Calculator       =");
        System.out.print("=================================");

        while (true) {
            try {
                System.out.println("\n\nEnter RPN statement:");
                String input = mcScan.nextLine();
                Double result = calc.rpnCalc(input);
                if (result != null) {
                    System.out.printf("Result: %.2f", result);
                } else {
                    System.out.println("Calculation Error...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Stopping Calculator...");
                break;
            }
            }
    }


}
