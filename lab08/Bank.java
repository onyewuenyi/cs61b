public interface Bank {
  public double withdraw(double amount);
  public void deposit(double amount);

  public double getTotal();

  default public void printTotal() {
    System.out.println(getTotal());
  }
}
