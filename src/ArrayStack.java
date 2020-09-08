import com.sun.glass.ui.View;

public class ArrayStack<E> implements Stack<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {
        if(size() == data.length){
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;
    }

    @Override
    public E top() {
        if(isEmpty()){
            return null;
        }
        return data[t];
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        //return data[t--]; //This is a solution.

        //This is better? It allows for GC.
        E poppedItem = data[t];
        data[t--] = null;

        return poppedItem;
    }
}
