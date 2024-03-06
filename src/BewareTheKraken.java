import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randoFish = new Random();
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36,200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        // If we set this to true nothing will change as we surface due to Krakens at 20,000ft
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            String[] fishes = {"Mackeral", "Guppy", "Lily Shark", "Dumbo Octopus", "Jeff"};
            System.out.println("Oh look a lesser spotted " + fishes[randoFish.nextInt(5)]);

            System.out.print("\nCancel Descent (y/n): ");
            if (input.next().equals("y")) {
                break;
            }

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("\nWe ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
