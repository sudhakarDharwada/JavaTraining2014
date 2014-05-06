import com.vl.ThreadPool.FileOperation;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class FolderOperation {
    public static void main(String ar[])throws InterruptedException{
    	String path = ar[0];
    	boolean check = true;
    	File folder = new File(path);
        if(folder.isDirectory()){
            File[] listOfFiles = folder.listFiles();
            String[] fileNames=new String[listOfFiles.length];
            ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
            for(int i=0;i<listOfFiles.length;i++)
            {
            	if(listOfFiles[i].isFile())
            	{
            	   executorPool.execute(new FileOperation(listOfFiles[i]));
            	}
            Thread.sleep(3000);
			}
			//shut down the pool
            executorPool.shutdown();

            //TO display Account summary info.
            FileOperation.getDetails();
        } 
    }
}
