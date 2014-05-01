package transactiondetails;

import java.io.IOException;

class ListOfFiles implements Runnable {
	String filename;

	public ListOfFiles(String filename) {
		this.filename = filename;
	}

	public void run() {
		try {
			Transaction.transactionDetailes(filename);

		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
