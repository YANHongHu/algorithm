import java.util.Stack;


public class stackToLink {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) throws Exception {
        stackToLink.push(1);
        stackToLink.push(2);
        System.out.println(stackToLink.pop());
        System.out.println(stackToLink.pop());
        stackToLink.push(3);
        System.out.println(stackToLink.pop());

    }

    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() throws Exception {
        if(stack1.empty()&&stack2.empty())
            throw new Exception("队列为空");

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
