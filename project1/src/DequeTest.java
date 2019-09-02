import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTest {
    /*** Unit-test for methods that modify the state of the Deque: addFirst, addLast, removeFirst, removeLast*/
    @Test
    public void testModifyDequeState() {
        // TODO: 2019-08-20 Design and build simple test and then add more complex scenarios to test

        DLListDeque<Integer> deque0 = DLListDeque.of(55,88,100,9);
        //ArrayDeque<Integer> arrayDequeItems = new ArrayDeque<>();


        // simple size test
        assertEquals(4, deque0.size());



        // get test
        assertEquals(Integer.valueOf(100), deque0.get(2));

        // of empty test
        DLListDeque<Integer> emptyDeque = DLListDeque.of();
        assertEquals(true, emptyDeque.isEmpty());

        /*** State change tests */
        DLListDeque<Integer> deque1 = DLListDeque.of(55,88,100,9);

        // addFirst test
        deque1.addFirst(1);
        assertEquals(Integer.valueOf(1), deque1.get(0));

        // addLast test
        deque1.addLast(300);
        assertEquals(Integer.valueOf(300), deque1.getRecursive(deque1.size() - 1));

        assertEquals(Integer.valueOf(88), deque1.getRecursive(2));

        // rm last and rm 1st
        // deque1 = {1, 55, 88, 100, 9, 300}

        deque1.removeFirst();

        deque1.printDeque();
        deque1.removeLast();
        deque1.printDeque();

        assertEquals(Integer.valueOf(55), deque1.get(0));
        assertEquals(Integer.valueOf(9), deque1.get(deque1.size() - 1));

        // test contents and order
        assertEquals(DLListDeque.of(55, 88, 100, 9), deque1);


        // isEmpty
        deque1.removeLast();
        deque1.removeLast();
        deque1.removeLast();
        deque1.removeLast();
        assertEquals(true, deque1.isEmpty());


    }

}
