package ArrayProblems;

import java.util.Arrays;

class Main {
    public static String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix_II(String[] strs) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(strs); // sorting the string-array

        // Getting the first and last string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        // start comparing
        for(int i=0; i<first.length; i++){
            if(first[i] != last[i]) break;
            result.append(first[i]);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        String[] strs = { "flower","flow","flight" };

        System.out.println("Longest Commong Prefix : " +longestCommonPrefix(strs));
        System.out.println("Longest Commong Prefix - Approach II : " +longestCommonPrefix_II(strs));
    }
}
