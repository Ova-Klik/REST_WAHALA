package Queue;

import CustomException.IllegalStateException;
import CustomException.NoSuchElementException;
import CustomException.NullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue myQueue;

    @BeforeEach
    void setUp() {
        myQueue = new MyQueue();
    }

    @Test
    void queueIsCreated_queueIsEmpty() {

        assertTrue(myQueue.isEmpty());
    }

    @Test
    void queueIsEmpty_addOneElement_queueHasOneElement() {
        assertTrue(myQueue.add("10"));
        assertEquals(1, myQueue.getSize());
    }

    @Test
    void queueIsFullWith10Element_addOneElement_queueThrowsException() {
        for (int count = 0; count < 10; count++) {
            myQueue.add(String.valueOf(count));
        }
        assertThrows(IllegalStateException.class, () -> myQueue.add("10"));
        assertEquals(10, myQueue.getSize());
    }

    @Test
    void queueHas3element_callElement_queueRetrievesTopElement() {
        assertTrue(myQueue.isEmpty());
        for (int count = 0; count < 3; count++) {
            myQueue.add(String.valueOf(count));
        }
        assertEquals("0", myQueue.element());
    }

    @Test
    void queueIsEmpty_callElement_queueThrowsException() {
        assertTrue(myQueue.isEmpty());
        assertThrows(NoSuchElementException.class, () -> myQueue.element());

    }

    @Test
    void queueHas3element_peekQueue_queueRetrievesTopElement() {
        assertTrue(myQueue.isEmpty());
        for (int count = 0; count < 3; count++) {
            myQueue.add(String.valueOf(count));
        }
        assertEquals("0", myQueue.peek());
    }

    @Test
    void queueIsEmpty_peekQueue_queueReturnsNull() {
        assertTrue(myQueue.isEmpty());
        assertNull(myQueue.peek());
    }

    @Test
    void queueHas3element_pollQueue_queueRetrievesARemoveTopElement() {
        assertTrue(myQueue.isEmpty());
        for (int count = 0; count < 3; count++) {
            myQueue.add(String.valueOf(count));
        }
        assertEquals("0", myQueue.poll());
        assertEquals("1", myQueue.peek());
    }

    @Test
    void queueIsEmpty_pollQueue_queueReturnsNull() {
        assertTrue(myQueue.isEmpty());
        assertNull(myQueue.poll());
    }

    @Test
    void queueHas3element_removeOneElement_queueHas2Element() {
        for (int count = 0; count < 3; count++) {
            myQueue.add(String.valueOf(count));
        }
        assertEquals("0", myQueue.remove());
        assertEquals(2,myQueue.getSize());
    }

    @Test
    void queueIsEmpty_removeOneElement_queueThrowsException() {
        assertTrue(myQueue.isEmpty());
        assertThrows(NoSuchElementException.class,()->myQueue.remove());
    }

    @Test
    void queueIsEmpty_offerOneElement_queueHasOneElement() {

        assertTrue(myQueue.offer("50"));
        assertEquals(1,myQueue.getSize());

    }

    @Test
    void queueIsFullWith10Element_offerOneElement_queueDoesNotAddElement() {
        for(int count= 0;count<10;count++){myQueue.offer("50");}
        assertEquals(10,myQueue.getSize());

        assertFalse(myQueue.offer("50"));
    }

    @Test
    void queueIsEmpty_offerNull_queueThrowsException() {
        assertTrue(myQueue.isEmpty());
        assertThrows(NullPointerException.class,()->myQueue.offer(null));
    }

}



