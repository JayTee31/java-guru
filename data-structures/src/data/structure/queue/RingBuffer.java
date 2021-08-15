package data.structure.queue;

public class RingBuffer<E> {
    private int writer;
    private int reader;
    private int size;
    private final Object[] items;

    public RingBuffer(final int capacity) {
        items = new Object[capacity];
        writer = 0;
        reader = 0;
        size = 0;
    }

    public void push(final E element) {
        if (items.length == size) {
            throw new IllegalStateException();
        }

        items[writer] = element;
        writer = (writer + 1) % items.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return (E)items[size - 1];
    }

    @SuppressWarnings("unchecked")
    public E pull() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        final E tmp = (E)items[reader];

        reader = (reader + 1) % items.length;
        size--;

        return tmp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
