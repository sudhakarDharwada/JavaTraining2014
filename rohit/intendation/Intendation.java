package fileios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Intendation 
{
	public void indent(String path)
	{
		try
		{
			InputStream inputFile = new FileInputStream(path);
			int size =inputFile.available();
	    	char data=' ';
	    	int countdepth=0;
	    	boolean nlbeforeopenbrace=false;
	    	boolean spaceafternl=false;
	    	boolean spaceafterob=false;
	    	boolean nlbeforeclosebrace=false;
	    	for(int i=0; i<size; i++)
	    	{
	    		data=(char)inputFile.read();
	    		if(data=='{')
	    		{
	    			spaceafterob=true;
	    			if(nlbeforeopenbrace)
	    			{
	    				for(int j=0;j<countdepth;j++)
		    				System.out.print("  ");
		    			System.out.print(data);
	    			}
	    			else
	    			{
	    				System.out.print('\n');
	    				for(int j=0;j<countdepth;j++)
	    					System.out.print("  ");
	    				System.out.print(data);
	    			}
	    			countdepth+=3;
	    		}
	    		else if(data=='\n')
	    		{
	    			nlbeforeopenbrace=true;
	    			nlbeforeclosebrace=true;
	    			spaceafternl=true;
	    			spaceafterob=false;
	    			System.out.print(data);
	    		}
	    		else if(data=='}')
	    		{
	    			countdepth=countdepth-3;
	    			if(nlbeforeclosebrace)
	    			{
	    				for(int j=0;j<countdepth;j++)
	    					System.out.print("  ");
		    			System.out.print(data);
	    			}
	    			else
	    			{
	    				System.out.print('\n');
	    				for(int j=0;j<countdepth;j++)
	    					System.out.print("  ");
	    				System.out.print(data);
	    			}
	    		}
	    		else if(data==' ')
	    		{
	    			if(!spaceafternl&&spaceafterob)
	    				System.out.print(data);
	    		}
	    		else if(data=='\t')
	    		{
	    			if(!spaceafternl&&spaceafterob)
	    				System.out.print(data);
	    		}
	    		else
	    		{
	    			if(spaceafterob)
	    			{
	    				System.out.println();
	    				for(int j=0;j<countdepth;j++)
		    				System.out.print("  ");
	    			}
	    			else if(spaceafternl)
	    			{
	    				for(int j=0;j<countdepth;j++)
		    				System.out.print("  ");
	    			}
	    			nlbeforeopenbrace=false;
	    			spaceafternl=false;
	    			nlbeforeclosebrace=false;
	    			spaceafterob=false;
	    			System.out.print(data);
	    		}
	    	}
	    	inputFile.close();
	    }
	    catch(IOException e)
	    {
	    	System.out.print("Exception");
	    }
	}
}
