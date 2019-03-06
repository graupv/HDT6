// package Main;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    Map<String, String> thing;
    HashMap<String, String> get_hash(){

        return new HashMap<String, String>();
    }

    HashMap<Carta, Integer> get_col_hash(){

        return new HashMap<>();
    }

    LinkedHashMap<String, String> get_linked(){

        return new LinkedHashMap<String, String>();
    }

    LinkedHashMap<Carta, Integer> get_col_linked(){

        return new LinkedHashMap<Carta, Integer>();
    }

    TreeMap<String, String> get_tree(){

        return new TreeMap<String, String>();
    }

    TreeMap<Carta, Integer> get_col_tree(){

        return new TreeMap<Carta, Integer>();
    }
}
