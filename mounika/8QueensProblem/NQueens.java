package solution;


import java.util.Scanner;

public class NQueens {
	static int solution = 0;

	public static void main(String args[]) {
		System.out.println("How  many queens? ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] Matrix = new int[n];
		placeQueenOnBoard(0, Matrix);
	}

	private static void placeQueenOnBoard(int Qi, int[] Matrix) {
		int n = Matrix.length;
		if (Qi == n) {
			solution++;
			System.out.print(solution + "   ");
			for (int q = 0; q < 8; q++)
				System.out.print("(" + q + "," + Matrix[q] + ")");
			System.out.println();
			for (int i = 0; i < Matrix.length; i++) {

				for (int j = 0; j < Matrix.length; j++) {

					if (Matrix[j] == i)
						System.out.print("Q* ");

					else
						System.out.print("_ ");
				}
				System.out.println("\n");
			}

			// System.out.println("/n");
		} else {

			for (int col = 0; col < n; col++) {
				if (isSafePlace(col, Qi, Matrix)) {
					Matrix[Qi] = col;

					placeQueenOnBoard(Qi + 1, Matrix);

				}
			}
		}
	}

	private static boolean isSafePlace(int col, int Qi, int[] Matrix) {

		for (int i = 0; i < Qi; i++) {
			if (Matrix[i] == col) {
				return false;
			}
			if (Math.abs(Matrix[i] - col) == Math.abs(i - Qi)) {
				return false;
			}
		}
		return true;
	}

}