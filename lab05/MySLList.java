import java.util.Objects;

public class MySLList {
    /***
     * IntNodes are hard to work with so we will create a
     *  class to encapsulate the complexity that the user will interact with
     */
    private MyIntNode sentinel;
    public  int size;
    public MyIntNode max;
    public MyIntNode min;

    public static class MyIntNode {
        public int item;
        public MyIntNode next;

        public MyIntNode(int item, MyIntNode next) {
            this.item = item;
            this.next = next;
        }

        public MyIntNode(int item) {
            this.item = item;
            this.next = null;
        }

        @Override
        public String toString() {
            return "MyIntNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        // Understand and test this f: default intellij


//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            MyIntNode myIntNode = (MyIntNode) o;
//
//            if (item != myIntNode.item) return false;
//            return next != null ? next.equals(myIntNode.next) : myIntNode.next == null;
//        }

        // Java +7
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyIntNode myIntNode = (MyIntNode) o;
            return item == myIntNode.item &&
                    Objects.equals(next, myIntNode.next);
        }


    }



    public MySLList(int item) {
        sentinel = new MyIntNode(0, new MyIntNode(item, null));
        size = 1;
        max = sentinel.next;
        min = sentinel.next;
    }

    public MySLList() {
        sentinel = new MyIntNode(0, null);
        size = 0;
        max = null;
        min = null;
    }

    // TODO: 2019-04-30 build helper f to build a list with a list of items
//    public MySLList(int[] items) {
//
//    }

    public void listCacheUpdate(MyIntNode node) {
        /***
         * Update cached members whenever a node is added or rm
         * This function will handle the case where a node is added to an empty list with the following case statement
         */

        if(max == null) {
            max = node;
            return;
        }
        else if(min == null) {
            min = node;
            return;
        }


        int value = node.item;
        if (value > max.item) max = node;
        if(value < min.item) min = node;
        size++;
    }



    public static MyIntNode recurGetNodeRef(MyIntNode p) {
        if((p == null) || (p.next == null)) return p;
        return recurGetNodeRef(p.next);
    }

    public void addLast(int value) {
        MyIntNode lastNode = recurGetNodeRef(sentinel.next);
        lastNode.next = new MyIntNode(value, null);
        listCacheUpdate(lastNode.next);
    }

    public static int size(MyIntNode p) {
        if(p.next == null) return 1;
        return 1 + size(p.next);
    }

    public int size() {
        return size(sentinel.next);
    }

    public void iterAddLast(int value) {
        /***
         * IntNode sentinel - ptr to the sentinel node in the list
         * int value - value to add to the end of the list that this points to
         */
        MyIntNode p = sentinel.next;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new MyIntNode(value, null);
    }



    public void addFirst(int value) {
        sentinel.next = new MyIntNode(value, sentinel.next);
        listCacheUpdate(sentinel.next);
    }

    public void printNthNode(int i) {
        // special case code - sentinel.next == null => input list is empty
        if(sentinel.next == null) System.out.println("Input list is empty");

        MyIntNode ptr = sentinel.next;
        int cnt = 0;
        while(cnt != i) {
            ptr = ptr.next;
            cnt++;
        }
        System.out.println(ptr.item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MySLList mySLList = (MySLList) o;

        if (size != mySLList.size) return false;
        if (sentinel != null ? !sentinel.equals(mySLList.sentinel) : mySLList.sentinel != null) return false;
        if (max != null ? !max.equals(mySLList.max) : mySLList.max != null) return false;
        return min != null ? min.equals(mySLList.min) : mySLList.min == null;
    }

    @Override
    public String toString() {
        return "MySLList{" +
                "sentinel=" + sentinel +
                ", size=" + size +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

    public static void main(String[] args) {
        // encapsulation: hides the detail that a null link exists

        MySLList L0 = new MySLList();
        L0.addFirst(123);

        MySLList L1 = new MySLList(55);
        L1.addLast(88);
        L1.addLast(100);
        L1.addLast(1400);


        System.out.println("max: " + L1.max.item + " = 100");
        System.out.println("min: " + L1.min.item + " = 55");
        System.out.println("size: " + L1.size + " = 3");

        L1.addLast(1000);

        // L1 = {55, 88, 100}
        System.out.println(L1.max.item + " = 1000");



    }
}
