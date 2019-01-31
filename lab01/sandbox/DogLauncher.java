public class DogLauncher {
  public static void main(String[] args) {
    Dog d = new Dog(0, "Schnauzer", 25.5f);
    //d.printDogInfo();

    Dog[] dogList = new Dog[2];
    dogList[0] = new Dog(1, "Charles", 44.64f);
    dogList[1] = new Dog(2, "Maya", 33.1f);

    // for(int i=0; i < 2; i++) {
    //   dogList[i].printDogInfo();
    // }

    // compare 2 dogs
      // define 2 dogs
      Dog d0 = new Dog(4, "Max", 33f);
      Dog d1 = new Dog(5, "Luna", 80.433f);

      Dog bigger = Dog.maxDog(d0, d1);
      //bigger.printDogInfo();

      Dog d3 = new Dog(6, "Johnny", 10.555f);
      Dog bigger2 = d3.maxDog(d1);
      bigger2.printDogInfo();

      System.out.println(bigger2.binomen);
      System.out.println(Dog.binomen);
  }
}
