package RecurssionBacktracking;

class Main {
    // ============== Recursive Approach =========
    private static int fibonacciRecursive(int n){
        if(n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void printFibonacciRecursive(int n){
        for(int i = 0; i < n; i++){
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }

    // =============== Iterative Approach ==========
    public static void printFibonacciIterative(int n){
        if (n <= 0) return;

        int a = 0, b = 1;
        System.out.print(a + " ");
        
        for(int i = 1; i < n; i++){
            System.out.print(b + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Series Recursive:");
        printFibonacciRecursive(9);
        System.out.println("\nFibonacci Series Iterative:");
        printFibonacciIterative(9);
    }
}
