import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    public MinStack() {
        this.m_stack = new Stack<>();
    }

    public void push(int val) {
        int min;
        if (this.m_stack.isEmpty() || this.m_stack.peek().min > val) {
            min = val;
        } else {
            min = this.m_stack.peek().min;
        }
        this.m_stack.push(new Node(val, min));
    }

    public void pop() {
        this.m_stack.pop();
    }

    public int top() {
        return this.m_stack.peek().val;
    }

    public int getMin() {
        return this.m_stack.peek().min;
    }

    private Stack<Node> m_stack;
    private class Node {
        int val;
        int min;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
