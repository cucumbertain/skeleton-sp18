import org.junit.Test;
import static org.junit.Assert.*;

public class TestDeque {
    @Test
    public void testGetFirst() {
        ArrayDeque<String> someList = new ArrayDeque<>();
        someList.addFirst("jack");
        someList.addLast("rose");
        someList.addLast("last");
        System.out.println(someList.getFirst());
    }
}
