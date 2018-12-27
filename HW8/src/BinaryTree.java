public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
// Tests to see if two trees are equal by comparing each node
	@Override
	public boolean equals(Object o) {
		//To do
		if (o instanceof BinaryTree) {
			BinaryTree b = (BinaryTree) o;
			if (this.root.equals(b.root)) {
				return true;
			}
		}
		return false;
	}
//Creates a deep copy of a tree by using the root and passing that into treenodes' deep copy method
	public BinaryTree<T> deepCopy() {
		//To do
		BinaryTree<T> copyTree= new BinaryTree<T>();
		if (this.root != null) {
			copyTree.setRoot(root.deepCopy());
		}
		return copyTree;
	}
//Combines a two trees to a new node as a root and returns that new tree
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		//To do
			BinaryTree<T> combine= new BinaryTree<T>();
			combine.setRoot(newRoot.deepCopy());
			if(left==true) {
				combine.root.setLeft(this.root);
				combine.root.setRight(t.root.deepCopy());
			}
			else {
				combine.root.setRight(this.root);
				combine.root.setLeft(t.root.deepCopy());
			}
			
		return combine;
	}
//	Finds the size of the tree
	public int size(){
		//To do
		if (root==null) {
			return 0;
		}
		return root.size();
	}
//	Finds the height of the tree if it not null if it is return 0 using the height method in tree node
	public int height(){
		//To do
		if (root==null) {
			return 0;
		}
		return root.height();
	}
//	Sees if the binary tree is node by testing to see if the node's are full using the method in tree node
	public boolean full(){
		//To do
		return root.full();
	}
//	Creates a mirror of a tree through the tree node method
	public void mirror(){
		//To do
		this.root.mirror();
	}
//	Prints out the in order traversal of the binary tree using the tree node method
	public String inOrder(){
		//To do
		return root.inOrder();
	}
}
