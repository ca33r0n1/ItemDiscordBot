package net.projectrefresh;

import java.util.*;
import java.util.stream.Stream;

public class Utils {

    /**
     * Sorts a HashMap into ascending order based on the Integer in the map.
     * @param hm Hashmap to needs to be sorted out.
     * @return a sorted hashmap.
     */
    @Deprecated
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        Stream<Map.Entry<String ,Integer>> sorted =temp.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        return (HashMap<String, Integer>) sorted;
    }

    /**
     * Sorts a HashMap into a descending order based on the Integer in the map.
     * @param hm Hashmap to needs to be sorted out.
     * @return a sorted hashmap.
     */
    public static HashMap<String,Integer> sortByHigh(HashMap<String, Integer> hm){
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
}
