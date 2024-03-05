import java.util.Scanner;

public class TriviaNight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the one and only Doctor Who trivia night!");
        System.out.print("Who is our contestant? ");
        String name = scanner.nextLine();
        int score = 0;
        System.out.println("Nice, hi "+name+"! Let's begin...\n");

        System.out.println("\n\n1) Which incarnation of the Doctor first met River Song?");
        if (scanner.nextInt() == 10) {
            System.out.println("Correct, it was David Tennant's Tenth Doctor!");
            score++;
        } else {
            System.out.println("Wrong, it was actually David Tennant's Tenth Doctor!");
        }

        System.out.println("\n\n2) What planet are the Silurians from?");
        System.out.println("\t1) Mars\t\t\t 3) Raxicorikofalapatorius");
        System.out.println("\t2) Earth\t\t 4) Clom");
        if (scanner.nextInt() == 2) {
            System.out.println("Correct, they predated Humans on Earth!");
            score++;
        } else {
            System.out.println("Wrong, they weren't in fact aliens but Earthlings!");
        }

        System.out.println("\n\n3) How did Clara leave the Doctor?");
        System.out.println("\t1) She was killed by a Raven and then stolen in her last second of life");
        System.out.println("\t2) She caused a temporal paradox in early 20th century only to be then sent back there by a Weeping Angel");
        System.out.println("\t3) She moped about on a cloud over Victorian London for a few decades");
        if (scanner.nextInt() == 1) {
            System.out.println("Correct, she was killed by a Raven!");
            score++;
        } else {
            System.out.println("Wrong, it was really the Raven!");
        }

        System.out.println("\n\nYou got "+score+" correct!");
        if (score == 3) {
            System.out.println("Awesome "+name+", you got them all right!");
        } else if (score == 0) {
            System.out.println("I think "+name+" needs to go rewatch Doctor Who!");
        } else {
            System.out.println("Not great... not terrible... "+name+", why don't you go rewatch Doctor Who!");
        }
    }
}
