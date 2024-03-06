public class SimpleCombination {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49}; // 12 numbers
        int[] secondHalf = {51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100}; // also 12!

        int[] wholeNumbers = new int[24];

        for (int i=0; i < wholeNumbers.length; i++) {
            if (i < 12) {
                wholeNumbers[i] = firstHalf[i];
            } else {
                wholeNumbers[i] = secondHalf[i%12];
            }
        }

        System.out.println("All together now!:");
        for (int n : wholeNumbers) {
            System.out.print(n+" ");
        }

    }
}
