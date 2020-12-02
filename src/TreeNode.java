public class TreeNode<E> {
	private E e;
	private TreeNode<E> left, right;

	public TreeNode(E val, TreeNode<E> left,
			TreeNode<E> right) {
		this.e = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(E val) {
		this(val, null, null);
	}

	public E getElement() { return e; }
	public TreeNode<E> getLeft() { return left; }
	public TreeNode<E> getRight() {	return right; }

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}
}
