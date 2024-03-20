package calculator;

import java.util.Scanner;

public class App {

    static Scanner mcScan = new Scanner(System.in);
    static IntMath mcCalc = new IntMath();
    public static void main(String[] args) {
        System.out.println("===== Calculator =====\n");
        System.out.println("Enter calculator (using string form of operators and separated by spaces): ");
        int a = mcScan.nextInt();
        MathOperator op = MathOperator.valueOf(mcScan.next().toUpperCase().strip());
        int b = mcScan.nextInt();
        System.out.printf("\nResult: %d", mcCalc.calculate(op, a, b));
    }
}
