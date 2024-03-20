import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Magical BirthDAY Calculator!");

        Scanner mcScan = new Scanner(System.in);
        System.out.println("What's your birthday (dd-mm-yyyy)?");
        LocalDate birthday = LocalDate.parse(mcScan.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));


        System.out.printf("\nThat's means you were born on a %s!", birthday.getDayOfWeek().toString().toUpperCase());
        LocalDate birthdayThisYear = birthday.withYear(LocalDate.now().getYear());
        if (LocalDate.now().isAfter(birthdayThisYear)) birthdayThisYear = birthdayThisYear.plusYears(1);

        System.out.printf("\nThis year it falls on a %s...",
                birthdayThisYear.getDayOfWeek().toString().toUpperCase());
        System.out.printf("\nAnd since today is %s, there's only %s more days until the next one!",
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ChronoUnit.DAYS.between(LocalDate.now(), birthdayThisYear));
        System.out.printf("\nBet yer excited to be turning %d!",
                ChronoUnit.YEARS.between(birthday, LocalDate.now()) + 1);

    }
}