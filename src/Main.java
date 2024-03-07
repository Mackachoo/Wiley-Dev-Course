import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);

        // Input Retrieval
        System.out.print("How much do you want to invest? ");
        double initialInvestment = mcScan.nextDouble();
        System.out.print("How many years are investing? ");
        int yearsInvesting = mcScan.nextInt();
        System.out.print("What is the annual interest rate % growth? ");
        float interest = 1 + mcScan.nextFloat()/100f;

        // Compound Period Input Retrieval
        System.out.println("What period does the interest compound?");
        System.out.println("a) Daily\t\t\tc) Quarterly\nb) Monthly\t\t\td) Yearly");
        String choice = mcScan.next();
        int compoundMultiplier = 4; // Default is quarterly
        switch (choice) {
            case "a":
                compoundMultiplier = 365;
                break;
            case "b":
                compoundMultiplier = 12;
                break;
            case "d":
                compoundMultiplier = 1;
                break;
        }

        // Calculation per Year
        System.out.println("\nCalculating...\n");
        for (int i = 1; i <= yearsInvesting; i++) {
            double start = initialInvestment*Math.pow(interest / compoundMultiplier, (i-1) * compoundMultiplier);
            double end = initialInvestment*Math.pow(interest / compoundMultiplier, i * compoundMultiplier);

            System.out.println("Year "+ i +":");
            System.out.format("Began with $%.2f", start);
            System.out.format("\nEarned $%.2f", (end-start));
            System.out.format("\nEnded with $%.2f", end);
            System.out.println("\n");
        }

   }
}