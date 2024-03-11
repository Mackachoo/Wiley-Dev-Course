import java.util.Scanner;

public class InterestCalculator {
    Scanner mcScan = new Scanner(System.in);
    double initialInvestment;
    int yearsInvesting;
    int compoundMultiplier;
    float interest;

    public InterestCalculator() {
        getInputs();
        // Calculation per Year
        System.out.println("\nCalculating...\n");
        for (int i = 1; i <= yearsInvesting; i++) {
            calculateYear(i);
        }

    }

    public void calculateYear(int year) {
        // Calculation per Year
        double start = initialInvestment*Math.pow(interest, (year-1) * compoundMultiplier);
        double end = initialInvestment*Math.pow(interest, year * compoundMultiplier);

        System.out.println("Year "+ year +":");
        System.out.format("Began with $%.2f", start);
        System.out.format("\nEarned $%.2f", (end-start));
        System.out.format("\nEnded with $%.2f", end);
        System.out.println("\n");
    }

    public void getInputs() {
        // Input Retrieval
        System.out.print("How much do you want to invest? ");
        initialInvestment = mcScan.nextDouble();
        System.out.print("How many years are investing? ");
        yearsInvesting = mcScan.nextInt();

        // Interest/Compound Input Retrieval
        System.out.println("What period does the interest compound?");
        System.out.println("a) Daily\t\t\tc) Quarterly\nb) Monthly\t\t\td) Yearly");
        String choice = mcScan.next();
        switch (choice) {
            case "a":
                compoundMultiplier = 365;
                break;
            case "b":
                compoundMultiplier = 12;
                break;
            case "c":
                compoundMultiplier = 4;
                break;
            case "d":
                compoundMultiplier = 1;
                break;
            default:
                compoundMultiplier = 0;
                break;
        }
        System.out.print("What is the annual interest rate % growth? ");
        interest = 1 + mcScan.nextFloat() / (100f * compoundMultiplier);
    }
}
