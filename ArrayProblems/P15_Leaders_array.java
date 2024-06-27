package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static ArrayList<Integer> leaders_brute(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            boolean leader = true;
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader) result.add(arr[i]);
        }
        return result;
    }

    public static ArrayList<Integer> leaders_OP(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        int max = arr[n-1];

        result.add(arr[n-1]);

        for(int i=n-2; i>=0; i--){
            if(arr[i] > max){
                result.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        int arr[]=  {10, 22, 12, 3, 0, 6};
        System.out.println("Leaders of the array : "+leaders_brute(arr, arr.length-1));
        System.out.println("Leaders of the array : "+leaders_OP(arr, arr.length-1));
    }
}
