import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner mcScan = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("Hello and welcome to ROCK, PAPER, SCISSORS!");
        System.out.println("-------------------------------------------");

        // Gets number of rounds!
        System.out.print("\n How many rounds will there be (1-10)? ");
        int numRounds = mcScan.nextInt();

        if (numRounds > 10 || numRounds < 1) {
            System.out.println("ERROR : Invalid number of rounds");
            return;
        }


        // Starts the game!
        int[] scores = new int[numRounds];
        System.out.println("\nLet's begin!!!!");
        System.out.println("--------------------------");

        for (int i = 0; i < numRounds; i++) {
            int userChoice;

            do {
                System.out.printf("Round %d : What will you chose?\n", i+1);
                System.out.println("R) Rock\t P) Paper\t S) Scissors");
                userChoice = choiceToInt(mcScan.next());
            } while(userChoice == -2);

            int compChoice = rng.nextInt(3);
            if (userChoice == -1 || (userChoice - 1) % 3 == compChoice) {
                scores[i] = 1;
            } else if (userChoice == compChoice) {
                scores[i] = 0;
            } else {
                scores[i] = -1;
            }
        }

        // Results
        System.out.println("--------------------------");
        System.out.println("The final results are...");
        int[] summedScores = sumScores(scores);
        System.out.printf("%d wins, %d ties and %d losses!\n", summedScores[0], summedScores[1], summedScores[2]);
        System.out.println("So the winner is...");
        if (summedScores[0] > summedScores[2]) {
            System.out.println("The Player. Congrats!");
        } else {
            System.out.println("The Computer. Whoops.");
        }
    }

    static int[] sumScores(int[] scores) {
        int[] result = new int[3];
        for (int score : scores) {
            if (score == 1)  result[0]++;
            if (score == 0)  result[1]++;
            if (score == -1) result[2]++;
        }
        return result;
    }

    static int choiceToInt(String choice) {
        switch (choice) {
            case "G":       // Gun
                return -1;
            case "R":       // Rock
                return 0;
            case "P":       // Paper
                return 1;
            case "S":       // Scissors
                return 2;
            default:        // Invalid Choice
                return -2;
        }


    }
}