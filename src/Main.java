import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // User Input
        Scanner mcScan = new Scanner(System.in);
        System.out.print("How much money do you have to bet? $");
        int money = mcScan.nextInt();

        // Playing the Game
        System.out.println("Let's play... LUCKY SEVENS!");
        int rounds = 0;
        while (money > 0) {
            System.out.println("\nYou have $"+money);
            money += play();
            rounds++;
        }
        System.out.printf("\n And you're out! You played for %d rounds!", rounds);

    }

    static int play() {
        Random rng = new Random();
        int[] dice = {rng.nextInt(6), rng.nextInt(6)};
        System.out.printf("You rolled... %d and %d %n", dice[0]+1, dice[1]+1);
        if (dice[0] + dice[1] == 5) { // 5 as both dice will be 1 less than their actual value
            System.out.println("Your dice add up to seven, you win $4");
            return 4;
        } else {
            System.out.println("Your dice don't add up to seven, you lose $1");
            return -1;
        }
    }
}