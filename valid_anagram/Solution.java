package valid_anagram;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public boolean isAnagram(String s, String t) {

        //runtime O(n + m), where m is number of character
        
        if ( s.length() != t.length() ) return false;

        Map<Character, Long> sComposition = s.toLowerCase()
                                            .chars()
                                            .filter(Character::isAlphabetic)
                                            .mapToObj(c -> (char) c )
                                            .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()
                                            ));

        Map<Character, Long> tComposition = t.toLowerCase()
                                            .chars()
                                            .filter(Character::isAlphabetic)
                                            .mapToObj(c -> (char) c )
                                            .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()
                                            ));


        return tComposition.equals(sComposition);
    }


    public static void main(String[] args) {

        Solution k = new Solution();
        boolean p = k.isAnagram("memek", "mmeek");
        System.out.println(p);
    }
}



