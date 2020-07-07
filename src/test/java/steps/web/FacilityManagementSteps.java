package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.configuration.ConfigurationException;
import pages.FacilityManagementPage;
import pages.UserSigninPage;
import pages.VendorManagementPage;

import java.io.IOException;

public class FacilityManagementSteps {

    private FacilityManagementPage facility;
    private VendorManagementPage vendor;
    private UserSigninPage userSigninPage;

    @Given("^User is on add facility screen$")
    public void userIsOnAddFacilityScreen() {
        facility.clickAddFacility();
    }


    @When("^User enters all the field in Facility screen$")
    public void userEntersAllTheFieldInFacilityScreen() {
        facility.enterAllFields();
    }

    @And("^User selects the default assignee dropdown$")
    public void userSelectsTheDefaultAssigneeDropdown() {
        facility.selectDropdown();
        vendor.tapOnSubmitButton();
    }

    @Given("^User created a new facility and reaches to the detail screen$")
    public void userCreatedANewFacilityAndReachesToTheDetailScreen() {
        facility.clickAddFacility();
        facility.enterAllFields();
        facility.selectAllGroup();
        facility.selectDropdown();
        vendor.tapOnSubmitButton();
    }

    @And("^User verify facility detail screen$")
    public void userVerifyFacilityDetailScreen() {
        facility.verifyDetails();
    }

    @Then("^User verify default assignee user group$")
    public void userVerifyDefaultAssigneeUserGroup() {
        facility.verifyDefaultSelectedUserGroup();
    }


    @And("^User selects multiple groups$")
    public void userSelectsMultipleGroups() {
        facility.tapOnUserGroupsAssignedDropdown();
        facility.selectUserGroupCheckbox();
    }

    @And("^User removes a user group$")
    public void userRemovesAUserGroup() {
        facility.tapOnUserGroupsAssignedDropdown();
        facility.removeUserGroup();
    }

    @And("^User adds a user group$")
    public void userAddsAUserGroup() {
        facility.tapOnUserGroupsAssignedDropdown();
        facility.addUserGroup();
    }

    @When("^User observes prefilled value of Company ID$")
    public void userObservesPrefilledValueOfCompanyID() {
        facility.companyIdValue();
    }

    @Then("^User verified the Company ID$")
    public void userVerifiedTheCompanyID() throws IOException, ConfigurationException {
        facility.verifyIdFromCompanyScreen();
    }

    @Given("^User observes a facility name$")
    public void userObservesAFacilityName() {
        facility.firstFacilityName();
    }

    @And("^User Go to the edit screen for another facility$")
    public void userGoToTheEditScreenForAnotherFacility() {
        facility.editScreenOfSecondFacility();
    }

    @When("^User updates the same facility name$")
    public void userUpdatesTheSameFacilityName() {
        facility.updateDuplicateName();
    }

    @Then("^User verifies the assigned member list$")
    public void userVerifiesTheAssignedMemberList() {
        facility.getMemberList();
    }

    @Then("^User verifies the selected assignee list$")
    public void userVerifiesTheSelectedAssigneeList() {
        facility.verifyAssignee();
    }

    @Given("^User is on add unit screen$")
    public void userIsOnAddUnitScreen() {
        facility.tapOnUnitAddButton();
    }

    @When("^User enters all the field in unit screen$")
    public void userEntersAllTheFieldInUnitScreen() {
        facility.enterUnitField();
    }

    @And("^User verify unit detail screen$")
    public void userVerifyUnitDetailScreen() {
        facility.verifyUnitField();
    }

    @And("^User tap on a company and taps on the facility tab$")
    public void userTapOnACompanyAndTapsOnTheFacilityTab() {
        facility.tapOnTheCompanyOfAccountOwner();
        vendor.tapOnNameLink();
        facility.tapOnFacilityTile();
    }

    @Then("^Activity log for facility creation is displayed$")
    public void activityLogForFacilityCreationIsDisplayed() {
        facility.verifyLogForAddFacility();
    }

    @Then("^Activity log for existing facility edited is displayed$")
    public void activityLogForExistingFacilityEditedIsDisplayed() {
        facility.verifyLogForEditFacility();
    }

    @Then("^Activity log for existing facility activated and deactivated is displayed$")
    public void activityLogForExistingFacilityActivatedAndDeactivatedIsDisplayed() {
        facility.verifyLogForDeactivateActivateFacility();
    }


    @Then("^Activity log for create and delete facility by admin is displayed$")
    public void activityLogForCreateAndDeleteFacilityByAdminIsDisplayed() {
        facility.verifyLogForAddFacilityByAdmin();
        facility.verifyLogForDeletedFacilityByAdmin();
    }

    @Then("^Activity log for unit creation is displayed$")
    public void activityLogForUnitCreationIsDisplayed() {
        facility.verifyLogForAddUnit();
    }

    @Then("^Activity log for existing unit edited is displayed$")
    public void activityLogForExistingUnitEditedIsDisplayed() {
        facility.verifyLogForEditUnit();
        userSigninPage.signout();
    }

    @Then("^Activity log for existing unit activated and deactivated is displayed$")
    public void activityLogForExistingUnitActivatedAndDeactivatedIsDisplayed() {
        facility.verifyLogForDeactivateActivateUnit();
    }

    @Then("^Notification for facility creation is displayed$")
    public void notificationForFacilityCreationIsDisplayed() {
        facility.addFacilityNotification();
    }

    @Then("^Notification for Existing Unit Edited is displayed$")
    public void notificationForExistingUnitEditedIsDisplayed() {
        facility.editUnitNotification();
    }

    @When("^User fetches facility and unit name$")
    public void userFetchesFacilityAndUnitName() {
        vendor.tapOnNameLink(); //Reaches to detail screen
        facility.fetchFacilityAndUnitName();
    }

    @Then("^Notification for Existing Unit deactivated is displayed$")
    public void notificationForExistingUnitDeactivatedIsDisplayed() {
        facility.deactivateUnitNotification();
        userSigninPage.signout();
    }

    @When("^User add a new unit$")
    public void userAddANewUnit() {
        vendor.tapOnNameLink();
        facility.tapOnUnitAddButton();
        facility.enterUnitField();
        vendor.tapOnSubmitButton();
    }

    @Then("^Notification for Existing unit Deleted is displayed$")
    public void notificationForExistingUnitDeletedIsDisplayed() {
        facility.deleteUnitNotification();
    }

    @Given("^User navigates to edit page from list screen for unit$")
    public void userNavigatesToEditPageFromListScreenForUnit() {
        vendor.tapOnEditUnitIcon();
    }

    @Then("^Activity log for add/remove user group is displayed$")
    public void activityLogForAddRemoveUserGroupIsDisplayed() {
        facility.verifyLogForRemoveUserGroup();
        facility.verifyLogForAddUserGroup();
    }

    @When("^User clicks on delete option to delete parent/child entity$")
    public void userClicksOnDeleteOptionToDeleteParentChildEntity() {
        vendor.tapOnActionButton();
        vendor.clickOnDeleteButton();
        facility.deleteBox();
    }
}

