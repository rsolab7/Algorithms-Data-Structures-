/**
 * Created by Roberto on 11/4/16.
 */
public class BSTNode<Integer> extends BTNode{
    public   BSTNode<Integer> root;
    public   BSTNode<Integer> Parent;

    public BSTNode(Object data, BTNode l, BTNode r) {
        super(data, l, r);
    }
    public BSTNode(Object data) {
        super(data);

    }
    public BSTNode<Integer> getParent(int value){
        BSTNode current = root;
        while (root != null){
            if (current == null) return null;
            if ((int)current.getData() == value){
                return current.Parent;
            }else if((int)current.getData() < value){
                current = current.getRight();
            } else
                current = current.getLeft();
        }
        return null;
    }

    public boolean search (int value){
        BTNode current = root;
        while (root != null){
            if (current == null) return false;
            if ((int)current.getData() == value){
                return true;
            }else if((int)current.getData() < value){
                current = current.getRight();
            } else
                current = current.getLeft();
        }
        return false;
    }

    public void insert (int value){
        BSTNode current = root;
        BSTNode newNode = new BSTNode(value);
        if (root == null){
            root = newNode;
            return;
        }
        BSTNode parent = null;
        while (true){
            parent = current;
            if (value < (int)current.getData()){
                current = (BSTNode) current.getLeft();
                if (current == null){
                    parent.setLeft(newNode);
                    newNode.Parent = parent;
                    return;
                }
            }else {
                current = (BSTNode) current.getRight();
                if (current == null){
                    parent.setRight(newNode);
                    newNode.Parent = parent;
                    return;
                }
            }
        }
    }

    BSTNode inOrderSuccessor(BSTNode root, BSTNode n) {

        // step 1 of the above algorithm
        if (n.getRight() != null) {
            return minValue(n.getRight());
        }

        // step 2 of the above algorithm
        BSTNode p = n.getParent();
        while (p != null && n == p.getRight()) {
            n = p;
            p = p.getParent();
        }
        return p;
    }

    /* Given a non-empty binary search tree, return the minimum data
     value found in that tree. Note that the entire tree does not need
     to be searched. */
    BSTNode minValue(BSTNode node) {
        BSTNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

}
