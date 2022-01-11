package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class TestPageObject extends Base {

	public TestPageObject() {

		// to initialize the element inside this class--
		PageFactory.initElements(driver, this);

	}

	// POM and page factory provides below annotation--
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBar;

	@FindBy(xpath = "//button[@type='button' and @class= 'btn btn-defaul btn-lg']")

	private WebElement searchButton;

	@FindBy(xpath = "//img[@title='iphone']")

	private WebElement iphoneImage;

	// this is the method--
	public void enterValueforSearchBar(String value) {

		searchBar.sendKeys(value);
	}

	public void clickOnSearchButton() {

		searchButton.click();

	}

	public boolean isIphoneDisplayed() {

		if (iphoneImage.isDisplayed())
			return true;
		else
			return false;
	}
}
