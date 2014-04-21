package com.eightqueen.test.programs;

public class Equeen {
	static int Matrix[] = new int[8];
	static int sno = 0;
        
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
					System.out.println("\nThank Q");
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

	public boolean isSafeToPalce(int pos) {
		boolean safe = true;
		for (int row = 0; row < pos; row++) {
			if (Matrix[row] == Matrix[pos]
					|| ((Math.abs(Matrix[row] - Matrix[pos])) == (Math.abs(row
							- pos)))) {
				safe = false;
				return safe;
			}
		}
		return safe;
	}

	public void out() {
		sno++;
		System.out.print("\n " + sno + ": ");
		for (int row = 0; row < 8; row++) {
			System.out.print("(" + row + "," + Matrix[row] + ")");
		}
	}

	public static void main(String[] args) {
		Equeen eq = new Equeen();
		eq.EqueenFinder();
	}

}

