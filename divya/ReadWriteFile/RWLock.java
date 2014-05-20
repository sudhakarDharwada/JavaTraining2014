
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWLock {
   public static File file = new File("/home/divya/Desktop/java/ReadWriteFile/file1.txt");
    

   public static void main(String[] args) {
      ReadWrite[] rw = new ReadWrite[];
      new ReadWrite(file,"read").start();
      new ReadWrite(file,"read").start();
      new ReadWrite(file,"write").start();
      new ReadWrite(file,"read").start();
      new ReadWrite(file,"read").start();
   }
}


class ReadWrite extends Thread{
         
 int no_of_reads = 0;
   boolean no_of_writes = false;
	File file;
	String operation;

	public ReadWrite(File file,String operation) {
          this.file = file;
	  this.operation = operation;
        }

	public void run(){
          System.out.println(Thread.currentThread().getName() +" started");
          try{
            if(operation.equals("read"))
	      readOperation();
	    else
	      writeOperation();
	  }
          catch (InterruptedException e){
            e.printStackTrace();
	  }
          catch (FileNotFoundException e){
            e.printStackTrace();
	  }
          catch (IOException e){
            e.printStackTrace();
	  }
       }
       public void readOperation() throws InterruptedException, IOException{
          synchronized (this) {
            
	   BufferedReader br = new BufferedReader(new FileReader(file));
           String line;
            if(no_of_writes == false){
	       no_of_reads++;
               while((line=br.readLine())!=null)
	        System.out.println("reading" + Thread.currentThread().getName() );
                readRelease();
            }
            else{
              System.out.println("waiting"+ Thread.currentThread().getName());
	      wait();
	    }
          }
       }

       public  void readRelease(){
          no_of_reads--;
	  if(no_of_reads == 0){
            System.out.println("notifyAll" +Thread.currentThread().getName());
	    notifyAll();
	  }
       }
     
       public  void writeOperation() throws InterruptedException, IOException{
          BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
          synchronized (this) {
	    if(no_of_reads == 0 && no_of_writes == false){
              no_of_writes=true;
	      System.out.println("writing");
	      bw.write("hi");
	      bw.flush();
              writeRelease();
	    }
            else{
              System.out.println("waiting "+Thread.currentThread().getName());
	      wait();
	    }
	  }
       }

       public void writeRelease(){
          no_of_writes=false;
	  if(no_of_writes == false){
	    System.out.println("notifyAll" +Thread.currentThread().getName());
	    notifyAll();
	  }
       }
}
