package Graphs;

class Main {
    public static int findCircleNum(int[][] provinces){
        boolean[] visited = new boolean[provinces.length];
        int provinceCount = 0;

        for(int i=0; i<provinces.length; i++){
            if(!visited[i]){
                dfs(provinces, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private static void dfs(int[][] provinces, boolean[] visited, int i) {
        for (int j = 0; j < provinces.length; j++) {
            if (provinces[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(provinces, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] provinces = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = findCircleNum(provinces);
        System.out.println("Number of provinces: " + result);
    }
}
