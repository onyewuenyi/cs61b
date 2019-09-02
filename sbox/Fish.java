public class Fish {

    int weight;
    private int ssn;

    // Constructor A: No-args Fish Constructor
    public Fish() {
      weight = 0;
    }

    // Constructor B: Fish Constructor with an int parameter
    public Fish(int w) {
        weight = w;
    }

    public void fry() {
        System.out.println("Frying fssssssssssh");
    }

    public void swim() {
        System.out.println("splash");
    }

    public static void printWeight(Fish f) {
      // f is-a Fish type so I can pass in Salmon and MegaSalmon
      System.out.println(f.weight);
      // each subclass Salmon and MegaSalmon have overriden swim()
      swim();
    }
}
