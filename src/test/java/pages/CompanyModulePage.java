package pages;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigLoader;
import utilities.LoadProperties;
import utilities.RandomGenerator;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static utilities.LoadProperties.getValueFromPropertyFile;


public class CompanyModulePage extends PageObject {
    private static Config conf = ConfigLoader.load();
    private static final Logger log = LoggerFactory.getLogger(CompanyModulePage.class);
    private static String dataFileName = File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "testdata.properties";
    public static String name;
    public static String Name;
    public static String Address;
    public static String Zipcode;
    public static String contactnumber;
    public static String email;
    public static String contactNumber;
    public static String accContactNumber;
    public static String accEmail;
    public static String Accountownername;
    public static String Accountowneremail;
    public static String Accountownercontactnumber;
    public static String EditAccountowneremail;
    public static String EditAccountownercontactnumber;
    @FindBy(xpath = "//input[@name='userName']")
    private WebElementFacade userName;
    @FindBy(xpath = "//*[@placeholder='Filter companies']")
    private WebElementFacade searchCompany;
    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElementFacade noList;
    @FindBy(xpath = "//input[@name='password']")
    private WebElementFacade password;
    @FindBy(xpath = "//span[text()='Sign Out']")
    private WebElementFacade signoutLink;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElementFacade enterusername;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElementFacade enterpassword;
    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElementFacade signinButton;
    @FindBy(xpath = "//a[@class='btn btn-brand btn-elevate btn-icon-sm']")
    private WebElementFacade createnewcompany;
    @FindBy(xpath = "//h3[@class='kt-portlet__head-title']")
    private WebElementFacade verfyredirection;
    @FindBy(xpath = "//input[@id='name']")
    private WebElementFacade entername;
    @FindBy(xpath = "//input[@name='address']")
    private WebElementFacade enteraddress;
    @FindBy(xpath = "//input[@name='zipCode']")
    private WebElementFacade enterzipcode;
    @FindBy(xpath = "//input[@name='website']")
    private WebElementFacade enterwebsite;
    @FindBy(xpath = "//input[@name='contactNumber']")
    private WebElementFacade entercontactnumber;
    @FindBy(xpath = "//input[@name='email']")
    private WebElementFacade enteremail;
    @FindBy(xpath = "//input[@name='accountOwnerContactNumber']")
    private WebElementFacade enterownercontactnumber;
    @FindBy(xpath = "//input[@name='accountOwnerName']")
    private WebElementFacade accountownername;
    @FindBy(xpath = "//input[@name='accountOwnerEmail']")
    private WebElementFacade accountownernemail;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitbtnofcompany;
    @FindBy(xpath = "//input[@placeholder='Type DELETE to confirm']")
    private WebElementFacade writevalueintextbox;
    private @FindBy(xpath = "//button[text()='OK']")
    WebElementFacade confirmbutton;
    private @FindBy(xpath = "//a[text()='Cancel']")
    WebElementFacade cancelbutton;
    private @FindBy(xpath = "//h3[text()=' Companies ']")
    WebElementFacade verifyredirection;
    private @FindBy(xpath = "//em[@title='Account Owner Name']")
    WebElementFacade accountownernameverify;
    private @FindBy(xpath = "(//*[text()='Account Owner Detail']/ancestor::div//a[contains(@class,'btn btn-sm btn-outline-brand btn-elevate btn-icon')])[2]")
    WebElementFacade editaccountownerdetails;
    private @FindBy(xpath = "(//span[text()='Inactive'])[1]")
    WebElementFacade comanyprofileinactive;
    private @FindBy(xpath = "(//span[text()='Active'])[1]")
    WebElementFacade comanyprofilenactive;
    @FindBy(xpath = "//select[@name='status']")
    private WebElementFacade selectStatus;
    @FindBy(xpath = "//div[contains(@class,'kt-notification__item-content')]")
    private WebElementFacade notificationContent;
    @FindBy(xpath = "//*[text()='Account Owner Detail']/ancestor::div//a[contains(@class,'-o')]")
    private WebElementFacade editbuttonforclientpersonel;


    private By deleteCompany(String companyname) {
        return By.xpath("//*[text()='" + companyname + "']/ancestor::tr//em[@title='Delete']");
    }

    private By editCompany(String companynameedit) {
        return By.xpath("//*[contains(text(),'" + companynameedit + "')]/ancestor::tr//em[@title='Edit']");
    }

    private By getEditCompany(String editCompany) {
        return By.xpath("//span[text()='" + editCompany + "']");
    }

    private By getEditOwner(String editOwner) {
        return By.xpath("(//a[@class='" + editOwner + "'])[2]");
    }

    private By getEditAccountOwnerDetails(String verifydetails) {
        return By.xpath("//*[text()='" + verifydetails + "']");
    }

    private By getActivateOrDeactivateTheCompany(String verifycompanystatus) {
        return By.xpath("//*[text()='" + verifycompanystatus + "']/ancestor::tr//em[@title= 'Deactivate']");
    }

    private By getDeactivateTheCompany(String verifycompanystatus) {
        return By.xpath("//*[text()='" + verifycompanystatus + "']/ancestor::tr//em[@title= 'Activate']");
    }

    private By userClicksOnTheCompany(String clicksoncompany) {
        return By.xpath("//*[text()='" + clicksoncompany + "']");
    }

    public void enterCredentialsForAdministrator(String username, String password) {
        try {
            enterusername.sendKeys(username);
            enterpassword.sendKeys(password);
            waitFor(signinButton).click();
        } catch (Exception ignored) {

        }
    }

    public void crateNewCompany() {
        waitFor(createnewcompany).click();
    }

    public void verifyRedirection() {
        assertTrue(verfyredirection.waitUntilVisible().isDisplayed());
    }

    public void addDetailsForCreatingNewCompany(DataTable dataTable) throws IOException, ConfigurationException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        name = data.get(0).get("Name") + RandomGenerator.randomAlphanumeric(3);
        LoadProperties.saveValueInPropertiesFile("name", name, "testData");
        email = data.get(0).get("Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
        contactNumber = data.get(0).get("Contact Number") + RandomGenerator.randomInteger(2);
        accContactNumber = data.get(0).get("Account Owner Contact Number") + RandomGenerator.randomInteger(2);
        accEmail = data.get(0).get("Account Owner Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
        Zipcode = data.get(0).get("Zip Code") + RandomGenerator.randomEmailAddress(2);
        Accountownername = data.get(0).get("Account Owner Name") + RandomGenerator.randomAlphabetic(2);
        entername.sendKeys(name);
        enteraddress.sendKeys(data.get(0).get("Address"));
        entercontactnumber.sendKeys(contactNumber);
        enteremail.sendKeys(email);
        enterzipcode.sendKeys(Zipcode);
        accountownername.sendKeys(Accountownername);
        accountownernemail.sendKeys(accEmail);
        enterownercontactnumber.sendKeys(accContactNumber);
    }

    public void userClicksOnSubmitButton() {
        waitFor(submitbtnofcompany).click();

    }

    public void userDeleteTheCompany() {
        String companyname = getValueFromPropertyFile("testData", "name");
        element(deleteCompany(companyname)).waitUntilVisible().click();
    }

    public void userCliksOnOkButtonForDeletingTheCompany() {
        writevalueintextbox.sendKeys("DELETE");
        confirmbutton.click();
        waitABit(3000);
    }

    public void userclicksOnTheEditButton() {
        String companyedit = getValueFromPropertyFile("testData", "name");
        element(editCompany(companyedit)).waitUntilVisible().click();
    }

    public void userEditTheCompanyDetails() {
        waitFor(entername).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().clear();
        waitFor(entername).waitUntilVisible().sendKeys(name);
    }

    public void enterInvalidValueInTheFields(String Name, String Address, String Zipcode, String contactnumber, String email, String Accountownername, String Accountowneremail, String Accountownercontactnumber) {
        entername.sendKeys(Name);
        enteraddress.sendKeys(Address);
        enterzipcode.sendKeys(Zipcode);
        entercontactnumber.sendKeys(contactnumber);
        enteremail.sendKeys(email);
        accountownername.sendKeys(Accountownername);
        accountownernemail.sendKeys(Accountowneremail);
        enterownercontactnumber.sendKeys(Accountownercontactnumber);
    }

    public void checkValidationsOnAddCompany(DataTable validation) {
        List<Map<String, String>> data = validation.asMaps(String.class, String.class);
        Name = data.get(0).get("name");
        Address = data.get(0).get("address");
        Zipcode = data.get(0).get("zipCode");
        contactnumber = data.get(0).get("contactNumber");
        email = data.get(0).get("email");
        Accountownername = data.get(0).get("accountOwnerName");
        Accountowneremail = data.get(0).get("accountOwnerEmail");
        Accountownercontactnumber = data.get(0).get("accountOwnerContactNumber");
        enterInvalidValueInTheFields(Name, Address, Zipcode, contactnumber, email, Accountownername, Accountowneremail, Accountownercontactnumber);
    }

    public void userCliksOnCancelButtonOfAddCompanyPage() {
        cancelbutton.click();

    }

    public void verifyTheRedirection() {
        assertTrue(verifyredirection.waitUntilVisible().isDisplayed());

    }

    public void dataVerify() {
        String comName = element(getEditCompany(name)).getText();
        assertEquals(comName, name);
    }

    public void userCliksOnTheEditButtonForAccountOwnerDetails() {
        waitABit(3000);
        waitFor(editaccountownerdetails).click();
    }

    public void userEditTheOwnerDetails(DataTable editownerdetails) {
        EditAccountowneremail = editownerdetails.asMaps(String.class, String.class).get(0).get("Account Owner Email") + RandomGenerator.randomEmailAddress(2) + "@mailinator.com";
        EditAccountownercontactnumber = editownerdetails.asMaps(String.class, String.class).get(0).get("Account Owner Contact Number") + RandomGenerator.randomInteger(3);
        waitFor(accountownername).waitUntilVisible().clear();
        waitFor(accountownername).waitUntilVisible().sendKeys(Accountownername);
        waitABit(2000);
        waitFor(accountownernemail).waitUntilVisible().clear();
        waitFor(accountownernemail).waitUntilVisible().sendKeys(EditAccountowneremail);
        waitFor(enterownercontactnumber).waitUntilVisible().clear();
        waitFor(enterownercontactnumber).waitUntilVisible().sendKeys(EditAccountownercontactnumber);

    }

    public void verifyTheDetailsOfTheEditCompany() {
        String companydetails = getValueFromPropertyFile("testData", "name");
        element(getEditAccountOwnerDetails(companydetails)).waitUntilVisible().click();
    }

    public void crossVeriyTheOwnerDetails() {
        element(verifyCompany(Accountownername)).waitUntilVisible();
        element(verifyCompany(Accountownername)).isDisplayed();
        element(verifyCompany(EditAccountownercontactnumber)).waitUntilVisible();
        element(verifyCompany(EditAccountownercontactnumber)).isDisplayed();
        element(verifyCompany(EditAccountownercontactnumber)).waitUntilVisible();
        element(verifyCompany(EditAccountowneremail)).isDisplayed();
    }

    public void userCheckTheCompanyStatus() {
        if (comanyprofilenactive.isVisible()) {
            String companystatus = getValueFromPropertyFile("testData", "name");
            element(getActivateOrDeactivateTheCompany(companystatus)).waitUntilVisible().click();
        }

    }

    public WebElement searchText() {
        return waitFor(searchCompany);
    }

    public void noData() {
        element(noList).waitUntilVisible().isDisplayed();
    }

    public void verifyCompanyOnList() {
        String comOnList = getValueFromPropertyFile("testData", "name");
        String ListCompany = $("//span[contains(text(),'tester')]").getText();
        Assert.assertEquals(comOnList, ListCompany);

    }

    public void verifyCompanyProfileStatusActive() {
        if (comanyprofileinactive.isVisible()) {
            String companyactivestatusstatus = getValueFromPropertyFile("testData", "name");
            element(getDeactivateTheCompany(companyactivestatusstatus)).waitUntilVisible().click();
        }
    }

    public void VerifyTheActiveStatus() {
        waitFor(selectStatus).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select active = new Select(selectStatus);
        active.selectByVisibleText("Active");
    }

    public void verifyAllTheActiveStatusVisibleToTheuser() {
        List<WebElement> count = getDriver().findElements(By.xpath("//span[@class='badge badge-success']"));
        int Size = count.size();
        for (int i = 0; i < Size; i++) {
            System.out.println(count.get(i).getText());

        }
    }

    public void VerifyTheInActiveStatus() {
        waitFor(selectStatus).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select active = new Select(selectStatus);
        active.selectByVisibleText("Inactive");
    }

    public void verifyAllTheInActiveStatusVisibleToTheuser() {
        List<WebElement> inactive = getDriver().findElements(By.xpath("//span[@class='badge badge-danger']"));
        int Size = inactive.size();
        for (int i = 0; i < Size; i++) {
            System.out.println(inactive.get(i).getText());
        }
    }

    public void navigationPage() {
        String value = getValueFromPropertyFile("testData", "Total_Link");
        int inum = Integer.parseInt(value);
        for (int i = 1; i <= inum; i++) {
            String currentLink = getValueFromPropertyFile("testData", "Link_" + i);
            $(" //*[contains(text(),'" + currentLink + "')]/ancestor::h4").click();
            String currentHeader = getValueFromPropertyFile("testData", "head_" + i);
            String header = $("//*[@class='row' or @class='kt-portlet__head-title' or @class='kt-subheader__breadcrumbs-link']/..//*[contains(text(),'" + currentHeader + "')]").getText();
            Assert.assertEquals(currentHeader, header);
            getDriver().navigate().back();
        }
    }
    public void userVerifyTheCompanyDetails() {
        element(verifyCompany(name)).waitUntilVisible();
        element(verifyCompany(name)).isDisplayed();
        element(verifyCompany(email)).waitUntilVisible();
        element(verifyCompany(email)).isDisplayed();
        element(verifyCompany(contactNumber)).waitUntilVisible();
        element(verifyCompany(contactNumber)).isDisplayed();
        element(verifyCompany(accContactNumber)).waitUntilVisible();
        element(verifyCompany(accContactNumber)).isDisplayed();
        element(verifyCompany(accEmail)).waitUntilVisible();
        element(verifyCompany(accEmail)).isDisplayed();
        element(verifyCompany(Zipcode)).waitUntilVisible();
        element(verifyCompany(Zipcode)).isDisplayed();
        element(verifyCompany(Accountownername)).waitUntilVisible();
        element(verifyCompany(Accountownername)).isDisplayed();

    }

    private By verifyCompany(String nameCompany) {
        return By.xpath("//*[contains(@class,'col-md-12 detail-form ng-star-inserted')]//div//*[contains(text(),'" + nameCompany + "')]");
    }

    public void verifyAddCompanyNotification() {
        String addCompanyNotification = name + " was created by an admin. Tap to view details.";
        Assert.assertEquals(addCompanyNotification, notificationContent.getText());
    }

    public void verifyDeactivatedCompanyNotification() {
        String deactivateCompanyNotification = name + " has been deactivated.";
        Assert.assertEquals(deactivateCompanyNotification, notificationContent.getText());
    }

    public void verifyDeleteCompanyNotification() {
        String deleteCompanyNotification = name + " has been deleted.";
        Assert.assertEquals(deleteCompanyNotification, notificationContent.getText());
    }

    public void checkEditButtonForClientPersoneel() {
        if (editbuttonforclientpersonel.isDisplayed()) {
            editbuttonforclientpersonel.click();
        }
    }

    public void checkEditButtonForClientAdmin() {
            editbuttonforclientpersonel.click();
        }
    }




































