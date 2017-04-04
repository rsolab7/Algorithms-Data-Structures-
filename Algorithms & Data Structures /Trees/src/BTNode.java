/**
 * Created by Roberto on 11/2/16.
 */
public class BTNode<T> {
    private T data;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T data){
        this.data = data;
        left = null;
        right = null;
    }

    public BTNode(T data, BTNode l, BTNode r){
        this.data = data;
        left = l;
        right = r;
    }

    public void setLeft(BTNode l ){
        left =l;
    }
    public void setRight(BTNode r ){
        right =r;
    }

    public boolean isLeaf(){
        if (left == null && right == null){
            return true;
        }else return false;
    }

    public BTNode getLeft(){
        return left;
    }

    public BTNode getRight(){
        return right;
    }

    public T getData(){
        return data;
    }

    public T getLeftMost(){
        if (left == null)
            return data;
        else
            return left.getLeftMost();
    }

    public T getRightMost(){
        if (right == null)
            return data;
        else
            return right.getRightMost();
    }

//LAST
}
