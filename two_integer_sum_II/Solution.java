package two_integer_sum_II;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int initIndex = 0;
        int lastIndex = numbers.length - 1;

        while (initIndex < lastIndex){
            int currNum = numbers[initIndex] + numbers[lastIndex];
            if (currNum == target) return new int[]{initIndex+1, lastIndex+1};
            else if (currNum < target) initIndex++;
            else lastIndex--; 
        }

        return null;
    }
}
