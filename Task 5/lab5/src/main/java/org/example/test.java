package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class test {
    private Map<String, String> mapTree = new LinkedHashMap<>();
    public void add(String key, String val){
        if (mapTree.containsKey(key) == true) {
            for (Map.Entry<String, String> o : mapTree.entrySet()) {
                if (o.getValue().contains(val)){
                    System.out.println("Значение '" + val + "' уже есть уже у " + key);
                    return;
                }
            }
            mapTree.merge(key, val, (oldVal, newVal) -> oldVal + ",\n" + newVal);
        } else {
            mapTree.put(key, val);
        }
    }

    public void get(String key){
        System.out.println(key + ": \n" + mapTree.getOrDefault(key, "Запись не найдена!") + "\n");
    }

    public void get(){
        System.out.println(mapTree.entrySet());
    }
}
