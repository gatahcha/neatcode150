package permutation_in_string;

import java.util.HashMap;

public class Solution {
    /**
     *  You are given two strings s1 and s2.
     *  Return true if s2 contains a permutation of s1, or false otherwise. 
     *  That means if a permutation of s1 exists as a substring of s2, then return true.
     *  Both strings only contain lowercase letters.
     */
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> mapS1 = hashMapStringTranslation(s1);
        int lenS = s1.length();

        for (int i = 0 ; i <= s2.length() - lenS; i++){
            HashMap<Character, Integer> slice = hashMapStringTranslation(s2.substring(i, i + lenS));
            if (mapS1.equals(slice)) return true;
        }

        //sliding windows

        return false;
    }

    public HashMap<Character, Integer> hashMapStringTranslation ( String s ){
        HashMap<Character, Integer> mapS = new HashMap<>();

        //create hashmap for s1
        for (int i = 0 ; i < s.length(); i++){
            char currectChar = s.charAt(i);
            if (!mapS.containsKey(currectChar)){
                mapS.put(currectChar, 1);
            }
            else {
                int currentVal = mapS.get(currectChar);
                mapS.put(currectChar, currentVal + 1);
            }
        }
        return mapS;
    }


    public static void main(String[] args) {
        Solution k = new Solution();

        String test1 = "adc";
        String test2 = "dcda";

        System.out.println(k.checkInclusion(test1, test2));

        // System.out.println(test2.substring(0, 3));
    }
}
