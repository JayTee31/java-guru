package data.structure.linkedlist;
import static  java.util.Objects.*;

public class LinkedList<E> {
    private class Node {
        E data;
        Node next;
        Node previous;

        Node(final E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void add(E element) {
        requireNonNull(element, "The key must not be null!");

        if (isNull(head)) {
            head = new Node(element);
            tail = head;
            size++;

        } else {
            tail.next = new Node(element);
            final Node temp = tail;
            tail = tail.next;
            tail.previous = temp;
            size++;
        }
    }

    public void add(int index, E element) {
        requireNonNull(element, "The element must not be null!");

        if (index > size || index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        if (index == size) {
            add(element);
            return;
        }

        Node requiredNode = new Node(element);

        if (index == 0) {
            head.previous = requiredNode;
            requiredNode.next = head;
            head = requiredNode;
            size++;
            return;
        }

        Node requestedPlace = findNode(index);

        requestedPlace.previous.next = requiredNode;
        requiredNode.previous = requestedPlace.previous;
        requiredNode.next = requestedPlace;
        requestedPlace.previous = requiredNode;
    }

    public void addAll(LinkedList<E> other) {
        requireNonNull(other, "The list must not be null!");

        LinkedList<E> copy = makeCopyList(other);

        tail.next = copy.head;
        copy.head.previous = tail;
        tail = copy.tail;
        size += copy.size;
    }

    public void addAll(int index, LinkedList<E> other) {
        requireNonNull(other, "The list must not be null!");

        if (index > size && index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        if (index == size) {
            addAll(other);
            return;
        }

        LinkedList<E> copy = makeCopyList(other);
        Node requestedPlace = findNode(index);

        requestedPlace.previous.next = copy.head;
        copy.head.previous = requestedPlace.previous;
        copy.tail.next = requestedPlace;
        requestedPlace.previous = copy.tail;
        size += copy.size;
    }

    public E set(int index, E element) {
        requireNonNull(element, "The element must not be null!");

        if (index >= size && index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        Node requestedPlace = findNode(index);

        final E replacedElement = requestedPlace.data;
        requestedPlace.data = element;

        return replacedElement;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E remove(int index) {
        if (index >= size && index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        Node requestedPlace = findNode(index);

        if (size == 1) {
            clear();
            return requestedPlace.data;
        }

        if (index == 0) {
            requestedPlace.next.previous = null;
            head = requestedPlace.next;
            size--;
            return requestedPlace.data;
        }

        if (index == size - 1) {
            requestedPlace.previous.next = null;
            tail = requestedPlace.previous;
            size--;
            return requestedPlace.data;
        }

        requestedPlace.previous.next = requestedPlace.next;
        requestedPlace.next.previous = requestedPlace.previous;
        size--;
        return requestedPlace.data;
    }

    public boolean contains(E element) {
        requireNonNull(element, "The element must not be null!");

        Node temp = head;

        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public int indexOf(E element) {
        requireNonNull(element, "The element must not be null!");

        Node temp = head;

        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element)) {
                return i;
            }

            temp = temp.next;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        return findNode(index).data;
    }

    private LinkedList<E> makeCopyList(final LinkedList<E> other) {
        requireNonNull(other, "The list must not be null!");

        if (other.isEmpty()) {
            throw new IllegalArgumentException("The list must not be empty!");
        }

        final LinkedList<E> copy = new LinkedList<>();
        Node temp = other.head;

        for (int i = 0; i < other.size; i++) {
            copy.add(temp.data);
            temp = temp.next;
        }

        return copy;
    }

    private Node findNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Enter a proper index value!");
        }

        Node requestedNode = head;

        for (int i = 0; i < index; i++) {
            requestedNode = requestedNode.next;
        }

        return requestedNode;
    }
}