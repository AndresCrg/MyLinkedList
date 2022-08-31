package models;

import exceptions.NodeNotFoundException;

public class MyLinkedList {
	
	private Node head;
	
	
	public Node createNode(String data) {
		return new Node(data);
	}
	
	public void addNode(Node nNode) {
		if (head != null) {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(nNode);
		}else {
			head = nNode;
		}
	}
	
	public void deleteNode(String data) throws NodeNotFoundException {
		if (head.getData().equalsIgnoreCase(data)) {
			head = head.getNext();
		}else {
			Node previous = searchPrevious(data);
            Node next = previous.getNext().getNext();
            previous.setNext(next);
		}
	}
	
	private Node searchPrevious(String data) throws NodeNotFoundException {
        Node actual = head;
        while (actual != null){
            if (actual.getNext() != null && actual.getNext().getData().equals(data)){
                return actual;
            }
            actual = actual.getNext();
        }
        throw new NodeNotFoundException();
    }
	
	public Node search(String data) throws NodeNotFoundException{
		Node current = head;
		while(current != null) {
			if (current.getData().equalsIgnoreCase(data)) {
				return current;
			}
			current = current.getNext();
		}
		throw new NodeNotFoundException();
	}
	
	public int findIdentical(String data) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.getData().equalsIgnoreCase(data)) {
				count++;
			}
			current = current.getNext();
		}
		return count;
	}
	
	public int countElements() {
        int count = 0;
        Node actual = head;
        while (actual != null){
            actual = actual.getNext();
            count++;
        }
        return count;
    }

    public boolean contains(String data){
        try {
            search(data);
            return true;
        } catch (NodeNotFoundException e) {
            return false;
        }
    }

    public void print(){
        System.out.println("-----------LISTA-----------");
        Node actual = head;
        while (actual != null){
            System.out.println(actual);
            actual = actual.getNext();
        }
        System.out.println("----------------------------");
    }


	public Node getHead() {
		return head;
	}
}