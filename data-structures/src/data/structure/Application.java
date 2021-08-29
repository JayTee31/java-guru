package data.structure;

import data.structure.arraylist.ArrayList;
import data.structure.linkedlist.LinkedList;
import data.structure.map.openaddressing.OpenAddressingMap;
import data.structure.map.overlinkedlist.LinkedHashMap;
import data.structure.queue.Queue;
import data.structure.queue.RingBuffer;
import data.structure.queue.overlinkedlist.LinkedQueue;
import data.structure.stack.Stack;
import data.structure.stack.overlinkedlist.LinkedStack;

public class Application {
    public static void main(String[] args) {

        final LinkedQueue<Integer> paff = new LinkedQueue<>();

        paff.add(10);
        paff.add(20);
        paff.add(30);

        System.out.println(paff.element());
        System.out.println(paff.peek());
        System.out.println(paff.poll());
        System.out.println(paff.peek());
        System.out.println(paff.remove());
        System.out.println(paff.peek());




    }
}
