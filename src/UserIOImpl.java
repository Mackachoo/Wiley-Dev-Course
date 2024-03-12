import java.util.Scanner;

public class UserIOImpl implements UserIO{

    Scanner mcScan = new Scanner(System.in);

    public void print(String message) {
        System.out.print(message);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return mcScan.next();
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return mcScan.nextInt();
    }

    public int readInt(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            input = mcScan.nextInt();
        } while (input <= min || input >= max);
        return input;
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        return mcScan.nextDouble();

    }

    public double readDouble(String prompt, double min, double max) {
        double input;
        do {
            System.out.print(prompt);
            input = mcScan.nextDouble();
        } while (input <= min || input >= max);
        return input;
    }

    public float readFloat(String prompt) {
        System.out.print(prompt);
        return mcScan.nextFloat();

    }

    public float readFloat(String prompt, float min, float max) {
        float input;
        do {
            System.out.print(prompt);
            input = mcScan.nextFloat();
        } while (input <= min || input >= max);
        return input;

    }

    public long readLong(String prompt) {
        System.out.print(prompt);
        return mcScan.nextLong();

    }

    public long readLong(String prompt, long min, long max) {
        long input;
        do {
            System.out.print(prompt);
            input = mcScan.nextLong();
        } while (input <= min || input >= max);
        return input;

    }

}
