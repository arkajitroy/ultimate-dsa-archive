import java.util.*;

class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        // If endWord is not in the wordSet, return empty result
        if (!wordSet.contains(endWord)) return result;

        // Step 1: Build graph using BFS
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> levels = new HashMap<>();
        buildGraphBFS(beginWord, endWord, wordSet, graph, levels);

        // Step 2: DFS to build all shortest paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        buildPathsDFS(beginWord, endWord, graph, levels, path, result);

        return result;
    }

    private static void buildGraphBFS(String startWord, String endWord, Set<String> wordSet,
                                      Map<String, List<String>> graph, Map<String, Integer> levels) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        levels.put(startWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int level = levels.get(word);
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue;

                        chars[j] = ch;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord)) {
                            graph.computeIfAbsent(word, k -> new ArrayList<>()).add(nextWord);

                            if (!levels.containsKey(nextWord)) {
                                levels.put(nextWord, level + 1);
                                if (nextWord.equals(endWord)) {
                                    foundEnd = true;
                                } else {
                                    queue.add(nextWord);
                                }
                            }
                        }
                    }
                    chars[j] = originalChar;
                }
            }

            if (foundEnd) break;
        }
    }

    private static void buildPathsDFS(String current, String endWord, Map<String, List<String>> graph,
                                      Map<String, Integer> levels, List<String> path, List<List<String>> result) {
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(current)) return;

        for (String next : graph.get(current)) {
            if (levels.get(next) == levels.get(current) + 1) {
                path.add(next);
                buildPathsDFS(next, endWord, graph, levels, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> results = findLadders(beginWord, endWord, wordList);

        System.out.println("All shortest transformation sequences:");
        for (List<String> path : results) {
            System.out.println(path);
        }
    }
}
