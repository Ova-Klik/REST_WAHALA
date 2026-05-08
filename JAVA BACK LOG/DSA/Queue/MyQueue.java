package Queue;

import CustomException.IllegalStateException;
import CustomException.NoSuchElementException;
import CustomException.NullPointerException;

public class MyQueue {
    private String [] queue ;
    private int front = 0;
    private int rear = 0;
    private int size=0;
    private final int DEFAULT_SIZE =10;

    public MyQueue(){
        queue = new String [DEFAULT_SIZE];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean add(String element) {
        if(isFull()) throw new IllegalStateException("Queue is full");
        queue[rear++]=element;
        size++;
        return true;
    }

    private boolean isFull() {
        return size==queue.length;
    }

    public int getSize() {
        return rear-front;
    }

    public String element() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue[front];
    }

    public String peek() {
        if(isEmpty()) return null;
        return queue[front];
    }

    public String poll() {
        if(isEmpty()) return null;
        return queue[front++];

    }

    public String remove() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue[front++];
    }

    public boolean offer(String element) {
        if(isFull()) return false;
        if(element==null)throw new NullPointerException("element is null");
        queue[rear++]=element;
        size++;
        return true;
    }
}
