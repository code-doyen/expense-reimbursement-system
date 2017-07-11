package com.revature.day5.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream {

	public static void main(String[] args) {
		try {
			serialization(new Employee());
			deserialization();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void serialization(Employee e) throws IOException, Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\temp\\serialization1.txt"));
		oos.writeObject(e);
		oos.close();
	}
	
	static void deserialization() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\temp\\serialization1.txt"));
		Employee emp1 = (Employee) ois.readObject();
		//Employee emp2 = (Employee) ois.readObject();
		System.out.println("ID : " + emp1.getEmployeeID() + " Name : " + emp1.getEmployeeName());
		System.out.println("SSN : " + emp1.getEmpSsn() + " Title : " + emp1.getEmpTitle());
	}

}


