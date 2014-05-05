import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileData{
  public static void main(String[ ] args) throws IOException {
    
      String file_name = "Integers.java";
      ReadFile file = new ReadFile(file_name);
      file.OpenFile();
  }
} 

class ReadFile{
   private String path;
   public ReadFile(String file_path){
     path = file_path;
   }

   public void OpenFile() throws IOException{
     FileReader fr = new FileReader(path);
     BufferedReader br = new BufferedReader(fr);
   
     try{
      
       char sCurrentLetter;
       int counterDepth=0;
       boolean previousCharNewLine=false;
       boolean previousCharIsChar=false;
       int b;
    
       while ((b = br.read()) != -1) {
         sCurrentLetter=(char)b;
         char c = sCurrentLetter;

         switch(c){

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
                    
    catch ( IOException e ) {
      System.out.println( e.getMessage() );
    }
 }


 void spacing(int counterDepth) {
   for(int j=0;j<counterDepth;j++)
   System.out.print("\t");
 }
}



