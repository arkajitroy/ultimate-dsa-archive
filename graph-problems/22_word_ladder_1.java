import java.util.*;

// Bidirectional BFS Approach
class WordLadderBiBFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set for optimization
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        chars[i] = c;
                        String newWord = new String(chars);

                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            nextLevelSet.add(newWord);
                            wordSet.remove(newWord); // prevent revisit
                        }
                    }

                    chars[i] = originalChar;
                }
            }
            beginSet = nextLevelSet;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadderBiBFS solver = new WordLadderBiBFS();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = solver.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length (Bi-BFS): " + result);
    }
}

// Approach: using the BFS traversal
// Complexity: O(n) | O(n)
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);

        if (!wordset.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue;

                        chars[j] = ch;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) return level + 1;

                        if (wordset.contains(newWord)) {
                            queue.add(newWord);
                            wordset.remove(newWord); // Avoid revisiting
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}