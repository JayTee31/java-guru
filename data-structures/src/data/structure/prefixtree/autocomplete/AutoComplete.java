package data.structure.prefixtree.autocomplete;

import data.structure.prefixtree.PrefixTree;

import java.util.Collection;
import java.util.List;

public class AutoComplete {
    private final PrefixTree items = new PrefixTree();

    public void addWord(final String word) {
        items.insert(word);
    }

    public void addWords(final Collection<String> words) {
        for (String word : words) {
            items.insert(word);
        }
    }

    public List<String> complete(final String fragment) {
        return items.getWithPrefix(fragment);
    }
}
