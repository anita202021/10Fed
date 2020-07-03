package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FacilityManagementPage;

public class FacilityManagementSteps {

    FacilityManagementPage facility;

    @Given("^User is on add facility screen$")
    public void userIsOnAddFacilityScreen() {
        facility.clickAddFacility();
    }

    @When("^User enters all the field in Facility screen$")
    public void userEntersAllTheFieldInFacilityScreen() {
        facility.enterAllFields();
        facility.selectDropdown();
    }

    @And("^User verify facility detail screen$")
    public void userVerifyFacilityDetailScreen() {
        facility.verifyDetails();
    }

    @Then("^User verify default assignee members$")
    public void userVerifyDefaultAssigneeMembers() {
        facility.verifyDefaultSelectedAssignee();
    }

    @When("^User taps on the Member Assigned Dropdown$")
    public void userTapsOnTheMemberAssignedDropdown() {
        facility.tapOnAssigneeDropdown();
    }

    @And("^User selects multiple assignees$")
    public void userSelectsMultipleAssignees() {
        facility.selectAssigneeCheckbox();
    }

    @When("^User observes prefilled value of Company ID$")
    public void userObservesPrefilledValueOfCompanyID() {
        facility.companyIdValue();
    }

    @Then("^User verified the Company ID$")
    public void userVerifiedTheCompanyID() {
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

    @And("^User tap on the newlane company and taps on the facility tab$")
    public void userTapOnTheNewlaneCompanyAndTapsOnTheFacilityTab() {
        facility.tapOnNewLaneCompany();
    }
}

