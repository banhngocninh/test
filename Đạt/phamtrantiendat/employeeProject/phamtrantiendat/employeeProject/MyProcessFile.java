package phamtrantiendat.employeeProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.List;

public class MyProcessFile {

	public static void saveData(List<Employee> list, String fileName) {
		try {
			FileOutputStream fOut = new FileOutputStream(fileName);
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(list);
			oOut.close();
			fOut.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Object openData(String fileName) {
		try {
			FileInputStream fIn = new FileInputStream(fileName);
			ObjectInputStream oIn = new ObjectInputStream(fIn);
			return oIn.readObject();
			
			
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}