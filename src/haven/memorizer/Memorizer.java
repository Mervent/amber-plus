package haven.memorizer;

import java.util.*;

import org.json.JSONObject;

import haven.Utils;

public class Memorizer {
    private boolean initialized = false;
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
        this.save();
    }

    public Flashback recall(long gobId) {
        if (!initialized) {
            this.load();
            initialized = true;
        }
        return memory.get(gobId);
    }

    private void save() {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        for (Map.Entry<Long, Flashback> entry : memory.entrySet()) {
            data.put(entry.getKey().toString(), Flashback.toJSON(entry.getValue()));
        }
        json.put("data", data);
        Utils.setprefjson("memoizer", json);
    }

    private void load() {
        JSONObject json = Utils.getprefjson("memoizer", new JSONObject());
        JSONObject data = json.getJSONObject("data");
        Iterator<String> keys = data.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            Long gobId = Long.parseLong(key);
            JSONObject flashbackJSON = data.getJSONObject(key);
            Flashback flashback = Flashback.fromJSON(flashbackJSON);
            if (flashback != null) {
                memory.put(gobId, flashback);
            }
        }
    }
}
