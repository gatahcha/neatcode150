package minimum_stack;
import java.util.Stack;



class MinStack {

    private Stack<int[]> stack; // = new Stack<>();

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.size() != 0) stack.push( new int[] {val,
                                                        Math.min(val, stack.peek()[1])});
        else stack.push(new int[] {val,val});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }

}