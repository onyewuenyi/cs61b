public class Salmon extends Fish {
    private String name;

    // Constructor C: No-args Salmon Constructor
    public Salmon() {
      super();
      name = "";
    }



    // Constructor E: Salmon Constructor with an int parameter
    // and a call to the super int parameter Constructor

    public Salmon(int w, String n) {
        super(w);
        name = n;
    }


    public void fry() {
        System.out.println("Frying sssssssssalmon");
    }

    // Change inherited method
    @Override
    public void swim() {
        System.out.println("splish splash");
    }

    // Add subclass specific method
    public void swim(int speed) {
        System.out.println("swimming at " + speed + " mph");
    }
}
