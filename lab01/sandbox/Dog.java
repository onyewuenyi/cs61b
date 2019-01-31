public class Dog {
  public int id;
  public String type;
  public float weightInPounds;
  public static String binomen = "Canis familars";

  public Dog(int i, String t, float w) {
    id = i;
    type = t;
    weightInPounds = w;
  }

  public void printDogInfo() {
    System.out.printf("id: %d\ntype: %s\nweight: %f\n", id, type, weightInPounds);
  }


  public static Dog maxDog(Dog d0, Dog d1) {
    if(d0.weightInPounds > d1.weightInPounds) {
      return d0;
    }
    return d1;
  }



  public Dog maxDog(Dog d1) {
  	if(weightInPounds > d1.weightInPounds) {
  		return this;
  	}
  	return d1;
  }
}
