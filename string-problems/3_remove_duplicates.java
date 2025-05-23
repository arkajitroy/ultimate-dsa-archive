import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public String removeDuplicates(String s) {
        // Use LinkedHashSet to maintain order and remove duplicates
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
