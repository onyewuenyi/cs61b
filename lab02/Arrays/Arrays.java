public class Arrays {
  public static void main(String[] args) {
    // declare an Array variable
    //  no obj is instantiated
    //  create a 64 bit box for storing a ref to an int array
    int[] myList0;

    // Instantiate a new int array obj
    // new returns the addr of this int array obj
    myList0 = new int[]{22,44,55};

    // declaration, instantiation, and assignment in one step
    int[] myList1 = new int[]{1,2,3,4,};
    System.out.println(myList0[0]);
    System.out.println(myList1[1]);

  }
}
