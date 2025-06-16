import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int startRow, int startCol, int newColor) {
        int oldColor = image[startRow][startCol];
        if(oldColor == newColor) return image;

        computeDFS(image, startRow, startCol, oldColor, newColor);
        return image;
    }

    private void computeDFS(int[][] image, int row, int col, int oldColor, int newColor){
        if(row <= 0 || col < 0 || 
            row >= image.length || col >= image[0].length || image[row][col] != oldColor){
            return;
        }

        image[row][col] = newColor;

        // compute for all the neighbor nodes
        computeDFS(image, row - 1, col, oldColor, newColor); // up
        computeDFS(image, row + 1, col, oldColor, newColor); // down
        computeDFS(image, row, col - 1, oldColor, newColor); // left
        computeDFS(image, row, col + 1, oldColor, newColor); // right
    }
}

class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // up, down, left, right

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && image[newRow][newCol] == originalColor) {
                    queue.offer(new int[]{newRow, newCol});
                    image[newRow][newCol] = newColor;
                }
            }
        }

        return image;
    }
}
