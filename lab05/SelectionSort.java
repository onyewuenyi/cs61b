import java.util.Arrays;

public class SelectionSort {
    public static int minLength(String s0, String s1) {
        /*** Return length of the smallest char arr of s0 and s1*/
        // convert to arrs and get len
        int arr0Len = s0.toCharArray().length;
        int arr1Len = s1.toCharArray().length;

        // return min arr using an tenary expression
        return arr0Len < arr1Len ? arr0Len : arr1Len;
    }


    public static boolean charComp(char c0, char c1) {
        /*** Return true if c0 > c1 */
        return (int) c0 < (int) c1;
    }


    public static boolean strComp(String s0, String s1) {
        /*** Return true if s0 > s1 */
        // setup
        int N = minLength(s0, s1);
        char[] arr0 = s0.toCharArray();
        char[] arr1 = s1.toCharArray();

        for(int i = 0; i < N; i++) {
            if (arr0[i] == arr1[i]) continue; // next if both chars are eq
            if(charComp(arr0[i], arr1[i])) {
                return true;
            }  else {
                return false;
            }
        }
        return arr0.length < arr1.length;
    }


    public static int findSmallest(String[] arr, int startIndex) {
        if (arr.length == 0) throw new IllegalArgumentException("arr has 0 elements");

        if (startIndex >= arr.length) throw new IllegalArgumentException(startIndex + " is greater than the last index");

        int smallestIndex = startIndex;  // set to startIndex
        for(int i = startIndex; i < arr.length; i++) {
            if (strComp(arr[i], arr[smallestIndex])) smallestIndex = i;
        }
        return smallestIndex;
    }


    public static void swap(String[] arr, int i, int j) {
        /** selectionSort helper; swap arr[i] value with arr[iSuccesor ]*/
        if (i == j) return;
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void selectionSort(String[] arr) {
        if (arr.length <= 0) throw new IllegalArgumentException("Array is empty");
        for (int i = 0; i < arr.length; i++) {

                swap(arr, i, findSmallest(arr, i));
        }
    }


//    public static void addHocTestSelectionSort() {
//        String[] input = {"i", "have", "an", "egg"};
//        String[] expected = {"an", "egg", "have", "i"};
//        selectionSort(input);
//
//        if (! java.util.Arrays.equals(input, expected)) {
//            System.out.println("Error! WTF"); // err output
//
//            // contents of both containers
//            System.out.println("Actual:");
//            for(String i: input) System.out.print(i + " ");
//
//            System.out.println("\n");
//
//            System.out.println("Expected:");
//            for(String i: expected) System.out.print(i + " ");
//        }
//    }


    public static void main(String[] args) {
        //testSelectionSort();
    }
}
