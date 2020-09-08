package ListImpl;

import javafx.geometry.Pos;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E>{
    private Node<E> header;
    private Node<E> trailer;
    private int size=0;

    public LinkedPositionalList() {
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null );
        header.setNext(trailer);
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
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> pre = node.getPrev();
        Node<E> post = node.getNext();

        pre.setNext(post);
        post.setPrev(pre);
        size--;

        E replaced = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);

        return replaced;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Invalid p.");
        }
        Node<E> node = (Node<E>)p;
        if(node.getNext() == null){
            throw new IllegalArgumentException("p is no longer in the list.");
        }
        return node;
    }

    private Position<E> position(Node<E> node){
        if(node == header || node == trailer){
            return null;
        }
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pre, Node<E> post){
        Node<E> node = new Node(e, pre,post);
        pre.setNext(node);
        post.setPrev(node);
        size++;
        return node;

    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions(){
        return new PositionIterable();
    }

    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if(element == null){
                throw new IllegalStateException("Position is no longer valid.");
            }
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

    private class PositionIterator implements Iterator<Position<E>>{
        private Position<E> cursor = first();
        private Position<E> recent = null;

        public boolean hasNext(){
            return !(cursor != null);
        }

        public Position<E> next() throws NoSuchElementException {
            if(cursor == null){
                throw new NoSuchElementException("No elements left to iterate through.");
            }
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        public void remove() throws IllegalStateException{
            if(recent == null){
                throw  new IllegalStateException("There is no element to remove.");
            }
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionIterable  implements Iterable<Position<E>> {

        @Override
        public Iterator<Position<E>>  iterator() {
            return new PositionIterator();
        }
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        public void remove(){
            posIterator.remove();
        }
    }


}
