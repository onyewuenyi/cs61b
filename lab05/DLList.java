/**
 * A generic DLList with a circular sentinel Node, which simplifies development
 of the API of the ADT no null checking: sentinel.next or sentinel.prev = sentinel node address
 */
public class DLList<BleepBlorp> {
     // TODO: 2019-06-18 Refractor "if (i > size - 1) throw new ArrayIndexOutOfBoundsException("index out of bounds");
     //        if (empty()) throw new IllegalArgumentException("Input list is empty");" to a function

      /** Fix: Had to make Node static
       * Fix: Had to declare generic version of Node. Orginally I was able to
       * define Node's member item BleepBlorp, but discovered this reqires
       * access to DLList, which is blocked when I declare Node static
       *
       * Fix for passing type paratmer to nested class: https://stackoverflow.com/questions/5211890/java-generics-with-class-and-nested-static-interface
       */
      private static class Node<BleepBlorp>{
         public Node prev;
         public BleepBlorp item;
         public Node next;

         public Node(BleepBlorp i, Node p, Node n) {
             prev = p;
             item = i;
             next = n;
         }
      }

    /* The first item (if it exists) is at sentinel.next. */
    private Node<BleepBlorp> sentinel;
    private int size;

    /** Creates an empty DLList. */
    public DLList() {
        sentinel = new Node<BleepBlorp>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Returns a DLList consisting of the given values. */
    public static <BleepBlorp> DLList of(BleepBlorp... values) {
        DLList<BleepBlorp> list = new DLList<>();
        for (BleepBlorp value : values) {
            list.addLast(value);
        }
        return list;
    }

     public boolean empty() {
         return (sentinel.prev == sentinel) && (sentinel.next == sentinel);
     }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds item to the front of the list. */
    public void addFirst(BleepBlorp item) {
        Node<BleepBlorp> n = new Node<BleepBlorp>(item, sentinel, sentinel.next);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /** Adds item to the back of the list. */
    public void addLast(BleepBlorp item) {
        Node<BleepBlorp> n = new Node<BleepBlorp>(item, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /**
     * DLList API helper method
     * The method I am tasked to develop
     * Returns the reference to the ith Node, throw an IllegalArgumentException
     * if the list is empty, or throws an ArrayIndexOutOfBoundsException
     * if the index i is   out of range
     */

     //static recurisve helper method for getRef. Common design pattern in Java
     private static Node getRef(int index, Node ptr, int size) {
         if (index == 0) return ptr;
         return getRef(index - 1, ptr.next, size);
     }


     public Node getRef(int index) {
         if (empty()) throw new IllegalArgumentException("Input list is empty");
         if (index > size - 1) throw new ArrayIndexOutOfBoundsException("index out of bounds");
         return getRef(index, sentinel.next, size);
     }


    /** Method I am tasked to dev
     * Adds item to the list at the specified index. */
    public void add(int index, BleepBlorp item) {
        // special case code: add to start of list; check if index is out of bounds, "index > size"
        if (empty()) {
            addFirst(item);
            return;
        } else if (index == size) {
            addLast(item);
            return;
        }
        else if (index > size ) throw new ArrayIndexOutOfBoundsException("index out of bounds");

            Node ithNodeRef = getRef(index);
            Node<BleepBlorp> newNode = new Node<BleepBlorp>(item, ithNodeRef.prev, ithNodeRef);
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
            size += 1;
    }
    private static void unlink(Node ptr) {
        Node next = ptr.next;
        Node prev = ptr.prev;

        ptr.next = null;
        ptr.prev = null;

        prev.next = next;
        next.prev = prev;
    }

    private Node findRef(BleepBlorp item) {
        Node ptr = sentinel.next;
        while (ptr.item != null) {
            if (ptr.item == item) return ptr;
            ptr = ptr.next;
        }
        return null;
    }


    /** Remove the first instance of item from this list. */
    public void remove(BleepBlorp item) {
        // effciency: O(N) runtime and O(N) space
        Node itemRef = findRef(item);
        unlink(itemRef);
        size--;
    }

    @Override
    public String toString() {
        String result = "";
        Node p = sentinel.next;
        boolean first = true;
        while (p != sentinel) {
            if (first) {
                result += p.item.toString();
                first = false;
            } else {
                result += " " + p.item.toString();
            }
            p = p.next;
        }
        return result;
    }

    /** Returns whether this and the given list or object are equal. */
    public boolean equals(Object o) {
        DLList other = (DLList) o;
        if (size() != other.size()) {
            return false;
        }
        Node op = other.sentinel.next;
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (!(p.item.equals(op.item))) {
                return false;
            }
            op = op.next;
        }
        return true;
    }


}
