
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode(){
		this(null,null,null)	;
	}

	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size(){
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
// Makes a deep copy of the tree nodes 
	public BinaryTreeNode<T> deepCopy(){
		//To do		
		BinaryTreeNode<T> deep= new BinaryTreeNode<T>();
		if(this.data!=null) {
			deep.setData(this.data);
		}
		if(this.left!=null) {
			deep.setLeft(this.getLeft().deepCopy());

		}
		if(this.right!=null) {
			deep.setRight(this.getRight().deepCopy());
		}
		return deep;
	}
// Tests to see if a node is equal to another by going through all the left elements and then right elements and then comparing the two.
	@Override
	public boolean equals(Object o){
		//To do
		if (o instanceof BinaryTreeNode) {
			BinaryTreeNode obj= (BinaryTreeNode) o;
			if(obj.height()==this.height()) {
				if(obj.getData().equals(this.data)) {
					boolean leftequals=false;
					boolean rightequals=false;
					if(this.left!=null) {
						leftequals=this.left.equals(obj.getLeft());		
					}
					else {
						leftequals=(this.left == obj.getLeft());
					}
					if(this.right!=null ) {
						rightequals=this.right.equals(obj.getRight());		
					}
					else {
						rightequals=(this.right == obj.getRight());
					}	
					return rightequals&&leftequals;
				}
			}
		}
		return false;
	}
//	Finds the height of the right tree and then the left tree and then finds the max of the two to give the higher height
	public int height(){
		//To do
		
		if(this.left==null && this.right==null) {
			return 1;
		}
		else if (this.left!=null && this.right==null) {
			return 1+this.left.height();
		}
		else if (this.left==null && this.right!=null) {
			return 1+ this.right.height();
		}
		else {
			return 1+ Math.max(this.right.height(),  this.left.height());
		}
	}
// Uses the formula that in this case the (size =2^n -1) where n is the height of the tree. 
//	And if say the height is 3, then the size will 7. If the two sizes are equal then it is full.
	public boolean full(){
		//To do
		return (Math.pow(2, this.height())-1)==this.size();
	}
// Mirrors each node through recursion and gets down to the base of the
//	tree and when the left and right null returns to the parent of the leaf and then sets its right as left and lefts as right
	public void mirror(){
		//To do
		if (this.left==null && this.right==null) {
			return;
		}
		if(this.left!=null) {
			this.left.mirror();
		}
		if(this.right!=null) {
			this.right.mirror();
		}
		BinaryTreeNode newleft= this.getRight();
		BinaryTreeNode newright= this.getLeft();
		this.setLeft(newleft);
		this.setRight(newright);


	}
// Recursively adds on a left root right traversal of a tree to an empty string
	public String inOrder(){
		//To do
		String empty="";
		if(this.left!=null) {
			empty+=this.left.inOrder();
		}
		empty+="("+this.data.toString()+")";

		if (this.right!= null) {
			empty+=this.right.inOrder();
		}
		return empty;
	}
}



