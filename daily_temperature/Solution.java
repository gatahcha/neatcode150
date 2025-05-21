package daily_temperature;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //we will use stack on storing the value prev value

        //In itteration condition, if we find that the current temperature is higher,
        //then we pop from the stack

        //Invariant, the stack from top to bottom, will perform increasing order

        int len = temperatures.length;
        int[] result = new int[len];
        Stack<int[]> stack = new Stack<>(); // { temp, index }

        for (int i = 0 ; i < len; i++){
            int temp = temperatures[i];
            while( !stack.empty() && temp > (int) stack.peek()[0] ) {
                int[] modify_res = stack.pop();
                result[modify_res[1]] = i - modify_res[1];
            }
            stack.push(new int[]{ temp, i });
        }

        return result;
    }
}
