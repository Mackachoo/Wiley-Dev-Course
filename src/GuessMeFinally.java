import java.util.Scanner;
public class GuessMeFinally {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int truth = 42;
        System.out.println("I've chosen a number. Betcha can't guess it!");

        boolean firstTry = true;
        while (true) {
            int guess = input.nextInt();

            if (guess == truth) {
                break;
            } else if (guess < truth) {
                System.out.println("Ha, nice try - too low! Do try again...");
            } else {
                System.out.println("Too bad, way too high. Do try Again...");
            }
            firstTry = false;
        }
        if (firstTry) {
            System.out.println("Wow, nice guess! That was it!");
        } else {
            System.out.println("Finally! It's about time you got it!");
        }
    }
}
