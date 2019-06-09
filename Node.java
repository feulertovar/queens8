
//In Class Lab - Queens 8 Problem

//Group Members - In class lab - 3/19/2019
//Feuler Tovar, feuler@bu.edu
//Kelly Duan, tsuru67@gmail.com
//Monika Nanda, monikan@bu.edu


public class Node {

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Cord getData() {
		return data;
	}
	public void setData(Cord data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	private Cord data;
	private Node next;
	
}
