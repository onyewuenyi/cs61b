public class Blah {
  public static int max(int x, int y) {
    if(x >= y) return x;
    return y;
  }
  public static void main(String[] args) {
    int[] a = {1, 11, -1, -11};
    int[] b = {3, -3, 2, -1};
    int largerN = max(a[0], b[0]);
    System.out.println(largerN);
    System.out.println(largerN == 3);


  }
}
