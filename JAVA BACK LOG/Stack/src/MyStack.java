import java.util.EmptyStackException;

public class MyStack{
    private int top;
    private int [] data ;

    public MyStack(int size){
        data = new int [size];
        top = -1;

    }
    public boolean isEmpty() {

        return top==-1;
    }
    public void push(int element) {
        data [++top] = element;
    }

    public int pop() {
        if(isEmpty()) throw new EmptyStackException();
        return data[top--];
    }

    public int peek() {
        if(isEmpty())  throw new EmptyStackException();
        return data[top];
    }

    public int search(int element) {
        int position = -1;
        for(int index=0;index<data.length;index++){
            if(data[index]==element)position = index;
        }
        return position;
    }
}