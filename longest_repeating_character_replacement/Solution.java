package longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int characterReplacement(String s, int k) {
        
        char[] str = s.toCharArray();
        int len = str.length;
        int lo = 0;
        int hi = -1;
        int max = -1;

        HashMap<Integer, Character> map = new HashMap<>(); 

        for ( int i = 0; i < len; i++ ){
            if (!map.values().contains(str[i])) {
                if ( map.size() > k ){
                    map.remove(lo);
                    lo = map.keySet()
                            .stream()
                            .parallel()
                            .reduce(Math::min)
                            .get();
                    map.put(i, str[i]);
                    
                }
                else {
                    
                }
            }
            hi = i;
            max = hi - lo + 1;
        }



        return 0;
    }
}
