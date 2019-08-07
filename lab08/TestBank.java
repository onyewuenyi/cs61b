import org.junit.Test;
import static org.junit.Assert.*;

public class TestBank {
  @Test
  public void testWithdraw() {
    CharlesBank b0 = new CharlesBank(60);
    b0.withdraw(50);
    assertEquals(10, b0.getTotal());

    JamesBank j0 = new JamesBank(60);
    j0.withdraw(50);
    assertEquals(10, j0.getTotal());
  }

  @Test
  public void testDeposit() {
    CharlesBank b0 = new CharleBank(100);
    JamesBank j0 = new JamesBank(100);
    b0.deposit(50);
    j0.deposit(50);
    assertEquals(150, b0.getTotal());
    assertEquals(150, j0.getTotal());
  }
}
