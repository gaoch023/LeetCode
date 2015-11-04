package binarytree;

import java.util.Stack;

/**
 * Created by Gaochao on 2015/9/17.
 * JAVA实现二叉树的先序、中序、后序、层序遍历
 * 递归和非递归版本
 */
public class BinaryTreeTraversal {

    /**
     *
     * @param root
     */
    public static void preOrderBinaryTreeREC(BinaryTree root){

        if (root!=null){
            System.out.print(root.data+" ");
            preOrderBinaryTreeREC(root.left);
            preOrderBinaryTreeREC(root.right);
        }

    }
    public static void midOrderBinaryTreeREC(BinaryTree root){
        if (root!=null){
            midOrderBinaryTreeREC(root.left);
            System.out.print(root.data + " ");
            midOrderBinaryTreeREC(root.right);
        }
    }
    public static void latOrderBinaryTreeREC(BinaryTree root){
        if (root!=null){
            latOrderBinaryTreeREC(root.left);
            latOrderBinaryTreeREC(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void preOrderBinaryTree(BinaryTree root){

        Stack<BinaryTree> treeStack = new Stack<BinaryTree>();
        while (root!=null||!treeStack.empty()){
            while (root!=null){
                System.out.print(root.data+" ");
                treeStack.push(root);
                root=root.left;
            }
            root=treeStack.pop();
            root=root.right;
        }

        System.out.println();
    }
    public static void midOrderBinaryTree(BinaryTree root){
        Stack<BinaryTree> treeStack = new Stack<BinaryTree>();
        while (root!=null||!treeStack.empty()){
            while (root!=null){
                treeStack.push(root);
                root=root.left;
            }
            root=treeStack.pop();
            System.out.print(root.data+" ");
            root=root.right;
        }

        System.out.println();
    }
    public static void latOrderBinaryTree(BinaryTree root){
        Stack<BinaryTree> treeStack = new Stack<BinaryTree>();
        Stack<BinaryTree> stack=new Stack<BinaryTree>();
        while (root!=null||!treeStack.empty()){
            while (root!=null){
                stack.push(root);
                treeStack.push(root);
                root=root.right;
            }
            root=treeStack.pop();
            root=root.left;
        }
        while (!stack.empty()){
            System.out.print(stack.pop().data+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(2);
        BinaryTree Node1 = new BinaryTree(4);
        BinaryTree Node2 = new BinaryTree(5);
        root.left=Node1;
        root.right=Node2;
        BinaryTree N3=new BinaryTree(1);
        BinaryTree N4=new BinaryTree(7);
        Node1.left=N3;
        Node1.right=N4;
        BinaryTree N5=new BinaryTree(9);
        Node2.left=N5;
        BinaryTree N6=new BinaryTree(12);
        N5.right=N6;

        BinaryTree N7=new BinaryTree(20);
        BinaryTree N8=new BinaryTree(8);
        N6.left=N7;
        N6.right=N8;
        System.out.println("递归结果");
        preOrderBinaryTreeREC(root);
        System.out.println();
        midOrderBinaryTreeREC(root);
        System.out.println();
        latOrderBinaryTreeREC(root);

        System.out.println("\n-----------------\n");
        preOrderBinaryTree(root);
        midOrderBinaryTree(root);
        latOrderBinaryTree(root);
    }

}

class BinaryTree{
    int data;
    BinaryTree left;
    BinaryTree right;
    public BinaryTree(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}