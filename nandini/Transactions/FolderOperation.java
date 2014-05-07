import com.vl.bank.FileOperation;

import java.io.*;
public class FolderOperation {
    public static void main(String ar[])throws InterruptedException{
    	String path = ar[0];
    	boolean check = true;
    	File folder = new File(path);
        if(folder.isDirectory()){
            File[] listOfFiles = folder.listFiles();
            String[] fileNames=new String[listOfFiles.length];
            //Threads to be create based on no.of files
            FileOperation threads[] = new FileOperation[listOfFiles.length];
            for(int i=0;i<listOfFiles.length;i++){
            	if(listOfFiles[i].isFile()){
            	    fileNames[i]=path+"\\"+listOfFiles[i].getName();
            	}
            	threads[i] = new FileOperation(listOfFiles[i]);
            	threads[i].start();
            }
            
            for(int i=0;i<listOfFiles.length;i++){
            	threads[i].join();
            }

            //TO display Account summary info.
            FileOperation.getDetails();
        }
        
    }
}
