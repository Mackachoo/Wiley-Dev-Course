import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);
        System.out.print("What is your age? ");

        int age = mcScan.nextInt();

        int maxHR = 220 - age;

        double[] hrRange = {maxHR * 0.5, maxHR * 0.85};

        System.out.printf("\n\tYour maximum heart rate should be %d beats per minute", maxHR);

        System.out.printf("\n\tYour target HR Zone is %.0f - %.0f beats per minute", hrRange[0], hrRange[1]);
    }
}
