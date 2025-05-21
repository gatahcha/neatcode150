package generate_parantheses;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Solution {
    public List<String> generateParenthesis(int n) {
        // create a data structure such that
        // Map <{String}, {left-right differences, total left}>
        //itterates over n

        HashMap<String, int[]> map = new HashMap<>();
        map.put("", new int[]{0,0});
        for (int i = 0 ; i < 2*n ; i++){
            HashMap<String, int[]> newMap = new HashMap<>();
            map.forEach( (key, value) -> {
                if (value[0] > 0){
                    if (value[1] < n){
                        newMap.put(key.concat("("), new int[]{value[0]+1, value[1]+1});
                        newMap.put(key.concat(")"), new int[]{value[0]-1, value[1]});
                    }
                    else {
                        newMap.put(key.concat(")"), new int[]{value[0]-1, value[1]});
                    }
                }
                else {
                    newMap.put(key.concat("("), new int[]{value[0]+1, value[1]+1});
                }
            });
            map = newMap;
        }
        return map.keySet().stream()
                            .parallel()
                            .collect(Collectors.toList());
    }
}
