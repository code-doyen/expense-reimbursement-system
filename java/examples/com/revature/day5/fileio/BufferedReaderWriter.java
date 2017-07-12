package com.revature.day5.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriter {
	
	public static void main(String[] args) throws IOException {
		readValues();
		//writeValues();
		//readValues();
	}
	static void readValues() throws IOException{
		BufferedReader b1 = new BufferedReader(new FileReader("C:\\temp\\7112017.txt"));
		try {
			String s1 = null;
			while ((s1 = b1.readLine()) != null){
				System.out.println(s1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			b1.close();
		}
	}
	static void writeValues() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\7112017.txt"));
		String str = "Replace all the content with my new string";
		bw.write(str);
		bw.close();
	}
}











