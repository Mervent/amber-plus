package haven.memorizer;

import java.lang.reflect.Field;

import org.json.JSONObject;

public class Flashback {
    public String asTooltip() {
        return "You remember that";
    }

    public String asOverlay() {
        return "You remember that";
    }

    public static JSONObject toJSON(Flashback instance) {
        JSONObject json = new JSONObject();
        Field[] fields = instance.getClass().getFields();
        json.put("_class", instance.getClass().getName());
        for (Field field : fields) {
            try {
                json.put(field.getName().toString(), field.get(instance));
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return json;
    }

    public static Flashback fromJSON(JSONObject json) {
        try {
            Class<?> cls = Class.forName(json.getString("_class"));
            Object instance = cls.newInstance();
            Field[] fields = instance.getClass().getFields();
            for (Field field : fields) {
                try {
                    Object value = json.get(field.getName().toString());
                    field.set(instance, value);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            return (Flashback) instance;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
