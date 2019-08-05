public class Dlist<T> implements MyList<T> {
    public static class Node<T> {
        public Node<T> next;
        public Node<T> prev;
        public T item;


        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> sentinel;
    private int size = 0;

    public Dlist() {
        sentinel = new Node<T>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public int size(){
        return size;
    }

    @Override
    public void addLast(T item) {
        Node last = sentinel.prev;
        Node newNode = new Node(item, last , sentinel);
        // update next and last ptr
        last.next = newNode;
        sentinel.prev = newNode;
        size += size;
    }

    @Override
    public T getLast() {
        return sentinel.prev.item;
    }


}
