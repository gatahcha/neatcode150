package three_sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        HashSet<List<Integer>> answer = new HashSet<>();

        for (int i = 0 ; i < len; i++){
            for(int j = i+1; j< len; j++){
                for (int k = j+1; k < len; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        answer.add(Stream.of(nums[i],nums[j],nums[k])
                                            .sorted()
                                            .collect(Collectors.toList()));
                    }
                }
            }
        }

        return new LinkedList<>(answer);
    }  
}
