public class SinglyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> node){
            this.next = node;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
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
        return head.getElement();
    }

    @Override
    public E last() {
        return tail.getElement();
    }


    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<E>(e, head);
        head = node;

        if(size == 0){
            tail = head;
        }

        size++;
    }

    @Override
    public void addLast(E e) {
        Node node = new Node(e, null);
        tail.setNext(node);


        if(isEmpty()){
            head = node;
        }else{
            tail = node;
        }
        size++;

    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E output = head.getElement();
        head = head.getNext();
        size--;

        if(size == 0){
            tail = null;
        }
        return output;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> tempHead = head;

        while (tempHead != null) {
            sb.append("[" + tempHead.getElement() + "]");
            tempHead = tempHead.getNext();
        }
        return sb.toString();
    }
}
