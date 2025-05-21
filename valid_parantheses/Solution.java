package valid_parantheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        Stack<Character> stackChar = new Stack<>();
        stackChar.add('.');

        char[] charStr = s.toCharArray();

        for (char k : charStr){
            switch (k) {
                case '(':
                case '{':
                case '[':
                    stackChar.add(k);
                    break;
                case ')':
                    if (stackChar.peek() == '(') stackChar.pop();
                    else stackChar.add(k);
                    break;
                case '}':
                    if (stackChar.peek() == '{') stackChar.pop();
                    else stackChar.add(k);
                    break;
                case ']':
                    if (stackChar.peek() == '[') stackChar.pop();
                    else stackChar.add(k);
                    break;
                default:
                    break;
            }
        }

        return stackChar.pop() == '.';
    }
}
