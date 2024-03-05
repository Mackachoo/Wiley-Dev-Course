import java.util.Scanner;
public class GuessMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int truth = 42;
        System.out.println("I've chosen a number. Betcha can't guess it!");

        int guess = Integer.parseInt( scanner.nextLine() );

        if (guess == truth) {
            System.out.println("Wow, nice guess! That was it!");
        } else if (guess < truth) {
            System.out.println("Ha, nice try - too low! I chose 42.");
        } else {
            System.out.println("Too bad, way too high. I chose 42.");
        }
    }
}
