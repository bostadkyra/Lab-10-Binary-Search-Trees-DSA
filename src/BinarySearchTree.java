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
}
