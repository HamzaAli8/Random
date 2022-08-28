package Patterns;


import java.util.HashMap;

public class TwoPointers {

    // brute force method

    public int[] pairWithTargetSum(int [] arr, int sum){

        int [] output = new int[2];

        for(int i = 0; i < arr.length -1; i++){

            int low = 0;
            int high = arr.length -1;

            while(low <= high){

                int mid = (high + low)/2;

                if (arr[mid] + arr[i] < sum) low = mid +1;
                else if (arr[mid] + arr[i] > sum) high = mid -1;
                else{
                    return new int[] {i , mid};
                }
            }
        }

        return output;
    }


// same method as above but using 2 pointer method

    public int[] pairWithTargetSum2(int [] arr, int sum){

        int left = 0, right = arr.length -1;

        while (left < right ){

            int currentSum = arr[left] + arr[right];
            if (currentSum == sum){
                return new int[] {left , right};
            }

            if (sum > currentSum)
                left ++;
            else
                right--;
        }
    return new int [] {-1, -1};
    }


    // another way to find the target pair sum

    public int[] pairWithTargetSum3 (int [] arr, int targetSum){

        HashMap<Integer,Integer> nums = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            if (nums.containsKey(targetSum - arr[i]))
                return  new int[] {nums.get(targetSum - arr[i]), i};

            else
                nums.put(arr[i],i);
        }

        return new int[] {-1,-1};
    }

    public int removeDuplicates (int [] arr){

        int nextNonDuplicate = 1;

        for(int i = 1; i < arr.length; i++){

            if(arr[nextNonDuplicate -1]  != arr[i]){

                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

}