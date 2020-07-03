package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import models.DetailsModel;
import models.FacilityModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.yecht.Data;
import utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacilityManagementPage extends PageObject {

    private FacilityModel facilityModel = new FacilityModel();
    List<String> selectedItems;
    String facilityName;
    @FindBy(xpath = "//a[contains(text(),'New Facility')]")
    private WebElementFacade addFacilityButton;
    @FindBy(xpath = "//label[contains(text(),'ID')]/..//div")
    private WebElementFacade companyID;
    @FindBy(xpath = "//em[@title='AccountID']/..")
    private WebElementFacade idOnCompanyScreen;

    @FindBy(xpath = "//div[@class='multiselect-dropdown']")
    private WebElementFacade selectedAssignee;
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
    //unit management locators
    @FindBy(xpath = "//a[text()=' New Unit ']")
    private WebElementFacade addUnitButton;

    @FindBy(xpath = "//span[text()='Townlane']")
    private WebElementFacade companyLink;
    @FindBy(xpath = "//a[text()='Facility']")
    private WebElementFacade facilityTab;


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

    public void clickAddFacility() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(addFacilityButton).click();
    }

    private void enterValueInFacility() {
        element(facilityField("Facility")).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible().click();
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
        facilityModel.setPmPhone("9879879879");
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
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(complaintsAssignee);
        Select complaint = new Select(complaintsAssignee);
        complaint.selectByIndex(1);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(moveOutAssignee);
        Select moveOut = new Select(moveOutAssignee);
        moveOut.selectByIndex(2);
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

    public void verifyDefaultSelectedAssignee() {
        Assert.assertEquals("All", selectedAssignee.getText());
    }

    public void tapOnAssigneeDropdown() {
        waitABit(5000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(selectedAssignee).click();
    }

    public void selectAssigneeCheckbox() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@class='item2']//li"));
        selectedItems = new ArrayList<>();
        selectedItems.add(elements.get(0).getText());
        selectedItems.add(elements.get(1).getText());
        elements.get(0).click();
        elements.get(1).click();
//        }
    }

    public void companyIdValue() {
        facilityModel.setCompanyId(withTimeoutOf(10, TimeUnit.SECONDS).waitFor(companyID).getText());
    }

    public void verifyIdFromCompanyScreen() {
        // String xyz = idOnCompanyScreen.getText();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(idOnCompanyScreen);
        Assert.assertTrue(idOnCompanyScreen.getText().contains(facilityModel.getCompanyId()));
    }

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

    public void tapOnNewLaneCompany() {
        withTimeoutOf(40,TimeUnit.SECONDS).waitFor(companyLink).click();
        withTimeoutOf(40,TimeUnit.SECONDS).waitFor(facilityTab).click();
    }
}
