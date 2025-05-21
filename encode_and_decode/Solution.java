package encode_and_decode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String encode(List<String> strs) {

        if (strs.size() == 0) return null;

        StringBuilder k = new StringBuilder();
        strs.stream().forEach(e ->{
            k.append(e.length());
            k.append('#');
            k.append(e);
        });

        return k.toString();
    }

    public List<String> decode(String str) {

        if (str == null) return new LinkedList<>();

        List<String> answer = new LinkedList<>();
        int pointer = 0;

        while (pointer < str.length()) {
            int len = 0;
            while ( str.charAt(pointer) != '#' ){
                len = 10 * len +  ( Character.valueOf(str.charAt(pointer)) - Character.valueOf('0') );
                pointer++;
            }
            pointer++; // moving after '#'
            String nextStr = str.substring(pointer, pointer + len);
            System.out.println(nextStr);
            answer.add(nextStr);
            pointer = pointer + len;
        }

        return answer;
    }

    // public static void main(String[] args){

    //     Solution k = new Solution();

    //     List<String> problem1 = new LinkedList<>(Arrays.asList("meki", "wanda", "wawan"));
    //     String j = k.encode(problem1); System.out.println(j);
    //     List<String> decoder = k.decode(j); System.out.println(decoder);

    // }
}
