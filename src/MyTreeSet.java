public class MyTreeSet<E extends Comparable<E>> {
	TreeNode<E> root = null;

	public boolean contains(E e) {
		return contains1(e, root);
	}
	private boolean contains1(E e, TreeNode<E> current) {
		if (current == null)
			return false;
		if (e.equals(current.getElement()))
			return true;
		if (e.compareTo(current.getElement()) > 0)
			return contains1(e, current.getRight());
		else
			return contains1(e, current.getLeft());
	}

	public void add(E e) {
		if (root == null) {
			root = new TreeNode<E>(e);
			return;
		}
		TreeNode<E> current = root;
		while (true) {
			if (e.equals(current.getElement()))
				return;
			if (e.compareTo(current.getElement()) > 0)
				if (current.getRight() == null)
					current.setRight(new TreeNode<E>(e));
				else
					current = current.getRight();
			else if (current.getLeft() == null)
				current.setLeft(new TreeNode<E>(e));
			else
				current = current.getLeft();
		}
	}
}
