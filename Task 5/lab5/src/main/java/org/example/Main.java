package org.example;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Map<String, String> hm = new HashMap<>();
        hm.put("Russia", "Moscow");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Germany", "Berlin2");
        hm.put("Norway", "Oslo");
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        hm.put("Germany", "Berlin2");
        System.out.println("New Germany Entry: " + hm.get("Germany"));

        System.out.println(hm.containsKey("Russia"));
        System.out.println(hm.entrySet());
        System.out.println(hm.getOrDefault("Kongo", "Запись не найдена"));

        System.out.println();





        Set<String> set = new HashSet<>();
        set.add("Aльфa");
        set.add("Бета");
        set.add("Aльфa");
        set.add("Этa");
        set.add("Гaммa");
        set.add("Эпсилон");
        set.add("Oмeгa");
        set.add("Гaммa");
        System.out.println(set);

        System.out.println();

        Set<String> lSet = new LinkedHashSet<>();
        lSet.add("Бета");
        lSet.add("Aльфa");
        lSet.add("Этa");
        lSet.add("Гaммa");
        lSet.add("Эпсилон");
        lSet.add("Oмeгa");
        System.out.println(lSet);

        //lSet.iterator()

        System.out.println();

        Set<String> tSet = new TreeSet<>();
        tSet.add("C");
        tSet.add("A");
        tSet.add("B");
        tSet.add("E");
        tSet.add("F");
        tSet.add("D");
        System.out.println(tSet);

        System.out.println();

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A", "B", "C", "B"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals("A")) {
                iter.remove();
            }
        }


        System.out.println(list);

        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A",
                "A", "B", "C", "B"));
        ListIterator<String> iter2 = list.listIterator();

        System.out.println(list2);




        String[] words = {"Alex", "Molodec", "Dmitry", "Molodec", "Elya", "Ivan", "Ivan", "Journal", "HeHe"};
        HashMap<String, Integer> list3 = new HashMap<>();

        for (String s: words) {
            list3.merge(s, 1, Integer::sum);
        }

        System.out.println(list3.entrySet());




        Map<String, String> mapTree = new TreeMap<>();
        mapTree.put("4", "1");
        mapTree.put("2", "2");
        mapTree.put("3", "3");
        mapTree.put("3", "3");
        System.out.println(mapTree.entrySet());
        mapTree.merge("4", "blabla", (oldVal, newVal) -> oldVal + newVal);
        System.out.println(mapTree.entrySet());



        Map<String, String> linkHM = new LinkedHashMap<>();
        linkHM.put("1", "term1");

        linkHM.merge("1", "blabla", (oldVal, newVal) -> oldVal + newVal + "\n");
        linkHM.merge("1", "123", (oldVal, newVal) -> oldVal + newVal + "\n");

        System.out.println(linkHM.entrySet());
    }
}