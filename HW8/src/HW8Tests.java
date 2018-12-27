import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HW8Tests {
	private BinaryTreeNode<Integer> bt;
	private BinaryTreeNode<Integer> bt1;
	private BinaryTreeNode<Integer> bt2;
	private BinaryTreeNode<Integer> bt3;
	private BinaryTreeNode<Integer> bt4;
	private BinaryTreeNode<Integer> bt5;
	private BinaryTreeNode<Integer> bt6;
	private BinaryTreeNode<Integer> n1;
	private BinaryTreeNode<Integer> n2;
	private BinaryTreeNode<Integer> n3;




	@Before
	public void setUp() throws Exception {
		bt= new BinaryTreeNode<Integer>(0);
		bt1= new BinaryTreeNode<Integer>(1);
		bt2= new BinaryTreeNode<Integer>(2);
		bt3= new BinaryTreeNode<Integer>(3);
		bt4= new BinaryTreeNode<Integer>(4);
		bt5= new BinaryTreeNode<Integer>(5);
		bt6= new BinaryTreeNode<Integer>(6);
		bt.setLeft(bt1);
		bt.setRight(bt2);
		bt1.setLeft(bt3);
		bt2.setLeft(bt4);
		bt4.setLeft(bt5);
		bt5.setRight(bt6);
		n1= new BinaryTreeNode<Integer>(1);
		n2= new BinaryTreeNode<Integer>(2);
		n3= new BinaryTreeNode<Integer>(3);

	}

	@Test
	public void testHeight() {
		assertEquals(bt.height(), 5);
	}
	@Test
	public void testHeightWhenRoot() {
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(0);
		assertEquals(root.height(), 1);
	}
	@Test
	public void testEqualsWhenEqual() {
		BinaryTreeNode<Integer> ct= new BinaryTreeNode<Integer>(0);
		BinaryTreeNode<Integer> ct1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> ct2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> ct3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> ct4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> ct5= new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> ct6= new BinaryTreeNode<Integer>(6);
		ct.setLeft(ct1);
		ct.setRight(ct2);
		ct1.setLeft(ct3);
		ct2.setLeft(ct4);
		ct4.setLeft(ct5);
		ct5.setRight(ct6);
		assertTrue(bt.equals(ct));
	}
	@Test
	public void testEqualsWhenUnequal() {
		BinaryTreeNode<Integer> nonequ= new BinaryTreeNode<Integer>(0);
		assertFalse(bt.equals(nonequ));
	}
	@Test
	public void testDeepCopywithOne(){
		BinaryTreeNode<Integer> original= new BinaryTreeNode<Integer>(0);
		BinaryTreeNode<Integer> copy= original.deepCopy();
		assertTrue(copy.equals(original));

	}
	@Test
	public void testDeepCopywithMulti(){
		BinaryTreeNode<Integer> copy= bt.deepCopy();
		assertTrue(bt.equals(copy));
	}
	@Test
	public void testFullwhenheight2(){
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1, n2,n3);
		assertTrue(n1.full());
	}
	@Test
	public void testFullWhenHeight1(){
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		assertTrue(n1.full());
	}
	@Test
	public void testFullwhenheight3(){

		BinaryTreeNode<Integer> n4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5= new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n6= new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> n7= new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n4, n5);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3, n6, n7);
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1, n2,n3);
		assertTrue(n1.full());
	}
	@Test
	public void testFullWhenNot(){
		BinaryTreeNode<Integer> n4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n4, null);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1, n2,n3);
		assertFalse(n1.full());
	}
	@Test
	public void testMirrorwith3() {
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1,  n2, n3);
		n1.mirror();
		assertEquals(n1.inOrder(), "(3)(1)(2)");
	}
	@Test
	public void testMirrorwith5() {
		BinaryTreeNode<Integer> n8= new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n5= new BinaryTreeNode<Integer>(5,  n1, n8);                                                           
		BinaryTreeNode<Integer> n7= new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n6= new BinaryTreeNode<Integer>(6,  n5, n7);
		n6.mirror();
		assertEquals(n6.inOrder(), "(7)(6)(8)(5)(1)");
		
	}
	@Test
	public void testInOrder1() {
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n10= new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2, n1, n3);
		BinaryTreeNode<Integer> n5= new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n7= new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n9= new BinaryTreeNode<Integer>(9,null, n10);
		BinaryTreeNode<Integer> n4= new BinaryTreeNode<Integer>(4, n2, n5);
		BinaryTreeNode<Integer> n8= new BinaryTreeNode<Integer>(8, n7, n9);
		BinaryTreeNode<Integer> n6= new BinaryTreeNode<Integer>(6, n4, n8);
		assertTrue(n6.inOrder().equals("(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)"));
	}
	@Test
	public void testInOrderBase() {
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		assertEquals(n1.inOrder(), "(1)");
	}
	@Test
	public void testEqualsTree1() {
		BinaryTree bintree1= new BinaryTree();
		BinaryTree bintree2= new BinaryTree();
		bintree1.setRoot(bt);
		BinaryTreeNode<Integer> ct= new BinaryTreeNode<Integer>(0);
		BinaryTreeNode<Integer> ct1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> ct2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> ct3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> ct4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> ct5= new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> ct6= new BinaryTreeNode<Integer>(6);
		ct.setLeft(ct1);
		ct.setRight(ct2);
		ct1.setLeft(ct3);
		ct2.setLeft(ct4);
		ct4.setLeft(ct5);
		ct5.setRight(ct6);
		bintree2.setRoot(ct);
		assertTrue(bintree1.equals(bintree2));	
	}
	@Test
	public void testEqualsTreeWhenOneRoot() {
		BinaryTree root1= new BinaryTree();
		BinaryTree root2= new BinaryTree();
		BinaryTreeNode<Integer> ct1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> ct2= new BinaryTreeNode<Integer>(1);
		root1.setRoot(ct1);
		root2.setRoot(ct2);
		root1.equals(root2);
	}
	@Test
	public void testdeepCopyTree1() {
		BinaryTreeNode<Integer> btn3= new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> btn2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> btn1= new BinaryTreeNode<Integer>(1, btn2, btn3);
		BinaryTree binary= new BinaryTree(n1);
		BinaryTree binary1= new BinaryTree(btn1);

		n1.setLeft(n2);
		n1.setRight(n3);
		assertTrue(binary.deepCopy().equals(binary1));

		
	}@Test
	public void testdeepCopyTree2() {
		BinaryTree oneroot= new BinaryTree(n1);
		BinaryTreeNode<Integer> btn1= new BinaryTreeNode<Integer>(1);
		BinaryTree comparing= new BinaryTree(btn1);
		BinaryTree cop= oneroot.deepCopy();
		assertTrue(cop.equals(comparing));

	}@Test
	public void testSizeTree1() {
		BinaryTree binary= new BinaryTree(n1);
		n1.setLeft(n2);
		n1.setRight(n3);
		assertEquals(binary.size(), 3);

	}@Test
	public void testSizeTree2() {
		BinaryTree binary= new BinaryTree(n1);
		
		assertEquals(binary.size(), 1);
	}@Test
	public void testFull1() {
		BinaryTree binary=new BinaryTree(n1);
		assertTrue(binary.full());
	}@Test
	public void testFull2() {
		BinaryTree binary=new BinaryTree(n1);
		n1.setLeft(n2);
		assertFalse(binary.full());
	}@Test
	public void testMirror1() {
		BinaryTree binary= new BinaryTree(n1);
		n1.setLeft(n2);
		BinaryTree binary2= new BinaryTree(n1);
		n1.setRight(n2);
		binary.mirror();
		assertTrue(binary.equals(binary2));
	}@Test
	public void testMirro2() {
		BinaryTree binary= new BinaryTree(n1);
		n1.setLeft(n2);
		n1.setRight(n3);

		binary.mirror();
		assertEquals(binary.inOrder(), "(3)(1)(2)");
	}
	@Test
	public void testInOrderTree1() {
		BinaryTree binary= new BinaryTree(n1);
		n1.setLeft(n2);
		n1.setRight(n3);
		assertEquals(binary.inOrder(), "(2)(1)(3)");
	}@Test
	public void testInOrderTree2() {
		BinaryTree binary= new BinaryTree(n1);
		assertEquals(binary.inOrder(), "(1)");
	}
	@Test
	public void testCombineLeft() {
		BinaryTree calling= new BinaryTree();
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3, n2, n1);
		
		BinaryTreeNode<Integer> n4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5= new BinaryTreeNode<Integer>(5,null,  n4);
		BinaryTree pass= new BinaryTree(n5);
		calling.setRoot(n3);
		BinaryTreeNode<Integer> newnode= new BinaryTreeNode<Integer>(10);
		BinaryTree combined=calling.combine(newnode, pass, true);
		assertEquals(combined.inOrder(), "(2)(3)(1)(10)(5)(4)");
	}
	@Test
	public void testCombineRight() {
		BinaryTree calling= new BinaryTree();
		BinaryTreeNode<Integer> n1= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> n2= new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> n3= new BinaryTreeNode<Integer>(3, n2, n1);
		
		BinaryTreeNode<Integer> n4= new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> n5= new BinaryTreeNode<Integer>(5,null,  n4);
		BinaryTree pass= new BinaryTree(n5);
		calling.setRoot(n3);
		BinaryTreeNode<Integer> newnode= new BinaryTreeNode<Integer>(10);
		BinaryTree combined=calling.combine(newnode, pass, false);
		assertEquals(combined.inOrder(), "(5)(4)(10)(2)(3)(1)");
	}
	
	
	
	
}
