package Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue queue;

    @Test
    void queueShouldBeEmpty_whenCreated() {
        queue = new MyQueue(2);
        assertTrue(queue.isEmpty());
    }
    @Test
    void queueShouldNotBeEmpty_whenAnElementIsAddedToTheQueue() {
        queue = new MyQueue(2);
        assertTrue(queue.isEmpty());
        queue.add(20);
        assertFalse(queue.isEmpty());

    }

    @Test
    void queueShouldNotAdd_whenSizeIsUsedUp() {
        queue = new MyQueue(2);
        assertTrue(queue.isEmpty());
        queue.add(20);
        queue.add(30);
        assertThrows(IllegalStateException.class, () -> queue.add(20));

    }

}