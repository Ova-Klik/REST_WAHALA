import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    MyStack stack;


    @BeforeEach
    void setUp() {

        stack = new MyStack(100);
    }

    @Test
    void stackShouldBeEmptyAtCreation() {
        assertTrue(stack.isEmpty());
    }


    @Test
    void stackShouldNotBeEmpty_whenAnElementIsPushed(){
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    void stackShouldBeEmpty_whenOneElementIsPopped_AfterOneElementIsPushed(){
        stack.push(20);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());

    }

    @Test
    void stackShouldReturnTopElement_WhenPeeked(){
        stack.push(15);
        stack.push(20);
        assertEquals(20,stack.peek());
    }

    @Test
    void stackShouldNotBeEmpty_whenXElementIsPopped_AfterXYElementsIsPushed(){
        stack.push(20);
        stack.push(50);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    void  stackShouldNotPop_whenEmpty(){

        assertThrows(EmptyStackException.class, ()-> stack.pop());

    }

    @Test
    void stackShouldShowEmpty_whenPeekedIfEmpty(){

        assertThrows(EmptyStackException.class, ()->stack.peek());
    }

    @Test
    void stackShouldReturnSearchedElement_ifExist(){
        stack.push(20);
        stack.push(50);
        int position = stack.search(50);
        assertEquals(1,position);
    }


}