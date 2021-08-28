package data.structure;

import data.structure.arraylist.ArrayList;
import data.structure.map.openaddressing.OpenAddressingMap;
import data.structure.queue.Queue;
import data.structure.queue.RingBuffer;
import data.structure.stack.Stack;

public class Application {
    public static void main(String[] args) {
        final OpenAddressingMap<String, Integer> paff = new OpenAddressingMap<>(4);

        paff.put("nagyanyád", 16);
        paff.put("hajjaj", 19);
        paff.put("ejj", 66);
        paff.put("jujuj", 89);
        paff.put("bbbbb", 100);
        paff.remove("jujuj");


        System.out.println(paff.has("hajja"));

    }
}
