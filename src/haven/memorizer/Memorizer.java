package haven.memorizer;

import java.util.*;

public class Memorizer {
    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    Map<Long, Flashback> memory = new HashMap<Long, Flashback>();

    public static Memorizer instance = new Memorizer();

    private Memorizer() {

    }

    public static Memorizer getInstance() {
        return instance;
    }

    public void remember(Long gobId, Flashback flashback) {
        memory.put(gobId, flashback);
    }

    public Flashback recall(long gobId) {
        return memory.get(gobId);
    }
}
