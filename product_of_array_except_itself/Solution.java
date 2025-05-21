package product_of_array_except_itself;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    public int[] productExceptSelf(int[] nums) {

        //detect all zeros
        List<Integer> saveZeroIndex = new LinkedList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if (nums[i] == 0) saveZeroIndex.add(i); 
        }

        //if num.zeros > 1 -> all array are zeros O(1)
        if (saveZeroIndex.size() > 1) return new int[nums.length];

        //if num.zeros ==1 -> count all multiplication except the zeros O(n)
        else if (saveZeroIndex.size() == 1) {
            int indexZero = saveZeroIndex.get(0);
            long k = 1;
            for (int i = 0 ; i < nums.length; i++){
                if (i != indexZero) {
                    k *= nums[i];
                }
            }
            int[] answer = new int[nums.length];
            answer[indexZero] = (int) k;
            return answer;
        }
        //else mult all the numbers and divide it one by one O(n)
        else {
            long k = 1;
            for (int i = 0 ; i < nums.length; i++){
                k *= nums[i];
            }
            int[] answer = new int[nums.length];
            for (int j = 0 ; j < nums.length; j++){
                answer[j] = (int) (k / (long) nums[j]);
            }
            return answer;
        }
    }
}
