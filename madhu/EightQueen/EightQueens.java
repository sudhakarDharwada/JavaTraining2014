package org.eight.test;
public class EightQueens {

	private static int[] b = new int[8];
	private  int s = 0;

	public static boolean unsafe(int y) {
		int x = b[y];
		for (int i = 1; i <= y; i++) {
			int t = b[y - i];
			if (t == x ||
					t == x - i ||
					t == x + i) {
				return true;
			}
		}
		return false;
	}

	public  void putboard() {
		System.out.println("\n Solution " + (++s));
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x <8; x++) {
				if(b[y]==x)
					System.out.print("("+x+","+y+")");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		EightQueens eq=new EightQueens();
		int y = 0;
		b[0] = -1;
		while (y >= 0) {
			do {
				b[y]++;
			} while ((b[y] < 8) && unsafe(y));
			if (b[y] < 8) {
				if (y < 7) {
					b[++y] = -1;
				} else {
					eq.putboard();
				}
			} else {
				y--;
			}
		}
	}
}