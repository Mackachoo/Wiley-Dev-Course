import java.util.*;

import static java.util.Map.entry;
public class Main {

    final static Map<String, String> statecapitals = Map.ofEntries(
            entry("Alabama",	"Montgomery"),
            entry("Alaska",	"Juneau"),
            entry("Arizona",	"Phoenix"),
            entry("Arkansas",	"Little Rock"),
            entry("California",	"Sacramento"),
            entry("Colorado",	"Denver"),
            entry("Connecticut",	"Hartford"),
            entry("Delaware",	"Dover"),
            entry("Florida",	"Tallahassee"),
            entry("Georgia",	"Atlanta"),
            entry("Hawaii",	"Honolulu"),
            entry("Idaho",	"Boise"),
            entry("Illinois",	"Springfield"),
            entry("Indiana",	"Indianapolis"),
            entry("Iowa",	"Des Moines"),
            entry("Kansas",	"Topeka"),
            entry("Kentucky",	"Frankfort"),
            entry("Louisiana",	"Baton Rouge"),
            entry("Maine",	"Augusta"),
            entry("Maryland",	"Annapolis"),
            entry("Massachusetts",	"Boston"),
            entry("Michigan",	"Lansing"),
            entry("Minnesota",	"Saint Paul"),
            entry("Mississippi",	"Jackson"),
            entry("Missouri",	"Jefferson City"),
            entry("Montana",	"Helena"),
            entry("Nebraska",	"Lincoln"),
            entry("Nevada",	"Carson City"),
            entry("New", "Hampshire Concord"),
            entry("New Jersey", "Trenton"),
            entry("New Mexico", "Santa Fe"),
            entry("New York", "Albany"),
            entry("North Carolina", "Raleigh")	,
            entry("North Dakota", "Bismarck")	,
            entry("Ohio",	"Columbus"),
            entry("Oklahoma",	"Oklahoma City") ,
            entry("Oregon",	"Salem"),
            entry("Pennsylvania",	"Harrisburg"),
            entry("Rhode Island", "Providence")	,
            entry("South Carolina", "Columbia")	,
            entry("South Dakota", "Pierre")	,
            entry("Tennessee",	"Nashville"),
            entry("Texas",	"Austin"),
            entry("Utah",	"Salt Lake City") ,
            entry("Vermont",	"Montpelier"),
            entry("Virginia",	"Richmond"),
            entry("Washington",	"Olympia"),
            entry("West Virginia", "Charleston")	,
            entry("Wisconsin",	"Madison"),
            entry("Wyoming",	"Cheyenne")
    );


    public static void main(String[] args) {

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

    private static void printList(Collection list) {
        for (Object item : list) {
            System.out.println(item.toString());
        }
    }
}