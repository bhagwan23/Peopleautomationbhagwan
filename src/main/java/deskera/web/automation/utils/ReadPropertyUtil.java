package deskera.web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadPropertyUtil {
	/**
	 * Description - : This util reads config and return particular key
	 * 
	 * @param property
	 * @param config_file
	 * @return
	 */
	public static String readProperty(String property, String config_file) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File(config_file)));
			value = prop.getProperty(property);
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty for " + property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}


	
	/**
	 * Set property to update any value dynamically
	 * @param property
	 * @param config_file
	 * @param value
	 */
	public  static void writeProperty(String property, String config_file,String value) {
		Properties prop;
		try {
			prop = new Properties();
			FileOutputStream out = new FileOutputStream(config_file);
			prop.setProperty(property,value);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
