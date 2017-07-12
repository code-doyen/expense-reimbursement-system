package com.revature.day5.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutStreamExample {

	public static void main(String args []) {
		try {
			//readBytes();
			writeBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readBytes() throws FileNotFoundException, IOException    {
		FileInputStream f1 = new FileInputStream("C:\\temp\\7112017.txt");
		
		while (f1.read() != -1){
			System.out.print((char)f1.read());
		}
		f1.close();
	}

	static void writeBytes() throws FileNotFoundException, IOException {
		FileOutputStream f2 = new FileOutputStream("C:\\temp\\7112017.txt");
		
		for (int i=65; i<1000; i++){
			f2.write(i);
		}
		f2.close();
	}
}
