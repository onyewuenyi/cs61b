
/*** Invariants
 * add and remove - O(1)
 * get must use iteration; O(N)
 * size - O(1)
 *
 * 1. add and remove operations must not involve any looping or recursion. A single such operation must take
 * “constant time”, i.e. execution time should not depend on the size of the deque.
 *
 * 2. get must use iteration, not recursion.
 * size must take constant time.
 *
 * 3. The amount of memory that your program uses at any given time must be proportional to the number of items.
 * For example, if you add 10,000 items to the deque, and then remove 9,999 items, the resulting size should be more
 * like a deque with 1 item than 10,000. Do not maintain references to items that are no longer in the deque.
 *
 * 4. The first item index is 0
 */
public class DLListDeque<T> implements Deque<T> {

    // Data model part declaration and implementation

    // Problem: We want to access the generic type T from DLListDeque class, which is non-static, in Node class
    // If Node is static then we would be a ref to non-static thing from a static context, which is not allowed

    // Solution: rm static from Node class declaration

    // Problem: Do not redeclare the generic type in the Node declaration bc then we would have two T and the complier will get
    // confused

    // Solution: Delete T and you can access T from the parent class bc Node class is nested
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node() {
            prev = null;
            item = null;
            next = null;
        }

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // DLListDeque data model parts
    private Node sentinel;
    private int size;

    // DLListDeque constructors
    public DLListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /*** DLListDeque API */

    /*** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        if(isEmpty()) {
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        }
        size += 1;
    }

    /*** Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        Node lastNodePtr = sentinel.prev;
        Node newNode = new Node(lastNodePtr, item, sentinel);
        lastNodePtr.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /*** Removes and returns the item at the front of the deque. If no such item exists, returns null*/
    public T removeFirst() {
        if(isEmpty()) return null;
        Node firstNode = sentinel.next;
        Node firstSuccessorNode = firstNode.next;
        T firstNodeItem = firstNode.item;

        setNodeNull(firstNode);

        firstSuccessorNode.prev = sentinel;
        sentinel.next = firstSuccessorNode;
        size -= 1;

        return firstNodeItem;
    }

    /*** Removes and returns the item at the back of the deque. If no such item exists, returns null*/
    public T removeLast() {
        if(isEmpty()) return null;
        Node lastNode = sentinel.prev;
        Node lastNodePred = lastNode.prev;
        T lastNodeItem = lastNode.item;

        setNodeNull(lastNode);

        // update list ptrs
        lastNodePred.next = sentinel;
        sentinel.prev = lastNodePred;
        size -= 1;

        return lastNodeItem;
    }


    /*** Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        return (sentinel.next == sentinel) && (sentinel.prev == sentinel);
    }

    /*** Returns the number of items in the deque*/
    public int size() {
        return size;
    }

    /*** Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        String str = "";
        Node ptr = sentinel.next;
        while(ptr != sentinel) {
            str += ptr.item + ",";
            ptr = ptr.next;
        }
        System.out.println(str.substring(0, str.length() - 1));
    }

    /*** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque*/
    public T get(int index) throws IndexOutOfBoundsException {
        int lastIndex = size - 1;
        if (! (index <= lastIndex)) throw new IndexOutOfBoundsException("index " + index + "is not a valid index the DLLDeque instance. The last index is " + lastIndex);
        Node ptr = sentinel.next;
        // mv ptr to the index item in the list
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /*** DLListDeque Helpers*/

    /*** Set all the Nodes members to Null to prep to be correctly removed by the garbage collector */
    public void setNodeNull(Node node) {
        node.prev = null;
        node.next = null;
        node.item = null;
    }

    /*** Return an instance of DLListDeque containing values of type T. The Nth value of the list of values is stored
     * as the Nth item in the DLListDeque instance */
    public static <T> DLListDeque of(T... values) {
        DLListDeque<T> list = new DLListDeque<>();
        for(T value: values) {
            list.addLast(value);
        }
        return list;
    }

     /*** get, but implemented recursively
      * Err: DLLDeque.this cannot be ref from a static context.
      * This error occurs bc Node has an implicit ref to DLLDeque
      * Node is a member of DLLDeque: this.Node
      *
      * Must use a helper method to pass in Node; for this is an instance of DLLDeque and not Node
      */
    public  Node getRecursiveHelper(Node ptr, int index) {
        if (index == 0) {
            return ptr;
        } else {
            return getRecursiveHelper(ptr.next, index - 1);
        }
    }

    public T getRecursive(int index) throws IndexOutOfBoundsException {
        int lastIndex = size - 1;
        if (! (index <= lastIndex)) throw new IndexOutOfBoundsException("index " + index + " is not a valid index the DLLDeque instance. The last index is " + lastIndex);
        Node firstNode = sentinel.next;
        return getRecursiveHelper(firstNode, index).item;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DLListDeque<T> that = (DLListDeque<T>) o;
        if (size != that.size) return false;
        Node ptr0 = sentinel.next;
        Node ptr1 = that.sentinel.next;

        while(ptr0 != sentinel) {
            if (! (ptr0.item.equals(ptr1.item))) return false;
            ptr0 = ptr0.next;
            ptr1 = ptr1.next;
        }
        return true;

    }
}
