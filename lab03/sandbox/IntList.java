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

    public IntList recurGetRef(int i) {
      if(i == 0) return this;
      return next.recurGetRef(i - 1);
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

    public int recurGet(int i) {
      if(i == 0) return value;
      return next.recurGet(i - 1);
    }

    public String toString() {
      if(next == null) return String.valueOf(value);
      return value + "," + next.toString();
    }

    public boolean recurEquals(IntList l) {
      // input val
      if(this.size() != l.size()) return false;
      if((this == null) && (l == null)) return value == l.value; //basecase
      return value == l.value && next.equals(l.next); // recur case
    }

    public boolean iterEquals(IntList l) {
      boolean equal = true;
      IntList ptr = this;
      while(ptr != null) {
        equal = equal && (ptr.value == l.value);
        ptr = ptr.next;
        l = l.next;
      }
      return equal;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5,
                        new IntList(10,
                            new IntList(15, null)));
        IntList L1 = new IntList(5,
                        new IntList(10,
                            new IntList(15, null)));
        IntList L2 = new IntList(5,
                        new IntList(10,
                            new IntList(122, null)));



        // recurGet test
        if(L.recurGet(1) != 10) {
          System.out.println("Expect 10 but got " + L.recurGet(1));
        }
        else {
          System.out.println("Passed: recurGet");
        }


        // recurGetRef test
        IntList l = L.recurGetRef(2);
        if(l.value != 15) {
          System.out.println("Expect 15 but got " + l.value);
        }
        else {
          System.out.println("Passed: recurGetRef");
        }

        // toString
        System.out.println("Testing toString");
        System.out.println(L);

        System.out.println("equals test = " + L.equals(L1));
        System.out.println("equals test = " + L.recurEquals(L1));





    }
}
