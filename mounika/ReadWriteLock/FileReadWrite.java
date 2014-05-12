package WaitAndNotify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite implements Runnable {

	static Lock1 lf = new Lock1();

	public static void write() throws InterruptedException, IOException {
		try {
			lf.get_write_lock();
			String content = "Hello";
			BufferedWriter bw = new BufferedWriter(new FileWriter("people.txt",
					true));

			bw.append(content);
			bw.close();
		} finally {
			lf.release_write_lock();
		}

	}

	public static void readFile() throws InterruptedException, IOException {
		try {
			lf.get_read_lock();
			String line;
			BufferedReader br = new BufferedReader(new FileReader("people.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);

			}
			br.close();
		} finally {
			lf.release_read_lock();
		}
	}

	public void run() {
		try {
			readFile();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		try {
			write();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyThread1 {
	public static void main(String args[]) {
		FileReadWrite frw = new FileReadWrite();
		// for(int i=0;i<=3;i++)
		// {
		Thread t1 = new Thread(frw);
		Thread t2 = new Thread(frw);
		Thread t3 = new Thread(frw);
		Thread t4 = new Thread(frw);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// }
	}
}
