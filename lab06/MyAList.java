/** Array based list.
 *  @author Josh Hug
 */

public class MyAList<T> {
  /**
   * Invariants: things that the client can expect to always be true; unless the ADT rep or API has a bug
   * The next item to be added is always pos size
   * The last item in the list is at i size - 1
   * The first item in the list is at i 0
   * Size =  total items in the list
   * Any method that adds an item to a list first checks if the list is full. If true then resize will be called
   *  and a new larger array will be created with the contents of the previous + the new item
   */
  private static int DEFAULT_SIZE = 100;
  private static double LOAD_FACTOR = 0.25;

  private T[] list;
  private int size;
  private double capacity;


  /** Creates an empty list. */
  public MyAList() {
    list = (T []) new Object[DEFAULT_SIZE];
    size = 0;
    capacity = size/ list.length;
  }

  public MyAList(T... values) {
    list = (T []) new Object[DEFAULT_SIZE];
    size = 0;
    for (int i = 0; i < values.length; i++) {
      list[i] = values[i];
      size += 1;
    }
    capacity = size/ list.length;
  }


  /** My navie implementation of System.arraycopy */
  private void arrCopy(T[] destArr) {
    for(int i = 0; i < list.length; i++) {
      destArr[i] = list[i];
    }
  }

  private void resize(int capacity) {
    // create new larger arr
    T[] newArray = (T []) new Object[capacity];

    // cp curr arr list items into newArray
    System.arraycopy(list, 0, newArray, 0, DEFAULT_SIZE);
    //arrCopy(newArray);

    // update list ptr
    list = newArray;
  }

  private void shrink() {
    T[] newArray = (T []) new Object[list.length/2];
    System.arraycopy(list,0, newArray, 0, size);
    list = newArray;
    capacity = (double)size/ (double)list.length;
  }


  /** Client API */
  public boolean empty() {
    if (size == 0) return true;
    return false;
  }

  public int size() {
    return size;
  }

  public double capacity() {
    return capacity;
  }

  public int length() {
    return list.length;
  }

  /** Gets the ith item in the list (0 is the front). */
  public T get(int i) {
    return list[i];
  }

  /** Returns the item from the back of the list.
   * return the last item correctly
   * input an empty list
   * */
  public T getLast() {
    return get(size - 1);
  }



  /** Deletes item from back of the list and
   * returns deleted item.
   * check that the correct index and value is rm
   * check update of size
   * rm last on empty list
   * rm last on a list with N items
   * Mutates Alist
   * */
  public T removeLast() {
    T valOfItemToDelete = list[size - 1];
    list[size - 1] = null;
    size  -= 1;
    capacity = (double)size/ (double)list.length;

    if (capacity < LOAD_FACTOR) shrink();


    return valOfItemToDelete;
  }

  /** Inserts X into the back of the list.
   * empty list, full list, list with N elements
   * size update
   * re-size correctly
   * correct value added to the correct loc
   * Mutates Alist
   * */
  public void addLast(T item) {
    int aListCapacity = list.length;
    boolean aListFull = size == aListCapacity;

    if(aListFull) {
      resize(aListCapacity + (DEFAULT_SIZE * 2));
    }
    list[size] = item;
    size += 1;
    capacity = (double)size/ (double)list.length;
  }
}