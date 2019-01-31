public class Dog {
  // class variable
  public int weightInPounds;

  // const class variable
  public static final String binomen = "Canis familiaris";

  // constructor
  public Dog(int myWeightInPounds) {
    weightInPounds = myWeightInPounds;
  }

  // class methods
  public static void printBinomen() {
    System.out.println("binomen: " + binomen);
  }

  // instance method
  public Dog maxDog(Dog d2) {
    /**
    instance method
    takes a instance of a dog
    called on an instance d0.maxDog(d1)
    returns the dog instance with the most weight
    this - the dog instance that the instance method is called on
     */
       if (this.weightInPounds > d2.weightInPounds) {
           return this;
       }
       return d2;
   }

  public void printWeightInPounds() {
    /** Print to studout weightInPounds of the instance invoked */
    System.out.println("weightInPounds: " + this.weightInPounds);
  }

}
