import org.junit.Test;
import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void testSllist() {
        Slist<String> names = new Slist<String>();
        names.addLast("Charles");
        assertEquals("Charles", names.getLast());
    }

    @Test
    public void testDllist() {
        return;
    }

    @Test
    public void testAlist() {
        return;
    }
}
