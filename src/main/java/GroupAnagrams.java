package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedValue = String.valueOf(array);
            if (map.containsKey(sortedValue)) {
                map.get(sortedValue).add(str);
            } else {
                List<String> newArray = new ArrayList<>();
                newArray.add(str);
                map.put(sortedValue, newArray);
            }
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"a"}));
    }

}
