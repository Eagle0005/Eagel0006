
package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;

	private String propertyPath = ".\\src\\test\\resources\\input\\property.properties";
	private String log4JPath = ".\\src\\test\\resources\\input\\log4j.properties";

	/**
	 * We create a constructor here t initialize the variable values from properties
	 * file
	 * 
	 */

	public Base() {

		try {
			// we create BufferedReader class object to read values of properties file
			// by byte, character or entire line of value
			BufferedReader reader = new BufferedReader(new FileReader(propertyPath));
			properties = new Properties(); // we create object of properties class
			properties.load(reader); // we are using .load method of properties to load the properties file value
			reader.close(); // will read the property file
			reader.close(); // will close property file---
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PropertyConfigurator.configure(log4JPath);

	}

	/**
	 * This method should return the url value from properties file
	 * 
	 * @return
	 */
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;

	}

	/**
	 * this method shold return value of browser we define in our properties file
	 * 
	 * @return browser
	 */
	public static String getBrowser() {

		String browser = properties.getProperty("brwoser");
		return browser;
	}

	/**
	 * this method will open browser and send url from properties file
	 * 
	 */

	public void openBrowser() {

		driver.get(getUrl());

	}

	/**
	 * This method will close all opened browsers once it is called
	 */

	public static void tearDown() {
		driver.close();
		driver.quit();

	}

	/**
	 * This method will run cross browser, means we can change value of browser in
	 * properties file and it will run test cases on specified browser
	 */
	public static void browser() {
		String browserName = getBrowser();
		switch (browserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		// browser properties methods---
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies(); // this method will delete all stored
		// cookies of browser

	}

}
