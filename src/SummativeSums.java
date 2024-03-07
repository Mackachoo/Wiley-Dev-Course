public class SummativeSums {

    public static void main(String[] args) {
        int[] list1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] list2 ={ 999, -60, -77, 14, 160, 301 };
        int[] list3 ={ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };


        System.out.printf("\n#1 Array Sum: %d", sumList(list1));
        System.out.printf("\n#2 Array Sum: %d", sumList(list2));
        System.out.printf("\n#3 Array Sum: %d", sumList(list3));
    }

    static int sumList(int[] list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
