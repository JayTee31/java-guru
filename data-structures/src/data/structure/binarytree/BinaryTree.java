package data.structure.binarytree;
import data.structure.stack.Stack;

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
        final StringBuilder str = new StringBuilder();

        Node temp = head;

        for (int i = 0; i < size; i++) {
            str.append(temp.data.toString());
            str.append(" ");

            if (nonNull(temp.left)) {
                temp = temp.left;
            } else if (nonNull(temp.right)) {
                temp = temp.right;
            } else {
                while (nonNull(temp.parent)) {
                    if (temp.equals(temp.parent.right)) {
                        temp = temp.parent;
                    } else {
                        temp = temp.parent.right;
                        break;
                    }
                }
            }
        }

        System.out.println(str);
    }

    public void showInfixNotation() {
        final StringBuilder str = new StringBuilder();
        final Stack<Node> parentNodes = new Stack<>();
        int counter = 0;

        Node temp = head;

        while (counter < size) {
            if (hasLeftChild(temp)) {
                parentNodes.push(temp);
                temp = temp.left;
            } else if (hasRightChild(temp)) {
                str.append(temp.data.toString());
                str.append(" ");
                counter++;
                temp = temp.right;
            } else {
                str.append(temp.data.toString());
                str.append(" ");
                counter++;

                while (!parentNodes.isEmpty()) {
                    if (hasRightChild(parentNodes.peek())) {
                        str.append(parentNodes.peek().data.toString());
                        str.append(" ");
                        counter++;
                        temp = parentNodes.pop().right;
                        break;
                    } else {
                        str.append(parentNodes.pop().data.toString());
                        str.append(" ");
                        counter++;
                    }
                }
            }
        }

        System.out.println(str);
    }

    public void showPostfixNotation() {
        final StringBuilder str = new StringBuilder();
        final Stack<Node> parentNodes = new Stack<>();
        int counter = 0;

        Node temp = head;

        while (counter < size) {
            if (hasLeftChild(temp)) {
                parentNodes.push(temp);
                temp = temp.left;
            } else if (hasRightChild(temp)) {
                parentNodes.push(temp);
                temp = temp.right;
            } else {
                str.append(temp.data.toString());
                str.append(" ");
                counter++;

                while (!parentNodes.isEmpty()) {
                    if (hasRightChild(parentNodes.peek()) && !parentNodes.peek().right.equals(temp)) {
                        temp = parentNodes.peek().right;
                        break;
                    }

                    temp = parentNodes.peek();
                    str.append(parentNodes.pop().data.toString());
                    str.append(" ");
                    counter++;
                }
            }
        }

        System.out.println(str);
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
