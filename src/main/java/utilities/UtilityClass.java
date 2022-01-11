package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.Base;

public class UtilityClass extends Base {

	// in this class we write our reusable methods
	// any methods we will use more than once we will store them here in static
	// methods

	// this method returns date and time as string
	public static String screenShotName() {

		Date date = new Date();
		String ScreenShot = date.toString();
		// this method date.to String will take or use calendar of computer and return
		// it as string--
		date.toString();
		return ScreenShot;
	}

	public static void takeScreenShot() {

		String location = System.getProperty("user.dir") + "\\output\\screenshots";
		String screenShotFileName = screenShotName() + ".png";
		// take a screenshot and store it in a file
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// we use try catch block to copy the screenshot that captured by above line--
		// and will be placed to below location
		try {

			FileUtils.copyFile(file, new File(location + screenShotFileName));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("excepton in execution");

		}

	}

//	this method will select the value from static Dropdown
	public static void selectByVisibleText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

//	this method will select value from static Dropdown by index   
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

//	this method will select value from static Dropdown by value 
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

//	this method will select value from static Dropdown by value 
	public static void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public static void switchToWindow() {

		Set<String> WindowsHandles = driver.getWindowHandles();
		Iterator<String> it = WindowsHandles.iterator();

		String window = it.next();
		driver.switchTo().window(window);

	}

//	This method will clear the text using Keys.Control method
	public static void clearTextUsingSendKeys(WebElement ele) {

		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
	}

// This method will clear the value form input text field
	public static void clearText(WebElement ele) {

		ele.clear();

	}

//This method will scroll page down using JS Executor interface
	public static void scrollPageDownWithJS() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click;", element);
	}

	public static boolean isElementDisplayed(WebElement element) {

		if (element.isDisplayed())

			return true;
		else
			return false;

	}

}
