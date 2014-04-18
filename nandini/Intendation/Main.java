import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	
  public static void main(String[] args) {
	  File file = null;
		if (0 < args.length) {
			file = new File(args[0]);
		}
	  Intend I1=new Intend();
	  I1.Intendation(file);
	  
	
    if (!file.exists()) {
      System.out.println(file + " does not exist.");
      return;
    }
    if (!(file.isFile() && file.canRead())) {
      System.out.println(file.getName() + " cannot be read from.");
      return;
    }
    
  }
  
}
class Intend{
	
	void Intendation(File file){
try {
    	
    	final int depthvalue=1;
    	boolean previoscharNL=false;
    	boolean previouscharIsChar=false;
    	FileInputStream fis = new FileInputStream(file);
    	char current;
    	int inDepth=0;
    	while (fis.available() > 0) {    	  
        current = (char) fis.read();
        switch(current)
        {
       
        case '{':
        	
        	inDepth+=depthvalue;
        	System.out.println(current);
        	space(inDepth);
    		previoscharNL=false;      	
        	break;
        	
        case '}':
        	System.out.print("\n");
        	inDepth-=depthvalue;
        	space(inDepth);
        	System.out.println(current);
        	break;
        case ';':
        	System.out.println(current);
        	space(inDepth);
        	//System.out.println(current);
        	break;
        	
        case '\n':
        	if(!previoscharNL)
        		previoscharNL=true;
        	break;
        	
        case '\t':
        	break;
        	
        case ' ':
        	if(previouscharIsChar){
				System.out.print(current);
				previouscharIsChar=false;	
        	}
        	break;
        default:
        	if(previoscharNL)
        	{   
        		previoscharNL=false;        		
        		System.out.print(current);
        		previouscharIsChar=true;
        	}
        	else{
        		System.out.print(current); 
        	previouscharIsChar=true;
        	}
        	
        }
        
      }
    	
      fis.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
}
void space(int inDepth)
{
	for(int j=0;j<inDepth;j++)
		System.out.print("\t");
}
	
}
	
