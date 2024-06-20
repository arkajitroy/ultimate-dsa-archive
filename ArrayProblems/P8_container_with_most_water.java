class Main{
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.max(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = { 1,8,6,2,5,4,8,3,7 };
        System.out.println("Max Water contained : " + maxArea(nums) + " Litres");
    }
}