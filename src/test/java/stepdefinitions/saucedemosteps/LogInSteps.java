package stepdefinitions.saucedemosteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.saucedemopages.SauceDemoLogInPage;
import pages.saucedemopages.SauceDemoMainPage;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.Locale;

public class LogInSteps {
    WebDriver driver= DriverHelper.getDriver();
    SauceDemoLogInPage sauceDemoLogInPage=new SauceDemoLogInPage(driver);
    SauceDemoMainPage sauceDemoMainPage=new SauceDemoMainPage(driver);
    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {
       driver.get(ConfigReader.readProperty("saucedemourl"));
    }
    @When("I fill the account information for account StandardUser into the {string} field and the {string} field")
    public void i_fill_the_account_information_for_account_standard_user_into_the_field_and_the_field(String username, String password) {
       sauceDemoLogInPage.LogIn(username,password);
    }
    @When("I click the Login Button")
    public void i_click_the_login_button() {
       sauceDemoLogInPage.ClickLogInButton();
    }
    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() {
        Assert.assertTrue(driver.getCurrentUrl().trim().toLowerCase().contains("saucedemo"));
    }
    @Then("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {
       Assert.assertTrue(sauceDemoMainPage.LogoPageIsPresent());

    }



    @When("I fill the account information for account LockedOutUser into the {string} field and the {string} field")
    public void i_fill_the_account_information_for_account_locked_out_user_into_the_field_and_the_field(String username, String password) {
     sauceDemoLogInPage.LogIn(username,password);
    }

    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String Expected) {

       Assert.assertTrue(sauceDemoLogInPage.FailedActualMessage().contains(Expected));
    }


}
