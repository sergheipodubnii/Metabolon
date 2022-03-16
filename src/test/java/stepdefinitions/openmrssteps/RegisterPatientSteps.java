package stepdefinitions.openmrssteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.openmrspages.OpenMRSLoginPage;
import pages.openmrspages.OpenMRSMainPage;
import pages.openmrspages.OpenMRSRegisterPage;
import utils.DriverHelper;

import java.util.Map;

public class RegisterPatientSteps {
    WebDriver driver= DriverHelper.getDriver();
    OpenMRSLoginPage openMRSLoginPage=new OpenMRSLoginPage(driver);
    OpenMRSMainPage openMRSMainPage=new OpenMRSMainPage(driver);
    OpenMRSRegisterPage openMRSRegisterPage =new OpenMRSRegisterPage(driver);
    @Given("the user logs in to OpenMRS with following credentials")
    public void the_user_logs_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
     //you should know that : dataTable will come as a parameter when you provide data table in
        //the feature file.And delete the first part of the Datatable and import it.
        Map<String,String> usernamePassworMap=dataTable.asMap();
        //username=admin
        //password=Admin123
//        String name=usernamePassworMap.get("username");
//        String password=usernamePassworMap.get("password");
//        System.out.println(name);//admin
//        System.out.println(password);//Admin123
        openMRSLoginPage.login(usernamePassworMap.get("username"),usernamePassworMap.get("password"));

    }
    @When("the user registers a new patient with following information:")
    public void the_user_registers_a_new_patient_with_following_information(DataTable dataTable) throws InterruptedException {

        Map<String,String> patientInfoMap=dataTable.asMap();

        openMRSMainPage.clickRegisterPatientButton();
        openMRSRegisterPage.sendName(patientInfoMap.get("GivenName"),patientInfoMap.get("FamilyName"));
        openMRSRegisterPage.sendGender(patientInfoMap.get("Gender"));
        openMRSRegisterPage.sendBirthDate(patientInfoMap.get("Day"),patientInfoMap.get("Month"),patientInfoMap.get("Year"));
        openMRSRegisterPage.sendAddress(patientInfoMap.get("Address"));
        openMRSRegisterPage.sendphoneNumber(patientInfoMap.get("PhoneNumber"));
        openMRSRegisterPage.sendRelativeInfo(patientInfoMap.get("RelationType"),patientInfoMap.get("RelativeName"));
        openMRSRegisterPage.clickConfirmButton();
    }
    @Then("the user validates the patient name and familyName")
    public void the_user_validates_the_patient_name_and_family_name(DataTable dataTable) {
       Map<String,String> validateNames=dataTable.asMap();
        Assert.assertEquals(validateNames.get("GivenName"),openMRSRegisterPage.getGivenName());
        Assert.assertEquals(validateNames.get("FamilyName"),openMRSRegisterPage.getFamilyName());
    }
}
