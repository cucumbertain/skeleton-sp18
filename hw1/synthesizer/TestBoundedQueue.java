package synthesizer;

import org.junit.Test;

public class TestBoundedQueue {
    @Test
    public void testIterable() {
        BoundedQueue<Integer> boundedQueue = new ArrayRingBuffer<>(10);
        boundedQueue.enqueue(5);
        boundedQueue.enqueue(6);
        boundedQueue.enqueue(7);
        for (int i : boundedQueue) {
            System.out.println(i);
        }
    }
}
