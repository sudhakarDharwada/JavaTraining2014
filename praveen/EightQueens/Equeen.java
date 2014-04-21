package com.eightqueen.test.programs;

public class Equeen {
	static int Matrix[] = new int[8];

	public static boolean yCondition(boolean ycon) {
		return ycon;
	}

	public static void main(String[] args) {
		boolean ycon = false;
		int i;
		for (i = 0; i < 8;) {
			int count = 0;
			for (int j = 0; j < 8; j++) {
				if (yCondition(ycon)) {
					j = Matrix[i];
				}
				if (CheckCondition(Matrix, i, j)) {
					count++;
					break;
				}
				ycon = false;
			}
			if (count == 0) {
				Matrix[i] = 0;
				i = i - 1;
				if (Matrix[i] >= 7) {
					Matrix[i] = 0;
					i = i - 1;
					Matrix[i] = Matrix[i] + 1;
					ycon = true;
				} else {
					Matrix[i] = Matrix[i] + 1;
					ycon = true;
				}
			} else {
				ycon = false;
				i++;
			}

		}

	}

	public static boolean CheckCondition(int matix[], int x, int y) {
		boolean result = false;
		int count = 0;
		for (int i = x; i >= 0; i--) {

			if (isSafeToPalce(i, matix[i], x, y)) {

				count++;
			} else {
			}
		}
		if (x == 0) {
			if (count == (x + 1)) {
				Matrix[x] = y;
				result = true;
			}
		} else {
			if (count == 7) {

				Matrix[x] = y;
				out();
				System.exit(0);
				result = true;
			} else if (count == (x)) {
				Matrix[x] = y;
				result = true;
			}
		}
		return result;
	}

	public static boolean isSafeToPalce(int x1, int y1, int x2, int y2) {
		boolean safe = false;
		if ((x1 == 0) && (x2 == 0) && (y1 == 0) && (y2 == 0)) {
			safe = true;
		} else if (y1 == y2) {
			safe = false;
		} else if (Math.abs((y2 - y1)) == Math.abs((x2 - x1))) {
			safe = false;
		} else if (x1 == x2) {
			safe = false;
		} else {
			safe = true;
		}
		return safe;
	}

	public static void out() {
		System.out.println("The places are");
		for (int i = 0; i < 8; i++) {
			System.out.print("(" + i + "," + Matrix[i] + ")\n");
		}
	}


}

