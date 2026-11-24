import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree {
    private Node root;
    private int size;

    public boolean insert(int key){
        if (root == null){
            root = new Node(key);
            size = 1;
            return true;
        }
        Node cur = root;
        while (true){
            if (key == cur.key){
                return false; //avoids inserting duplicates into tree
            }
            if (key < cur.key){
                if (cur.left == null){
                    cur.left = new Node(key);
                    size ++;
                    return true; //returns true when key is added
                }
                cur = cur.left;
            } else {
                if (cur.right == null){
                    cur.right = new Node(key);
                    size ++;
                    return true;
                }
                cur = cur.right;
            }
        }
    }

    public FindResult find (int key){ //returns whether the node was found and how many nodes were visited during find
        Node cur = root;
        int visited = 0; //differs from typical find method as it counts the number of nodes visited
        while (cur != null){
            visited ++;
            if (key == cur.key){
                return new FindResult(true, visited);
            }
            cur = (key < cur.key) ? cur.left : cur.right; //if key<cur.key then cur=cur.left, else cur=cur.right
        }
        return new FindResult(false, visited);
    }

    public int height(){
        if (root == null){
            return 0;
        }
        int h = 0; //height measured in number of nodes rather than number of links/edges
        Deque<Node> level = new ArrayDeque<>();
        level.add(root);
        while (!level.isEmpty()){
            h++;
            for (int i = level.size(); i > 0; i--){
                Node n = level.poll();
                if (n.left != null){
                    level.add(n.left);
                }
                if (n.right != null){
                    level.add(n.right);
                }
            }
        }
        return h;
    }

    public int getSize(){
        return size;
    }
}
