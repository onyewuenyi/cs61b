public class DefaultValues {
  public static void main(String[] args) {

    // declare ref var; java i allocate 64 bits in mem
    DefaultValuesClass s0;
    DefaultValuesClass s1;

    // create a instance in memory and return the address using the new op
    s0 = new DefaultValuesClass("Charles", 44);
    s1 = new DefaultValuesClass("Maya", 66);
    System.out.println(s0.name);
    System.out.println(s1.name);

    DefaultValuesClass.older(s0, s1);

  }
}
