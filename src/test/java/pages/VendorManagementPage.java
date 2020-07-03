package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoadProperties;
import utilities.RandomGenerator;
import models.DetailsModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class VendorManagementPage extends PageObject {

    private DetailsModel detailsModel = new DetailsModel();

    @FindBy(xpath = "//h3[contains(text(),'Vendors')]")
    private WebElementFacade vendorHeading;
    @FindBy(xpath = "//a[contains(text(),'New Vendor')]")
    private WebElementFacade addVendorButton;
    @FindBy(xpath = "//label[contains(text(),'Type')]/..//div")
    private WebElementFacade vendorTypeDropdown;
    @FindBy(xpath = "//option[contains(text(),'Electricity Provider')]")
    private WebElementFacade selectElectricityProvider;
    @FindBy(xpath = "//span[@class='link']")
    private WebElementFacade nameLink;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElementFacade submitButton;
    @FindBy(xpath = "//span[text()=' payal Gaur ']/../../..//p")
    private List<WebElementFacade> activityList;
    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElementFacade cancelButton;
    @FindBy(xpath = "//button[contains(text(),'Action')]")
    private WebElementFacade actionButton;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElementFacade deleteButton;
    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    private WebElementFacade editButton;
    @FindBy(xpath = "//span[contains(text(),'Notes')]")
    private WebElementFacade notesButton;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElementFacade addNoteButton;
    @FindBy(xpath = "//i/../../button")
    private WebElementFacade editNoteIcon;
    @FindBy(xpath = "//label[contains(text(),'Note')]/..//textarea")
    private WebElementFacade noteTestArea;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElementFacade submitNoteButton;
    @FindBy(xpath = "//h3[contains(text(),'Note')]/span")
    private WebElementFacade notesCount;
    @FindBy(xpath = "//div[@class='col-md-3']//select")
    private WebElementFacade selectFilterDropdown;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElementFacade filterButton;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElementFacade resetButton;
    @FindBy(xpath = "//input[contains(@placeholder,'Filter')]")
    private WebElementFacade searchVendor;
    //pagination
    @FindBy(xpath = "//select[contains(@class,'custom')]")
    private WebElementFacade selectLimitDropdown;
    @FindBy(xpath = "//div[@id='DataTables_Table_0_info']")
    private WebElementFacade datatableInfo;
    @FindBy(xpath = "//div[contains(@class,'kt-notification__item-content')]")
    private WebElementFacade notificationContent;
    @FindBy(xpath = "//div[@class='kt-widget3']")
    private WebElementFacade activityLogWidget;

    private By validationMessage(String text) {
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }

    private By vendorFormField(String text) {
        return By.xpath("//label[contains(text(),'" + text + "')]/..//input");
    }

    private By vendorDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }

    private By pageRecord(String option) {
        return By.xpath("//option[text()='" + option + "']");
    }

    private By storedName(String name) {
        return By.xpath("//span[contains(text(),'" + name + "')]");
    }

    private By editIconForAUser(String name) {
        return By.xpath("//span[contains(text(),'" + name + "')]/../..//em[contains(@class,'fa fa-edit')]");
    }

    private By deleteIconForAUser(String name) {
        return By.xpath("//span[contains(text(),'" + name + "')]/../..//em[contains(@title,'Delete')]");
    }

    private By entityName(String entity) {
        return By.xpath(" //a[contains(text(),'" + entity + "')]");
    }


    public void verifyValidationMessage(String text) {
        WebElementFacade a = element(validationMessage(text));
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(a).shouldBeVisible();
    }

    private void enterValueInName() throws IOException, ConfigurationException {
        WebElementFacade nameField = element(vendorFormField("Name"));
        waitABit(10000);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(nameField).waitUntilClickable().click();
        nameField.clear();
        detailsModel.setName("Ram" + RandomGenerator.randomAlphabetic(3));
        nameField.sendKeys(detailsModel.getName());
        LoadProperties.saveValueInPropertiesFile("name", detailsModel.getName(), "testData");
    }

    private void enterValueInPhone() {
        WebElementFacade contactField = element(vendorFormField("Contact"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(contactField).waitUntilVisible().click();
        contactField.clear();
        detailsModel.setContact(RandomGenerator.randomInteger(10));
        contactField.sendKeys(detailsModel.getContact());
    }

    private void enterValueInEmail() {
        WebElementFacade emailField = element(vendorFormField("Email"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(emailField).waitUntilVisible().click();
        emailField.clear();
        detailsModel.setEmail("vendor" + RandomGenerator.randomInteger(4) + "@mailinator.com");
        emailField.sendKeys(detailsModel.getEmail());
    }

    private void enterValueInLocation() {
        WebElementFacade locationField = element(vendorFormField("Location"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(locationField).waitUntilVisible().click();
        locationField.clear();
        detailsModel.setLocation("Noida Sector 11");
        locationField.sendKeys(detailsModel.getLocation());
    }

    private void enterValueInAccountNo() {
        WebElementFacade accNoField = element(vendorFormField("Account"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(accNoField).waitUntilVisible().click();
        accNoField.clear();
        detailsModel.setAccountNo(Integer.parseInt(RandomGenerator.randomInteger(5)));
        accNoField.sendKeys(detailsModel.getAccountNo().toString());
    }

    public void tapOnAddVendorButton() {
        waitABit(1000);
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(addVendorButton).click();
    }

    public void addInputFieldsOfVendorForm() throws IOException, ConfigurationException {
        enterValueInName();
        enterValueInPhone();
        enterValueInEmail();
        enterValueInLocation();
        enterValueInAccountNo();
    }

    public void selectTypeFromDropdown() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(vendorTypeDropdown).waitUntilClickable().click();
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(selectElectricityProvider).click();
        detailsModel.setType(selectElectricityProvider.getText());
    }

    public void enterInvalidContactNo() {
        waitFor(submitButton).withTimeoutOf(10, TimeUnit.SECONDS).sendKeys("1234");
        waitFor(2000);
    }

    public void tapOnSubmitButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(submitButton).click();
    }

    public void vendorDetailsVerify() {
        WebElementFacade a = element(vendorDetail("Name"));
        Assert.assertEquals(detailsModel.getName(),
                withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).getText());
        Assert.assertTrue(detailsModel.getType().contains(element(vendorDetail("Type")).getText()));
        Assert.assertEquals(detailsModel.getContact(), element(vendorDetail("Phone")).getText());
        Assert.assertEquals(detailsModel.getEmail(), element(vendorDetail("Email")).getText());
        Assert.assertEquals(detailsModel.getLocation(), element(vendorDetail("Location")).getText());
        Assert.assertEquals(detailsModel.getAccountNo().toString(), element(vendorDetail("Account Number")).getText());
    }

    public void saveUserName() throws IOException, ConfigurationException {
        WebElementFacade nameInDetail = element(vendorDetail("Name"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(nameInDetail);
        LoadProperties.saveValueInPropertiesFile("nameInDetail", nameInDetail.getText(), "testData");
    }

    public void tapOnCancelButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(cancelButton).waitUntilClickable().click();
    }

    public void tapOnEditIcon() {
        WebElementFacade editIcon = element(editIconForAUser(LoadProperties.getValueFromPropertyFile("testData", "name")));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(editIcon).click();
    }

    public void verifyEditIconIsNotDisplayed() {
        WebElementFacade editIconForAdmin = element(editIconForAUser(LoadProperties.getValueFromPropertyFile("testData", "name")));
        Assert.assertFalse(editIconForAdmin.isVisible());
    }

    public void tapOnNameLink() {
        //waitABit(1000);
        // WebElementFacade nameLink = element(storedName(LoadProperties.getValueFromPropertyFile("testData", "name")));
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(nameLink).waitUntilVisible().click();
        waitABit(1000);
    }

    public void tapOnActionButton() {
        waitABit(1000);
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(actionButton).click();
    }

    public void editFromActionButton() {
        waitFor(editButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void noteOptionFromActionButton() {
        waitFor(notesButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void tapOnAddButton() {
        waitFor(addNoteButton).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void enterNote() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(noteTestArea).click();
        noteTestArea.clear();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(noteTestArea).sendKeys("Automation note is added.");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(submitNoteButton).click();
    }

    public void tapOnEditNoteIcon() {
        waitFor(editNoteIcon).withTimeoutOf(10, TimeUnit.SECONDS).click();
    }

    public void countNotesForVendor() {
        String value = notesCount.getText();
        int intValue = Integer.parseInt(value.replaceAll("[^0-9]", ""));
        System.out.println(intValue);

        int countIcon = getDriver().findElements(By.xpath("//i/../../button")).size();
        Assert.assertEquals(countIcon, intValue);
        waitABit(10000);
    }

    public void selectVendorTypeToFilterList() {
        waitFor(selectFilterDropdown).withTimeoutOf(10, TimeUnit.SECONDS).click();
        Select vendorFilter = new Select(selectFilterDropdown);
        vendorFilter.selectByValue("3");
    }

    private By vendorTypeDynamic(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[2]");
    }

    public void verifyVendorType() {
        waitABit(2000);
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            String vType = element(vendorTypeDynamic(i)).getText();
            Assert.assertEquals("Electricity Provider", vType);
        }

    }

    public void tapOnResetButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(resetButton).click();
        waitABit(1000);
    }


    public void tapOnFilterButton() {
        waitFor(filterButton).withTimeoutOf(20, TimeUnit.SECONDS).click();
    }

    public void pressEnterKey() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(searchVendor).sendKeys(Keys.ENTER);
    }

    private By vendorNameSearch(int count) {
        return By.xpath("((//tbody/tr)[" + count + "]/td)[1]");
    }

    public void verifyVendorName() {
        waitABit(2000);
        int num = getDriver().findElements(By.xpath("//tbody/tr")).size();
        waitABit(2000);
        for (int i = 1; i <= num; i++) {
            String vName = element(vendorNameSearch(i)).getText();
            Assert.assertTrue(vName.contains("Vendor"));
        }
    }


    public void clickOnDeleteIcon() {
        WebElementFacade deleteIcon = element(deleteIconForAUser(LoadProperties.getValueFromPropertyFile("testData", "name")));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(deleteIcon).click();

    }

    public void clickOnDeleteButton() {
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(deleteButton).click();
    }

    public void acceptOptionInJSPopup() {
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void verifyAddButtonForClientPersonnel() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(vendorHeading).isDisplayed();
        Assert.assertFalse(addVendorButton.isVisible());

    }

    public int totalRecordCount() {
        Scroll.to(datatableInfo);
        String str = datatableInfo.getText();
        String[] arrOfStr = str.split("of");
        String value = arrOfStr[1];
        return Integer.parseInt(value.replaceAll("[^0-9]", ""));
    }

    public int selectPageLimit(String option) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(selectLimitDropdown).click();
        element(pageRecord(option)).click();
        return Integer.parseInt(element(pageRecord(option)).getText());
    }


    public void verifyPaginationFunction(String option) {
        int totalRecordCount = totalRecordCount();
        int recordCountPerPage = selectPageLimit(option);
        int noOfRecordInLastPage = totalRecordCount % recordCountPerPage;
        int pageCount = (noOfRecordInLastPage > 0) ? totalRecordCount / recordCountPerPage + 1 : totalRecordCount / recordCountPerPage;

        for (int noOfPage = 0; noOfPage < pageCount; noOfPage++) {
            WebElement NextButton = getDriver().findElement(By.xpath("//a[text()='" + (noOfPage + 1) + "']/.."));
            if (NextButton.isDisplayed()) {
                NextButton.click();
            }
            waitABit(3000);
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor("//tbody/tr");
            int rowCountInTable = getDriver().findElements(By.xpath("//tbody//tr")).size();
            if ((noOfPage != pageCount - 1)) {
                Assert.assertEquals(rowCountInTable, recordCountPerPage);
            } else {
                int lastPageRecordCount = noOfRecordInLastPage == 0 ? recordCountPerPage : noOfRecordInLastPage;
                Assert.assertEquals(rowCountInTable, lastPageRecordCount);
                break;
            }
        }


    }

    //.......Activity Log...........

    public void searchContentForActivity(String contentType) {
        waitABit(1000);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(activityList.get(0));
        for (int i = 0; i < activityList.size(); i++) {
            //   withTimeoutOf(20, TimeUnit.SECONDS).waitFor(activityList.get(i)).waitUntilPresent();
            if (activityList.get(i).isDisplayed()) {
                String actual = activityList.get(i).getText();
                if (actual.contains(contentType)) {
                    break;
                }
            }
            if (i == activityList.size() - 1) {
                Assert.fail();
            }
        }
        Assert.assertTrue(true);
    }

    public void verifyLogForAddVendor() {
        String addUserLog = "New vendor " + detailsModel.getName() + " was created";
        searchContentForActivity(addUserLog);
    }


    public void verifyLogForEditVendor() {
        String editNameLog = "Vendor " + detailsModel.getName() + " has been changed";
        searchContentForActivity(editNameLog);
        String editAccNoLog = "Vendor " + detailsModel.getName() + " account number changed";
        searchContentForActivity(editAccNoLog);
        String emailNameLog = "Vendor " + detailsModel.getName() + " email changed";
        searchContentForActivity(emailNameLog);
        String editContactLog = "Vendor " + detailsModel.getName() + " contact number changed";
        searchContentForActivity(editContactLog);
    }

    public void verifyLogForDeleteVendor() {
        WebElementFacade entity = element(entityName(detailsModel.getName()));
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(entity).shouldBePresent();
        String deleteUserLog = detailsModel.getName() + " has been deleted";
        Assert.assertTrue(activityLogWidget.containsText(deleteUserLog));
    }

    //........Notification................

    public void verifyAddVendorNotification() {
        String notification = "New vendor " + detailsModel.getName() + " was created. Tap to view details.";
        Assert.assertEquals(notification, notificationContent.getText());
    }


    public void verifyEditVendorNotification() {
        String notification = detailsModel.getName() + " details have been updated. Tap to view details.";
        Assert.assertEquals(notification, notificationContent.getText());
    }


    public void verifyDeleteVendorNotification() {
        String notification = detailsModel.getName() + " has been deleted.";
        Assert.assertEquals(notification, notificationContent.getText());
    }


}