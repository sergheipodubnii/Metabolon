package pages.saucedemopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoMainPage {
    public SauceDemoMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement LogoPage;

 public boolean LogoPageIsPresent(){

    return LogoPage.isDisplayed();
 }


}
