package top_k_frequent_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // runtime complexity O(n*k)

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> ordering = new HashMap<>();

        for ( int j : nums){
            ordering.put( j, ordering.getOrDefault(j, null) +1 );
        }
        int[] answer = new int[k];

        for (int i = 0 ; i < k ; i++){
            answer[i] = ordering.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null);
            ordering.remove(answer[i]);
        }
        return answer;
    }
}
