package data.structure.arraylist;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Makes a new dynamic ArrayList with an initial capacity of eight.
 * @param <E>
 */
public class ArrayList<E> {
    private static final int STARTING_CAPACITY = 8;
    private static final int STARTING_SIZE = 0;

    private Object[] items = new Object[STARTING_CAPACITY];
    private int size = STARTING_SIZE;

    /**
     * Add a new element at the end of this list.
     * @param element the desired element to be appended to this list
     */
    public void add(final E element) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }

        items[size++] = element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     * @param index the index of the desired position in this list
     * @param element the desired element to be added to this list
     */
    public void add(final int index, final E element) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }

        for (int i = size; i >= index; i--) {
                items[i + 1] = items[i];
        }

        items[index] = element;
        size++;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     * @param other the other ArrayList which elements will be appended to this list
     */
    public void addAll(final ArrayList<E> other) {
        if (items.length < size + other.size) {
            items = Arrays.copyOf(items, size + other.size);
        }

        for (int i = 0; i < other.size; i++) {
            if (other.get(i) == null) {
                throw new NullPointerException("hajjaj");
            }

            items[size++] = other.get(i);
        }
    }

    /**
     * Inserts all of the elements in the specified collection into this list, starting at the specified position.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     * @param index the index of the position where the other list's element will be added
     * @param other the other ArrayList which elements will be added
     */
    public void addAll(final int index, ArrayList<E> other) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Index can not be larger than the size of the ArrayList, or lower than zero");
        }

        if (items.length < size + other.size) {
            items = Arrays.copyOf(items, size + other.size);
        }

        for (int i = size; i >= index; i--) {
            items[i + other.size ] = items[i];
        }

        for (int i = 0; i < other.size; i++) {
            if (other.get(i) == null) {
                throw new NullPointerException("hajjaj");
            }

            items[index + i] = other.get(i);
        }

        size += other.size;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index the index where the element going to be set
     * @param element the element to be set
     * @return the replaced element
     */
    @SuppressWarnings("unchecked")
    public E set(final int index, final E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        final E originalElement = (E)items[index];

        items[index] = element;

        return originalElement;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @SuppressWarnings("unchecked")
    public E remove(final int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        }

        final E removedElement = (E)items[index];

        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }

        size--;

        return removedElement;
    }

    /**
     * Returns true if this list contains the specified element.
     * @param element element to search for
     * @return true, if the list contains the element
     */
    public boolean contains(final E element) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param element the element to search for
     * @return the index of the first occurrence of the specified element, or -1 if the list does not contain the element
     */
    public int indexOf(final E element) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Repeats the contents of the current ArrayList count times into a new ArrayList.
     * @param count repeats the contents of the list that many times
     * @return a new ArrayList which contains the original list's elements 'count' times
     */
    @SuppressWarnings("unchecked")
    public ArrayList<E> repeat(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count should be greater than or equal to zero");
        }

        final ArrayList<E> newArrayList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < size; j++) {
                newArrayList.add((E)items[j]);
            }
        }

        return newArrayList;
    }

    /**
     * Reverses the list in place.
     */
    @SuppressWarnings("unchecked")
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            final E tmp = (E)items[i];

            items[i] = items[size - 1 - i];

            items[size - 1 - i] = tmp;
        }
    }

    /**
     * Returns a new list containing the elements between the specified fromIndex, inclusive, and toIndex, exclusive.
     * @param fromIndex starting index of the sublist
     * @param toIndex ending index of the sublist
     * @return a new ArrayList as a sublist of the original
     */
    @SuppressWarnings("unchecked")
    public ArrayList<E> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || fromIndex > size - 1 || toIndex < 0 || toIndex > size - 1 || fromIndex >= toIndex) {
            throw new IllegalArgumentException();
        }

        final ArrayList<E> subList = new ArrayList<>();

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((E)items[i]);
        }

        return subList;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public E get(final int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Paff");
        }

        return (E)items[index];
    }

    public void shrink() {
        items = Arrays.copyOf(items, size);
    }

    public void ensure(final int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalArgumentException("Piff");
        }

        if (minCapacity > items.length) {
            items = Arrays.copyOf(items, minCapacity);
        }
    }
}
