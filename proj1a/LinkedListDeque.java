public class LinkedListDeque<T> {
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
    private StuffNode last;
    private T sen; //A T Stuff made for creating sentinel
    private int size;

    /**
     * Create a empty list.
     */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, sen, null);
        sentinel.rest = new StuffNode(sentinel, sen, null);
        last = sentinel.rest;
        size = 0;
    }

    /**
     * Create a one-element list.
     */
    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null, sen, null);
        sentinel.rest = new StuffNode(sentinel, sen, null);
        sentinel.rest = new StuffNode(sentinel, item, sentinel.rest);
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.rest = new StuffNode(sentinel, item, sentinel.rest);
        sentinel.rest.rest.prev = sentinel.rest;
        size += 1;
    }

    public void addLast(T item) {
        last.prev = new StuffNode(last.prev, item, last);
        last.prev.prev.rest = last.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the size of the list.
     */
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

    /**
     * Removes and returns the item at the front of the deque.
     */
    public T removeFirst() {
        size -= 1;
        sentinel.rest = sentinel.rest.rest;
        sentinel.rest.prev = sentinel;
        return sentinel.rest.first;
    }

    public T removeLast() {
        size -= 1;
        last.prev = last.prev.prev;
        last.prev.rest = last;
        return last.prev.first;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            StuffNode n = sentinel.rest;
            if (index != 0) {
                for (int i = 0; i < index; i += 1) {
                    n = n.rest;
                }
            }
            return n.first;
        }
    }


    private T recurhelper(StuffNode fnode, int index) {
        if (index == 0) {
            return fnode.first;
        } else {
            return recurhelper(fnode.rest, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            return recurhelper(sentinel.rest, index);
        }
    }


    public static void main(String[] args) {
        LinkedListDeque<String> s1 = new LinkedListDeque<>();
        s1.addFirst("jack");
        s1.addFirst("rose");
        s1.addLast("the last one");
    }

}
