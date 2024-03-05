import java.util.Random;

public class MaybeItLovesMe {

    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        Random cupid = new Random();
        int cupidsChoice = cupid.nextInt(75) + 15;
        int count = 0;
        while (count < cupidsChoice) {
            count++;
            if (count % 2 == 1) {
                System.out.println("It loves me NOT!");
            } else {
                System.out.println("It loves me!");
            }
        }

        if (cupidsChoice % 2 == 0) {
            System.out.println("\tI knew it! It LOVES ME!");
        } else {
            System.out.println("\tDAMN! It has poor taste!");
        }
    }
}
