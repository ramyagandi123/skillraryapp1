package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties
	 * @param filepah
	 */
	public void propertirdInitialization(String filepath) {
		FileInputStream fis=null;
		try {
		
			fis=new FileInputStream(filepath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
	}	
   }
	/**
	 * This method is used to fetch the data from properties file
	 * @param Key
	 * @return
	 */
	public String readFromProperties(String Key) {
		return property.getProperty(Key);
	}
}
