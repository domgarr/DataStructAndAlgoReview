public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 1000;

    private E[] data;
    int first; // First element in Queue.
    int size; //Current number of elements stored in Queue.

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) throws IllegalStateException{
        if(size == data.length){
            throw new IllegalStateException("Queue is full.");
        }
        int index = (first + size) % data.length;
        data[index] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        E element = data[first];
        data[first] = null;

        first = (first+1) % data.length;
        size--;
        return element;
    }

    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return data[first];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
