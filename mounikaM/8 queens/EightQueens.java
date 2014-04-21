class EightQueens
{
	public static int[] queen_position=new int[8];
	public static int solution=0;
    public static void main(String []args)
    {
        EightQueens pQueen=new EightQueens();
        pQueen.settingQueenPosition(0);
        System.out.println("The toatal number of solutions are "+solution);
    }
    boolean settingQueenPosition(int r)
    {
        boolean safe=false,check=false;
        int i=0,count=0,c=0;
		if(r<8)
		{
			for(c=0;c<8&&safe==false;c++)
			{   
				count=0; 
				for(i=0;i<r;i++)
				{     
					check=isSafeToPlace(i,queen_position[i],r,c);
					if(check)
						count++;
				}
				if(count==r)
				{
					queen_position[r]=c;
					safe=settingQueenPosition(r+1);
				}
			}
		}
		else
        {
			solution++;
			printQueen();
		}
		return safe;	
	}
    boolean isSafeToPlace(int x1,int y1,int x2,int y2)
    {
        if(x1==x2 || y1==y2 || Math.abs(x1-x2)==Math.abs(y1-y2))
            return false;
        return true;
    }
    void printQueen()
    {
        System.out.println("queen positions are ");
        for(int k=0;k<8;k++)
        {
            System.out.println(k+","+queen_position[k]);
        }
    }
}

