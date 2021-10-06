package data.structure.binarytree;

import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

public class BinarySearchTree<T extends Comparable<T>> {
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
    private int size;

    public BinarySearchTree() {
        head = null;
        size = 0;
    }

    public void insert(final T data) {
        if (isEmpty()) {
            head = new Node(data);
            size++;
            return;
        }

        createNodeAtRightPlace(data, head);
    }

    public void remove(final T data) {
        if (size == 1) {
            head = null;
            size--;
        }

        Node nodeToBeRemoved = nodeToRemove(data, head);

        if (isNodeALeaf(nodeToBeRemoved)) {
            if (isNodeALeftChild(nodeToBeRemoved)) {
                nodeToBeRemoved.parent.left = null;
            } else {
                nodeToBeRemoved.parent.right = null;
            }
        } else if (isNodeHasOnlyOneChild(nodeToBeRemoved)) {
            final Node removedNodesChild = selectNodesOnlyChild(nodeToBeRemoved);

            if(!nodeToBeRemoved.equals(head)) {
                if (isNodeALeftChild(nodeToBeRemoved)) {
                    removedNodesChild.parent = nodeToBeRemoved.parent;
                    nodeToBeRemoved.parent.left = removedNodesChild;
                } else {
                    removedNodesChild.parent = nodeToBeRemoved.parent;
                    nodeToBeRemoved.parent.right = removedNodesChild;
                }
            } else {
                removedNodesChild.parent = null;
                head = removedNodesChild;
            }
        } else {
            Node inorderSuccessor = findInorderSuccessor(nodeToBeRemoved);

            nodeToBeRemoved.data = inorderSuccessor.data;

            if (isNodeALeftChild(inorderSuccessor)) {
                inorderSuccessor.parent.left = null;
            } else {
                inorderSuccessor.parent.right = null;
            }
        }

        size--;
    }

    public T firstValue() {
        Node lowestValue = head;

        while (nonNull(lowestValue.left)) {
            lowestValue = lowestValue.left;
        }

        return lowestValue.data;
    }

    public T lastValue() {
        Node largestValue = head;

        while (nonNull(largestValue.right)) {
            largestValue = largestValue.right;
        }

        return largestValue.data;
    }

    private Node findInorderSuccessor(final Node node) {
        Node inorderSuccessor = node.right;

        while (nonNull(inorderSuccessor.left)) {
            inorderSuccessor = inorderSuccessor.left;
        }

        return inorderSuccessor;
    }

    private Node nodeToRemove(final T data, final Node node) {
        Node nodeToRemove = node;

        if (node == null) {
            throw new NullPointerException();
        }

        if (data.compareTo(nodeToRemove.data) < 0) {
            if (isNull(nodeToRemove.left)) {
                throw new IllegalArgumentException();
            } else {
                nodeToRemove = nodeToRemove(data, nodeToRemove.left);
            }
        } else if (data.compareTo(nodeToRemove.data) > 0) {
            if (isNull(nodeToRemove.right)) {
                throw new IllegalArgumentException();
            } else {
                nodeToRemove = nodeToRemove(data, nodeToRemove.right);
            }
        }

        return nodeToRemove;
    }

    private void createNodeAtRightPlace(final T data, Node node) {
        if (data.compareTo(node.data) == 0) {
            node.data = data;
        } else if (data.compareTo(node.data) < 0) {
            if (isNull(node.left)) {
                node.left = new Node(data);
                node.left.parent = node;
                size++;
            } else {
                node = node.left;
                createNodeAtRightPlace(data, node);
            }
        } else {
            if (isNull(node.right)) {
                node.right = new Node(data);
                node.right.parent = node;
                size++;
            } else {
                node = node.right;
                createNodeAtRightPlace(data, node);
            }
        }
    }

    private boolean isNodeALeaf(final Node node) {
        return isNull(node.left) && isNull(node.right);
    }

    private boolean isNodeHasOnlyOneChild(final Node node) {
        return isNull(node.left) ^ isNull(node.right);
    }

    private boolean isNodeALeftChild(final Node node) {
        return node.equals(node.parent.left);
    }

    private Node selectNodesOnlyChild(final Node node) {
        if (isNodeHasOnlyOneChild(node)) {
            if (isNull(node.left)) {
                return node.right;
            } else {
                return node.left;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
