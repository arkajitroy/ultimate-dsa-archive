package Arrays;

class Main{
    private static int findMaxConsecutiveOnes(int[] nums){
        int count=0, max_count= 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                max_count = Math.max(max_count, count);
            }else count = 0;
        }
        return max_count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println("Max Occurance 1s : "+findMaxConsecutiveOnes(nums));
    }
}