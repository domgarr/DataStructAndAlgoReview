package ListImpl;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /*
    Returns replaced element.
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E replaced = data[i];

        data[i] = e;
        return replaced;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if(size == data.length){
            resize(2 * data.length);
        }
        //Shift all elements one to the right.
        for(int index = size - 1; index >= i ; index-- ){
            data[index + 1] = data[index];
        }
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        E removed = data[i];
        // (size - 1) is used as condition since the next element at (size - 1) will be null.
        for(int index = i; i < size - 1; i++){
            data[index] = data[index + 1];
        }
        data[size - 1] = null;

        size--;
        return null;
    }

    protected void checkIndex(int i, int size) throws IndexOutOfBoundsException{
        if(i < size || i >= size) {
            throw new IndexOutOfBoundsException("Illegal index at " + "i");
        }
    }

    protected void resize(int capacity){
        E[] expandedArray = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            expandedArray[i] = data[i];
        }
        data = expandedArray;

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>{
        private int i = 0;
        private boolean removable = false;

        public boolean hasNext(){
            return i < size;
        }

        public E next() throws NoSuchElementException {
            if(i == size){
                throw new NoSuchElementException("No next element exists.");
            }
            removable = true;
            return data[i++];
        }

        public void remove(){
            if(!removable){
                throw new IllegalStateException("There is no element to remove.");
            }
            ArrayList.this.remove(i - 1);
            i--;
            removable = false;
        }
    }

}
