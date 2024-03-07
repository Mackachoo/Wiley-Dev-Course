import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);
        Random rng = new Random();

        // User Input
        System.out.print("How much money do you have to bet? $");
        int money = mcScan.nextInt();

        // Playing the Game
        System.out.println("Let's play... LUCKY SEVENS!");
        int rounds = 0;
        int maxMoney = 0;
        int maxRound = 0;
        while (money > 0) {
            System.out.println("\nYou have $"+money);
            if (money > maxMoney) {
                maxMoney = money;
                maxRound = rounds;
            }

            int[] dice = {rng.nextInt(6), rng.nextInt(6)};
            System.out.printf("You rolled... %d and %d %n", dice[0]+1, dice[1]+1);
            if (dice[0] + dice[1] == 5) { // 5 as both dice will be 1 less than their actual value
                System.out.println("Your dice add up to seven, you win $4");
                money += 4;
            } else {
                System.out.println("Your dice don't add up to seven, you lose $1");
                money -= 1;
            }
            rounds++;
        }
        System.out.printf("\n And you're out! You played for %d rounds!", rounds);
        System.out.printf("\n You should have quit after %d rounds, you had won $%d!!!", maxRound, maxMoney);

    }
}