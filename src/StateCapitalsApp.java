import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsApp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner mcScan = new Scanner(System.in);
        Map<String, Capital> statecapitals = readCapitals("src/MoreStateCapitals.txt");
        System.out.println("LOADED: " + statecapitals.size() + " entries");

        System.out.println("\nCAPITALS INFO:");
        System.out.println("==============");

        for (String state : statecapitals.keySet()) {
            Capital capital = statecapitals.get(state);
            System.out.printf("\n%s - %s | Pop: %d | Area: %.1f sq mi", state, capital, capital.getPop(),
                    capital.getArea());
        }

        System.out.print("\n\nFILTER by minimum population : ");
        long minPop = mcScan.nextLong();

        for (String state : statecapitals.keySet()) {
            Capital capital = statecapitals.get(state);
            if (capital.getPop() > minPop) System.out.printf("\n%s - %s | Pop: %d | Area: %.1f sq mi", state, capital
                    , capital.getPop(), capital.getArea());
        }
    }

    private static Map<String, Capital> readCapitals(String filename) throws FileNotFoundException {
        Map<String, Capital> out = new HashMap<>();
        Scanner sc = new Scanner(
                new BufferedReader(new FileReader(filename)));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("::");
            out.put(line[0], new Capital(line[1], line[2], line[3]));
        }
        return out;
    }


}
