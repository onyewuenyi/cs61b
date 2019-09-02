/**
 * Array-based list. Invariants:
 *
 *   addLast: The next item we want to add, will go into position size
 *   getLast: The item we want to return is in position size - 1
 *   size: The number of items in the list should be size.
 */
public class AList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Returns True or False if the collection contains k.
     * 1. Traverse list
     * */
    public boolean contains(Item x) {
        // TODO
        for (int i = 0; i < size; i++) {
            if (x.equals(get(i))) return true;
        }
        return false;
    }

    /** Adds x to the end of the list. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size += 1;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, Item x) {
        // input val

        // Alist range: 0 to size - 1
        if (index < 0 || index > size) {
            return;
        }
        // trigger resize if Alist is full
        else if (size == items.length) {
            resize(size * 2);
        }

        // FIXME
        // shift the elements starting from i right to make room to add x to index i
        // the bug is right here: we are writing over the value at i
        // the fix is to start from the tail with the shift right op
        for (int i = size; i > index; i -= 1) {
            items[i] = items[i - 1];
        }
        items[index] = x;
        size += 1;
    }

    /** Returns the last item in the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Returns the i-th item in the list, where 0 is the first item. */
    public Item get(int i) {
        return items[i];
    }

    /** Deletes item from back of the list and returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    /** Removes the first instance of the item from this list. */
    public void remove(Item x) {
        // TODO
        for (int i = 0; i < size; i++) {
            if (x.equals(items[i])) {
                items[i] = null;
                size -= 1;
                return;
            }
        }
        return;
    }
}
