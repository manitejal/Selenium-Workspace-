package Mavenpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertieDemo {

	public static void main(String[] args) throws IOException {
		

		Properties pro = new Properties();
		// create a new property file

		FileInputStream fis = new FileInputStream("data.properties");
		pro.load(fis);
		System.out.println(pro.getProperty("Url"));
		System.out.println(pro.getProperty("email"));
		System.out.println(pro.getProperty("password"));
		
		
		//updating or storing the data in data.properties file (it was fail and updating it to pass
		pro.setProperty("result", "Pass");
		FileOutputStream fip =new FileOutputStream("data.properties");
		pro.store(fip, null);
	

	}

}
