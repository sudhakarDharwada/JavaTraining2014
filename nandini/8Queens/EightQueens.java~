

public class EightQueens {
    
    // queens for returning the solutions
    static int queens[] = new int[8];

    // track the no. of solutions
    static int count;
    static int rows;

    /** If it returns TRUE, it place a value in that position,
        If it returns FALSE, Move to next position
    */
    public static boolean canPlaceQueens(int row,int cols) {

        for(int i=0;i<row;i++) {
            //check the down validation
            if(queens[i] == cols) {
                return false;
            }
            //check the left diagonal validation
            if((i-row) == (queens[i]-cols)) {
                return false;
            }
            //check the right diagonal validation
            if((i-row) == (cols-queens[i])) {
                return false;
            }
        }
	//System.out.println("hai");
        return true;

    }
 
    // Print the Array of Queen positions
    public static void printQueens(int queens[]) {
        for(int i=0;i<8;i++) {
            System.out.print(queens[i]+" ");
        }
        System.out.println();
    }

    // Used Backtracking technique to place the queens in appr. position
    public static void placeQueens(int rows) {
        
        for(int cols=0;cols<8;cols++) {
            if(canPlaceQueens(rows,cols)) {
                queens[rows] = cols;
                if(rows == 7) {
                    printQueens(queens);
                    count++;
                }  
                else { 
                    placeQueens(rows+1);
                }
            }
        }
        
    }

    public static void main(String args[]) {
        placeQueens(rows);  
        System.out.print("The no. of solutions for 8 Queens Problem:"+count);      
    }
}
