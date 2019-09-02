/***
 * 1. add and remove must take constant time, except during resizing operations. A circular arr is used to achive this
 * 2. get and size must take constant time.
 * 3. The starting size of your array should be 8.
 * 4. The amount of memory that your program uses at any given time must be proportional to the number of items.
 *  For example, if you add 10,000 items to the deque, and then remove 9,999 items, you shouldn’t
 *  still be using an array of length 10,000ish. For arrays of length 16 or more, your usage factor should
 *  always be at least 25%. For smaller arrays, your usage factor can be arbitrarily low.
 * */
public class AListDeque<T> implements Deque<T> {
    private T[] list;
    private int size;
    private int nextFirst;
    private int nextLast;

    private final static int HEAD = 3;
    private final static int TAIL = 4;
    private static final int RESIZE_FACTOR = 2;
    private static final double USAGE_FACTOR_MIN_16 = 0.25;
    private static final double USAGE_FACTOR_MAX_15 = 0.15;
    private static final int DEFAULT_ARRAY_SIZE = 8;

    public AListDeque() {
        list = (T[]) new Object[DEFAULT_ARRAY_SIZE];
        size = 0;
        nextFirst = HEAD;
        nextLast = TAIL;
    }

    /*** AListDeque API: implements Deque Interface  */
    
    /*** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        if(listFull()) growList();
        list[nextFirst] = item;
        size += 1;
        nextFirst = decrementPtr(nextFirst);
    }

    /*** Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        if (listFull()) growList();
        list[nextLast] = item;
        size += 1;
        nextLast = incrementPtr(nextLast);
    }

    /*** Removes and returns the item at the front of the deque. If no such item exists, returns null*/
    public T removeFirst() {
        if (isEmpty()) return null;
        T item = list[getFirstItemIndex()];

        list[getFirstItemIndex()] = null;
        incrementPtr(nextFirst);
        size -= 1;

        if (!listUsageGood()) shrinkList();
        return item;
    }

    /*** Removes and returns the item at the back of the deque. If no such item exists, returns null*/
    public T removeLast(){
        if (isEmpty()) return null;
        T item = list[getLastItemIndex()];

        list[getLastItemIndex()] = null;
        decrementPtr(nextLast);
        size -= 1;


        if (!listUsageGood()) shrinkList();
        return item;
    }

    /*** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque*/
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        int lastIndex = size - 1;
        if( ! indexInBounds(index)) {
            throw new ArrayIndexOutOfBoundsException("index " + index + "is not a valid index in AListDeque instance. The last index is " + lastIndex);
        }
        return list[index];
    }

    /*** Returns true if deque is empty, false otherwise. Logic dependent on size member*/
    public boolean isEmpty() {
        return size == 0;
    }

    /*** Returns the number of items in the deque*/
    public int size() {
        return size;
    }

    /*** Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += list[i] + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
    }

    /*** AListDeque API Helpers */

    /** Return the index of the last item; or throw a IndexOutOfBoundsException if the internal list is empty  */
    private int getLastItemIndex() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException("AListDeque is empty!!!");
        return decrementPtr(nextLast);
    }

    /** Return the index of the first item; or throw a IndexOutOfBoundsException if the internal list is empty  */
    private int getFirstItemIndex() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException("AListDeque is empty!!!");
        return incrementPtr(nextFirst);
    }

    /*** addLast and rmLast helper fun: update nextLast ptr in the circular internal array. nextnex increments +1 until
     *  it is at the last index in the array.*/
    public int incrementPtr(int ptr) {
         return (ptr + 1) % list.length;
    }

    /*** Traverse ptr in the decresing direction of the circular internal array: e.g 3, 1, 0, N, N-1 */
    public int decrementPtr(int ptr) {
        if ( ! (ptr == 0)) {
            return ptr - 1;
        } else {
            return list.length - 1;
        }
    }

    /*** Return a new AListDeque containing items*/
    public static <T> AListDeque<T> of(T... items) {
        AListDeque<T> newList = new AListDeque<>();
        for (int i = 0; i < items.length; i++) {
            newList.addLast(items[i]);
        }
        return newList;
    }

    /*** List state change helper: Cp the contents in the current full array to a new arr with 2X the size */
    public void growList() {
        // create new arr
        T[] newArr = (T[]) new Object[list.length * RESIZE_FACTOR];

        // cp over all elements from curr to new array
        for (int i = 0; i < list.length; i++) {
            newArr[i] = list[i];
        }
        // update curr arr ref to new arr
        list = newArr;
    }

    /*** shrinkList helper: Return true if the list usage > 25% for an arr  with a len >= 16 ; and usage > 5% for a arr with a len <= 16*/
    public boolean listUsageGood() {
        if (list.length >= 15) {
            double ratio = (double) size / list.length;
            return ratio >= USAGE_FACTOR_MIN_16;
        }
        double ratio = (double) size / list.length;
        return ratio >= USAGE_FACTOR_MAX_15;
    }

    /*** List state change helper: Create a new list half the size of the curr and copy over the items. */
    public void shrinkList() {
        // create new smaller arr to cp items from curr arr
        T[] newArr = (T[]) new Object[(int) (list.length / 2)];
        for (int i = 0; i < size; i++) {
            newArr[i] = list[i];
        }
        // update curr arr ref to new arr
        list = newArr;
    }

    public boolean listFull() {
        return size == list.length;
    }

    public int lastItemIndex() { return size -1; }

    public boolean firstItemPtrWrapped() {
        return getFirstItemIndex() > HEAD;
    }

    public boolean lastItemPtrWrapped() {
        return getLastItemIndex() < TAIL;
    }

    /*** get helper method */
    public boolean indexInBounds(int index) {
        // check if nextFirst or nextLast has wrapped around
        // first item index

        if (firstItemPtrWrapped()) {
            if (
                    (index >= getFirstItemIndex()) && (index <= list.length - 1) &&
                            ((index >= 0) && (index <= HEAD))
            )
            {

            }
        } else {
            // range: first item index to HEAD, which i
            return ( (index >= getFirstItemIndex()) && (index <= HEAD));
        }

    }

    public int listSize() {
        return list.length;
    }

    @Override
    public boolean equals(Object o) {
        // same obj
        if (this == o) return true;

        // input obj null or not that same class or superclass
        if (o == null || getClass() != o.getClass()) return false;

        AListDeque<T> that = (AListDeque<T>) o;

        // list same size
        if (size != that.size) return false;

        // traverse both list and check if each i item are equal
        for (int i = 0; i < size ; i++) {
            T listIthValue = list[i];
            T thatIthValue = that.get(i);

            if ( !(listIthValue.equals(thatIthValue)) ) {
                return false;
            }
        }
        // all items in both list are equal
        return true;
    }
}