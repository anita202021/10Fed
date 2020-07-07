package pages;

import models.WorkOrderModel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.RandomGenerator;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WorkOrderPages extends PageObject {

    private WorkOrderModel workOrderModel = new WorkOrderModel();
    private VendorManagementPage vendor;
    private FacilityManagementPage facility;

    //......Static Locators..........
    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElementFacade addNewFromGrid;
    @FindBy(xpath = "//label[contains(text(),'Title')]/..//input")
    private WebElementFacade titleInputbox;
    @FindBy(xpath = "//textarea")
    private WebElementFacade descriptionTesxtArea;
    @FindBy(xpath = "//app-work-order-grid-view-item")
    private WebElementFacade gridItem;
    @FindBy(xpath = "//div[@class='col-12']//button")
    private WebElementFacade addWOPhoto;
    @FindBy(xpath = "//i[@class='la la-trash']/..")
    private WebElementFacade detetePhoto;
    @FindBy(xpath = "//div[@class='col-2']//img")
    private WebElementFacade uploadedImg;
    @FindBy(xpath = "//div[@class='col-9 text-right']//button")
    private WebElementFacade statusButton;
    @FindBy(xpath = "//div[@class='col-9 text-right']//a")
    private WebElementFacade changeStatusFromDetailScreen;
    @FindBy(xpath = "//div[@class='btn-group']//button")
    private WebElementFacade priorityButton;
    @FindBy(xpath = "//div[@class='btn-group']//a")
    private WebElementFacade changePriorityFromDetailScreen;


    //......Dynamic Locators........
    private By selectDropdownField(String field) {
        return By.xpath("//label[contains(text(),'" + field + "')]/..//select");
    }

    private By workOrderDetail(String detail) {
        return By.xpath("//label[contains(text(),'" + detail + "')]/..//p");
    }


    public void tapOnAddNewButtonFromGrid() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addNewFromGrid).click();
    }

    public void enterTitleAndDescription() {
        waitABit(2000);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(titleInputbox).waitUntilClickable().click();
        titleInputbox.clear();
        workOrderModel.setTitle("Work Order Automated Title " + RandomGenerator.randomAlphabetic(7));
        titleInputbox.sendKeys(workOrderModel.getTitle());

        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(descriptionTesxtArea).waitUntilClickable().click();
        descriptionTesxtArea.clear();
        workOrderModel.setDescription("Automated Description " + RandomGenerator.randomAlphabetic(7));
        descriptionTesxtArea.sendKeys(workOrderModel.getDescription());
        waitABit(4000);
    }

    public void selectPriority() {
        WebElementFacade priority = element(selectDropdownField("Priority"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(priority).selectByIndex(1);
    }

    public void selectCategory() {
        WebElementFacade category = element(selectDropdownField("Category"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(category).selectByIndex(1);
    }

    public void selectFacility() {
        WebElementFacade facility = element(selectDropdownField("Facility"));
        waitFor(facility).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select option = new Select(facility);
        workOrderModel.setFacility("DLF NTH");
        option.selectByVisibleText(workOrderModel.getFacility());
    }

    public void selectUnit() {
        waitABit(7000);
        WebElementFacade unit = element(selectDropdownField("Unit"));
        waitFor(unit).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select option = new Select(unit);
        workOrderModel.setUnit("Club house");
        option.selectByVisibleText(workOrderModel.getUnit());
    }

    public void selectAssignee() {
        WebElementFacade assignee = element(selectDropdownField("Assignee"));
        waitFor(assignee).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select option = new Select(assignee);
        option.selectByIndex(1);
    }

    public void verifyDetails() {
        WebElementFacade title = element(workOrderDetail("Title"));
        Assert.assertEquals(workOrderModel.getTitle(),
                withTimeoutOf(20, TimeUnit.SECONDS).waitFor(title).getText());
        Assert.assertEquals(workOrderModel.getFacility(), element(workOrderDetail("Facility")).getText());
        Assert.assertEquals(workOrderModel.getUnit(), element(workOrderDetail("Unit")).getText());
    }
     public void fetchWOId(){
        workOrderModel.setWorkOrderId(element(workOrderDetail("ID")).getText());
     }

    public void removeAssignee() {
        WebElementFacade assignee = element(selectDropdownField("Assignee"));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(assignee).selectByIndex(0);
    }

    public void updateStatus() {
        workOrderModel.setOldStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(statusButton).getText());
        statusButton.click();
        workOrderModel.setStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(changeStatusFromDetailScreen).getText());
        changeStatusFromDetailScreen.click();
    }

    public void updatePriority() {
        waitABit(1000);
        workOrderModel.setOldPriority(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(priorityButton).getText());
        priorityButton.click();
        workOrderModel.setStatus(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(changePriorityFromDetailScreen).getText());
        changePriorityFromDetailScreen.click();
    }

    public void enterMandatoryFields() {
        enterTitleAndDescription();
        selectPriority();
        selectFacility();
        selectUnit();
    }

    public void tapOnGridItem() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(gridItem).click();
    }

    public void tapOnAddPhotoIcon() throws IOException {
        String path = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testData" + File.separator + "profileIcon.png";
        getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(path);
        // withTimeoutOf(50, TimeUnit.SECONDS).waitFor(addWOPhoto).sendKeys(path);
        // withTimeoutOf(20, TimeUnit.SECONDS).waitFor(addWOPhoto).click();
        waitABit(5000); //Application is too slow right now that is why adding dynamic wait
    }

    public void maxPhotosAdded() throws IOException {
        for (int i = 0; i <= 5; i++) {
            tapOnAddPhotoIcon();
        }
    }

    public void verifyImageIsUploaded() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(uploadedImg).shouldBePresent();
    }

    public void deleteWOImage() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(detetePhoto).click();
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(uploadedImg).waitUntilNotVisible();
    }



    //........Activity Log.............
    public void verifyLogForStatusUpdate() {
        String statusUpdate = "Work Order " + workOrderModel.getWorkOrderId() + " status changed from " +
                workOrderModel.getOldStatus() + " to " + workOrderModel.getStatus();
        vendor.searchContentForActivity(statusUpdate);
    }

    public void verifyLogForPriorityUpdate() {
        String priorityUpdate = "Work Order " + workOrderModel.getWorkOrderId() + " priority changed from " +
                workOrderModel.getOldPriority() + " to " + workOrderModel.getPriority();
        vendor.searchContentForActivity(priorityUpdate);
    }

    public void verifyLogForAddWO() {
        String activity="Work Order "+workOrderModel.getWorkOrderId()+" created";
        vendor.searchContentForActivity(activity);
    }

    //..........Notification............
    public void verifyAddWONotification(){
        String notification="Work Order "+workOrderModel.getWorkOrderId()+" has been created. Tap to view details.";
        facility.searchNotificationContent(notification);
    }
}
