package longest_repeating_character_replacement;

import java.util.HashMap;

public class Solution {
    public int characterReplacement(String s, int k) {

        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> currentWindowList = new HashMap<>();

        //slidingWindows properties;
        int lo = -1;
        int windowsLength = 0;
        int maxLength = 0;

        for (int i = 0 ; i < charArray.length; i++){
            //increase the hi-index and windows length sliding windows by one
            windowsLength++;
            if (currentWindowList.containsKey(charArray[i])){
                    int numCurChar = currentWindowList.get(charArray[i]);
                    currentWindowList.put(charArray[i], numCurChar+1);
                }
                else{
                    currentWindowList.put(charArray[i], 1);
                }
            //set up logic if the the number of character but the majority is lessthan k
            if (windowsLength - currentWindowList.values().stream().max(Integer::compareTo).orElse(0) > k){
                //move the lower windows forward
                do{
                    lo++;
                    int numCharloWindow = currentWindowList.get(charArray[lo]); // invariant : Should be above 0
                    if (numCharloWindow > 1) currentWindowList.put(charArray[lo], numCharloWindow - 1);
                    else currentWindowList.remove(charArray[lo]);
                    windowsLength--;
                } while (windowsLength - currentWindowList.values().stream().max(Integer::compareTo).orElse(0) > k);
            }
            if (windowsLength > maxLength) maxLength = windowsLength;
        }

        return maxLength;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        String test1 = "AAABABB";
        int result = solution.characterReplacement(test1, 1);

        System.out.println("Result : " + result);

    }
}
