package data.structure;

import data.structure.binarytree.BinarySearchTree;
import data.structure.binarytree.heap.Heap;
import data.structure.binarytree.heap.priorityqueue.PriorityQueue;
import data.structure.binarytree.navigablemap.NavigableMap;
import data.structure.prefixtree.PrefixTree;
import data.structure.prefixtree.autocomplete.AutoComplete;
import data.structure.stack.Stack;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

       final Heap<Integer> paff = new Heap<>();

       paff.insert(100);
       paff.insert(90);
       paff.insert(110);
       paff.insert(80);
       paff.insert(70);
       paff.insert(60);

       paff.showPrefixNotation();

       paff.showInfixNotation();

       paff.showPostfixNotation();


    }
}
