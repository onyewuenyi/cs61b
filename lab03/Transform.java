public class Transform {
  /***
  Translate the following while loops to for loops.
  The body of the for loops should contain only the call to println
  */
  public static void printNames(String[] names) {
    // names - ref; 64 bit addr that points to names
    for(String name: names) {
      System.out.println(name);
    }
  }

  public static double aggregationMax(double grades[]) {
    double max = grades[0];
    for(double n: grades) {
      if (n > max) {
        max = n;
      }
    }
    return max;
  }
  public static void main(String[] args) {
    String names[] = {"Charles", "Maya", "James"};
    printNames(names);

    double grades[] = {22.3, 55.3, 66.3, 55.3};
    double maxGrade = aggregationMax(grades);
    System.out.println(maxGrade);

  }
}
