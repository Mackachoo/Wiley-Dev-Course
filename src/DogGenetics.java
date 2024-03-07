import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args) {
        Scanner mcScan = new Scanner(System.in);
        Random rng = new Random();

        System.out.println("What is your dog's name?");
        String dogName = mcScan.nextLine();

        System.out.printf("\nWell then, I have this highly reliable report on %s's prestigious background right here.",
                dogName);
        System.out.printf("\nMIra\n%s is:", dogName);
        
        double[] breeds = {rng.nextDouble(), rng.nextDouble(), rng.nextDouble(), rng.nextDouble(), rng.nextDouble(),};
        double sum = Arrays.stream(breeds).sum();
        for (int i = 0; i < 5; i++) {
            breeds[i] = breeds[i] * 100 / sum;
        }

        System.out.printf("\n%.1f St. Bernard", breeds[0]);
        System.out.printf("\n%.1f Chihuahua", breeds[1]);
        System.out.printf("\n%.1f Dramatic RedNosed Asian Pug", breeds[2]);
        System.out.printf("\n%.1f Common Cur", breeds[3]);
        System.out.printf("\n%.1f King Doberman", breeds[4]);

        System.out.printf("\n\nWow, that's %.0f%% a dog!", Arrays.stream(breeds).sum());


    }
    
}
