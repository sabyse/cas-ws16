package haw.cas.praktikum.parser;

import java.util.HashMap;
import java.util.stream.Stream;

import haw.cas.praktikum.parser.Obj.MObjekt;

public class MObjektRepository {

    static HashMap<String, MObjekt> hm = new HashMap<String, MObjekt>();

    public static void add(String key, MObjekt obj) {
        //TODO: vileicht hier pr�fen
        hm.put(key, obj);
    }

    public static MObjekt get(String key) {
        return hm.get(key);
    }

    public static void clear() {
        hm.clear();
    }

    public static void remove(String key) {
        hm.remove(key);
    }

    public static Stream<MObjekt> getStream() {
        return hm.values().stream();
    }
}
