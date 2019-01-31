public class SumArgs {
  // static method/class; no access to instance vars; call with class SumArgs.main
  // return type void
  // input is an vector of strings
  public static void main(String[] args) {
    int total = 0;
    for(int i=0; i < args.length; i++) {
      total += Integer.parseInt(args[i]);
    }
    System.out.printf("Total = %d", total);
  }
}
