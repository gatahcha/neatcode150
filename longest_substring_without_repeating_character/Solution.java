package longest_substring_without_repeating_character;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> memo = new HashSet<>();
        int max = 0;
        int init_index = 0;

        char[] str = s.toCharArray();
        int len = str.length;

        for (int i = 0 ; i < len; i++ ){
            if (!memo.contains(str[i])){
                memo.add(str[i]);
                if ( (i - init_index + 1) > max){
                    max = i - init_index + 1;
                    System.out.println(str[i]);
                } 
            }
            else {
                while(str[init_index] != str[i]){
                    memo.remove(str[i]);
                    init_index++;
                }
                init_index++;
            }
        }

        return max;   
    }
}
