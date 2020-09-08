package StackImpl;

/*
This is an example of Adapter Pattern, where we use an existing class
and enable it's API to adhere to a new interface.
 */
public class LinkedStack<E> implements Stack<E> {
    private LinkedList<E> list = new SinglyLinkedList<E>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
