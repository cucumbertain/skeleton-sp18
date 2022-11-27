public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 1;
        nextLast = 2;
    }


    /** Double the size of a list */
    private T[] doubleSizeArray(T[] oItems) {
        T[] a = (T[]) new Object[oItems.length * 2];
        if (nextLast == 0) {
            System.arraycopy(oItems, 0, a, 0, oItems.length);
        } else {
            System.arraycopy(oItems, nextLast, a, 0, oItems.length - nextLast);
            System.arraycopy(oItems, 0, a, oItems.length - nextLast, nextLast);
        }
        nextLast = oItems.length;
        nextFirst = oItems.length * 2 - 1;
        return a;
    }

    /** Divide the size of a list by 2. */
    private T[] divideSizeArray(T[] oItems) {
        T[] a = (T[]) new Object[oItems.length / 2];
        if (calIndex(nextLast - 1) >= size - 1) {
            System.arraycopy(oItems, calIndex(nextFirst + 1), a, 0, size);
        } else {
            System.arraycopy(oItems, nextFirst + 1, a, 0, oItems.length - nextFirst - 1);
            System.arraycopy(oItems, 0, a, oItems.length - nextFirst - 1, nextLast);
        }
        nextLast = size;
        nextFirst = oItems.length / 2 - 1;
        return a;
    }


    /** Calculate the index of nextLast and nextFirst. */
    private int calIndex(int index) {
        if (index >= items.length) {
            index = index - items.length;
        }
        if (index <= -1) {
            index = items.length + index;
        }
        return index;
    }


    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            items = doubleSizeArray(items);
        }
        items[nextLast] = x;
        nextLast = calIndex(nextLast + 1);
        size += 1;
    }

    /** Inserts X into the front of the list. */
    public void addFirst(T x) {
        if (size == items.length) {
            items = doubleSizeArray(items);
        }
        items[nextFirst] = x;
        nextFirst = calIndex(nextFirst - 1);
        size += 1;
    }


    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length > 8 && size * 4 == items.length) {
            items = divideSizeArray(items);
        }
        T removeditem = items[calIndex(nextLast - 1)];
        items[calIndex(nextLast - 1)] = null;
        nextLast = calIndex(nextLast - 1);
        size -= 1;
        return removeditem;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length > 8 && size * 4 == items.length) {
            items = divideSizeArray(items);
        }
        T removeditem = items[calIndex(nextFirst + 1)];
        items[calIndex(nextFirst + 1)] = null;
        nextFirst = calIndex(nextFirst + 1);
        size -= 1;
        return removeditem;
    }



    /* Returns the item from the back of the list.
    public T getLast() {
        return items[calIndex(nextLast - 1)];
    }
    */

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[calIndex(i + nextFirst + 1)];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("null");
            return;
        }
        int a = nextFirst;
        int b = nextLast;
        while (calIndex(a + 1) != b) {
            System.out.print(items[calIndex(a + 1)] + " ");
            a += 1;
        }
    }

}
