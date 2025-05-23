class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        
        return sb.toString().trim();
    }
}
