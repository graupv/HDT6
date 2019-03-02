package Main;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    Map<String, String> thing;
    HashMap<String, String> get_hash(){

        return new HashMap<String, String>();
    }

    LinkedHashMap<String, String> get_linked(){
//        thing = new LinkedHashMap<>();
//        return (LinkedHashMap<String, String>) thing;
        return new LinkedHashMap<String, String>();
    }

    TreeMap<String, String> get_tree(){

        return new TreeMap<String, String>();
    }
}
