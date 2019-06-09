
//In Class Lab - Queens 8 Problem

//Group Members - In class lab - 3/19/2019
//Feuler Tovar, feuler@bu.edu
//Kelly Duan, tsuru67@gmail.com
//Monika Nanda, monikan@bu.edu

import javafx.scene.chart.XYChart.Data;

public class DriveStack {

	public DriveStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriveStack me = new DriveStack();
		me.doIt();
	}

	public void doIt() {
		LinkedStack s = new LinkedStack();

		//put the first choice onto the stack
		s.push(1, 1);

		System.out.println(s);

		//set success to false
		boolean success = false;

		//Main while loop for algorithm
		//execute loop until success and stack is empty
		while (!success & !s.isEmpty()) {
			
			//init conflict flag
			boolean conflict = false;
			
			//no need to check for first item on stack
			if (s.size() > 1) {
				
				//check for conflict throughout the whole stack
				//if conflict found exit do while
				Node temp = s.top().getNext();
				do {
					conflict = checkConflict(s.top().getData(), temp.getData());
					temp = temp.getNext();
				} while (temp != null & !conflict);
			}

			//if conflict found handle 2 scenarios.
			//if stack is not empty and column is 8, pop the stack
			if (conflict) {
				while (!s.isEmpty() && s.top().getData().getColumn() == 8) {
					s.pop();
				}
				//if stack is not empty after popping, increase the column of the top choice by 1
				if (!s.isEmpty()) {
					s.top().getData().setColumn(s.top().getData().getColumn() + 1);

				}
			} 
			//Else If no conflict and the stack depth is 8,
			//Set success to true, and display the results
			else if (!conflict && s.size() == 8) {
				success = true;
				System.out.println(s);
				System.out.println(output(s));
			} 
			//Else push information onto the stack 
			//indicating the next choice is to place a queen at Row = current stack size + 1, Column = 1
			else {
				s.push(s.size() + 1, 1);
			}

		}//end of Main While Loop

	}

	
	//method to check for conflicts
	//Cord is Coordinate class that has int row and int column members defined.
	public boolean checkConflict(Cord q1, Cord q2) {

		//check for same Row or Same column conflict
		if (q1.getRow() == q2.getRow() || q1.getColumn() == q2.getColumn()) {
			System.out.println("Same Row, Same Column conflict");
			return true;
		//check for diagonal conflict	
		} else if (Math.abs(q1.getRow() - q2.getRow()) == Math.abs(q1.getColumn() - q2.getColumn())) {
			System.out.println("Same diagonal conflict");
			return true;
		}
		return false;
	}

	public String output(LinkedStack s2) {
		LinkedStack s = s2;
		String rtn = "";
		char[][] array = new char[8][8];
		while (!s.isEmpty()) {
			Cord c = s.pop();
			int row = c.getRow();
			int column = c.getColumn();
			array[row - 1][column - 1] = 'Q';
		}

		// row
		for (int i = 0; i < 8; i++) {
			rtn += "+---+---+---+---+---+---+---+---+\n";
			// col
			for (int j = 0; j < 8; j++) {
				rtn += "|";
				if (array[i][j] == 'Q') {
					rtn += " Q ";
				} else {
					rtn += "   ";
				}
			}
			rtn += "|\n";
		}
		rtn += "+---+---+---+---+---+---+---+---+\n";

		return rtn;
	}

}
