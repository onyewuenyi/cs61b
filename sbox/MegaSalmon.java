public class MegaSalmon extends Salmon  {
  int str;


  public MegaSalmon() {
    super();
    str = 0;
  }

  public MegaSalmon(int w, String n, int s) {
    // inherit Fish weight member and Salmon name member
    super(w, n);
    str = s;
  }



  // MegaSalmon specific method
  public void swing() {
    System.out.println("Swing!! " + str);
  }

  // Override Salmon method inherited
  @Override
  public void swim() {
    System.out.println("MegaSalmon swim");
  }

  // Override Fish method inherited
  @Override
  public void swim(int speed) {
    System.out.println(speed * 100);
  }

}
