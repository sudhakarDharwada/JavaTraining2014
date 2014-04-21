package com.eightqueen.test.programs;

public class Equeen {
	static int Matrix[] = new int[8];
	static int sno = 0;
        /*This method find the Solution N Queens(8 Queens)*/
	public void EqueenFinder() {
		System.out.println("the solutions are");
		for (int row = 0; row >= 0;) {
			while ((Matrix[row] < 8) && (!isSafeToPalce(row))) {
				Matrix[row]++;
			}
			if (Matrix[row] > 7) {
				Matrix[row] = 0;
				row--;
				if (row < 0) {
					System.out.println("\n\nThank Q");
				} else {
					Matrix[row] = Matrix[row] + 1;
				}

			} else {
				if (row == 7) {
					out();
					Matrix[row]++;
				} else {
					row++;
					Matrix[row] = 0;
				}
			}
		}

	}
        /*This Method checks whether at required position the element is insert or not*/
	public boolean isSafeToPalce(int req_position) {
		boolean safe = true;
		for (int curr_row = 0; curr_row < req_position; curr_row++) {
			if (Matrix[curr_row] == Matrix[req_position]
					|| ((Math.abs(Matrix[curr_row] - Matrix[req_position])) == (Math.abs(curr_row
							- req_position)))) {
				safe = false;
				return safe;
			}
		}
		return safe;
	}
        /*This method print the all solution*/
	public void out() {
		sno++;
		System.out.print("\n " + sno + ": ");
		for (int row = 0; row < 8; row++) {
			System.out.print("(" + row + "," + Matrix[row] + ")");
		}
	}
        /*main method*/
	public static void main(String[] args) {
		Equeen eq = new Equeen();
		eq.EqueenFinder();
	}

}

