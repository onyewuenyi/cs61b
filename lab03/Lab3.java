public class Lab3 {
  public static boolean find(int value) {
    /***
    Return true if the integer value is in the array of integers values;
    else return false
    */
    int[] values = {33, 44, 5, 6, 6, 55};
    boolean found = false;

    // traverse values
    for(int n: values) {
      if (n == value) {
        found = true;
        break;
      }
    }
    return found;
  }

  public static void myCountZeros(int[] values) {
    int count = 0;
    for (int i = 0; i < values.length; i++) {
        if (values[i] == 0) {
          count++;
        }
    }
    System.out.println("Number of 0s in values array: " + count);
  }


  public static void countZeros(int[] values) {
    int count = 0;
    for (int i = 0; i < values.length; i++) {
        if (values[i] != 0) {
            continue;
        }
        count += 1;
    }
    System.out.println("Number of 0s in values array: " + count);
  }

  public static boolean duplicateExist(int[] values) {
    /***
    Return if array contains at least 1 duplicate Integer
    1 pass through seq
    i and j are ptrs to the pos in the arr
    */

    for (int i = 0; i < values.length; i++) {
      for (int j = i + 1; j < values.length; j++) {
          if (values[i] == values[j]) {
              return true;
          }
      }
    }
    return false;
  }



  private static int max(int[] values) {
    /***
    name: max
    method function: return the max Integer in the list values of Integer
    reflecting on your problem solving process
    Did you come up with a few representative example: small test case int values[] = {22, 33, 55, 6};
    Did you trace through the code: box plot
    How did you keep track of the different variable: mentally due to the simplicity
    Which variables were easy to identify, and what made them easy to identify
    variables:
    rtn: this name sucks; max or currMax would be better
    k: I would prefer i as a loop index/prt
    values.length
    values: I would prefer integers or integerValues to be more descriptive
    */
    // loop init
    int rtn = values[0]; // set min to the 1st element
    int k = 1; // start from the 2nd element

    // iterate from the 2nd element to the last
    while (k < values.length) {
      // update rtn if values[k] is greater
        if (rtn < values[k]) {
            rtn = values[k];
        }
        k++;
    }
    return rtn;
  }

  private static void reverseIntListInPlace(int[] values) {
    /***
    Reverse, in-place,  the list of Integers in the arr values
    */
    int k = 0;
    int arrLen = values.length;
    int medianListIndex = arrLen / 2;

    while (k < medianListIndex) {
        // loop cond check

        // loop computation

        // init swap computations
        int arrLastIndex = arrLen;
        int temp = values[k];
        int swapIndex = arrLastIndex - k;

        // swap computation
        values[k] = values[swapIndex];
        values[swapIndex] = temp;

        // loop update
        k = k + 1;
    }
  }

  private static boolean IntListIsSorted (int[] values) {
      int k = 0;
      int lastIndex = values.length - 1;

      while (k < lastIndex) {
          // init bstraction
          int currValue = values[k];
          int nextValue = values[k + 1];

          if (currValue > nextValue) {
              return false;
          }
          k++;
      }
      return true;
  }

  private static int totalInstancesInList (int[] values, int a) {
    int k = 0;
    int counter = 0;

    // iterate from the first index to the last index in the arr
    while (k < values.length ) {
        // if kth value == a then counter++
        if (values[k] == a) {
            counter++;
        }
        // update loop index
        k++;
    }
    return counter;
  }

  public static void main(String[] args) {
    int values[] = {22, 33, 55, 6};
    int values2[] = {22, 33, 55, 909};
    int values3[] = {3, 55, 5, 3, 5, 3};



    System.out.println(instancesInList(values3, 3));



  }
}
