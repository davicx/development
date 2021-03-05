public class InsertionSort {

    public static void main(String[] args)  {
        System.out.println("hi");
        int [] numbers = {10,5,3,7,2};
        printArray(numbers);
        sort(numbers);
        System.out.println("_____________");
        printArray(numbers);
    }

    public static int[] sort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            int key = arrayToSort[i];
            int j = i - 1;

            while(j>=0 && arrayToSort[j]> key) {
                arrayToSort[j+1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j+1] = key;
        }
        return arrayToSort;
    }

    public static void printArray(int[] arrayToPrint) {

        for (int i = 0; i < arrayToPrint.length; i++) {
            int currentValue = arrayToPrint[i];
            System.out.println(currentValue);
        }
    }


}
