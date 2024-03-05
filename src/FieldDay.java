import java.util.Scanner;
public class FieldDay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your last name? ");
        String lastname = scanner.nextLine().toLowerCase();

        if ("baggins".compareTo(lastname) > 0) {
            System.out.println("Aha! You're on the team \"Red Dragons\"!\n");
        } else if ("dresden".compareTo(lastname) > 0) {
            System.out.println("Aha! You're on the team \"Dark Wizards\"!\n");
        } else if ("howl".compareTo(lastname) > 0) {
            System.out.println("Aha! You're on the team \"Moving Castles\"!\n");
        } else if ("potter".compareTo(lastname) > 0) {
            System.out.println("Aha! You're on the team \"Golden Snitches\"!\n");
        } else if ("vimes".compareTo(lastname) > 0) {
            System.out.println("Aha! You're on the team \"Night Guards\"!\n");
        } else {
            System.out.println("Aha! You're on the team \"Black Holes\"!\n");
        }
    }
}
