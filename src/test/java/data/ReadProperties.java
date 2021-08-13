package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
// load the properties file 
	public static Properties userData = loadProperties("C:\\Users\\dod\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\properties\\userdata.properties");
	
	private static Properties loadProperties(String path)   {
		Properties  pro = new Properties();
		//stream for reading the file 
		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		 catch (NullPointerException e) {
				e.printStackTrace();
			}
		return pro;
	}
}
