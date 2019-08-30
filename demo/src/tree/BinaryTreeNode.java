/**
 * 
 */
package tree;

/**
 * @author LC
 *创建时间：2019年8月2日 上午10:13:49
 * 二叉树模型
 */
public class BinaryTreeNode {
	private int data;//数据
	private BinaryTreeNode leftTree;//左子树
	private BinaryTreeNode rightTree;//右子树
	public BinaryTreeNode() {
		super();
	}
	public BinaryTreeNode(int data, BinaryTreeNode leftTree, BinaryTreeNode rightTree) {
		super();
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(BinaryTreeNode leftTree) {
		this.leftTree = leftTree;
	}
	public BinaryTreeNode getRightTree() {
		return rightTree;
	}
	public void setRightTree(BinaryTreeNode rightTree) {
		this.rightTree = rightTree;
	}
	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + ", leftTree=" + leftTree + ", rightTree=" + rightTree + "]";
	}
	
}
