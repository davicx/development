import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {

        int [] existingNumbers = {314159265, 701071009, 309321903,577456789,221243698, 134532587};
        int [] newNumbers = {314159265, 722007009, 309321903, 522456789,201243698, 134532587};
        int arr[] = {2, 3, 4, 10, 40};

        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(10);
        numberList.add(17);
        numberList.add(28);
        numberList.add(33);
        numberList.add(40);

        int n = numberList.size();
        int x = 17;

        int result = binarySearchArrayList(numberList, 0, n - 1, x);
        System.out.println(numberList.get(3));

        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result);
        }

    }

    public static int binarySearchArrayList(ArrayList<Integer> arr, int l, int r, int x) {
        // Returns index of x if it is present in arr[l..r], else return -1
        //ArrayList<Integer> millionInts = new ArrayList<Integer>();

        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr.get(mid) == x)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearchArrayList(arr, l, mid - 1, x);

            // Else the element can only be presen in right subarray
            return binarySearchArrayList(arr, mid + 1, r, x);
        }

        return -1;
    }

    public static int binarySearch(int arr[], int l, int r, int x) {
        // Returns index of x if it is present in arr[l..r], else return -1


            if (r >= l) {
                int mid = l + (r - l) / 2;

                // If the element is present at the middle itself
                if (arr[mid] == x)
                    return mid;

                // If element is smaller than mid, then it can only be present in left subarray
                if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);

                // Else the element can only be presen in right subarray
                return binarySearch(arr, mid + 1, r, x);
            }

            return -1;
    }

}


/*
import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {


        int arr[] = {2, 3, 4, 10, 40};
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(10);
        numberList.add(40);
  */
/*
ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList = getNumbers();
                int n = numberList.size();
                int x = 10;
                System.out.println(n);

                int result = binarySearch(numberList, 0, n - 1, x);

                if (result == -1) {
                System.out.println("Element not present");
                } else {
                System.out.println("Element found at index " + result);
                }

                }

public static ArrayList<Integer> getNumbers() {
        ArrayList<Integer> millionInts = new ArrayList<Integer>();
        Random rand = new Random();
        int currentNumber = 0;

        for (int j = 0; j<100; j++) {

        currentNumber = rand.nextInt(10) + 1;
        System.out.println(currentNumber);
        millionInts.add(currentNumber);

        }
        return millionInts;

        }


public static int binarySearch(ArrayList<Integer> arr, int l, int r, int x) {
        // Returns index of x if it is present in arr[l..r], else return -1


        if (r >= l) {
        int mid = l + (r - l) / 2;

        // If the element is present at the middle itself
        if (arr.get(mid) == x)
        return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr.get(mid) > x)
        return binarySearch(arr, l, mid - 1, x);

        // Else the element can only be presen in right subarray
        return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
        }

        }

*/