// declare that CharlesBank is a subclass of Bank using interface inheritance
// promised that we would implement the methods specified in the interface
public class CharlesBank implements Bank {
  // In CharleBank total is broken into 2 parts

  // underlying data model should be different from MayaBank; data class
  // nested static (dont talk to the parent class) inner class
  public static class Total {
    public double checking;
    public double savings;

    public Total() {
      checking = 0;
      savings = 0;
    }
    public Total(double checking, double savings) {
      this.checking = checking;
      this.savings = savings;
    }
  }
  private Total total;

  public CharlesBank() {
    total = new Total();
  }

  public CharlesBank(double amount) {
    double partialAmount = amount / 4;
    double newAmount = amount - partialAmount;
    total = new Total(newAmount, partialAmount);
  }


  // CharlesBank implemention of  interface methods
  @Override
  public double getTotal() { return total.checking + total.savings; }

  @Override
  public double withdraw(double amount) {
    double curr = getTotal();
    total.checking -= amount;
    System.out.println("Balance = " + curr + "\nNew Balance = " + getTotal() );
    return getTotal();
  }

  @Override
  public void deposit(double amount) {
    double curr = getTotal();
    total.checking += amount;
    System.out.println("Balance = " + curr + "\nNew Balance = " + getTotal() );
  }
}
