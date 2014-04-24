package indentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the file name ");

		File file = new File(in.next());
		if (!file.exists()) {
			System.out.println(args[0] + " does not exist.");
			return;
		}
		if (!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + " cannot be read from.");
			return;
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			char currentdata = ' ';
			int depth = 0;
			boolean isprevious = false;
			;
			while (fis.available() > 0) {
				currentdata = (char) fis.read();
				switch (currentdata) {
				case '{':
					depth += 3;
					// System.out.print('\n');

					System.out.print(currentdata);
					break;
				case '}':
					depth -= 3;
					// System.out.print('\n');

					System.out.print(currentdata);
					break;
				case ' ':
					if (!isprevious) {
						System.out.print(currentdata);
					}
					break;
				case '\n':
					isprevious = true;
					System.out.print(currentdata);
					break;

				default:
					if (isprevious) {
						for (int i = 0; i < depth; i++) {
							System.out.print(" ");
						}
					}
					isprevious = false;
					System.out.print(currentdata);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Error while reading file line by line:"
					+ e.getMessage());
		}
	}
}
