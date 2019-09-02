import org.junit.Test;
import static org.junit.Assert.*;

public class TestBank {
  @Test
  public void testWithdraw() {
    CharlesBank b0 = new CharlesBank(60);
    b0.withdraw(50);
    assertEquals(10, b0.getTotal(), 0.5);

    JamesBank j0 = new JamesBank(60);
    j0.withdraw(50);
    assertEquals(10, j0.getTotal(), 0.5);
  }

  @Test
  public void testDeposit() {
    CharlesBank b0 = new CharlesBank(100);
    JamesBank j0 = new JamesBank(100);
    b0.deposit(50);
    j0.deposit(50);
    assertEquals(150, b0.getTotal(), 0.5);
    assertEquals(150, j0.getTotal(), 0.5);

    // call default method imp in the Bank interface
    b0.printTotal();
    j0.printTotal();
  }
}
