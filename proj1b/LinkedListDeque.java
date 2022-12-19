public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private T first;
        private StuffNode rest;
        private StuffNode prev;

        public StuffNode(StuffNode previous0, T first0, StuffNode rest0) {
            first = first0;
            rest = rest0;
            prev = previous0;
        }
    }

    /**
     * the first item should be sentinel.next(if it exists)
     */
    private StuffNode sentinel;
    private T sen;
    private int size;

    /**
     * Create a empty list.
     */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, sen, null);
        sentinel.rest = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.rest = new StuffNode(sentinel, item, sentinel.rest);
        sentinel.rest.rest.prev = sentinel.rest;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.rest = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    /**
     * Print the list
     */
    public void printDeque() {
        StuffNode n = sentinel.rest;
        for (int i = 0; i < size; i += 1) {
            System.out.print(n.first + " ");
            n = n.rest;
        }
        System.out.print("\n");
    }

    @Override
    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removeditem = sentinel.rest.first;
        sentinel.rest = sentinel.rest.rest;
        sentinel.rest.prev = sentinel;
        size -= 1;
        return removeditem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removeditem = sentinel.prev.first;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.rest = sentinel;
        size -= 1;
        return removeditem;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            StuffNode n = sentinel.rest;
            while (index > 0) {
                n = n.rest;
                index -= 1;
            }
            return n.first;
        }
    }

    @Override
    public T getFirst() {
        if(size == 0) {
            return null;
        } else {
            return sentinel.rest.first;
        }
    }


    private T recurHelper(StuffNode fnode, int index) {
        if (index == 0) {
            return fnode.first;
        } else {
            return recurHelper(fnode.rest, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            return recurHelper(sentinel.rest, index);
        }
    }



}
