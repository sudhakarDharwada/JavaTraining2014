package readAndWritefinal;

import java.io.File;

public class MainClass {
	
	public static File file = new File("/home/valuelabs/workspace/Threads/src/readAndWritefinal/abc.txt");
	public static int readers = 0;
	public static int writers = 0;

	public static void main(String[] args) {
		
	
		
		ReadAndWrite[] rw = new ReadAndWrite[100];
		
		
		for(int i=1;i<4;i++){
			rw[i] = new ReadAndWrite();
			
			rw[i].start();
		}
		
	}

}
