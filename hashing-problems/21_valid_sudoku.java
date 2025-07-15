import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        HashSet<Character>[] rows = new HashSet[size];
        HashSet<Character>[] cols = new HashSet[size];
        HashSet<Character>[] boxes = new HashSet[size];

        // Assigning the value (0-9) to all the given sets
        for(int i=0; i<size; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Looping into the matrix grid
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                char current = board[i][j];

                if(current == '.') continue;

                // Check Row
                if(rows[i].contains(current)) return false;
                rows[i].add(current);

                // Check Column
                if(cols[j].contains(current)) return false;
                cols[j].add(current);

                // Check Box Index
                int boxIndex = (i / 3) * 3 + j / 3;
                if(boxes[boxIndex].contains(current)) return false;
                boxes[boxIndex].add(current);
            }
        }

        return true;
    }
}