package evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            int a,b,result = 0;
            switch (token) {
                case "+":
                    if (stack.size() > 0) a = stack.pop(); else return Integer.MAX_VALUE;
                    if (stack.size() > 0) b = stack.pop(); else return Integer.MAX_VALUE;
                    result = a + b;
                    stack.push(result);
                    break;
                case "-":
                    if (stack.size() > 0) a = stack.pop(); else return Integer.MAX_VALUE;
                    if (stack.size() > 0) b = stack.pop(); else return Integer.MAX_VALUE;
                    result = b - a;
                    stack.push(result);
                    break;
                case "*":
                    if (stack.size() > 0) a = stack.pop(); else return Integer.MAX_VALUE;
                    if (stack.size() > 0) b = stack.pop(); else return Integer.MAX_VALUE;
                    result = a * b;
                    stack.push(result);
                    break;
                case "/":
                    if (stack.size() > 0) a = stack.pop(); else return Integer.MAX_VALUE;
                    if (stack.size() > 0) b = stack.pop(); else return Integer.MAX_VALUE;
                    result = b / a;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
