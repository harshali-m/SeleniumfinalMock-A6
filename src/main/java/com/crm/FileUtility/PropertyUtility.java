package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	public static String InputData(String key) throws IOException {
        Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\selenium\\com.crm.FinalMock-A6\\src\\test\\resources\\ConfigureFile\\Property.properties");
		
		prop.load(fis);
		
		String data = prop.getProperty(key);
		return data;
		}

}
