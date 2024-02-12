import java.util.ArrayList;
import java.util.List;
public class Tree {
    private Node root;
    private class Node {
        public Object data;
        public List<Node> children = new ArrayList<>();

        public int getLeavesAmount() {
            if(children.isEmpty()) return 1;
            int sum = 0;
            for (Node children : children) {
                sum += children.getLeavesAmount();
            }
            return sum;
        }
        public int getMaxSiblings() {
            if(children.size() == 0) return 0;
            int max = children.size();
            for(Node child : children){
                if(child.getMaxSiblings() > max) max = child.getMaxSiblings();
            }
            return max;       
        }
    }
    public Tree(String data){
        root = new Node();
        root.data = data;
    }
    public void addSubtree(Tree tree) {
        this.root.children.add(tree.root);
    }
    public int getLeavesAmount() {
        return root.getLeavesAmount();
    }
    public int getMaxSiblings() {
        return root.getMaxSiblings();
    }

}
