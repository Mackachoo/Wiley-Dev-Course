import java.util.Scanner;

public class YourLifeInMovies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hey, let's play a game!\nWhat's your name? ");
        String name = scanner.nextLine();
        System.out.print("Ok, "+name+", when were you born? ");

        int birthYear = scanner.nextInt();
        if (birthYear < 2005) {
            System.out.println("Did you know that Pixar's 'Up' came out over a decade ago?");
        }
        if (birthYear < 1995) {
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        if (birthYear < 1985) {
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        if (birthYear < 1975) {
            System.out.println("The OG Jurassic Park released closer to the first lunar landing than today");
        }
        if (birthYear < 1965) {
            System.out.println("Whatever the MASH TV series is, it's been around for almost half a century!");
        }

    }
}
