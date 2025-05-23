import java.util.*;

// Approach: HashMap + sorting
// complexity: O(n * k log k) | O(n * k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();

        // for each string in the array, sort the characters
        // and use the sorted string as a key in the map
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}


// Approach: Character frequency as key
// complexity: O(n * k) 

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
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
}