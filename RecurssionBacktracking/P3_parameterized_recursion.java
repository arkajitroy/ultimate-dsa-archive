package RecurssionBacktracking;

// These problems arer based on Parrameterized Recurssion
class Main {
    public static int sumOfKNumbers(int n){
        if(n == 0) return 0;
        return n + sumOfKNumbers(n-1);
    }

    public static int factorial(int n){
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Sum of First K Numbers : "+sumOfKNumbers(9));
        System.out.println("Factorial of N Number : " + factorial(5));
    }
}
