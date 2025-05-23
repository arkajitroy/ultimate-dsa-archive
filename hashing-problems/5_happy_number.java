import java.util.HashSet;

// Approach: using Hashet
// complexity: O(n) | O(n)

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while( n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}

// Approach: using fast and slow pointers
// complexity: O(log n) | O(1)

class Solution1 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }
    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}