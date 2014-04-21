import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Indentation {
	public static void main(String[] args) {
		File inFile = null;
		if (0 < args.length) {
			inFile = new File(args[0]);
			Indent i=new Indent();
			i.fileIndentation(inFile);
		}	
	}
}
class Indent { 
	public void fileIndentation(File inFile)
	{
		BufferedReader br = null;
		try {
			char sCurrentLetter;
			int counterDepth=0;
			boolean previousCharNewLine=false;
			boolean previousCharIsChar=false;
			br = new BufferedReader(new FileReader(inFile));
			int b;
			while ((b = br.read()) != -1) {
				sCurrentLetter=(char)b;
				char c = sCurrentLetter;
				switch(c)
				{
					case '{':
						counterDepth++;
						System.out.print(c);
						System.out.println("");						
						spacing(counterDepth);
						previousCharNewLine=false;					      	
						break;
					case '}':
						counterDepth--;
						spacing(counterDepth);
						System.out.print(c);
						break;
					case ' ':
						if(previousCharIsChar){
							System.out.print(c);
							previousCharIsChar=false;
						}	
						break;
					case ';':
						System.out.print(c);
						System.out.print("\n");
						spacing(counterDepth);
						break;
					case '\n':
						if(!previousCharNewLine)
							previousCharNewLine=true;
						System.out.print(c);
						break;
					case '\t':
						break;
					default: 
						if(previousCharNewLine){
							spacing(counterDepth);
						System.out.print(c);
						previousCharNewLine=false;
						previousCharIsChar=true;
					}
					else{	
						System.out.print(c);
						previousCharIsChar=true;
					}	
				}
			}	
		} 
	catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	void spacing(int counterDepth)
	{
		for(int i=0;i<counterDepth;i++)
				System.out.print("\t");
	}
}
