package longest_consecutive_sequence;

import java.nio.channels.Pipe.SourceChannel;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> k = new HashSet<>();
        
        for (int num : nums) k.add(num);

        int max = 0;

        //check over the hashset
        for (int num : k){
            if (!k.contains(num-1)){
                //check over the consequtiveness considering lookup is O(1)
                int length = 1;
                while (k.contains(num+length)) length++;
                if (length > max) max = length;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] p = {1,2,3,4,6,5,6,6, 700, 45};
        Solution k = new Solution();
        k.longestConsecutive(p);
    }
}
