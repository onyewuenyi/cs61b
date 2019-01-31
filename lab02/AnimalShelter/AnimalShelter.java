public class AnimalShelter {
  public static void feed(Dog d0, int foodWeightInPounds) {
    /*** Increase a instance of Dog weightInPounds by foodWeightInPounds */
    d0.weightInPounds += foodWeightInPounds;
  }

  public static void main(String[] args) {
    Dog d0 = new Dog(55);
    Dog d1 = new Dog(22);

    Dog max = d0.maxDog(d1);
    max.printWeightInPounds();

    AnimalShelter.feed(d1, 1000);
    max = d0.maxDog(d1);
    max.printWeightInPounds();
  }
}
