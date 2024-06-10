package wk4;
public class BST {

	public BSTNode root;

	public BST() {
		root = null;
	}

	public BST(int A[]) {
		root = null;
		for (int a : A)
			insert(a);
	}

	public BSTNode search(int key) {
		BSTNode tmp = root;
		while (tmp != null) {
			if (tmp.value == key)
				return tmp;
			else if (tmp.value > key)
				tmp = tmp.left;
			else
				tmp = tmp.right;
		}
		return null;
	}

	public BSTNode insert(int key) { // complete this method
		if (size() == 0)
		{
			root = new BSTNode(key);
			return root;

		}
		BSTNode tmp = root;
		BSTNode parent = null;
		while (tmp != null)
		{
		if (tmp.value == key)
			{
			return null;
			}
		else 
			{
			parent = tmp;
			if (tmp.value < key)
				{
				tmp = tmp.right;
				}
			else
				{
				tmp = tmp.left;
				}
			}
		}
		BSTNode newNode = new BSTNode(key);
		newNode.parent = parent;
		if (parent.value > key)
			{
			parent.left = newNode;
			}
		else
			{
			parent.right = newNode;
			}
		while (parent != null)
			{
			parent.size++;
			parent = parent.parent;
			}
		return newNode;
	}

	public boolean remove(int key) { // complete this method
		BSTNode nodeToBeDeleted = search(key);
		if (nodeToBeDeleted == null)
			return false;
		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right != null)
			{
			BSTNode max = findMax(nodeToBeDeleted.left);
			nodeToBeDeleted.value = max.value;
			nodeToBeDeleted = max;
			}
		BSTNode parent = nodeToBeDeleted.parent;
		while (parent != null)
			{
			parent.size--;
			parent = parent.parent;
			}
		if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null)
			{
			removeLeaf(nodeToBeDeleted);
			}
		else
			{
			removeNodeWithOneChild(nodeToBeDeleted);
			}
		return true;
	}

	private void removeLeaf(BSTNode leaf) { // complete this method
		if (leaf.equals(root))
			{
			root = null;
			}
		else
			{
			BSTNode parent = leaf.parent;
			if (leaf != null && leaf.parent.left != null && leaf.parent.left.equals(leaf))
				{
				parent.left = null;
				}
			else
				{
				parent.right = null;
				}
			leaf.parent = null;

			}
	}

	private void removeNodeWithOneChild(BSTNode node) { // complete this method
		BSTNode child;
		if (node.left != null)
			{
			child = node.left;
			}
		else
			{
			child = node.right;
			node.right = null;
			}
		if (node.equals(root))
			{
			root = child;
			child.parent = null;
			}
		else
			{
			if (node != null && node.parent.left != null && node.parent.left.equals(node))
				{
				node.parent.left = child;
				}
				else
					{
					node.parent.right = child;
					}
			}
		child.parent = node.parent;
		node.parent = null;
	}

	private static BSTNode findMin(BSTNode node) {
		if (null == node)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static BSTNode findMax(BSTNode node) {
		if (null == node)
			return null;
		while (node.right != null)
			node = node.right;
		return node;
	}

	private static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private void print(BSTNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	public void print() {
		print(root);
	}

	public int size() {
		return (root == null) ? 0 : root.size;
	}
}
