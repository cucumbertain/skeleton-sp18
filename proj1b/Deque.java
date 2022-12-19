public interface Deque<T> {
    public void addLast(T x);
    public void addFirst(T x);
    public T getFirst();
    public T removeFirst();
    public T removeLast();
    public T get(int i);
    public int size();
    public boolean isEmpty();
    public void printDeque();
}
