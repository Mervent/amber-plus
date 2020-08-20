package haven.memoizer;

import java.util.*;

import org.json.JSONObject;

import haven.Utils;

public class Memoizer {
    private boolean initialized = false;
    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    Map<Long, String> memory = new HashMap<Long, String>();

    public void set(long gobId, String text) {
        memory.put(gobId, text);
        this.save();
    }

    public String get(long gobId) {
        if (!initialized) {
            this.load();
        }
        return memory.getOrDefault(gobId, "");
    }

    private void save() {
        JSONObject json = new JSONObject();
        json.put("data", memory);
        Utils.setprefjson("memoizer", json);
    }

    private void load() {
        JSONObject json = Utils.getprefjson("memoizer", new JSONObject());
        JSONObject data = json.getJSONObject("data");
        Iterator<String> keys = data.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            Long gobId = Long.parseLong(key);
            memory.put(gobId, data.getString(key));
        }
    }
}
