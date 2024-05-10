package TwoPointers;

import java.util.HashMap;

class Main {
    public static int totalFruit(int[] fruits){
        int maxFruits = 0, left= 0;
        // map<num, freq>
        HashMap<Integer, Integer> basket = new HashMap<>();

        //itterating through array
        for(int right=0; right < fruits.length; right++){
            int fruit = fruits[right];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // maintian only two types in the basket
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit)-1);
                if(basket.get(leftFruit) == 0) basket.remove(leftFruit);
                left++;
            }
            // updating the maximum number of fruits
            maxFruits = Math.max(maxFruits, right - left+1);
        }
        return maxFruits;        
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println("Maximum number of fruits: " + totalFruit(fruits));
    }
}
