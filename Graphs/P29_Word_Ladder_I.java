package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Main {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list to a set for faster lookups
        Set<String> wordSet = new HashSet<>(wordList);
        // If the end word is not in the word list, return 0
        if (!wordSet.contains(endWord)) return 0;
        // Initialize the queue for BFS and add the begin word
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int level = 1;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll(); // Get the front word in the queue
                char[] charArray = currentWord.toCharArray(); // Convert word to character array

                // Try changing each character of the word to every other possible character
                for (int index = 0; index < charArray.length; index++) {
                    char originalChar = charArray[index]; // Save the original character

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue; // Skip if the character is the same

                        charArray[index] = ch; // Change to the new character
                        String newWord = new String(charArray); // Form the new word

                        // If the new word is the end word, return the current level + 1
                        if (newWord.equals(endWord)) return level + 1;

                        // If the new word is in the word set, add it to the queue and remove from the set
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    charArray[index] = originalChar; // Restore the original character
                }
            }
            level++; // Increment the level after processing all nodes at the current level
        }
        return 0; // Return 0 if no transformation sequence is found
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation sequence length: " + result);
    }
}
