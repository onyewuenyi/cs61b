/**
  * An SLList is a list of integers, which hides the terrible truth of the
  * nakedness within.
  * invariants:
  * sentinel is never equal to null. It always points to the sentinel node
  */
public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(int i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }

        @Override
        public String toString() {
            return "IntNode{" +
                    "item=" + item +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntNode intNode = (IntNode) o;

            if (item != intNode.item) return false;
            if (next != null ? !next.equals(intNode.next) : intNode.next != null) return false;
            return prev != null ? prev.equals(intNode.prev) : intNode.prev == null;
        }

        @Override
        public int hashCode() {
            int result = item;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            result = 31 * result + (prev != null ? prev.hashCode() : 0);
            return result;
        }
    }

    private IntNode sentinel;
    private int size;
    private IntNode last;

    //--------------------
    // Constructors
    //--------------------
    /** Creates list: Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63, null, null);
        size = 0;
        last = sentinel;  // point last to sentinel node
    }

     /** Creates list: Creates a SLList with 1 item with the value x. */
    public SLList(int x) {
        sentinel = new IntNode(63, null, null);
        IntNode firstNodePtr = sentinel.next;
        firstNodePtr = new IntNode(x, null, sentinel);
        size++;
        last = firstNodePtr;
    }

    //--------------------
    // Helpers
    //--------------------
    /** Mutates list: Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    public boolean isEmpty() {
        /** Return true if the list is empty */
        return sentinel.next == null && sentinel.prev == null;
    }

    public IntNode firstNodePtr() {
        return sentinel.next;
    }

    //--------------------
    // API
    //--------------------
     /** Mutates list: adds x to the front of the list. */
     public void addFirst(int x) {
         IntNode ptr = sentinel.next;
         ptr = new IntNode(x, null, ptr);
         size++;
         last = ptr;
     }


    /** Mutates list: Adds x to the end of the list in constant runtime using the cached member last */
    public void addLast(int x) {
        last.next = new IntNode(x, null, last);
        size++;
        last = last.next;
    }


    /** Mutates list: Rm the last item in the list: constant runtime O(N) */
    public void rmLast() {
        // The node last is cleaned up by the garbage collector
        IntNode tempLastPrev = last.prev;
        last.prev = null;
        last.prev.next = null;
        size--;
        last = tempLastPrev;
    }

     /** reverse helper function */
     private static void swap(IntNode headPtr, IntNode tailPtr) {
         int temp = headPtr.item;
         headPtr.item = tailPtr.item;
         tailPtr.item = temp;
     }

     /** Returns the reverse of this list. This method is destructive. */
//    public void reverse() {
//        IntNode firstItem = sentinel.next;
//        if (firstItem == null) return;
//        int size = getSize();
//
//        int x = size;
//        IntNode headPtr = firstItem;
//        IntNode tailPtr = getNodeRef(x, firstItem);
//        while(tailPtr.next != headPtr) {
//            swap(headPtr, tailPtr);
//            headPtr = headPtr.next;
//            x = x - 1;
//            tailPtr = getNodeRef(x, firstItem);
//        }
//    }

//    /** Add item with the value x to the index of the list specified by the ptr next. Returen ptr to new item */
//    public static IntNode addNode(IntNode next, int value) {
//        IntNode temp = next;
//        next = new IntNode(value, temp, temp.prev);
//        temp.prev = next;
//        return next;
//    }
//
//    /** Static recursive helper method to process the inner naked recursive data structure */
//    public static IntNode add(IntNode ptr, int i, int value) {
//        if (i == 0) {
//            return addNode(ptr, value); // specific line of code. How to DRY add, get, rm
//        } else {
//            add(ptr.next, value, i - 1);
//        }
//        return addNode(ptr, value); // specific line of code. How to DRY add, get, rm
//    }
//
//    /** Add item at the index i to the list*/
//     public void add(int i, int value) {
//        IntNode head = sentinel.next;
//        add(head, i, value);
//        size++;
//     }

     public void remove(int i) {
         return;
     }

     /** Return the value at the given index. */
     public int get(int index) {
         IntNode p = sentinel.next;
         while (index > 0) {
             p = p.next;
             index -= 1;
         }
         return p.item;
     }


    //--------------------
     // Auto-gen code
     //--------------------
     @Override
     public String toString() {
         return "SLList{" +
                 "sentinel=" + sentinel +
                 ", size=" + size +
                 '}';
     }


     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         SLList slList = (SLList) o;

         if (size != slList.size) return false;
         return sentinel != null ? sentinel.equals(slList.sentinel) : slList.sentinel == null;
     }


     public IntNode getLast() {
         return last;
     }

     public int getSize() {
         return size;
     }



 }
