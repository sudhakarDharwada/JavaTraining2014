package com.inteended.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Intended {
	/*main method*/
	public static void main(String[] args) {
		Intended intended = new Intended();
		/*read the input file*/
		System.out.print("\n\nEnter The Path of File To read from it:");
		Scanner s = new Scanner(System.in);
		String ReadFilePath = s.next();
		/*read the output file path*/
		System.out.print("\n\nEnter the path of File To Write On it");
		String WriteFilePath = s.next();
		String FileData = intended.readFile(ReadFilePath);
		if (intended.WriteFile(WriteFilePath, FileData)) {
			System.out.print("\n\nTHE FILE PRINTING IS SUCCESSFULL");
		} else {
			System.out.print("\n\nTHE FILE PRINTING IS FAILED");
		}
	}
	/*This method write the indented string into the file*/
	protected boolean WriteFile(String FilePath, String Data) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(FilePath));
			output.write(Data);
			output.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;

		}
	}
	/*It reads the input from file*/
	protected String readFile(String path) {
		/*In this we can add the word in an order so that, when we print it, it would be in indented*/
		StringBuilder sb = new StringBuilder();
		BufferedReader input = null;
		try {
			String sCurrentLine;
			input = new BufferedReader(new FileReader(path));
			int Depth = 0;
			while ((sCurrentLine = input.readLine()) != null) {
				int index = 0, DepthControl = 0;
				while (index < sCurrentLine.length()) {
					if (sCurrentLine.charAt(index) == '\'') {
						while (index < sCurrentLine.length()) {
							index++;
							if (sCurrentLine.charAt(index) == '\'') {
								index = index + 1;
								break;
							}
						}
					} else if (sCurrentLine.charAt(index) == '\"') {
						while (index < sCurrentLine.length()) {
							index++;
							if (sCurrentLine.charAt(index) == '\"') {
								index = index + 1;
								break;
							}
						}
					} else {
						if ((sCurrentLine.charAt(index) == '{')) {
							if ((0 < Depth)) {
								DepthControl = 0;
								while (DepthControl < Depth) {
									DepthControl++;
									sb.append("    ");
								}
							}
							Depth = Depth + 1;
							index++;
						} else if (((sCurrentLine.charAt(index)) == '}')) {
							Depth = Depth - 1;
							if ((Depth > 0)) {

								DepthControl = 0;
								while (DepthControl < Depth) {
									DepthControl++;
									sb.append("    ");
								}
							}
							index++;
						} else if ((index == 0)) {
							DepthControl = 0;
							while (DepthControl < Depth) {
								DepthControl++;
								sb.append("    ");
							}
							index++;

						} else {
							index++;
						}
					}
				}
				sb.append(sCurrentLine);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}
}
