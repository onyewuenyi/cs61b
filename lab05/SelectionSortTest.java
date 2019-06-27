import org.junit.Test;
import static org.junit.Assert.*;

public class SelectionSortTest {
    // https://www.baeldung.com/junit-assert-exception

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionSelectionSort() {
        // empty list
        String[] empty = {};
        SelectionSort.selectionSort(empty);
    }



    @Test
    public void testSelectionSort() {
        // basic case
        String[] actually = {"I", "have", "an", "egg"};
        String[] expected = {"I", "an", "egg", "have"};
        SelectionSort.selectionSort(actually);
        assertArrayEquals(expected, actually);

        // not case sensitive and empty str
        String[] actually1 = {"Axe", "", "axe", "egg"};
        String[] expected1 = {"", "Axe", "axe", "egg"};
        SelectionSort.selectionSort(actually1);
        assertArrayEquals(expected1, actually1);
    }

    // same code. It would be good to turn this in a function that takes the function it wants to call and the input
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionFindSmallest() {
        String[] empty = {};
        int i = 0;
        SelectionSort.findSmallest(empty, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIFindSmallest() {
        // i out of bounds
        String[] smallestFirst = {"charles", "max", "axeaaa", "axe"}; // smallest is the first item
        int i = 44;
        org.junit.Assert.assertEquals(3, SelectionSort.findSmallest(smallestFirst, 44));
    }

    @Test
    public void testFindSmallest() {
        // 1 word
        String[] oneItem = {"Zak"}; // 1 item
        int i = 0;
        org.junit.Assert.assertEquals(0, SelectionSort.findSmallest(oneItem, i));

        // mix case words
        String[] smallestLast = {"egg", "Charles", "Axe", "an"};// smallest is the last item
        org.junit.Assert.assertEquals(2, SelectionSort.findSmallest(smallestLast, 0));

        // all lower case words
        String[] smallestFirst = {"charles", "max", "axeaaa", "axe"}; // smallest is the first item
        org.junit.Assert.assertEquals(3, SelectionSort.findSmallest(smallestFirst, 0));

    }

    @Test
    public void testStrComp() {
        // Upper case
        String s0 = "egg";
        String s1 = "Axe";

        boolean actually = SelectionSort.strComp(s0, s1);
        org.junit.Assert.assertEquals(false, actually);

        // Empty
        s0 = "";
        s1 = "and";
        actually = SelectionSort.strComp(s0, s1);
        org.junit.Assert.assertEquals(true, actually);

        // same chars until the ith char
        s0 = "aaa";
        s1 = "aaaaaax";
        actually = SelectionSort.strComp(s0, s1);

        // this input was failling: Axe", "egg"
    }

    @Test
    public void testMinLength() {
        // basic test of functionality
        String s0 = "Charles";
        String s1 = "Maya";

        int actual = SelectionSort.minLength(s0, s1);
        org.junit.Assert.assertEquals(4, actual);

        // test empty String
        s0 = "";
        s1 = "Charles";
        actual = SelectionSort.minLength(s0, s1);
        org.junit.Assert.assertEquals(0, actual);
    }
}


