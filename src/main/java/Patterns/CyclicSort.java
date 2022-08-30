package Patterns;



public class CyclicSort {

    public void cyclicSort1(int [] nums){

        int i = 0;

        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                swap(nums,i, j);
            }
            else
                i++;
        }
    }

    public void swap (int[] arr,int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findMissingNumber(int [] nums){

        int i = 0;
        while (i < nums.length){

            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        for(i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

            return nums.length;
    }

    


}
