package ArrayProblems;

class Main {
    public static void setZeroes(int[][] matrix){
        int col0 = 1;
        int rows = matrix.length, cols = matrix[0].length;

        for(int i=0; i<rows; i++){
            if(matrix[i][0] == 0) col0 = 0;

            for(int j=1; j<cols; j++){
                if(matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for(int i=rows-1; i >=0; i--){
            for(int j=cols-1; j>=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix [i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public static void printMatrix(int[][] matrix){
        for(int row[] : matrix){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("Matrix after setting zeroes:");
        printMatrix(matrix);
    }
}
