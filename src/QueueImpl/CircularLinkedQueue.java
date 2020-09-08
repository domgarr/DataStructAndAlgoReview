package QueueImpl;

public class CircularLinkedQueue<E> implements CircularQueue<E> {
    private LinkedList<E> list = new CircularLinkedList<>();

    @Override
    public void rotate() {
        ((CircularLinkedList)list).rotate();
    }

    @Override
    public void enqueue(E e) {
        list.addFirst(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
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
