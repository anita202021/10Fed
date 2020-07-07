package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.VendorManagementPage;
import pages.WorkOrderPages;

import java.io.IOException;
import java.util.List;

public class WorkOrderSteps {
    private WorkOrderPages workOrder;
    private VendorManagementPage vendor;

    @Given("^User is on add work order screen$")
    public void userIsOnAddWorkOrderScreen() {
        workOrder.tapOnAddNewButtonFromGrid();
    }

    @When("^User enters the mandatory fields in work order screen$")
    public void userEntersTheMandatoryFieldsInWorkOrderScreen() {
        workOrder.enterMandatoryFields();
    }

    @Given("^User is on the work order detail screen$")
    public void userIsOnTheWorkOrderDetailScreen() {
        workOrder.tapOnGridItem();
    }

    @Given("^A work order is created$")
    public void aWorkOrderIsCreated() {
        workOrder.tapOnAddNewButtonFromGrid();
        workOrder.enterMandatoryFields();
        vendor.tapOnSubmitButton();
    }

    @And("^User verify work order detail screen$")
    public void userVerifyWorkOrderDetailScreen() {
        workOrder.verifyDetails();
        workOrder.fetchWOId();
    }

    @When("^User uploads more than five images to a work order$")
    public void userUploadsMoreThanFiveImagesToAWorkOrder() throws IOException {
        workOrder.maxPhotosAdded();
    }

    @When("^User uploads an image to a work order$")
    public void userUploadsAnImageToAWorkOrder() throws IOException {
        workOrder.tapOnAddPhotoIcon();
    }

    @Then("^Uploaded image is getting displayed on the screen$")
    public void uploadedImageIsGettingDisplayedOnTheScreen() {
        workOrder.verifyImageIsUploaded();
    }

    @And("^User removes the uploaded image$")
    public void userRemovesTheUploadedImage() {
        workOrder.deleteWOImage();
    }

    @And("^User selects an assignee to the work order$")
    public void userSelectsAnAssigneeToTheWorkOrder() {
        workOrder.selectAssignee();
        vendor.tapOnSubmitButton();
    }

    @And("^User removes the assignee$")
    public void userRemovesTheAssignee() {
        workOrder.removeAssignee();
    }

    @When("^User updates the work order status and priority$")
    public void userUpdatesTheWorkOrderStatusAndPriority() {
        workOrder.updateStatus();
        workOrder.updatePriority();
    }

    @Then("^Activity log for status update is displayed$")
    public void activityLogForStatusUpdateIsDisplayed() {
        workOrder.verifyLogForStatusUpdate();
    }

    @Then("^Activity log for priority update is displayed$")
    public void activityLogForPriorityUpdateIsDisplayed() {
        workOrder.verifyLogForPriorityUpdate();
    }

    @Then("^Activity log for work order added is displayed$")
    public void activityLogForWorkOrderAddedIsDisplayed() {
        workOrder.verifyLogForAddWO();
    }


    @Then("^Notification for work order added is displayed$")
    public void notificationForWorkOrderAddedIsDisplayed() {
    }

}
