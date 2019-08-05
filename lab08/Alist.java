public class Alist<T> implements MyList<T> {
    private int size;
    private T[] list;


    public Alist() {
        list = (T[]) new Object[100];
        size = 0;
    }

    public int size(){
        return size;
    }

    @Override
    public void addLast(T item) {
        list[size] = item;
        size += size;
    }

    @Override
    public T getLast() { return list[size-1]; }
}
