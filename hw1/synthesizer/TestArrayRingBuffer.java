package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void otherTest() {
        ArrayRingBuffer<Integer> intArray= new ArrayRingBuffer<>(4);
        intArray.enqueue(4);
        intArray.enqueue(5);
        intArray.enqueue(6);
        intArray.enqueue(7);
        assertTrue(intArray.isFull());

        int x = intArray.peek();
        assertEquals(4, x);
        intArray.dequeue();
        x = intArray.dequeue();
        assertEquals(5, x);
        intArray.dequeue();
        intArray.dequeue();
        assertTrue(intArray.isEmpty());

        intArray.enqueue(1);
        x = intArray.dequeue();
        assertEquals(1, x);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> intArray= new ArrayRingBuffer<>(4);
        intArray.enqueue(4);
        intArray.enqueue(5);
        intArray.enqueue(6);
        intArray.dequeue();
        intArray.enqueue(7);

        Iterator iter = intArray.iterator();
        while (iter.hasNext()) {
            int i = (int)iter.next();
            System.out.println(i);
        }


    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
