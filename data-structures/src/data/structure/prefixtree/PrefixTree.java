package data.structure.prefixtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.nonNull;

public class PrefixTree {
    private class Node {
        HashMap<Character, Node> children;
        String content;
        boolean isWord;

        Node(final String content) {
            this.content = content;
            children = new HashMap<>();
            isWord = false;
        }
    }

    private final Node head = new Node("");

    public void insert(final String content) {
        Node temp = head;

        for (int i = 0; i < content.length(); i++) {
            if (temp.children.containsKey(content.charAt(i))) {
                temp = temp.children.get(content.charAt(i));
            } else {
                temp.children.put(content.charAt(i), new Node(content.substring(0, i + 1)));

                if (content.substring(0, i + 1).equals(content)) {
                    temp.children.get(content.charAt(i)).isWord = true;
                }

                temp = temp.children.get(content.charAt(i));
            }
        }
    }

    public List<String> getWithPrefix(final String prefix) {
        final List<String> listWithWords = new ArrayList<>();

        Node temp = head;

        for (int i = 0; i < prefix.length(); i++) {
            if (temp.children.containsKey(prefix.charAt(i))) {
                temp = temp.children.get(prefix.charAt(i));
            } else {
                return listWithWords;
            }
        }

        return getWords(temp, listWithWords);
    }


    private List<String> getWords(final Node node, final List<String> list) {
        if (node.isWord) {
            list.add(node.content);
        }

        if (nonNull(node.children)) {
            node.children.forEach((k, v) -> getWords(v, list));
        }

        return list;
    }
}
