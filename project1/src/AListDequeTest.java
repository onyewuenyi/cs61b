import org.junit.Test;
import static org.junit.Assert.*;
public class AListDequeTest {
    @Test
    public void testHelpers() {
        AListDeque<String> d0 = AListDeque.of("Charles", "Maya", "James");
        d0.printDeque();

        // of
        assertEquals(AListDeque.of("Charles", "Maya", "James"), d0);

        // lastItemIndex
        assertEquals(2, d0.lastItemIndex());

        // isFull, isEmpty, size, listUsageGood
        AListDeque<Integer> d1 = new AListDeque<>();
        assertEquals(true, d1.isEmpty());
        assertEquals(false, d1.listUsageGood());

        for (int i = 0; i < 8 ; i++) {
            d1.addLast(55);
        }

        assertEquals(8, d1.size());
        assertEquals(true, d1.listFull());
        assertEquals(true, d1.listUsageGood());


        // test a seq of 2 growList calls

        // 1st growList call the i0 iteration

        // size of arr = 9; len = 16
        d1.addLast(100);

        for (int i = 0; i < 7 ; i++) {
            d1.addLast(100);
        }
        // test AListDeque size and list len
        assertEquals(16, d1.size());
        assertEquals(16, d1.listSize());

        // 2nd growList call
        d1.addLast(100);

        assertEquals(17, d1.size());
        assertEquals(32, d1.listSize());



        // test removeLast
        AListDeque<Double> d2 = AListDeque.of(33.4, 55.4,10.5, 22.4);
        assertEquals(8, d2.listSize());
        assertEquals(4, d2.size());


        //test shrinkList
        d2.removeLast();
       assertEquals(AListDeque.of(33.4, 55.4,10.5), d2);
       assertEquals(8, d2.listSize());
       assertEquals(3, d2.size());

        d2.removeLast();
        d2.removeLast();
        assertEquals(4, d2.listSize());
        assertEquals(1, d2.size());



        // removeFirst test
        AListDeque<Double> d3 = AListDeque.of(33.4, 55.4,10.5, 22.4);
        d3.removeFirst();
        d3.removeFirst();
        assertEquals(8, d3.listSize());
        assertEquals(2, d3.size());
        assertEquals(AListDeque.of(10.5, 22.4), d3);







    }


}
