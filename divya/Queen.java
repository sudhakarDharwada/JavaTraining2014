


public class Queen{

  public static int[] positions =new int[8];

  public void placeQueen(int row){
 
    if(row==8){
      System.out.println("Queens can be placed in:");
      for(int i=0;i<8;i++)
      System.out.println("("+i+","+positions[i]+")");
    }
    else{
      for(int column=0;column<8;column++){
        int x=0;
        for(int k=0;k<row;k++){
          if(issafeposition(k,positions[k],row, column))
          x++;
        }
        if(x==row){
          positions[row]=column;
          placeQueen(row+1);
        }
     }
   }

 }

 public boolean issafeposition(int x1,int y1,int x2,int y2){
    if(x1==x2||y1==y2||Math.abs(x2-x1)==Math.abs(y2-y1))
    return false;
    return true;
 }

 public static void main(String[] args){
   Queen q=new Queen();
   q.placeQueen(0);
 }
}
