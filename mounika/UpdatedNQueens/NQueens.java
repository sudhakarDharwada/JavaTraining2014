package solution;

import java.util.Scanner;

public class NQueens {
	static int solution = 0;
	static int n;

	public static void main(String args[]) {
		System.out.println("How  many queens? ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] matrix = new int[n];
		placeQueenOnBoard(0, matrix);
	}

	private static void printQueens(int[] matrix1) {
		// System.out.println("hi");
		for (int q = 0; q < n; q++)
			System.out.print("(" + q + "," + matrix1[q] + ")");
		System.out.println();
		for (int i = 0; i < matrix1.length; i++) {

			for (int j = 0; j < matrix1.length; j++) {

				if (matrix1[j] == i)
					System.out.print("Q* ");

				else
					System.out.print("_ ");
			}
			System.out.println("\n");
		}

		// System.out.println("/n");

	}

	private static void placeQueenOnBoard(int Qi, int[] matrix) {
		int n = matrix.length;
		if (Qi == n) {
			solution++;
			System.out.print(solution + "   ");
			printQueens(matrix);

		} else {

			for (int col = 0; col < n; col++) {
				if (isSafePlace(col, Qi, matrix)) {
					matrix[Qi] = col;

					placeQueenOnBoard(Qi + 1, matrix);

				}
			}
		}
	}

	private static boolean isSafePlace(int col, int Qi, int[] matrix) {

		for (int i = 0; i < Qi; i++) {
			if (matrix[i] == col) {
				return false;
			}
			if (Math.abs(matrix[i] - col) == Math.abs(i - Qi)) {
				return false;
			}
		}
		return true;
	}

}