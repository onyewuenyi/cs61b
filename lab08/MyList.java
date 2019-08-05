public interface MyList<T> {
    public void addLast(T y);
    public T getLast();
    public int size();

    // imp inheritance: inherit code: how and behavior
    default public void printLast() {
        System.out.println(getLast());
    }

//    public void addFirst(T x);
//    public T getFirst();
//    public T removeLast();
//    public T get(int i);
//    public void insert(T x, int position);



}
