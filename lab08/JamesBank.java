public class JamesBank implements Bank {
  public static class Total {
    /*** No getters are needed bc this is a nested data class. The parent
    class has access permissions to all this class members
    A data class has not methods; other than toString, equals, and ....
    */
    public double retirement;
    public double checking;
    public double savings;
    public double HSA;

    public Total() {
      retirement = 0;
      checking = 0;
      savings = 0;
      HSA = 0;
    }

    public Total(double retirement, double checking, double savings, double HSA) {
      this.retirement = retirement;
      this.checking = checking;
      this.savings = savings;
      this.HSA = HSA;
    }


  }

  private Total total;

  public JamesBank() {
    total = new Total();
  }

  public JamesBank(double amount) {
    double retirement = amount / 5;
    double checking = amount / 2.5;
    double savings = amount / 5;
    double HSA = amount / 10;
    total = new Total(retirement,checking, savings, HSA);
  }

  // JamesBank implemention of  interface methods
  @Override
  public getTotal() return total.retirement + total.checking + total.savings + total.HSA;

  // I have used these twice in each Bank subclass. This is a good piece of code
  // to generalize, but how exactly
  // calls specific getTotal methods
  // double curr = getTotal();
  // System.out.println("Balance = " + curr + "\nNew Balance = " + getTotal() );

  @Override
  public double withdraw(double amount) {
    double curr = getTotal();
    total.checking -= amount;
    System.out.println("Balance = " + curr + "\nNew Balance = " + getTotal() );
  }
  @Override
  public void deposit(double amount) {
    double curr = getTotal();
    total.checking += amount;
    System.out.println("Balance = " + curr + "\nNew Balance = " + getTotal() );

  }
}
