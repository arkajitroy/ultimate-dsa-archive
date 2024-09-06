package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P40_group_anagrams {

    // Approach 01: Sorting the Keys
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            // converting into strinng
            String sorted = new String(charArray);
            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            // first getting the key then inserting the string
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Appraoch 02: Character Count of the keys
    public static List<List<String>> groupAnagramsB(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for(char ch : s.toCharArray()){
                count[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i : count){
                key.append("#").append(i);
            }

            String keyString = key.toString();
            if(!map.containsKey(keyString)) map.put(keyString, new ArrayList<>());
            // first getting the key then inserting the string
            map.get(keyString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
         String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
    }
}
