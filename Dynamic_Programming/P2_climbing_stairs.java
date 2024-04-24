package Dynamic_Programming;

class Main{
    public static int climbStairs(int n) {
        if(n <= 1) return 1;
        int first_step = 1, second_step = 1;

        for(int i=2; i<=n; i++){
            int temp = second_step;
            second_step = first_step + second_step;
            first_step = temp;
        }

        return second_step;
    }

    public static void main(String[] args) {
        int stairs = 3;
        int result = climbStairs(stairs);
        System.out.println("Result: "+ result);
    }
}