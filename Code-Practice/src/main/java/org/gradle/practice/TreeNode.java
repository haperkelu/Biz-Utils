/**
 * 
 */
package org.gradle.practice;

/**
 * @author pai.li
 *
 */
public class TreeNode {
	public TreeNode(int value) {
		this.value = value;
	}
	public TreeNode() {}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private int value;
	private TreeNode left;
	private TreeNode right;
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}
