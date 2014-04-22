package com.problem;

public class EightQ {

	static int size = 8;
	static int[] a = new int[8];
	public static int precol = -1;
	static boolean flag =false;

	private static int index = 0; 


	public static void main(String [] arg){


		code();

		finalvalues();

	}

	private static void finalvalues() {
		
		System.out.println("Places are...");

		for(int i=0;i<size;i++)
			System.out.println(i+"--->"+a[i]);

	}

	public static void code(){

		while(index<size){

			int nexval =getnexcol(precol);

			if(nexval!=-1){
				a[index++] = nexval;  
				precol = -1;  

			}else if(index>0){
				precol = a[--index];

			}

		}

	}

	private static int getnexcol(int col1) {

		int col2 = col1+1;

		for(int i=col2;i<size;i++){
			if(!succeess(i)){

				return i; 
			}
		}
		return -1;

	}


	private static boolean succeess(int i) {

		for (int ii=0; ii<index; ii++){
			if(checkingcondition(index, i, ii, a[ii])){

				return true;
			}
		}
		return false;
	}


	private static boolean checkingcondition(int row1, int col1, int row2, int col2) {

		return sameCol(col1, col2) || sameDiagonal(row1, col1, row2, col2);  
	}  

	private static boolean sameCol(int col1, int col2) {  
		return col1 == col2;  
	}  

	private static boolean sameDiagonal(int row1, int col1, int row2, int col2) {  
		return col1 - col2 == row1 - row2 || col1 - col2 == row2 - row1;  
	}  

}