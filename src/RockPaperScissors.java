import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    final Random rng = new Random();
    final Scanner mcScan = new Scanner(System.in);
    int[] scores;
    int numRounds;
    int[] summedScores;

    public RockPaperScissors() {

        System.out.println("-------------------------------------------");
        System.out.println("Hello and welcome to ROCK, PAPER, SCISSORS!");
        System.out.println("-------------------------------------------");

        // Gets number of rounds!
        System.out.print("\n How many rounds will there be (1-10)? ");
        numRounds = mcScan.nextInt();

        if (numRounds > 10 || numRounds < 1) {
            System.out.println("ERROR : Invalid number of rounds");
            return;
        }


        // Starts the game!
        scores = new int[numRounds];
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
        summedScores = sumScores(scores);
        System.out.printf("%d wins, %d ties and %d losses!\n", summedScores[0], summedScores[1], summedScores[2]);
        System.out.println("So the winner is...");
        if (Objects.equals(winnerIs(), "player")) {
            System.out.println("The Player. Congrats!");
        } else if (Objects.equals(winnerIs(), "noone")) {
            System.out.println("Offt, it was a draw. Oh well...");
        } else {
            System.out.println("The Computer. Whoops.");
        }
    }

    public String winnerIs() {
        if (summedScores[0] > summedScores[2]) {
            return "player";
        } else if (summedScores[0] == summedScores[2]) {
            return "noone";
        } else {
            return "computer";
        }
    }

    private int[] sumScores(int[] scores) {
        int[] result = new int[3];
        for (int score : scores) {
            if (score == 1)  result[0]++;
            if (score == 0)  result[1]++;
            if (score == -1) result[2]++;
        }
        return result;
    }

    private int choiceToInt(String choice) {
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
