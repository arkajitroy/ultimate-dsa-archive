# 🧠 Top 30 Most-Asked Graph Problems for Interviews

These problems are carefully selected from LeetCode, GeeksforGeeks, and Striver's SDE Sheet. They cover essential patterns like BFS, DFS, Union-Find, Topo Sort, MST, and Shortest Path. Ideal for mastering graph-based questions asked in fullstack and software engineering interviews.

---

| No.   | Problem                                                                                                                                                | Platform            | Difficulty | Pattern                      |
| ----- | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------- | ---------- | ---------------------------- |
| 1.    | [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)                                                                              | LeetCode            | Medium     | DFS/BFS                      |
| 1-[a] | [Number of island](https://leetcode.com/problems/number-of-islands/description/)                                                                       | LeetCode            | Medium     | DFS/BFS                      |
| 2.    | [Flood Fill](https://leetcode.com/problems/flood-fill/)                                                                                                | LeetCode            | Easy       | BFS/DFS (Matrix)             |
| 3.    | [01 Matrix](https://leetcode.com/problems/01-matrix/)                                                                                                  | LeetCode            | Medium     | Multi-source BFS             |
| 4.    | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)                                                                                      | LeetCode            | Medium     | BFS (Matrix)                 |
| 5.    | [Detect Cycle in an Undirected Graph](https://www.geeksforgeeks.org/detect-cycle-undirected-graph/)                                                    | GFG                 | Medium     | DFS/BFS                      |
| 6.    | [Detect Cycle in a Directed Graph](https://www.geeksforgeeks.org/detect-cycle-in-a-graph/)                                                             | GFG                 | Medium     | DFS (Rec Stack)              |
| 7.    | [Course Schedule](https://leetcode.com/problems/course-schedule/)                                                                                      | LeetCode            | Medium     | Topological Sort             |
| 8.    | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)                                                                                | LeetCode            | Medium     | Topological Sort             |
| 9.    | [Alien Dictionary](https://practice.geeksforgeeks.org/problems/alien-dictionary/1)                                                                     | GFG                 | Hard       | Topological Sort             |
| 10.   | [Shortest Path in Directed Asyclic Graph](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1)                                  | GFG                 | Medium     | Topological Sort             |
| 11.   | [Shortest Path in Undirected Graph with Unit Weights](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1) | GFG                 | Easy       | BFS                          |
| 12.   | [Dijkstra’s Algorithm](https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)                                     | GFG                 | Medium     | Dijkstra (Min Heap)          |
| 13.   | [Bellman Ford Algorithm](https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1)                                | GFG                 | Medium     | Bellman-Ford                 |
| 14.   | [Floyd Warshall Algorithm](https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1)                                              | GFG                 | Medium     | All-pairs Shortest Path      |
| 15.   | [Minimum Spanning Tree (Prim's)](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)                                                  | GFG                 | Medium     | MST (Prim’s)                 |
| 16.   | [Kruskal’s Algorithm](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)                                                             | GFG                 | Medium     | MST (Kruskal’s + Union-Find) |
| 17.   | [Redundant Connection](https://leetcode.com/problems/redundant-connection/)                                                                            | LeetCode            | Medium     | Union Find                   |
| 18.   | [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)          | LeetCode            | Medium     | DFS/Union Find               |
| 19.   | [Graph Valid Tree](https://neetcode.io/problems/valid-tree)                                                                                            | LeetCode / NeetCode | Medium     | DFS/Union Find               |
| 20.   | [Clone Graph](https://leetcode.com/problems/clone-graph/)                                                                                              | LeetCode            | Medium     | DFS/BFS (Graph Cloning)      |
| 21.   | [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)                                                                               | LeetCode            | Medium     | BFS/DFS (2-coloring)         |
| 22.   | [Word Ladder](https://leetcode.com/problems/word-ladder/)                                                                                              | LeetCode            | Hard       | BFS (Shortest Path)          |
| 23.   | 🔴 [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)                                                                                     | LeetCode            | Hard       | BFS + Backtracking           |
| 24.   | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)                                                                          | LeetCode            | Hard       | Eulerian Path (DFS + Stack)  |
| 25.   | [Critical Connections (Bridges)](https://leetcode.com/problems/critical-connections-in-a-network/)                                                     | LeetCode            | Hard       | Tarjan's Algo                |
| 26.   | [Strongly Connected Components](https://www.geeksforgeeks.org/strongly-connected-components/)                                                          | GFG                 | Hard       | Kosaraju’s Algo              |
| 27.   | [Journey to the Moon (HackerRank)](https://www.hackerrank.com/challenges/journey-to-the-moon/problem)                                                  | HackerRank          | Medium     | DFS/Component Counting       |
| 28.   | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)                                                      | LeetCode            | Medium     | Modified BFS / Bellman-Ford  |
| 29.   | [Network Delay Time](https://leetcode.com/problems/network-delay-time/)                                                                                | LeetCode            | Medium     | Dijkstra’s Algo              |
| 30.   | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)                                                              | LeetCode            | Medium     | Multi-source DFS/BFS         |
| 31.   | [Keys and Room](https://leetcode.com/problems/keys-and-rooms/description)                                                                              | LeetCode            | Medium     | DFS/BFS                      |

---

🧩 **Tips**:

- Master both **adjacency list** and **adjacency matrix** representations.
- Practice both **recursive DFS** and **iterative BFS**.
- For shortest paths, know when to use **BFS**, **Dijkstra**, **Bellman-Ford**, or **Floyd-Warshall**.
- Union-Find is key for **cycle detection**, **MST**, and **connected components**.
