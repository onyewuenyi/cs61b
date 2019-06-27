import org.junit.Test;
import static org.junit.Assert.*;

public class SLListTest {
    // @Test
//    public void testSLListAdd() {
//        SLList test1 = SLList.of(1, 3, 5);
//        SLList test2 = new SLList();
//
//        test1.add(1, 2);
//        test1.add(3, 4);
//        assertEquals(5, test1.getSize());
//        assertEquals(3, test1.get(2));
//        assertEquals(4, test1.get(3));
//
//        // I changed this test: index 1 does not exists in an empty list and should throw an exception:
//        // org: test2.add(1, 1)
//        // new: test2.add(0, 1);
//
//        test2.add(0, 1);
//        assertEquals(1, test2.get(0));
//        assertEquals(1, test2.getSize());
//
//        // learn how to expect an certain exception
//        // I noticed that I am using junit4 instead of 5. Find out how to update the library in Java and IntellJ
//        // https://www.baeldung.com/junit-assert-exception
//        //test2.add(10, 10);
//        // assertEquals(10, test2.get(1));
//        test1.add(0, 0);
//        assertEquals(SLList.of(0, 1, 2, 3, 4, 5), test1);
//    }

//    @Test
//    public void testSLListReverse() {
//        // empty
//        SLList s0 = new SLList();
//        s0.reverse();
//        assertEquals(new SLList(), s0);
//
//        // one element and that the reverse is in-place
//        SLList s1 = SLList.of(1);
//        s1.reverse();
//        assertEquals(s1, s1);
//        assertEquals(SLList.of(1), s1);
//
//
//        // reverse behavior
//        SLList actual = SLList.of(8, 11, 2, 5);
//        actual.reverse();
//
//        assertEquals(s1, s1);
//        assertEquals(SLList.of(5, 2, 11, 8), actual);
//    }

//    @Test
//    public void testAdd() {
////        SLList s0 = new SLList();
////        s0.add(0, 55); // ???
//
//        SLList s1 = SLList.of(8, 11, 2, 5);
//        s1.add(2, 55);
//        assertEquals(s1, s1); // test that the op is in-place
//        assertEquals(SLList.of(8, 11, 55, 2, 5), s1);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddIllegalArgument() {
//        SLList s0 = SLList.of(8, 11, 2, 5);
//        s0.add(10, 44);
//    }
}
