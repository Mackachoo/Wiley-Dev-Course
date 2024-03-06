import java.util.ArrayList;
import java.util.Locale;

public class FruitSalad {

    public static void main(String[] args) {
        String[] fruits = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry",
                "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int fruitCount = 0;
        int berryCount= 0;
        int appleCount = 0;
        int orangeCount = 0;

        // Add all the berries
        for (String fruit: fruits) {
            if (fruit.contains("berry") && fruitCount < 12) {
                fruitSalad[fruitCount] = fruit;
                fruitCount++;
                berryCount++;
            }
        }

        //Add the other fruits
        for (String fruit: fruits) {
            if (fruitCount >= 12) {
                break;
            }
            if ((!fruit.contains("Apple") || appleCount < 3) && (!fruit.contains("Orange") || orangeCount < 3) &&
                    !fruit.contains("Tomato") && !fruit.contains("berry")) {
                fruitSalad[fruitCount++] = fruit;
                if (fruit.contains("Apple")) {
                    appleCount++;
                }
                if (fruit.contains("Orange")) {
                    orangeCount++;
                }
            }
        }

        System.out.println("The fruit salad is:");
        System.out.print(" | ");
        for (String fruit: fruitSalad) {
            System.out.print(fruit+" | ");
        }
        System.out.println("\nwith "+appleCount+" apples, "+berryCount+" berries and "+orangeCount+" oranges.");
    }
}
