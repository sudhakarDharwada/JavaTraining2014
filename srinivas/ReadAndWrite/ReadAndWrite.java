package readAndWritefinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite extends Thread{

	
	int ch;
	
	FileReader fr;
	FileWriter fw;
		
	public BufferedReader br;
	public BufferedWriter bw;

	@Override
	public void run(){

		System.out.println(Thread.currentThread().getName() +"***** started");

		try {
			reading();
			writing();

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public   void reading() throws InterruptedException, IOException{

		fr = new FileReader(MainClass.file);
		br = new BufferedReader(fr);
		synchronized (this) {


			if(MainClass.writers == 0){


				MainClass.readers++;
				while((ch = br.read()) != -1){

					System.out.print((char)ch);
				}

				System.out.println(" ");
				System.out.println("reading..." + MainClass.readers + " reading");

				readRelease();

			}else{
				System.out.println("waiting for reading by ..."+ Thread.currentThread().getName());
				wait();
			}

		}

	}

	public  void readRelease(){

		MainClass.readers--;
		if(MainClass.readers == 0){
		
			System.out.println("notifyAll by readRelease" +Thread.currentThread().getName());
			notifyAll();
		}
		
	}

	public  void writing() throws InterruptedException, IOException{

		bw = new BufferedWriter(new FileWriter(MainClass.file, true));

		synchronized (this) {
			if(MainClass.readers == 0 && MainClass.writers == 0){

				MainClass.writers++;
				System.out.println("writing...");
				bw.write(" .");
				bw.flush();

				writeRelease();
			}else{

				System.out.println("waiting for write by ... "+Thread.currentThread().getName());
				wait();
			}
		}
	}

	public void writeRelease(){

		MainClass.writers--;
		if(MainClass.writers == 0)
		{
			System.out.println("notifyAll by writeRelease" +Thread.currentThread().getName());
			notifyAll();
		}
	}
}