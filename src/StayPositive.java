import java.util.Scanner;

public class StayPositive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Countdown: ");
        int count;
        do {
            count = input.nextInt();
        } while (count <= 0);

        System.out.println("Counting down...\n");

        while(count > -1) {
            System.out.print(count + "...\t");
            if (count % 10 == 0) {
                System.out.println();
            }
            count--;
        }

        System.out.println("\nBlast off!");

    }
}
