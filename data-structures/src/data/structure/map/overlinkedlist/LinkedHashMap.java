package data.structure.map.overlinkedlist;

import data.structure.linkedlist.LinkedList;
import data.structure.map.openaddressing.OpenAddressingMap;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class LinkedHashMap<K, V> {
    private static final int STARTING_CAPACITY = 12;

    private int size;
    private final Object[] items;

    private class Entry {
        final K key;
        final V value;

        Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LinkedHashMap() {
        size = 0;
        items = new Object[STARTING_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public void put(final K key, final V value) {
        requireNonNull(key, "The key must not be null!");

        final int index = Math.abs(key.hashCode()) % STARTING_CAPACITY;

        if (isNull(items[index])) {
            items[index] = new LinkedList<Entry>();
            ((LinkedList<Entry>)items[index]).add(new Entry(key, value));
            size++;
            return;
        }

        if (!isNull(items[index])) {
            for (int i = 0; i < ((LinkedList<Entry>)items[index]).size(); i++) {
                if (((LinkedList<Entry>)items[index]).get(i).key.equals(key)) {
                    ((LinkedList<Entry>) items[index]).set(i, new Entry(key, value));
                    return;
                }
            }

            ((LinkedList<Entry>)items[index]).add(new Entry(key, value));
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public V get(final K key) {
        requireNonNull(key, "The key must not be null!");

        final int index = Math.abs(key.hashCode()) % STARTING_CAPACITY;

        if (isNull(items[index])) {
            return null;
        }

        for (int i = 0; i < ((LinkedList<Entry>)items[index]).size(); i++) {
            if (((LinkedList<Entry>)items[index]).get(i).key.equals(key)) {
                return ((LinkedList<Entry>)items[index]).get(i).value;
            }
        }

         return null;
    }

    public boolean has(final K key) {
        return !isNull(get(key));
    }

    @SuppressWarnings("unchecked")
    public void remove(final K key) {
        requireNonNull(key, "The key must not be null!");

        final int index = Math.abs(key.hashCode()) % STARTING_CAPACITY;

        if (!isNull(items[index])) {
            for (int i = 0; i < ((LinkedList<Entry>)items[index]).size(); i++) {
                if (((LinkedList<Entry>)items[index]).get(i).key.equals(key)) {
                    ((LinkedList<Entry>)items[index]).remove(i);
                    size--;
                    return;
                }
            }

            throw new IllegalArgumentException();
        }
    }
}
