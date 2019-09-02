import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the MyAList class.
 *  @author Josh Hug
 */

public class MyAListTest {
  @Test
  public void testEmptySize() {
    MyAList L = new MyAList();
    assertEquals(0, L.size());
  }

  @Test
  public void testAddAndSize() {
    MyAList L = new MyAList();
    L.addLast(99);
    L.addLast(99);
    assertEquals(2, L.size());
  }


  @Test
  public void testAddAndGetLast() {
    MyAList L = new MyAList();
    L.addLast(99);
    assertEquals(99, L.getLast());
    L.addLast(36);
    assertEquals(36, L.getLast());
  }


  @Test
  public void testGet() {
    MyAList L = new MyAList();
    L.addLast(99);
    assertEquals(99, L.get(0));
    L.addLast(36);
    assertEquals(99, L.get(0));
    assertEquals(36, L.get(1));
  }


  @Test
  public void testRemove() {
    MyAList L = new MyAList();
    L.addLast(99);
    assertEquals(99, L.get(0));

    L.addLast(36);
    assertEquals(99, L.get(0));

    L.removeLast();
    assertEquals(99, L.getLast());

    assertEquals(null, L.get(2));

    L.addLast(100);
    assertEquals(100, L.getLast());
    assertEquals(2, L.size());
  }

  /** Tests insertion of a large number of items.*/
  @Test
  public void testMegaInsert() {
    MyAList L = new MyAList();
    //int N = 1000000;
    int N = 300;
    for (int i = 0; i < N; i += 1) {
      L.addLast(i);
    }

    for (int i = 0; i < N; i += 1) {
      L.addLast(L.get(i));
    }
  }

  @Test
  public void testShrinkAndCapacity() {
    // create Alist and fill it with the Integers from 0 to N -1
    MyAList L = new MyAList();
    int N = 10;
    for (int i = 0; i < N; i++) {
      L.addLast(i);
    }

    // rm 9   items
    int J = 9;
    for (int i = 0; i < J; i++) {
      L.removeLast();
    }

    // check size of the MyAlist L
    // I expect it to shrink to times resulting in a load factor of 0.50
    assertEquals(3, L.length());

    // test capacity
    assertEquals(0.33, L.capacity(), 0.05);

    // test size
    assertEquals(1, L.size());
  }

  @Test
  public void testGenericMyAlist() {
    MyAList<Double> A = new MyAList<Double>();
    A.addLast(55.3);
    A.addLast(33.1);
    A.addLast(22.1);
    A.removeLast();

    assertEquals(33.1, A.getLast(), 0.05);

  }


  public static void main(String[] args) {
    jh61b.junit.TestRunner.runTests("all", MyAListTest.class);
  }
}