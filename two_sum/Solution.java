package two_sum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //runtime O(n)

        HashMap<Integer, Integer> mapping = new HashMap<>();
        mapping.put(nums[0], 0);

        for ( int i = 1 ; i < nums.length; i++ ){
            if ( mapping.containsKey(target - (nums[i])) ){
                int[] result = {mapping.get(target - (nums[i])), i};
                return result;
            }
            else {
                mapping.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args){
        Solution k = new Solution();
        int[] j = {2,3,4,5,6};
        int[] ans = k.twoSum(j, 7);
        System.out.println(ans[1]);
    }
}

