import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter; 
import java.io.*;

public class FileReadWrite{
	public static void main(String[] args) {
		ReadandWrite rw=new ReadandWrite("read");
		ReadandWrite rw1=new ReadandWrite("write");
		ReadandWrite rw2=new ReadandWrite("read");
		ReadandWrite rw3=new ReadandWrite("write");
		ReadandWrite rw4=new ReadandWrite("write");
		ReadandWrite rw5=new ReadandWrite("read");
		Thread t1=new Thread(rw);
		Thread t2=new Thread(rw1);
		Thread t3=new Thread(rw2);
		Thread t4=new Thread(rw3);
		Thread t5=new Thread(rw4);
		Thread t6=new Thread(rw5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}
		
}
class ReadandWrite implements Runnable
{
	String mode="write";
	static int no_of_read_operations;
	static boolean write_operation=false;
	File file=new File("/home/vnandini/Desktop/java/ThreadMethods/info.txt");
	ReadandWrite(String mode)
	{
		this.mode=mode;
	}
	public void run(){
		try{
			if(mode.equals("read"))
			{
				readData(file);
			}
			else
			{			
				writeData(file);
			}
		}
		catch(Exception e)
		{
		}
	}
	public void getRelease(File file1){
			file1.notifyAll();
	}
	public void writeData(File f1){
		if(no_of_read_operations==0 && write_operation==false){
		synchronized(this){	
			try{
				if(!file.exists()){
					file.createNewFile();
				}
				FileWriter writer=new FileWriter(file);
				System.out.println(Thread.currentThread().getName()+" started Writing----------------------------------");
				writer.write("welcome to Threads............\nThis is an example for\nSynchronisation\nWait and Notify methods are available in this class");
				writer.flush();
				writer.close();
			}
			catch(IOException e){                            
			}
		}
	}
	System.out.println(Thread.currentThread().getName()+" Writing completed------------------------------------");
	getRelease(f1);
	}
	public void readData(File f1){
		BufferedReader br=null;
		if(write_operation==false){
		try{
			String currentline;
			br=new BufferedReader(new FileReader(file));
			System.out.println(Thread.currentThread().getName()+" started Reading-----------------------------------");
			while((currentline= br.readLine())!=null){
				System.out.println(currentline);
			}
			wait();
			}
			catch(IOException e){	
			}
			catch(InterruptedException e){
			}
			finally 
			{
				try 
				{
					if (br != null)br.close();
					System.out.println(Thread.currentThread().getName()+" Reading completed----------------------------------");
				}
				catch (IOException ex) 
				{
				}
			}
		}
		getRelease(f1);
	}	
}
