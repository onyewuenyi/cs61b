public class Main {
  public static void main(String[] args) {
    Salmon s0 = new Salmon();
    Salmon s1 = new Salmon(5, "Charles");

    Salmon.printWeight(s0);
    Salmon.printWeight(s1);
    s0.swim();
    s0.swim(55);

    MegaSalmon m0 = new MegaSalmon();
    MegaSalmon m1 = new MegaSalmon(5, "John", 44);

    MegaSalmon.printWeight(m0);
    m0.swim();
    m0.swim(55);


  }
}
