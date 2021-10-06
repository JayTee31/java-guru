package data.structure.binarytree.heap;

import data.structure.binarytree.BinaryTree;
import data.structure.stack.Stack;
import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

public class Heap <T extends Comparable<T>> {
    private final BinaryTree<T> items = new BinaryTree<>();

    public void insert(final T data) {
        if (isEmpty()) {
            items.head = items.makeNode(data);
            items.size++;
            return;
        }

        insertToProperPlace(data);
        items.size++;
    }

    public T peekTop() {
        if (isNull(items.head)) {
            return null;
        }

        return items.head.data;
    }

    public T removeTop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        final Stack<Integer> stck = new Stack<>();
        BinaryTree<T>.Node lastNode = items.head;
        final T dataStore = lastNode.data;

        if (items.size == 1) {
            items.head = null;
            items.size--;
            return dataStore;
        }

        for (int i = items.size; i > 1; i /= 2) {
            stck.push(i % 2);
        }

        while (stck.size() > 0) {
            if (stck.pop() == 0) {
                lastNode = lastNode.left;
            } else {
                lastNode = lastNode.right;
            }
        }

        items.head.data = lastNode.data;

        if (lastNode.parent.left.equals(lastNode)) {
            lastNode.parent.left = null;
        } else {
            lastNode.parent.right = null;
        }


        items.size--;
        bubbleDown();

        return dataStore;
    }

    public int size() {
       return items.size;
}

    public boolean isEmpty() {
        return items.size == 0;
    }

    private void insertToProperPlace(final T data) {
        final Stack<Integer> stck = new Stack<>();
        BinaryTree<T>.Node temp = items.head;
        BinaryTree<T>.Node newNode = items.makeNode(data);

        for (int i = items.size + 1; i > 1; i /= 2) {
            stck.push(i % 2);
            }

        while (stck.size() > 1) {
            if (stck.pop() == 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (stck.pop() == 0) {
            temp.left = newNode;
            newNode.parent = temp;
        } else {
            temp.right = newNode;
            newNode.parent = temp;
        }

        bubbleUp(newNode);
    }

    private void bubbleUp(final BinaryTree<T>.Node node) {
        BinaryTree<T>.Node temp = node;
        final T dataOfNode = temp.data;

        while (nonNull(temp.parent) && temp.data.compareTo(temp.parent.data) > 0) {
            temp.data = temp.parent.data;
            temp.parent.data = dataOfNode;
            temp = temp.parent;
        }
    }

    private void bubbleDown() {
        BinaryTree<T>.Node temp = items.head;

        final T dataOfNode = items.head.data;
        BinaryTree<T>.Node nodeOfTheLargestData;

        while (nonNull(temp.right) || nonNull(temp.left)) {
            if (isNull(temp.left)) {
                nodeOfTheLargestData = temp.right;
            } else if (isNull(temp.right)) {
                nodeOfTheLargestData = temp.left;
            } else {
                if (temp.right.data.compareTo(temp.left.data) > 0) {
                    nodeOfTheLargestData = temp.right;
                } else {
                    nodeOfTheLargestData = temp.left;
                }
            }

            if (temp.data.compareTo(nodeOfTheLargestData.data) < 0) {
                temp.data = nodeOfTheLargestData.data;
                nodeOfTheLargestData.data = dataOfNode;
                temp = nodeOfTheLargestData;
            } else {
                break;
            }
        }
    }

    public void showPrefixNotation() {
        items.showPrefixNotation();
    }

    public void showInfixNotation() {
        items.showInfixNotation();
    }

    public void showPostfixNotation() {
        items.showPostfixNotation();
    }
}
