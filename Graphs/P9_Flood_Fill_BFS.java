package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int[][] floodFill(int[][] image, int startRow, int startCol, int newColor) {
        int oldColor = image[startRow][startCol];
        if (oldColor == newColor) return image;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        image[startRow][startCol] = newColor;

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            for (int[] direction : directions) {
                int newRow = pixel[0] + direction[0];
                int newCol = pixel[1] + direction[1];
                
                if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == oldColor) {
                    queue.add(new int[]{newRow, newCol});
                    image[newRow][newCol] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
