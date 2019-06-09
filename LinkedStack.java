
//In Class Lab - Queens 8 Problem

//Group Members - In class lab - 3/19/2019
//Feuler Tovar, feuler@bu.edu
//Kelly Duan, tsuru67@gmail.com
//Monika Nanda, monikan@bu.edu


public class LinkedStack implements MyStack {

	private Node head = null;
	private int count = 0;

	public LinkedStack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean push(int r, int c) {
		Cord data = new Cord();
		data.setColumn(c);
		data.setRow(r);
		// TODO Auto-generated method stub
		Node n = new Node();
		n.setData(data);
		n.setNext(head);
		
		head = n;
		count++;
				
		return true;
	}

	@Override
	public Cord pop() {
		// TODO Auto-generated method stub

		if (isEmpty()) {
			return null;
		} else {
			Cord tmp = head.getData();
			head = head.getNext();
			count--;
		  return tmp;
		}
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public Node top() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		} else {
			Node n = head; //using Interger constructor class was deprecated for some reason here
			return n;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		count = 0;
	}
	
	public String toString() {
		if (isEmpty()) {

			return "<Empty>";
		}
		String rtn = "";
		Node tmp = head;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				rtn += "top -> " + "("+ tmp.getData().getRow()+ "," + tmp.getData().getColumn()+ ")"+ "\n";

			} else {
				rtn +=  "("+ tmp.getData().getRow()+ "," + tmp.getData().getColumn()+ ")" + "\n";
			}
			tmp = tmp.getNext();
		}

	return rtn;

	}

}
