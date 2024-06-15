package RecurssionBacktracking;

import java.util.Arrays;

class Main {
    public static void reverseArrray(int[] nums, int start, int end){
        if(start >= end) return;
        // swap
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        // recursive-call
        reverseArrray(nums, start+1, end-1);
    }

    public static boolean palindromeCheck(String str, int start, int end){
        if(start >= end) return true;
        if(str.charAt(start) != str.charAt(end)) return false;
        // recursive-call
        return palindromeCheck(str, start+1, end-1);
    }

    public static boolean palindromeCheck_LongString(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
            // we will only insert the character and digit no spaces
        }
        return palindromeCheck(sb.toString(), 0, sb.toString().length()-1);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 9, 7, 5, 1, 10, 6 };
        String str = "madam";
        String str_long = "A man, a plan, a canal, Panama";
        
        reverseArrray(nums, 0, nums.length-1);
        System.out.println("Reversed Array using Iteration : " + Arrays.toString(nums));
        System.out.println("String is palindrome or not? : " + palindromeCheck(str, 0, str.length()-1));
        System.out.println("String is palindrome or not (II) ? : " + palindromeCheck_LongString(str_long));
    }
}

    // ======================= (reverse arrray iterative)
    // public static void reverseAraryIterative(int[] nums){
    //     int[] result = new int[nums.length];
    //     int temp;
    //     int start = 0, end = nums.length - 1;
    //     while (start < end) {
    //         temp = nums[start];
    //         result[start] = nums[end];
    //         result[end] = temp;
    //         // incrementing
    //         start++;
    //         end--;
    //     }
    //     System.out.println("Reversed Array using Iteration : " + Arrays.toString(result));
    // }