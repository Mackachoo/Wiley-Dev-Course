import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> statecapitals = readMap("src/StateCapitals.txt");

        System.out.println("STATES:");
        System.out.println("=======");
        printList(statecapitals.keySet());


        System.out.println("\n\nCAPITALS:");
        System.out.println("=========");
        printList(statecapitals.values());

        System.out.println("\n\nSTATE - CAPITAL PAIRS:");
        System.out.println("=======================");
        printList(concatMap2String(statecapitals));

    }

    private  static List<String> concatMap2String(Map<String, String> map) {
        List<String> output = new ArrayList<>();
        for (String k : map.keySet()) {
            output.add(k + " - " + map.get(k));
        }
        return output;
    }

    private static void storeMap(String filename, Map<String, String> map) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        for (String key : map.keySet()) {
            out.println(key + "::" + map.get(key));
        }
        out.flush();
        out.close();
    }

    private static Map<String, String> readMap(String filename) throws FileNotFoundException {
        Map<String, String> out = new HashMap<>();
        Scanner sc = new Scanner(
                new BufferedReader(new FileReader(filename)));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("::");
            out.put(line[0], line[1]);
        }
        return out;
    }

    private static void printList(Collection list) {
        for (Object item : list) {
            System.out.println(item.toString());
        }
    }
}