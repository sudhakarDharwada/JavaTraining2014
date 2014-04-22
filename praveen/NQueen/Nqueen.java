package com.eightqueen.test.programs;

import java.util.Scanner;

public class Nqueen {
        private static long startTime;
	static int Matrix[];
	static int sno = 0;
         /*This method find the Solution N Queens*/
	public void EqueenFinder(int Nq) {
		System.out.println("the solutions are");
		for (int row = 0; row >= 0;) {
			while ((Matrix[row] < Nq) && (!isSafeToPalce(row))) {
				Matrix[row]++;
			}
			if (Matrix[row] > (Nq-1)) {
				Matrix[row] = 0;
				row--;
				if (row < 0) {
					System.out.println("\n\nTotal "+sno+" solutions\n");
					long endTime = System.currentTimeMillis();
					System.out.println("It took " + (endTime - startTime) + " milliseconds");
				} else {
					Matrix[row] = Matrix[row] + 1;
				}

			} else {
				if (row == (Nq-1)) {
					out(Nq);
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
			if (Matrix[curr_row] == Matrix[req_position] || ((Math.abs(Matrix[curr_row] - Matrix[req_position])) == (Math.abs(curr_row - req_position)))) {
				safe = false;
				return safe;
			}
		}
		return safe;
	}
        /*This method print the all solution*/
	public void out(int Nq) {
		sno++;
		System.out.print("\n " + sno + ": ");
		for (int row = 0; row <Nq ; row++) {
			System.out.print("(" + row + "," + Matrix[row] + ")");
		}
	}
        /*main method*/
	public static void main(String[] args) {
		Nqueen eq = new Nqueen();
		Scanner s=new Scanner(System.in);
		System.out.print("\nEnter the Number of Queens:");
		int No_of_Queens=s.nextInt();
                startTime = System.currentTimeMillis();
		Matrix=new int[No_of_Queens];
		eq.EqueenFinder(No_of_Queens);
	}

}

