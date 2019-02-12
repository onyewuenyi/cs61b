import java.util.Random;

/** A class that represents a path via pursuit curves. */
public class Path {
  public Point curr;
  public Point next;

  public Path(double x, double y) {
    // curr = createRandomPoint();
    curr = new  Point(0, 0);
    next = new Point(x, y);
  }

  /***
  Instantiate and return a Point with a random values, between 0-100, for x and y
  */
  public Point createRandomPoint() {
    double rangeMin = 0;
    double rangeMax = 100;
    Random rand = new Random();
    double randVal0 = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
    double randVal1 = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
    Point curr = new Point(randVal0, randVal1);
    return curr;

  }

  /***
  Sets curr to next and updates the position of next to be the curr with
  movement defined by dx and dy
  */
  public void iterate(double dx, double dy) {
    Point currAddr = this.curr ;
    Point nextAddr = this.next;
    // set curr to next
    // this.curr == Point addr
    // this.curr = new Point(this.next);
    this.curr = new Point(this.next);

    // this.next == Point addr
    // updates the position of next to be the curr with movement defined by dx and dy
    this.next = new Point(dx, dy);
  }

  public static void main(String[] args) {
    Path path0 = new Path(5, 3);
    Path path1 = new Path(11, 4);

    System.out.println("path0:\n" + "curr = " + path0.curr.toString() + "\n" + "next = " + path0.next.toString());

    path0.iterate(25, 9);

    System.out.println("path0:\n" + "curr = " + path0.curr.toString() + "\n" + "next = " + path0.next.toString());
    path0.iterate(25, 9);
    path0.iterate(100, 92);
    path0.iterate(124, 110);
    System.out.println("path0:\n" + "curr = " + path0.curr.toString() + "\n" + "next = " + path0.next.toString());




  }
}
