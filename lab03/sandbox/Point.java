public class Point {
  public int x;
  public int y;
  public static int totalInstances = 0;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
    totalInstances++;
  }

  public Point() {
    x = 0;
    y = 0;
    totalInstances++;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

  public boolean equals(Point p0) {
    return (this.x == p0.x) && (this.y == p0.y);
  }

  public static void printTotalInstances() {
    System.out.println(totalInstances);
  }

  public static void main(String[] args) {
    Point p0 = new Point(33,5);
    Point p1 = new Point(33,5);
    Point p2 = new Point(44, 2);
    Point p3 = new Point();”

    System.out.println(p0);
    System.out.println(p1.equals(p1));
    System.out.println(p0.equals(p2));

    Point.printTotalInstances();


  }
}
