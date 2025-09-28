import java.util.*;

class Solution {
    List<Integer> preorderResult = new ArrayList<>();
    List<Integer> postorderResult = new ArrayList<>();
    
    class Node {
        int num, x, y;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = this.right = null;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> graph = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            graph.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(graph, (a, b) -> {
            return (a.y == b.y) ? a.x - b.x : b.y - a.y;
        });
        
        for(int i = 1; i < graph.size(); i++) {
            graphInsert(graph.get(0), graph.get(i));
        }
        
        preorder(graph.get(0));
        postorder(graph.get(0));
        
        int[] preorderArr = preorderResult.stream().mapToInt(i -> i).toArray();
        int[] postorderArr = postorderResult.stream().mapToInt(i -> i).toArray();
        return new int[][]{preorderArr, postorderArr};
    }
    
    void graphInsert(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else graphInsert(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else graphInsert(parent.right, child);
        }
    }
    
    void preorder(Node node) {
        if(node == null) return;
        
        preorderResult.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if(node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorderResult.add(node.num);
    }
}