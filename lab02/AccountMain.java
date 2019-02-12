public class AccountMain {
  public static void main(String[] args) {
    Account kathy = new Account(100);
    Account megan = new Account(100, kathy);
    megan.withdraw(50);
    megan.withdraw(200);  // kathy can't cover
    megan.withdraw(700); // kathy can't cover

    System.out.println("kathy balance = $" + kathy.balance);
    System.out.println("megan balance = $" + megan.balance);

  }
}
