public class LovesMe {

    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");

        int count = 0;
        while (count < 34) {
            count++;
            if (count % 2 == 1) {
                System.out.println("It loves me NOT!");
            } else {
                System.out.println("It loves me!");
            }
        }

        System.out.println("I knew it! It LOVES ME!");
    }
}
