package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import models.MyLinkedList;
import models.Node;

class TestDataStructureLL {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testAdd() {
		MyLinkedList list = new MyLinkedList();
		Node node = new Node("Brayan");
		list.addNode(node);
		Assert.assertEquals(node, list.getHead());
	}
	
	@Test
	public void testAddTwoNodes() {
		MyLinkedList list = new MyLinkedList();
		Node nodeB = new Node("Brayan");
		list.addNode(nodeB);
		Node nodeA = new Node("Andres");
		list.addNode(nodeA);
		Assert.assertEquals(nodeA, list.getHead().getNext());
	}
	
	@Test
	public void testFindSimilar() {
		MyLinkedList list = new MyLinkedList();
		Node nodeB = new Node("Brayan");
		list.addNode(nodeB);
		Node nodeA = new Node("Andres");
		list.addNode(nodeA);
		Node nodeC = new Node("Andres");
		list.addNode(nodeC);
		Node nodeD = new Node("Andres");
		list.addNode(nodeD);
		Assert.assertEquals(3, list.findIdentical("Andres"));
	}
	
	@Test
	public void testFindSimilarZero() {
		MyLinkedList list = new MyLinkedList();
		Node nodeB = new Node("Brayan");
		list.addNode(nodeB);
		Node nodeA = new Node("Andres");
		list.addNode(nodeA);
		Assert.assertEquals(0, list.findIdentical("Andrea"));
	}

}
