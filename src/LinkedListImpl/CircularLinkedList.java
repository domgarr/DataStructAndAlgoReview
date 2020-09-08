package LinkedListImpl;

public class CircularLinkedList<E> implements LinkedList<E> {
    private Node<E> tail = null;
    private int size;

    public CircularLinkedList() {
    }

    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
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
    public E first() {
        if(tail == null){
            return null;
        }
        return tail.getNext().getElement();
    }

    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        if(size == 0){
            tail = new Node(e, null);
            tail.setNext(tail);
        }else{
            Node newHead = new Node(e, tail.getNext());
            tail.setNext(newHead);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }

        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        }else{
            tail.setNext(head.getNext());
        }

        size--;

        return head.getElement();
    }

    private static class Node<E> {
        private E element;
        private CircularLinkedList.Node<E> next;

        public Node(E element, CircularLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement(){
            return element;
        }

        public CircularLinkedList.Node<E> getNext(){
            return next;
        }

        public void setNext(CircularLinkedList.Node<E> node){
            this.next = node;
        }
    }
}
