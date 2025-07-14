class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = weights[0];
        int totalWeight = 0;

        for(int weight : weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight, right = totalWeight;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(canShip(weights, days, mid)){
                result = mid;
                right = mid - 1; // Try to find smaller capacity
            }
            else{
                left = mid + 1; // Can load larger capacity
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int dayEst, int capacity){
        int dayCount = 1;
        int currentLoad = 0;

        for(int weight : weights){
            if(currentLoad + weight > capacity){
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return dayCount <= dayEst;
    }
}