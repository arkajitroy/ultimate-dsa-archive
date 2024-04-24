package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    // ================================ (DP) ==================================
    public static List<String> generateParenthesis_DP(int n){
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));

        for(int i=1; i<=n; i++){
            List<String> current = new ArrayList<>();
            for(int j=0; j<i; j++){
                List<String> inside = dp.get(j);
                List<String> outside = dp.get(i-j-1);
                for(String in : inside){
                    for(String out : outside){
                        current.add("(" + in + ")" + out);
                    }
                }
            }
            dp.add(current);
        }

        return dp.get(n);
    }

    // ================================ (Backtracking) =============================
    public static List<String> generateParenthesis_BT(int n){
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private static void backtrack(String current, int open, int close, int n, List<String> result){
        if(current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if(open < n) backtrack(current + "(", open + 1, close, n, result);
        if(close < open) backtrack(current + ")", open, close + 1, n, result);
    }

    public static void main(String[] args) {
        int parenthesis = 3;
        List<String> result = generateParenthesis_DP(parenthesis);
        System.out.println("Valid Combination of parenthesis =>");
        for(String s : result){
            System.out.println(s);
        }
    }
}
