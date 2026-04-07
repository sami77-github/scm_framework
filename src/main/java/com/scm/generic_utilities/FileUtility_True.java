package com.scm.generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility_True {

	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./test_data/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
