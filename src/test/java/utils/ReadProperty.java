package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	// ConfigReader class to read properties from .properties file

	Properties prop;

	public String getPostUrl() {

		try {
			FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\properties\\routes.properties");
			prop = new Properties();
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load the properties file or not able to find the file");
		}

		return prop.getProperty("posturl");

	}

	public String getGetUrl() {

		try {
			FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\properties\\routes.properties");
			prop = new Properties();
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load the properties file or not able to find the file");
		}

		return prop.getProperty("geturl");

	}

	public String getDeleteUrl() {

		try {
			FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\properties\\routes.properties");
			prop = new Properties();
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load the properties file or not able to find the file");
		}

		return prop.getProperty("deleteurl");

	}

	public String getPutUrl() {

		try {
			FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\properties\\routes.properties");
			prop = new Properties();
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load the properties file or not able to find the file");
		}

		return prop.getProperty("puturl");

	}
}
