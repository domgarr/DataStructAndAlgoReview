package LinkedListImpl;

public class DoublyLinkedList<E> implements LinkedList<E> {
    /* The following are sentinel, they are dummy nodes and do not store elements.
    Sentinel nodes greatly simplify operations.
    Pros:
        The header and trailer never change.
        Insertion and Deletion can be performed in a unified manner since sentinel nodes do not change.
     */

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        this.header = new Node(null, null, null);
        this.trailer = new Node(null, header, null);
        this.header.setNext(trailer);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header.getNext() == trailer;
    }

    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement(); //The first element beyond the header is the first element.
    }

    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    private void addBetween(E e, Node<E> pre, Node<E> post){
        Node<E> node = new Node<>(e,pre,post);
        post.setPrev(node);
        pre.setNext(node);
        size++;
    }

    private E remove(Node<E> e){
        Node<E> pre = e.getPrev();
        Node<E> post = e.getNext();
        pre.setNext(post);
        post.setPrev(pre);

        E value = e.getElement();
        e = null;
        size--;

        return value;
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    private static class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
