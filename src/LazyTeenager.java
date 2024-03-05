import java.util.Random;

public class LazyTeenager {

    public static void main(String[] args) {
        Random teenageBrain = new Random();
        int count = 1;
        boolean notClean = true;
        do {
            System.out.println("Clean your room!! (x"+count+")");

            // Cleans Room
            if (teenageBrain.nextInt(10) < count) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                notClean = false;
            }

            // Uh Oh
            if (count >= 7) {
                System.out.println("That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
            }
            count++;
        } while (notClean);
    }

}
