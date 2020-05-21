package deskera.web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
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
}
