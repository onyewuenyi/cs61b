public class IntList {
    public int value;
    public IntList next;

    public IntList(int f) {
        value = f;
        next = null;
    }

    public IntList(int f, IntList r) {
        value = f;
        next = r;
    }


    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.next;
        }
        return totalSize;
    }

    /** Return the size of the list using recursion! */
    public int size() {
        if (next == null) {
            return 1;
        }
        return 1 + this.next.size();
    }

    /** List ops helper function  */
    public IntList getIndexRef(int index) {
      // assume getIndexRef is always called on the head
      // TODO if this.next == null; return this
      // TODO out of range check
      int i = 0;
      IntList ptr = this;
      while(i < index) {
        ptr = ptr.next;
        i++;
      }
      return ptr;
    }

    /** Add an integer with the the value V at index I */
    public void add(int index, int value) {
      // assume add is always called on the head
      IntList L = new IntList(value);
      IntList ptr = this.getIndexRef(index - 1);
      IntList temp = ptr.next;
      ptr.next = L;
      L.next = temp;
    }

    /** Return the list element at the given (zero-indexed) pos in the list */
    public int get(int index) {
      // assume get is always called on the head
      IntList ptr = this.getIndexRef(index);
      return ptr.value;
    }



    public static void main(String[] args) {
        IntList L = new IntList(5,
                        new IntList(10,
                            new IntList(15, null)));
        System.out.println(L.iterativeSize());
        System.out.println(L.size());
        System.out.println(L.get(2));
        L.add(2, 22);
        System.out.println(L.get(2));
        System.out.println(L.get(3));


    }
}
