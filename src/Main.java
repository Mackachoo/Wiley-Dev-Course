import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);
        int n;

        // Checks for correct n
        do {
        System.out.println("What number would you like to factor? ");
        n = mcScan.nextInt();
        } while(n <= 0);

        // Finds Factors
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        // Prints Results
        System.out.println("The factors of "+ n +" are:");
        for (Integer factor: factors) {
            System.out.print(factor + " ");
        }
        System.out.println("\n"+n +" has "+ (factors.size()) +" factors.");
        System.out.println(n +" is "+ ((sumList(factors) == n) ? "" : "not ") +"a perfect number.");
        System.out.println(n +" is "+ ((factors.size() == 2) ? "" : "not ") +"a prime number.");

    }

    static int sumList(List<Integer> nums) {
        int result = 0;
        for (int num: nums) {
            result += num;
        }
        return result;
    }
}