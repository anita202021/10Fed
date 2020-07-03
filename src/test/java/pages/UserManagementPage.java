package pages;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import models.DetailsModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserManagementPage extends PageObject {

    private DetailsModel detailsModel = new DetailsModel();
    String userStatus;
    private VendorManagementPage vendor;

    //String userNameStored = LoadProperties.getValueFromPropertyFile("testData", "name");
    // String surnameStored = LoadProperties.getValueFromPropertyFile("testData", "surname");

    @FindBy(xpath = "//span[text()='Users']")
    private WebElementFacade userLink;
    @FindBy(xpath = "//a[contains(text(),'New User')]")
    private WebElementFacade addUserButton;
    @FindBy(xpath = "//select")
    private WebElementFacade userRoleDropdown;
    @FindBy(xpath = "//h3[contains(text(),'Detail')]")
    private WebElementFacade detailScreenHeading;


    @FindBy(xpath = "(//select)[1]")
    private WebElementFacade roleDropdown;
    @FindBy(xpath = "(//select)[2]")
    private WebElementFacade statusDropdown;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElementFacade filterButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    private WebElementFacade searchUser;
    @FindBy(xpath = "//span[contains(@class,'badge badge')]")
    private WebElementFacade statusInList;
    @FindBy(xpath = "(//label[contains(text(),'Status')]/..//label)[2]")
    private WebElementFacade statusOnDetailScreen;
    @FindBy(xpath = "//span[contains(text(),'Activate')]")
    private WebElementFacade activateFromAction;
    @FindBy(xpath = "//span[contains(text(),'Deactivate')]")
    private WebElementFacade deactivateFromAction;
    @FindBy(xpath = "//button[contains(text(),'Choose file')]")
    private WebElementFacade chooseFile;
    @FindBy(xpath = "//button[text()='Upload']")
    private WebElementFacade uploadImageButton;
    @FindBy(xpath = "//th[text()='Action']")
    private WebElementFacade actionColumn;
    @FindBy(xpath = "//i[contains(@class,'fa fa-bell')]/../..")
    private WebElementFacade notificationIcon;
    @FindBy(xpath = "//div[contains(@class,'kt-notification__item-content')]")
    private WebElementFacade notificationContent;
    @FindBy(xpath = "//div[contains(@class,'kt-notification')]")
    private WebElementFacade notificationTable;

    @FindBy(xpath = "//div[@class='kt-widget3']")
    private WebElementFacade activityLogWidget;

    private By userFormField(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//input");
    }

    private By userDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }

    private By entityName(String entity) {
        return By.xpath(" //a[contains(text(),'" + entity + "')]");
    }


    public void tapOnAddUserButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addUserButton).click();
    }


    //Select and upload profile picture
    public void uploadProfilePicture() throws IOException {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(chooseFile).shouldBeVisible();
        String path = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testData" + File.separator + "profileIcon.png";
        getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(path);
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(uploadImageButton).click();
    }

    private void enterValueInFirstName() throws IOException, ConfigurationException {
        WebElementFacade firstField = element(userFormField("First"));
        waitABit(6000);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(firstField).waitUntilClickable().click();
        firstField.clear();
        detailsModel.setName("Madhvan" + RandomGenerator.randomAlphabetic(3));
        firstField.sendKeys(detailsModel.getName());
        LoadProperties.saveValueInPropertiesFile("name", detailsModel.getName(), "testData");
    }

    private void enterValueInSurname() throws IOException, ConfigurationException {
        WebElementFacade lastNameField = element(userFormField("Last"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(lastNameField).waitUntilVisible().click();
        lastNameField.clear();
        detailsModel.setSurname(RandomGenerator.randomAlphabetic(3));
        lastNameField.sendKeys(detailsModel.getSurname());
        LoadProperties.saveValueInPropertiesFile("surname", detailsModel.getSurname(), "testData");
    }

    private void enterValueInEmail() {
        WebElementFacade emailField = element(userFormField("Email"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(emailField).waitUntilVisible().click();
        emailField.clear();
        detailsModel.setEmail("user" + RandomGenerator.randomInteger(4) + "@mailinator.com");
        emailField.sendKeys(detailsModel.getEmail());
    }

    private void enterValueInPhone() {
        WebElementFacade phoneField = element(userFormField("Phone"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(phoneField).waitUntilVisible().click();
        phoneField.clear();
        detailsModel.setContact(RandomGenerator.randomInteger(10));
        phoneField.sendKeys(detailsModel.getContact());
    }


    public void addInputFieldsOfUserForm() throws IOException, ConfigurationException {
        enterValueInFirstName();
        enterValueInSurname();
        enterValueInEmail();
        enterValueInPhone();

    }

    public void selectRole(String roles) {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(userRoleDropdown).click();
        Select type = new Select(userRoleDropdown);
        detailsModel.setUserRole(roles);
        type.selectByVisibleText(detailsModel.getUserRole());
    }

    public void userDetailsVerify() {
        // waitForLoader();
        WebElementFacade a = element(userDetail("First"));
        Assert.assertEquals(detailsModel.getName(),
                withTimeoutOf(40, TimeUnit.SECONDS).waitFor(a).getText());
        Assert.assertEquals(detailsModel.getSurname(), element(userDetail("Last")).getText());
        Assert.assertEquals(detailsModel.getEmail(), element(userDetail("Email")).getText());
        Assert.assertEquals(detailsModel.getContact(), element(userDetail("Phone")).getText());
        Assert.assertEquals(detailsModel.getUserRole(), element(userDetail("Role")).getText());
    }

    public void selectRoleDropdown() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(roleDropdown).click();
    }

    public void selectStatusDropdown() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusDropdown).click();
    }

    private By dropdownOptions(String opt) {
        return By.xpath("//option[text()='" + opt + "']");
    }

    private By status(String opt) {
        return By.xpath("//label[contains(text(),'" + opt + "')]");
    }

    public void selectFilterDropdown(String opt) {
        WebElementFacade a = element(dropdownOptions(opt));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).click();

    }

    public void enterKeyInSearchField(String searchKey) {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchUser).click();
        searchUser.clear();
        detailsModel.setKeyword(searchKey);
        searchUser.sendKeys(detailsModel.getKeyword());
    }

    public void tapOnFilterButton() {
        waitFor(filterButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
        waitABit(5000);
    }

    private By userNameSearch(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[1]");
    }

    public void verifyUserName() {
        waitABit(5000);
        WebElementFacade firstName = element(userNameSearch(1));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(firstName).shouldBeVisible();
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            String vName = element(userNameSearch(i)).getText();
            Assert.assertTrue(vName.contains(detailsModel.getKeyword()));
        }
    }

    private By roleInTable(int count) {
        return By.xpath("(//tbody//tr[" + count + "]/td)[4]");
    }


    public void verifyUserRole(String userRoles) {
        WebElementFacade firstRole = element(roleInTable(1));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(firstRole).shouldBeVisible();
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            WebElementFacade temp = element(roleInTable(i));
            String vType = withTimeoutOf(20, TimeUnit.SECONDS).waitFor(temp).getText();
            if (userRoles.equals("Administrator")) {
                Assert.assertEquals("Administrator", vType);

            } else if (userRoles.equals("Personnel")) {
                Assert.assertEquals("Personnel", vType);
            }
        }

    }

    private By statusInTable(int count) {
        return By.xpath("(//span[contains(@class,'badge badge')])[" + count + "]");
    }


    public void verifyStatus(String userStatus) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(statusInList).shouldBeVisible();
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        for (int i = 1; i <= num; i++) {
            WebElementFacade s = element(statusInTable(i));
            String vType = withTimeoutOf(20, TimeUnit.SECONDS).waitFor(s).getText();
            if (userStatus.equals("Active")) {
                Assert.assertEquals("Active", vType);

            } else if (userStatus.equals("Inactive")) {

                Assert.assertEquals("Inactive", vType);
            }
        }

    }

    private By statusIcon(String title) {
        return By.xpath("//em[@title='" + title + "']");
    }

    public void tapOnStatusIcon(String title) {
        element(statusIcon(title)).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void changeUserStatus() {
        userStatus = withTimeoutOf(10, TimeUnit.SECONDS).waitFor(statusOnDetailScreen).getText();
        if (userStatus.equals("Inactive")) {
            withTimeoutOf(10, TimeUnit.SECONDS).waitFor(activateFromAction).click();
        } else if (userStatus.equals("Active")) {
            withTimeoutOf(10, TimeUnit.SECONDS).waitFor(deactivateFromAction).click();
        }
        waitFor(2000);
    }

    public void verifyChangedStatus() {
        waitABit(4000);

        if (userStatus.equals("Inactive")) {
            WebElementFacade status = element(status("Active"));
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).shouldBeVisible();
        } else if (userStatus.equals("Active")) {
            WebElementFacade status = element(status("Inactive"));
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(status).shouldBeVisible();
        }
    }

    public void addUserForPersonnel() {
        Assert.assertFalse(addUserButton.isVisible());

    }

    public void verifyActionFeatureForPersonnel() {
        Assert.assertFalse(actionColumn.isVisible());
    }

    public void tapOnBellIcon() {
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(notificationIcon).click();
        waitABit(1000);
    }

    //.........Activity Log..........

    public void verifyLogForAddUser() {
        String addUserLog = "New user " + detailsModel.getName() + " " + detailsModel.getSurname() + " was created";
        vendor.searchContentForActivity(addUserLog);
    }

    public void redirectionOfEntity() {
        WebElementFacade entity = element(entityName(detailsModel.getName()));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(entity).click();
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(detailScreenHeading).shouldBePresent();
    }

    public void verifyLogForEditUser() {
        String nameEditLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s name has been changed";
        vendor.searchContentForActivity(nameEditLog);
        String roleEditLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s role has been changed";
        vendor.searchContentForActivity(roleEditLog);
        String contactEditLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s contact number has been changed";
        vendor.searchContentForActivity(contactEditLog);
        String emailEditLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s email has been changed";
        vendor.searchContentForActivity(emailEditLog);
    }

    public void verifyLogForDeactivateActivateUser() {
        String deactivateLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s account has been deactivated";
        vendor.searchContentForActivity(deactivateLog);
        String activateLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s account has been activated";
        vendor.searchContentForActivity(activateLog);
    }

    public void verifyLogForDeletedUser() {
        String deletedLog = detailsModel.getName() + " " + detailsModel.getSurname() + "'s account has been deleted";
        vendor.searchContentForActivity(deletedLog);
    }

    //........Notification............

    public void verifyAddUserNotification() {
        String notification = "New user " + detailsModel.getName() + " was created. Tap to view details.";
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void VerifyDeactivateNotification() {
        String notification = detailsModel.getName() + "'s account has been deactivated.";
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void VerifyDeletedNotification() {
        waitABit(1000);
        String notification = detailsModel.getName() + "'s account has been deleted.";
        Assert.assertEquals(notification, notificationContent.getText());
    }
}