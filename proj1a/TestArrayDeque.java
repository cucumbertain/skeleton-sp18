import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDeque {

    /** Test whether doubleSizeArray is working when addLast runs. */
    @Test
    public void testAddLast() {
        ArrayDeque<String> A = new ArrayDeque();
        A.addLast("Hello");
        A.addLast("jack");
        assertEquals(A.get(1), "jack");
    }

    /** Test whether doubleSizeArray is working when addFirst runs. */
    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 0; i < 30; i += 1) {
            A.addFirst(i);
        }
        int x = A.get(0);
        assertEquals(x, 29);
        //System.out.println(A);
    }

    @Test
    public void testAddFirstAndAddLast() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 0; i < 15; i += 1) {
            A.addFirst(i);
        }
        for (int i = 15; i < 30; i += 1) {
            A.addLast(i);
        }
        int x = A.get(0);
        assertEquals(x, 14);
    }


    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 1; i < 16; i += 1) {
            A.addFirst(i);
        }
        for (int i = 15; i < 33; i += 1) {
            A.addLast(i);
        }
        A.addFirst(33);
        A.addFirst(36);
        A.addFirst(35);
        A.addLast(34);
        for (int i = 0; i < 33; i += 1) {
            A.removeLast();
        }
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> A = new ArrayDeque();
        A.addLast(1);
        A.addLast(2);
        A.addFirst(3);
        A.removeFirst();
        int x = A.get(0);
        assertEquals(1, x);
    }



    @Test
    public void testGet() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 0; i < 4; i += 1) {
            A.addLast(i);
        }
        int x = A.get(3);
        assertEquals(x, 3);
    }


    @Test
    public void testSize() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 0; i < 30; i += 1) {
            A.addLast(i);
        }
        assertEquals(30, A.size());
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> A = new ArrayDeque();
        for (int i = 0; i < 30; i += 1) {
            A.addLast(i);
        }
        for (int i = 0; i < 30; i += 1) {
            A.removeLast();
        }
        assertTrue(A.isEmpty());
    }

    @Test
    public void testPrintDeque() {
        ArrayDeque<Integer> A = new ArrayDeque();
        A.addFirst(5);
        A.addLast(7);
        A.addFirst(3);
        A.printDeque();
    }



}
