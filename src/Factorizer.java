import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factorizer {

    Scanner mcScan = new Scanner(System.in);
    int n;
    List<Integer> factors;

    public Factorizer(){
        getN();
    }

    // Checks for correct n
    public void getN(){
            do {
            System.out.println("What number would you like to factor? ");
            n = mcScan.nextInt();
        } while(n <= 0);
    }

    // Finds Factors
    public void findFactors() {
        factors = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
    }

    // Prints Results
    public void printResults(){
            System.out.println("The factors of "+ n +" are:");
            for (Integer factor: factors) {
            System.out.print(factor + " ");
        }
            System.out.println("\n"+n +" has "+ (factors.size()) +" factors.");
            System.out.println(n +" is "+ ((factors.stream().reduce(0, Integer::sum) == n) ? "" : "not ") +
                    "a perfect number.");
            System.out.println(n +" is "+ ((factors.size() == 2) ? "" : "not ") +"a prime number.");

    }

}
