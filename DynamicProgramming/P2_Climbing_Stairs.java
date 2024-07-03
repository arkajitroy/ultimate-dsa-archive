package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static int climbStairs_recursive(int n){
        if(n <= 1) return 1;
        return climbStairs_recursive(n-1) + climbStairs_recursive(n-2);
    }

    // top-down approach
    private static Map<Integer, Integer> dp = new HashMap<>();
    public static int climbStairs_DP(int n){
        if(n <= 1) return 1;

        if(dp.containsKey(n)) return dp.get(n);

        int result = climbStairs_DP(n-1) + climbStairs_DP(n-2);
        dp.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb Stairs - Recursive : " + climbStairs_recursive(n));
        System.out.println("Number of ways to climb Stairs - DP : " + climbStairs_DP(n));
    }
}
