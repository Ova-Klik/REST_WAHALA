package Queue;

public class MyQueue {
    private int [] data;
    private int front;

    public MyQueue(int size) {
        data = new int [size];
        front =-1;
        int rear = 0;
    }

    public int getSize(){
        return data.length;
    }

    public boolean isEmpty() {
        return front==-1;
    }

    public boolean add(int element) {
        int size = getSize();
        if(size == front){
            throw new IllegalStateException();
        }else{
          data[++front] = element;
        }
        return true;
    }
}
