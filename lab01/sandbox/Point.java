public class Point {
  // instance variables
  public double x;
  public double y;

  public Point(double inputX, double inputY) {
    x = inputX;
    y = inputY;

  }
  // instance non-static method; uses instance vars
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }

  // public Point addPoints(Point p0, Point p1) {
  //   Point newPoint = new Point(x.getX(), y.gety());
  //   return newPoint;
  // }
  //
}
