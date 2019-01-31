public class DefaultValuesClass {

  public static String bark = "Whoooo";
  public String name;
  public int age;

  // public DefaultValuesClass(String myName, int myAge) {
  //   name = myName;
  //   age = myAge;
  // }

  public DefaultValuesClass(String myName, int myAge) {
    // store local var into ref
    name = myName;
    age = myAge;
  }


  // class methods
  public static void older(DefaultValuesClass s0, DefaultValuesClass s1) {
    if (s0.age > s1.age) {
      System.out.println("DefaultValuesClass s0 is older" + bark);
    }
    else {
      System.out.println("DefaultValuesClass s1 is older" + bark);
    }
  }

  // instance methods
  public void printDefaultValuesClassInstance() {
    System.out.printf("name = %s\nage = %d", name, age);
  }
}
