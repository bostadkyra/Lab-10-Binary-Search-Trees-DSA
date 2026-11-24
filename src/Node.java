public class Node {
    final int key; //referred to as "data" in the slides
    Node left;
    Node right;

    Node(int key){
        this.key = key; //after initialization, a node's key can never be changed (marked final)
    }
}
