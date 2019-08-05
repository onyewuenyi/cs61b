package sbox;

public class Slist<T> implements MyList<T> {
    // A data class
    public static class Node<T> {
        public Node next;
        public T item;

        public Node(T item, Node next) {
           this.next = next;
           this.item = item;
        }

    }

    private Node<T> sentinel;
    private  Node<T> last;
    private int size = 0;

    public Slist() {
        sentinel = new Node(null, null);
        last = sentinel;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void addLast(T item) {
        last.next = new Node(item, null);
        size += size;
    }

    @Override
    public T getLast() {
        return last.item;
    }

    public static void main(String[] args) {
        Slist<String>  names = new Slist<String>();
        names.addLast("Charles");
    }

}
