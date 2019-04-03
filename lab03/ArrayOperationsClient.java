public class ArrayOperationsClient {
  public static void main(String[] args) {

    int[] values = {1, 2, 3, 4, 5};
    for(int n: values) System.out.print(n + " ");

    ArrayOperations.insert(values, 0, 0);
    int[] afterInsert1 = {0, 1, 2, 3, 4};

    System.out.println();


    for(int n: values) { System.out.print(n + " "); }



  }
}
