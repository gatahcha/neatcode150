// Problem: https://leetcode.com/problems/contains-duplicate/ 

import java.util.HashMap;

class Solution {
    public boolean hasDuplicate(int[] nums) {

        //runtime complexity O(n)
        
        HashMap<Integer, Boolean> check_duplicate = new HashMap<>();

        for( int i = 0 ; i < nums.length ; i++ ){
            if ( check_duplicate.containsKey(nums[i]) ) return true;
            else {
                check_duplicate.put(nums[i], true);
            }
        }


        return false;
    }
}