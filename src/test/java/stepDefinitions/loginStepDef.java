package stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import core.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObject;
import utilities.UtilityClass;

public class loginStepDef extends Base {

	// each step in scenario should have
	// one java method associated with that step
	// we can't have duplicate method for steps in scenario steps
	// in order to get access to POM class methods we need to create
	// object of LoginPageObject class

	LoginPageObject loginPageObject = new LoginPageObject();

	@Given("^user is on retail website$")
	public void user_is_on_Retail_Retail_website() {
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "TEK SCHOOL";
		// Assertion is to verify actual meets that expected
		// if actual does not equals to expected value then execution will stop
		// and test step will fail
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Actual Title is matchg with expected title");
		UtilityClass.takeScreenShot();
	}

	@When("^user click on Myaccount$")
	public void user_click_onMyaccount() {
		loginPageObject.clickOnMyAccout();
		logger.info("user clicked on MyAccount");
		UtilityClass.takeScreenShot();
	}

	@And("^user click on login opiton$")
	public void user_click_on_Login_option() {
		loginPageObject.clickOnLogin();
		logger.info("user clicked on options");
	}

	// '(.+)' define String for user name and password
	@And("^user enter userName '(.+)' and password '(.+)'$")
	public void user_enter_userName_and_password(String uName, String pass) {
		loginPageObject.enterEmailAndPassword(uName, pass);
		logger.info("user Enter " + uName + " and password" + pass);
		UtilityClass.takeScreenShot();
	}

	@And("^user click on Login Button$")
	public void user_clic_login_Button() {
		loginPageObject.clickOnLoginButton();
		logger.info("user clicked on Login Button");

	}

	@Then("^user shoul be logged in to Myaccount dashboard$")
	public void user_should_be_logged_in_to_Myaccount_dashboard() {
		// if myAccountText is present it will pass
		// if myAccountText is not present or displayed it will fail
		Assert.assertTrue(loginPageObject.myAccountTextisPresent());
		logger.info("user is logged in to MyAccount Dashboard");
		UtilityClass.takeScreenShot();
	}
}
