package group_anagram;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

    //ordered based 
    // assume word lenth in average m -> mlog(m)
    // number of words -> n
    // in total n.mlog(m)

    //hashmap_based -> the key is the hash
    // m*n

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Long>, LinkedList<Integer>> mapping = new LinkedHashMap();

        for (int i = 0 ; i < strs.length; i++){
            Map<Character, Long> curStr = strs[i].toLowerCase()
                                                    .chars()
                                                    .mapToObj(c -> (char) c)
                                                    .collect(Collectors.groupingBy(
                                                        c -> c,
                                                        Collectors.counting()
                                                    ));
            if ( mapping.containsKey(curStr) ){
                mapping.get(curStr).add(i);
            }                              
            else {
                LinkedList<Integer> k = new LinkedList<>();
                k.add(i);
                mapping.put(curStr, k);
            }         
        }

        List<List<String>> answer = new ArrayList<>();
        mapping.forEach( (key, value) -> {
            List<String> strCollection = new ArrayList<>();
            value.forEach(e -> {
                strCollection.add(strs[e]);
            });
            answer.add(strCollection);
        });


        return answer;
    }

    public static void main(String[] args) {
        HashMap<HashMap<Character, Integer>, Integer> k = new HashMap<>();

        
    }



}
