import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String colour =     randoThing("colour"); // call colour method here
        String animal =     randoThing("animal"); // call animal method again here
        String colorAgain = randoThing("colour"); // call colour method again here
        int weight = randoNum(5, 200); // call number method,
        // with a range between 5 - 200
        int distance = randoNum(10, 20); // call number method,
        // with a range between 10 - 20
        int number = randoNum(10000, 20000); // call number method,
        // with a range between 10000 - 20000
        int time = randoNum(2, 6); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + colour + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    static int randoNum(int min, int max) {
        Random rng = new Random();
        return rng.nextInt(1-min+max) + min;
    }

    static String randoThing(String group) {
        Random rng = new Random();
        String[] colours = {"blue", "green", "red", "purple", "yellow"};
        String[] animals = {"gorgon", "unicorn", "redcap", "manticore", "dragon"};
        switch (group) {
            case "colour":
                return colours[rng.nextInt(colours.length)];
            case "animal":
                return animals[rng.nextInt(animals.length)];
            default:
                return "/Error/";
        }
    }

}
