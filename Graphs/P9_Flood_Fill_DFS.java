package Graphs;

import java.util.Arrays;

class Main{
    public static int[][] floodFill(int[][] image, int startRow, int startCol, int newColor){
        int oldColor = image[startRow][startCol];
        if(oldColor != newColor) dfs(image, startRow, startCol, oldColor, newColor);
        return image;
    }

    private static void dfs(int[][] image, int startRow, int startCol, int oldColor, int newColor){
        // checking for all the edge-cases
        if(startRow < 0 || startRow >= image.length || startCol < 0 
        || startCol >= image[0].length || image[startRow][startCol] != oldColor) return;

        image[startRow][startCol] = newColor;

        // dfs-call in 4 direction
        dfs(image, startRow + 1, startCol, oldColor, newColor);
        dfs(image, startRow - 1, startCol, oldColor, newColor);
        dfs(image, startRow, startCol + 1, oldColor, newColor);
        dfs(image, startRow, startCol - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }
}