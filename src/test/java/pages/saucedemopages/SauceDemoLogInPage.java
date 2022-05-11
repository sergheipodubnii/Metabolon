package pages.saucedemopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogInPage {
public SauceDemoLogInPage(WebDriver driver){
    PageFactory.initElements(driver,this);
}
    @FindBy(id="user-name")
    private WebElement username;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(id="login-button")
    private WebElement LoginButton;
    @FindBy(tagName = "h3")
    private WebElement FailedMessage;

    public void LogIn(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void ClickLogInButton(){
        LoginButton.click();
    }

   public String FailedActualMessage(){
       System.out.println("Actual Message is :"+FailedMessage.getText().trim());
        return FailedMessage.getText().trim();
   }

}
