package QueueImpl;

import LinkedListImpl.DoublyLinkedList;

public class DoublyLinkedDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
