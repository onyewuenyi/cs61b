import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the AList class.
 *  @author Josh Hug
 */

public class AListTest {
    @Test
    public void testEmptySize() {
        AList L = new AList();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        AList L = new AList();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }


    @Test
    public void testAddAndGetLast() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.getLast());
        L.addLast(36);
        assertEquals(36, L.getLast());
    }


    @Test
    public void testGet() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        assertEquals(36, L.get(1));
    }


    @Test
    public void testRemove() {
        AList L = new AList();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        L.removeLast();
        assertEquals(99, L.getLast());
        L.addLast(100);
        assertEquals(100, L.getLast());
        assertEquals(2, L.size());
    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        AList L = new AList();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }
    
    @Test
    public void addTest() {
        AList<Integer> L = new AList<Integer>();
        L.addLast(5);
        L.addLast(2);
        L.addLast(8);
        L.addLast(9);
        L.addLast(6);

        // index out of bounds check: list L size should stay the same
        L.add(-11, 44);
        assertEquals(5, L.size());

        L.add(40, 44);
        assertEquals(5, L.size());



        // add element check
        L.add(2, 55);
        int value = L.get(2);
        assertEquals(55, value);
    }

    @Test
    public void testContains() {
        AList<Integer> L = new AList<Integer>();
        L.addLast(5);
        L.addLast(2);
        L.addLast(8);
        L.addLast(9);
        L.addLast(6);


        assertEquals(true, L.contains(8));
        assertEquals(false, L.contains(88));
    }

    @Test
    public void testRemoveIthItem() {
        AList<Integer> L = new AList<Integer>();
        L.addLast(5);
        L.addLast(2);
        L.addLast(8);
        L.addLast(9);
        L.addLast(6);

        L.remove(6);
        L.remove(2);

        assertEquals(null, L.get(4));
        assertEquals(null, L.get(1));

    }


        public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", AListTest.class);
    }
}