/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author LC
 *创建时间：2019年8月2日 上午10:21:28
 *遍历二叉树
 */
public class ErgodicTree {
	public static void main(String[] args) {
		BinaryTreeNode node10=new BinaryTreeNode(10,null,null);
		BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
		BinaryTreeNode node9=new BinaryTreeNode(9,null,node10);
		BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
		BinaryTreeNode node5=new BinaryTreeNode(5,node8,node9);
		BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
		BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
		BinaryTreeNode node3=new BinaryTreeNode(3,node6,node7);
		BinaryTreeNode node2=new BinaryTreeNode(2,node4,node5);
		BinaryTreeNode node1=new BinaryTreeNode(1,node2,node3);
		ErgodicTree tree=new ErgodicTree();
		tree.preOrder(node1);
		System.out.println();
		tree.preOrderNonRecursive(node1);
		System.out.println();
		tree.inOrder(node1);
		System.out.println();
		tree.behindOrder(node1);
	}
	 //前序遍历递归的方式
    public void preOrder(BinaryTreeNode root){
        if(null!=root){
            System.out.print(+root.getData()+"\t");
            preOrder(root.getLeftTree());
            preOrder(root.getRightTree());
        }
    }
  //前序遍历非递归的方式
    public void preOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                System.out.print(root.getData()+"\t");
                stack.push(root);
                root=root.getLeftTree();
            }
            if(stack.isEmpty()) break;
            root=stack.pop();
            root=root.getRightTree();
        }
    }
    public void inOrder( BinaryTreeNode root ) {
    	if( root != null ) {
    		inOrder(root.getLeftTree());
    		System.out.print(root.getData()+"\t");
    		inOrder(root.getRightTree());
    	}
    }
    public void behindOrder( BinaryTreeNode root ) {
    	if( root != null ) {
    		behindOrder(root.getLeftTree());    		
    		behindOrder(root.getRightTree());
    		System.out.print(root.getData()+"\t");
    	}
    }
}
