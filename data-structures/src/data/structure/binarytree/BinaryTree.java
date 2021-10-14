package data.structure.binarytree;
import data.structure.stack.Stack;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree<T> {
    public final class Node {
        public T data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(final T data) {
            this.data = data;
            left = null;
            right = null;
            parent = null;
        }
    }

    public Node head;
    public int size;

    public BinaryTree() {
        head = null;
        size = 0;
    }

    public void showPrefixNotation() {
        final List<T> list = new ArrayList<>();

        iteratePrefix(head, list);

        System.out.println(list);
    }

    public void showInfixNotation() {
        final List<T> list = new ArrayList<>();

        iterateInfix(head, list);

        System.out.println(list);
    }

    public void showPostfixNotation() {
        final List<T> list = new ArrayList<>();

        iteratePostfix(head, list);

        System.out.println(list);
    }

    private void iteratePrefix(final Node node, final List<T> list) {
        if (isNull(node)) {
            return;
        }

        list.add(node.data);
        iteratePrefix(node.left, list);
        iteratePrefix(node.right, list);
    }

    private void iterateInfix(final Node node, final List<T> list) {
        if (isNull(node)) {
            return;
        }

        iterateInfix(node.left, list);
        list.add(node.data);
        iterateInfix(node.right, list);
    }

    private void iteratePostfix(final Node node, final List<T> list) {
        if (isNull(node)) {
            return;
        }

        iteratePostfix(node.left, list);
        iteratePostfix(node.right, list);
        list.add(node.data);
    }


    public Node makeNode(final T data) {
        return new Node(data);
    }

    private boolean hasLeftChild(final Node node) {
        return nonNull(node.left);
    }

    private boolean hasRightChild(final Node node) {
        return nonNull(node.right);
    }
}
