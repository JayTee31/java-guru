package data.structure.binarytree.navigablemap;

import data.structure.binarytree.BinarySearchTree;
import data.structure.stack.Stack;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class NavigableMap<K extends Comparable<K>, V> {
    class Item implements Comparable<Item> {
        K key;
        V value;

        @Override
        public int compareTo(Item o) {
            return key.compareTo(o.key);
        }
    }

    private final BinarySearchTree<Item> bst = new BinarySearchTree<>();

    public void add(final K key, final V value) {
        final Item item = new Item();
        item.key = key;
        item.value = value;
        bst.insert(item);
    }

    public V get(final K key) {
        BinarySearchTree<Item>.Node temp = findNode(key);

        if (isNull(temp)) {
            return null;
        } else {
            return temp.data.value;
        }
    }

    public void remove(final K key) {
        BinarySearchTree<Item>.Node temp = findNode(key);

        if (nonNull(temp)) {
            bst.remove(temp.data);
        }
    }

    public V firstValue() {
        return bst.firstValue().value;
    }

    public V lastValue() {
        return bst.lastValue().value;
    }

    public List<V> head(final K toKey) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final List<V> listOfValues = new ArrayList<>();

        fillListWithValuesSmallerThanSelectedKey(temp, toKey, listOfValues);

        return listOfValues;
    }

    public List<V> headInclusive(final K toKey) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final List<V> listOfValues = new ArrayList<>();

        fillListWithValuesSmallerOrEqualThanSelectedKey(temp, toKey, listOfValues);

        return listOfValues;
    }

    public List<V> tail(final K fromKey) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final List<V> listOfValues = new ArrayList<>();

        fillListWithValuesHigherThanSelectedKey(temp, fromKey, listOfValues);

        return listOfValues;
    }

    public List<V> tailInclusive(final K fromKey) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final List<V> listOfValues = new ArrayList<>();

        fillListWithValuesHigherOrEqualThanSelectedKey(temp, fromKey, listOfValues);

        return listOfValues;
    }

    public K lowerKey(final K key) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final Stack<K> largestKey = new Stack<>();

        findLargestKeyWhichSmallerThenGiven(temp, largestKey, key);

        if (largestKey.isEmpty()) {
            return null;
        } else {
            return largestKey.peek();
        }
    }

    public K higherKey(final K key) {
        BinarySearchTree<Item>.Node temp = bst.head;
        final Stack<K> smallestKey = new Stack<>();

        findSmallestKeyWhichLargerThenGiven(temp, smallestKey, key);

        if (smallestKey.isEmpty()) {
            return null;
        } else {
            return smallestKey.peek();
        }
    }

    private void findLargestKeyWhichSmallerThenGiven(final BinarySearchTree<Item>.Node selectedNode, Stack<K> stack, final K givenKey) {
        if (selectedNode.data.key.compareTo(givenKey) < 0) {
            if (stack.isEmpty()) {
                stack.push(selectedNode.data.key);
            } else if (selectedNode.data.key.compareTo(stack.peek()) > 0) {
                stack.push(selectedNode.data.key);
            }
        }

        if (nonNull(selectedNode.left)) {
            findLargestKeyWhichSmallerThenGiven(selectedNode.left, stack, givenKey);
        }

        if (nonNull(selectedNode.right)) {
            findLargestKeyWhichSmallerThenGiven(selectedNode.right, stack, givenKey);
        }
    }

    private void findSmallestKeyWhichLargerThenGiven(final BinarySearchTree<Item>.Node selectedNode, Stack<K> stack, final K givenKey) {
        if (selectedNode.data.key.compareTo(givenKey) > 0) {
            if (stack.isEmpty()) {
                stack.push(selectedNode.data.key);
            } else if (selectedNode.data.key.compareTo(stack.peek()) < 0) {
                stack.push(selectedNode.data.key);
            }
        }

        if (nonNull(selectedNode.left)) {
            findSmallestKeyWhichLargerThenGiven(selectedNode.left, stack, givenKey);
        }

        if (nonNull(selectedNode.right)) {
            findSmallestKeyWhichLargerThenGiven(selectedNode.right, stack, givenKey);
        }
    }

    private void fillListWithValuesSmallerThanSelectedKey(final BinarySearchTree<Item>.Node selectedNode,final K key, final List<V> list) {
        if (selectedNode.data.key.compareTo(key) < 0) {
            list.add(selectedNode.data.value);
        }

        if (nonNull(selectedNode.left)) {
            fillListWithValuesSmallerThanSelectedKey(selectedNode.left, key, list);
        }

        if (nonNull(selectedNode.right)) {
            fillListWithValuesSmallerThanSelectedKey(selectedNode.right, key, list);
        }
    }

    private void fillListWithValuesSmallerOrEqualThanSelectedKey(final BinarySearchTree<Item>.Node selectedNode,final K key, final List<V> list) {
        if (selectedNode.data.key.compareTo(key) <= 0) {
            list.add(selectedNode.data.value);
        }

        if (nonNull(selectedNode.left)) {
            fillListWithValuesSmallerOrEqualThanSelectedKey(selectedNode.left, key, list);
        }

        if (nonNull(selectedNode.right)) {
            fillListWithValuesSmallerOrEqualThanSelectedKey(selectedNode.right, key, list);
        }
    }

    private void fillListWithValuesHigherThanSelectedKey(final BinarySearchTree<Item>.Node selectedNode,final K key, final List<V> list) {
        if (selectedNode.data.key.compareTo(key) > 0) {
            list.add(selectedNode.data.value);
        }

        if (nonNull(selectedNode.left)) {
            fillListWithValuesHigherThanSelectedKey(selectedNode.left, key, list);
        }

        if (nonNull(selectedNode.right)) {
            fillListWithValuesHigherThanSelectedKey(selectedNode.right, key, list);
        }
    }

    private void fillListWithValuesHigherOrEqualThanSelectedKey(final BinarySearchTree<Item>.Node selectedNode,final K key, final List<V> list) {
        if (selectedNode.data.key.compareTo(key) >= 0) {
            list.add(selectedNode.data.value);
        }

        if (nonNull(selectedNode.left)) {
            fillListWithValuesHigherOrEqualThanSelectedKey(selectedNode.left, key, list);
        }

        if (nonNull(selectedNode.right)) {
            fillListWithValuesHigherOrEqualThanSelectedKey(selectedNode.right, key, list);
        }
    }

    public boolean has(final K key) {
        return nonNull(get(key));
    }

    private BinarySearchTree<Item>.Node findNode(final K key) {
        BinarySearchTree<Item>.Node temp = bst.head;

        while (!temp.data.key.equals(key)) {
            if (temp.data.key.compareTo(key) > 0) {
                if (isNull(temp.left)) {
                    return null;
                } else {
                    temp = temp.left;
                }
            } else {
                if (isNull(temp.right)) {
                    return null;
                } else {
                    temp = temp.right;
                }
            }
        }

        return temp;
    }
}
