package pages;

import models.FacilityModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacilityManagementPage extends PageObject {

    private FacilityModel facilityModel = new FacilityModel();
    private VendorManagementPage vendor;
    List<String> selectedItems;
    String facilityName;
    //String companyIDWeb;
    @FindBy(xpath = "//a[contains(text(),'New Facility')]")
    private WebElementFacade addFacilityButton;
    @FindBy(xpath = "//label[contains(text(),'ID')]/..//div")
    private WebElementFacade companyID;
    @FindBy(xpath = "//em[@title='AccountID']/..")
    private WebElementFacade idOnCompanyScreen;

    @FindBy(xpath = "//div[@class='multiselect-dropdown']")
    private WebElementFacade selectedUserGroup;
    @FindBy(xpath = "//select[@name='complaintsAssigneeId']")
    private WebElementFacade complaintsAssignee;
    @FindBy(xpath = "//select[@name='moveOutAssigneeId']")
    private WebElementFacade moveOutAssignee;
    @FindBy(xpath = "//div[contains(@style,'display: block')]")
    private WebElementFacade loader;
    @FindBy(xpath = "(//span[@class='link'])[1]")
    private WebElementFacade firstFacility;
    @FindBy(xpath = "(//em[contains(@class,'fa-edit')])[2]")
    private WebElementFacade editSecondFacility;
    @FindBy(xpath = "//em[@title='Member Assigned']/..//span")
    private WebElementFacade assignedMemberList;
    @FindBy(xpath = "//a[text()=' New Unit ']")
    private WebElementFacade addUnitButton;
    @FindBy(xpath = "//span[@class='link']")
    private WebElementFacade companyLink;
    @FindBy(xpath = "//a[text()='Facility']")
    private WebElementFacade facilityTab;
    @FindBy(xpath = "//div[@class='col-md-12 text-right']//button[text()='Delete']")
    private WebElementFacade deleteBox;
    @FindBy(xpath = "//div[@class='modal-body']//input")
    private WebElementFacade typeDELETE;
    @FindBy(xpath = "//div[contains(@class,'kt-notification__item-content')]")
    private List<WebElementFacade> notificationList;
    @FindBy(xpath = "//div[contains(@class,'kt-notification__item-content')]")
    private WebElementFacade notificationContent;
    @FindBy(xpath = "//div[text()='Select All']")
    private WebElementFacade selectAllCheckbox;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    private WebElementFacade searchUser;


    private By facilityField(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//input");
    }

    private By facilityDetail(String detail) {
        return By.xpath("//em[contains(@title,'" + detail + "')]/..");
    }

    private By assigneeOnDetailPage(String detail) {
        return By.xpath("//span[contains(text(),'" + detail + "')]");
    }

    private By unitDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }

    private By companyIdElement(String id) {
        return By.xpath("//td[text()='" + id + "']/..//span[@class='link']");
    }

    public void clickAddFacility() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(addFacilityButton).click();
    }

    private void enterValueInFacility() {
       // waitABit(5000);
        element(facilityField("Facility")).withTimeoutOf(40, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Facility")).clear();
        facilityModel.setName(RandomGenerator.randomAlphabetic(5) + "Pvt Ltd");
        element(facilityField("Facility")).sendKeys(facilityModel.getName());
    }

    private void enterValueInAddress() {
        element(facilityField("Address")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Address")).clear();
        facilityModel.setFacilityAddress("Sector 11 Noida");
        element(facilityField("Address")).sendKeys(facilityModel.getFacilityAddress());
    }

    private void enterValueInZip() {
        element(facilityField("Zip")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Zip")).clear();
        facilityModel.setZipCode("123456");
        element(facilityField("Zip")).sendKeys(facilityModel.getZipCode());
    }

    private void enterValueInManagerName() {
        element(facilityField("Manager Name")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Manager Name")).clear();
        facilityModel.setPmName("Aditya " + RandomGenerator.randomAlphabetic(4));
        element(facilityField("Manager Name")).sendKeys(facilityModel.getPmName());
    }

    private void enterValueInManagerEmail() {
        element(facilityField("Email")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Email")).clear();
        facilityModel.setPmEmail("pm" + RandomGenerator.randomInteger(4) + "@mailinator.com");
        element(facilityField("Email")).sendKeys(facilityModel.getPmEmail());
    }

    private void enterValueInManagerPhone() {
        element(facilityField("Phone")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Phone")).clear();
        facilityModel.setPmPhone(RandomGenerator.randomInteger(10));
        element(facilityField("Phone")).sendKeys(facilityModel.getPmPhone());
    }

    private void enterValueInType() {
        element(facilityField("Type")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Type")).clear();
        facilityModel.setTypeOfConstruction("IT");
        element(facilityField("Type")).sendKeys(facilityModel.getTypeOfConstruction());
    }


    public void enterAllFields() {
        enterValueInFacility();
        enterValueInAddress();
        enterValueInZip();
        enterValueInManagerName();
        enterValueInManagerEmail();
        enterValueInManagerPhone();
        enterValueInType();
    }

    public void selectDropdown() {
        waitABit(3000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(complaintsAssignee);
        Select complaint = new Select(complaintsAssignee);
        complaint.selectByIndex(1);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(moveOutAssignee);
        Select moveOut = new Select(moveOutAssignee);
        moveOut.selectByIndex(1);
    }


    public void verifyDetails() {
        WebElementFacade a = element(facilityDetail("Name"));
        Assert.assertEquals(facilityModel.getName(),
                withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).getText());
        Assert.assertEquals(facilityModel.getFacilityAddress() + ", " + facilityModel.getZipCode(),
                element(facilityDetail("Address")).getText());
        Assert.assertEquals(facilityModel.getPmName(), element(facilityDetail("Manager Name")).getText());
        Assert.assertEquals(facilityModel.getPmEmail(), element(facilityDetail("Email")).getText());
        Assert.assertEquals(facilityModel.getPmPhone(), element(facilityDetail("Number")).getText());
        Assert.assertEquals(facilityModel.getTypeOfConstruction(), element(facilityDetail("Type")).getText());
    }

    public void verifyDefaultSelectedUserGroup() {
        Assert.assertEquals("All", selectedUserGroup.getText());
    }

    //User Group Field
    public void tapOnUserGroupsAssignedDropdown() {
        waitABit(5000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(selectedUserGroup).click();
    }

    public void selectUserGroupCheckbox() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        selectedItems = new ArrayList<>();
        facilityModel.getGroupA(selectedItems.add(elements.get(0).getText()));
        facilityModel.getGroupB(selectedItems.add(elements.get(1).getText()));
        elements.get(0).click();
        elements.get(1).click();
    }

    public void selectAllGroup() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(selectedUserGroup).click();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(selectAllCheckbox).click();
    }

    String removeUserGroupLog;
    String addUserGroupLog;

    public void removeUserGroup() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        selectedItems = new ArrayList<>();
        selectedItems.add(elements.get(0).getText());
        elements.get(0).click();
        String a = elements.get(0).getText();
        removeUserGroupLog = facilityModel.getName() + " user group " + a + " was removed";
    }

    public void addUserGroup() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        selectedItems = new ArrayList<>();
        selectedItems.add(elements.get(0).getText());
        elements.get(0).click();
        String a = elements.get(0).getText();
        addUserGroupLog = a + " was added to " + facilityModel.getName();
    }

    public void companyIdValue() {
        facilityModel.setCompanyId(withTimeoutOf(10, TimeUnit.SECONDS).waitFor(companyID).getText());
    }

    public void verifyIdFromCompanyScreen() throws IOException, ConfigurationException {
        // String xyz = idOnCompanyScreen.getText();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(idOnCompanyScreen);
        Assert.assertTrue(idOnCompanyScreen.getText().contains(facilityModel.getCompanyId()));
        LoadProperties.saveValueInPropertiesFile("companyIdWeb", idOnCompanyScreen.getText(), "testData");
    }

    //Duplicate facility
    public void firstFacilityName() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(firstFacility);
        facilityName = firstFacility.getText();
    }

    public void editScreenOfSecondFacility() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(editSecondFacility).click();
    }

    public void updateDuplicateName() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(facilityField("Facility"));
        element(facilityField("Facility")).clear();
        element(facilityField("Facility")).sendKeys(facilityName);
    }

    public void getMemberList() {
        List<WebElement> assignedMember = getDriver().findElements(By.xpath("//em[@title='Member Assigned']/..//span"));
        System.out.print(assignedMember);
    }


    public void verifyAssignee() {
        waitABit(5000);
        for (int i = 0; i < selectedItems.size(); i++) {
            element(assigneeOnDetailPage(selectedItems.get(i))).shouldBeVisible();
        }

    }

    //Unit Management
    public void tapOnUnitAddButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addUnitButton).click();
    }

    private void enterValueInUnitName() {
        element(facilityField("Unit")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
        element(facilityField("Unit")).clear();
        facilityModel.setUnitName("Unit" + RandomGenerator.randomAlphabetic(4));
        element(facilityField("Unit")).sendKeys(facilityModel.getUnitName());
    }

    public void enterUnitField() {
        enterValueInUnitName();
    }

    public void verifyUnitField() {
        Assert.assertEquals(facilityModel.getUnitName(), element(unitDetail("Unit Name")).getText());
    }

//    public void fectchFacilityName() {
//        WebElementFacade facilityName = element(unitDetail("Facility Name"));
//        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(facilityName).waitUntilPresent();
//        facilityModel.setUnitName(facilityName.getText());
//
//    }

    public void fetchFacilityAndUnitName() {
        WebElementFacade unitName = element(unitDetail("Unit Name"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(unitName).waitUntilPresent();
        facilityModel.setUnitName(unitName.getText());
        facilityModel.setName(element(unitDetail("Facility Name")).getText());
    }

    public void tapOnTheCompanyOfAccountOwner() {
        String companyIdWeb = LoadProperties.getValueFromPropertyFile("testData", "companyIdWeb");
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(searchUser).sendKeys(companyIdWeb, Keys.ENTER);
//        //WebElementFacade companyLink = element(companyIdElement(companyIdWeb));
//        WebElementFacade companyLink = element(companyIdElement("ID12280"));
//        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(companyLink).click();
//        waitABit(1000);
//        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(facilityTab).waitUntilClickable().click();
    }

    public void tapOnFacilityTile() {
        waitABit(1000);
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(facilityTab).waitUntilClickable().click();
    }

    //......Activity Log..........

    public void verifyLogForAddFacility() {
        String addFacilityLog = facilityModel.getName() + " was created";
        vendor.searchContentForActivity(addFacilityLog);
    }

    public void verifyLogForAddFacilityByAdmin() {
        String addFacilityLog = facilityModel.getName() + " was created by an admin";
        vendor.searchContentForActivity(addFacilityLog);
    }


    public void verifyLogForEditFacility() {
        String nameEditLog = facilityModel.getName() + " name was updated";
        vendor.searchContentForActivity(nameEditLog);
        String pmNameEditLog = facilityModel.getName() + " property manager was updated";
        vendor.searchContentForActivity(pmNameEditLog);
        String pmContactEditLog = facilityModel.getName() + " property manager's contact number was updated";
        vendor.searchContentForActivity(pmContactEditLog);
        String pmNameEmailLog = facilityModel.getName() + " property manager's email was updated";
        vendor.searchContentForActivity(pmNameEmailLog);
    }

    public void verifyLogForDeactivateActivateFacility() {
        String deactivateLog = " has been deactivated";
        vendor.searchContentForActivity(deactivateLog);
        String activateLog = " has been activated";
        vendor.searchContentForActivity(activateLog);
    }

    public void verifyLogForDeletedFacilityByAdmin() {
        String deletedLog = facilityModel.getName() + " has been deleted by an admin";
        vendor.searchContentForActivity(deletedLog);
    }

    public void verifyLogForRemoveUserGroup() {
        vendor.searchContentForActivity(removeUserGroupLog);
    }

    public void verifyLogForAddUserGroup() {
        vendor.searchContentForActivity(addUserGroupLog);
    }

    public void deleteBox() {
        if (deleteBox.isEnabled()) {
            withTimeoutOf(40, TimeUnit.SECONDS).waitFor(deleteBox).click();
        } else {
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(typeDELETE).sendKeys("DELETE");
            withTimeoutOf(40, TimeUnit.SECONDS).waitFor(deleteBox).waitUntilEnabled().click();
        }

    }

    public void verifyLogForAddUnit() {
        String addUnitLog = "Unit " + facilityModel.getUnitName() + " has been added to facility";
        vendor.searchContentForActivity(addUnitLog);
    }

    public void verifyLogForEditUnit() {
        String editUnitLog = "Unit " + facilityModel.getUnitName() + " details have been updated";
        vendor.searchContentForActivity(editUnitLog);
    }

    public void verifyLogForDeactivateActivateUnit() {
        String deactivateUnitLog = "Unit " + facilityModel.getUnitName() + " from facility " + facilityModel.getName() + " has been deactivated";
        vendor.searchContentForActivity(deactivateUnitLog);
        String activateUnitLog = "Unit " + facilityModel.getUnitName() + " from facility " + facilityModel.getName() + " has been activated";
        vendor.searchContentForActivity(activateUnitLog);
    }


    ///............Notification..............

    public void searchNotificationContent(String contentType) {
        waitABit(1000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(notificationList.get(0));
        for (int i = 0; i < notificationList.size(); i++) {
            //   withTimeoutOf(20, TimeUnit.SECONDS).waitFor(activityList.get(i)).waitUntilPresent();
            if (notificationList.get(i).isDisplayed()) {
                String actual = notificationList.get(i).getText();
                if (actual.contains(contentType)) {
                    break;
                }
            }
            if (i == notificationList.size() - 1) {
                Assert.fail();
            }
        }
        Assert.assertTrue(true);
    }


    public void addFacilityNotification() {
        String notification = facilityModel.getName() + " was created by an admin. Tap to view details.";
        searchNotificationContent(notification);
        // Assert.assertEquals(notification, notificationContent.getText());
    }

    public void facilityAssignedNotification() {
        String notification = "You have been assigned to " + facilityModel.getName() + ". Tap to view details.";
        searchNotificationContent(notification);
        // Assert.assertEquals(notification, notificationContent.getText());
    }

    public void facilityRemovedNotification() {
        String notification = "You have been removed from the facility " + facilityModel.getName() + ". Tap to view details.";
        searchNotificationContent(notification);
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void editFacilityNotification() {
        String notification = facilityModel.getName() + " details have been updated. Tap to view the details.";
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void deactivateFacilityNotification() {
        String notification = facilityModel.getName() + " has been deactivated.";
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void deleteFacilityNotification() {
        String notification = facilityModel.getName() + " has been deleted.";
        Assert.assertEquals(notification, notificationContent.getText());
    }

    public void editUnitNotification() {
        String notification = facilityModel.getUnitName() + " details have been updated. Tap to view details.";
        //Assert.assertEquals(notification, notificationContent.getText());
        searchNotificationContent(notification);
    }

    public void deactivateUnitNotification() {
        String notification = facilityModel.getUnitName() + " from facility " + facilityModel.getName() + " has been deactivated.";
        //Assert.assertEquals(notification, notificationContent.getText());
        searchNotificationContent(notification);
    }

    public void deleteUnitNotification() {
        String notification = facilityModel.getUnitName() + " from facility " + facilityModel.getName() + " has been deleted.";
        searchNotificationContent(notification);
    }
}