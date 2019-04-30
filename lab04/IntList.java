/**
 * A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * <p>
 * This is a dummy implementation to allow IntListTest to compile. Replace this
 * file with your own IntList class.
 */
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /**
     * Returns an IntList consisting of the given values.
     */
    public static IntList of(int... values) {
        if (values.length == 0) {
            return null;
        }
        IntList p = new IntList(values[0], null);
        IntList front = p;
        for (int i = 1; i < values.length; i += 1) {
            p.rest = new IntList(values[i], null);
            p = p.rest;
        }
        return front;
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    /**
     * Returns [position]th value in this list.
     */
    public int get(int position) {
        if (position == 0) {
            return first;
        } else {
            return rest.get(position - 1);
        }
    }

    public IntList recurGetLastItemAddr() {
        if (rest == null) return this;
        return rest.recurGetLastItemAddr();
    }

    public String toString() {
        if (rest == null) return String.valueOf(first);
        return String.valueOf(first) + " " + rest.toString();

    }

    public boolean equals(Object o) {
        IntList other = (IntList) o;
        if (rest == null) return first == other.first;
        return (first == other.first) && rest.equals(other.rest);
    }


    public IntList iterGetLastItemAddr() {
        IntList ptr = this;
        while (ptr.rest != null) {
            ptr = ptr.rest;
        }
        return ptr;
    }

    public void add(int value) {
        IntList i = new IntList(value, null);
        IntList ptr = this.recurGetLastItemAddr();
        ptr.rest = i;
    }


    public int smallest() {
        int smallest = first;
        IntList ptr = this;
        while (ptr != null) {
            if (ptr.first < smallest) smallest = ptr.first;
            ptr = ptr.rest;
        }
        return smallest;
    }

    public int recurSmallest() {
        if (rest.rest == null) {
            if (first < rest.first) {
                return first;
            } else {
                return rest.first;
            }
        }
        int value = rest.recurSmallest();
        if (value < first) {
            return value;
        } else {
            return first;
        }
    }

    public int squaredSum() {
        int sum = 0;
        IntList ptr = this;
        while (ptr != null) {
            sum = sum + (ptr.first * ptr.first);
            ptr = ptr.rest;
        }
        return sum;
    }

    public int recurSquaredSum() {
        if (rest == null) return (first * first);
        return (first * first) + rest.recurSquaredSum();
    }

    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    public IntList iterSqr() {
        // create new list and add the first squared value
        IntList R = new IntList(first * first, null);
        // pointers
        IntList rPtr = R;
        IntList iPtr = rest;
        while (iPtr != null) {
            // compute sqr value for the ith e
            int ithValueSqr = iPtr.first * iPtr.first;
            // create a new node with its value eq to ithValueSqr
            IntList newNode = new IntList(ithValueSqr, null);
            // point the tail link to the new node
            rPtr.rest = newNode;
            // update rPtr to the next node newNode
            rPtr = rPtr.rest;
            iPtr = iPtr.rest;
        }
        return R;
    }

    public void recurSqr(IntList R) {
        /**
         * R - a list with the first node value already added
         * this - list, starting at the 2nd elemnet, that I want to copy the node value^2
         * post-condition: A list R built in memory that contains the values squared of the list this
         * */
        if (rest == null) {
            R.add(first * first);
            R = R.rest;
            return;
        }
        R.add(first * first);
        R = R.rest; // update traverse ptr to point to new node
        rest.recurSqr(R);
        return;
    }

    public void iterDSqr() {
        // cp of the ptr to the list L. This is used to keep track of the loc while traversing the list
        IntList ptr = this;

        // ptr != null:  at the end of the list
        while (ptr != null) {
            ptr.first = ptr.first * ptr.first; // mutate the list ith node's value
            ptr = ptr.rest; // traverse to next node
        }
        return;
    }

    public void recurDSqr() {
        if (rest == null) {
            first = first * first;
            return;
        }
        first = first * first;
        rest.recurDSqr();
        return;
    }

    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }

    public IntList copyIntList() {
        if (rest == null) return new IntList(first, null);
        return new IntList(first, rest.copyIntList());
    }

    public static IntList catenate(IntList A, IntList B) {
        if ((A == null) || (B == null)) return A;
        IntList aCopy = A.copyIntList();
        IntList bCopy = B.copyIntList();
        IntList last = aCopy.recurGetLastItemAddr();
        last.rest = bCopy;
        return aCopy;
    }


    public static IntList dcatenate(IntList A, IntList B) {
        // want to return null; could return A or B. I choose to return A to be consistent with the other return
        // statememnt; for that is the list we are appending to
        if ((A == null) || (B == null)) return A;
        IntList last = A.recurGetLastItemAddr();
        IntList bCopy = B.copyIntList();
        last.rest = bCopy;
        return A;
    }


    public static void main(String args[]) {
        IntList L = new IntList(2, null);
        L.add(3);
        L.add(4);


        IntList L0 = new IntList(77, null);
        L0.add(33);
        L0.add(44);


        // Ls0 = {2,3,4}
        System.out.println(L.toString());
        System.out.println(L0.toString());
        IntList blah = catenate(L, L0);

        // Lsf = {2,3,4}
        System.out.println(L.toString());

        // blahs0 = {2,3,4,2,33,44}
        System.out.println("catendate = " + blah.toString());
//        IntList L1 = new IntList(2, null);
//        L1.add(3);
//        L1.add(1);


//        IntList ptr = L.iterGetLastItemAddr();
//
//        IntList L0 = L.iterSqr();
//        // new list: {4, 9, 16}
//        System.out.println(L0.first + " " + L0.rest.first + " " + L0.rest.rest.first);
//        // org list: {2, 3, 4}
//        System.out.println(L.first + " " + L.rest.first + " " + L.rest.rest.first);
//
//
//        IntList R = new IntList(L.first * L.first, null);
//        L.rest.recurSqr(R);
//
//
//        // org list: {2, 3, 4}
//        System.out.println(L.first + " " + L.rest.first + " " + L.rest.rest.first);
//
//        // new list: {4, 9, 16}
//        System.out.println(R.first + " " + R.rest.first + " " + R.rest.rest.first);
//
//        System.out.println("Testing iterDSqr");
//        System.out.println("Ls0 " + L.first + " " + L.rest.first + " " + L.rest.rest.first);
//        L.iterDSqr();
//        System.out.println("Lsf " + L.first + " " + L.rest.first + " " + L.rest.rest.first);
//
//
//        System.out.println("Testing dSquareList");
//        System.out.println("Ls0 " + L.first + " " + L.rest.first + " " + L.rest.rest.first);
//        IntList.dSquareList(L);
//        System.out.println("Lsf " + L.first + " " + L.rest.first + " " + L.rest.rest.first);
//
//


    }
}
