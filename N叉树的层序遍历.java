import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class N叉树的层序遍历 {
    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();

        if (root != null) {
            // first node
            queue.offer(root);

            while(!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();

                // fixed size of last level node
                int count = queue.size();
                for(int i = 0; i < count; i++) {
                    // enqueue next level node
                    Node cur = queue.poll();
                    assert cur != null;
                    queue.addAll(cur.children);
                    // add current node value
                    list.add(cur.val);
                }
                // add this level value
                result.add(list);
            }
        }
        return result;
    }
}
