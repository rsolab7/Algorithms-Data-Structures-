import java.util.Scanner;

public class Main {

    public static void preorderPrint(BTNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getData()+" ");

        preorderPrint(root.getLeft());
        preorderPrint(root.getRight());

    }

    public static void postoderdePrint(BTNode root){
        if (root == null){
            return;
        }
        preorderPrint(root.getLeft());
        preorderPrint(root.getRight());
        System.out.print(root.getData()+" ");
    }

    public static void inorderPrint (BTNode root){
        if (root == null){
            return;
        }
        preorderPrint(root.getLeft());
        System.out.print(root.getData()+" ");
        preorderPrint(root.getRight());


    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);


        BSTNode<Integer> myTree = new BSTNode<Integer>(14);

        myTree.insert(14);
        myTree.insert(1);
        myTree.insert(17);
        myTree.insert(4);
        myTree.insert(3);
        myTree.insert(53);
        myTree.insert(9);
        myTree.insert(7);
        myTree.insert(19);
        myTree.insert(13);

        System.out.println("\nPre order print");
        preorderPrint(myTree.root);
        System.out.println("\nPost order print");
        postoderdePrint(myTree.root);

        System.out.print("\nThe parent of the Node 53 is "+ myTree.getParent(53));
        myTree.inOrderSuccessor(myTree.root,myTree.search(9));



    }
}
