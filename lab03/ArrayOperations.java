public class ArrayOperations {
    /**
     * Delete the value at the given position in the argument array, shifting
     * all the subsequent elements down, and storing a 0 as the last element of
     * the array.
     */
    public static void delete(int[] values, int pos) {
        if (pos < 0 || pos >= values.length) {
          System.out.println("Error: pos out of range");
          return;
        }
        // TODO: YOUR CODE HERE
        int lastIndex = values.length - 1;
        int sucessorPtr = pos + 1;

        while(sucessorPtr <= lastIndex) {
          values[sucessorPtr - 1] = values[sucessorPtr];
          sucessorPtr++;
        }
        values[lastIndex] = 0;

    }

    /**
     * Insert newInt at the given position in the argument array, shifting all
     * the subsequent elements up to make room for it. The last element in the
     * argument array is lost.
     */
    public static void insert(int[] values, int pos, int newInt) {
        if (pos < 0 || pos >= values.length ) {
            System.out.println("Error: pos out of range");
            return;
        }
        // TODO: YOUR CODE HERE
        int lastIndex = values.length - 1;
        int tailPtr = lastIndex;
        while(tailPtr > pos) {
          values[tailPtr] = values[tailPtr - 1];
          tailPtr--;
        }
        values[pos] = newInt;
    }
}
