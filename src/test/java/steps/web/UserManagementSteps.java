package steps.web;

import com.typesafe.config.Config;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.configuration.ConfigurationException;
import pages.UserManagementPage;
import pages.UserManagementPage;
import pages.UserSigninPage;
import pages.VendorManagementPage;
import utilities.ConfigLoader;

import java.io.IOException;

public class UserManagementSteps {
    Config conf = ConfigLoader.load();
    private UserManagementPage users;
    private UserSigninPage userSigninPage;
    private VendorManagementPage vendor;


    @Given("^User is on add user screen$")
    public void userIsOnAddUserScreen() {
        users.tapOnAddUserButton();
    }


    @When("^User enters all the field in user screen$")
    public void userEntersAllTheFieldInUserScreen() throws IOException, ConfigurationException {
        users.uploadProfilePicture();
        users.addInputFieldsOfUserForm();
        users.selectRole("Administrator");
    }

    @When("^User updates all the field of user form$")
    public void userUpdatesAllTheFieldOfUserForm() throws IOException, ConfigurationException {
        users.addInputFieldsOfUserForm();
        users.selectRole("Personnel");
    }

    @Given("^User has created a new user and reaches to the detail screen$")
    public void userHasCreatedANewUserAndReachesToTheDetailScreen() throws IOException, ConfigurationException {
        users.tapOnAddUserButton();
        users.uploadProfilePicture();
        users.addInputFieldsOfUserForm();
        users.selectRole("Administrator");
        vendor.tapOnSubmitButton();
    }


    @And("^User select Client Admin as the user role$")
    public void userSelectClientAdminAsTheUserRole() {
        users.selectRole("Administrator");
    }


    @And("^User select Client Personnel as the user role$")
    public void userSelectClientPersonnelAsTheUserRole() {
        users.selectRole("Personnel");
    }

    @And("^Verify user detail screen$")
    public void verifyUserDetailScreen() {
        users.userDetailsVerify();
    }


    @When("^User clicks on Select role dropdown$")
    public void userClicksOnSelectRoleDropdown() {
        users.selectRoleDropdown();

    }

    @And("^User select \"([^\"]*)\" role$")
    public void userSelectRole(String userRoles)  {
        users.selectFilterDropdown(userRoles);
        users.tapOnFilterButton();
    }

    @Then("^List displayed is according to the selected \"([^\"]*)\" role$")
    public void listDisplayedIsAccordingToTheSelectedRole(String userRoles) throws Throwable {
        users.verifyUserRole(userRoles);
    }

    @When("^User clicks on Select status dropdown$")
    public void userClicksOnSelectStatusDropdown() {
        users.selectStatusDropdown();
    }

    @And("^User select \"([^\"]*)\" status$")
    public void userSelectStatus(String status)  {
        users.selectFilterDropdown(status);
        users.tapOnFilterButton();
        users.verifyStatus(status);
    }

    @Then("^List displayed is according to the selected \"([^\"]*)\" status$")
    public void listDisplayedIsAccordingToTheSelectedStatus(String status) throws Throwable {
        users.verifyStatus(status);
    }

    @When("^User enters a keyword \"([^\"]*)\" in the search field$")
    public void userEntersAKeywordInTheSearchField(String searchKey) throws Throwable {
        users.enterKeyInSearchField(searchKey);
    }


    @Then("^List displayed is according to the entered keyword$")
    public void userListDisplayedIsAccordingToTheEnteredKeyword() {
        users.verifyUserName();
    }

    @When("^User clicks on \"([^\"]*)\" icon on list page$")
    public void userClicksOnIconOnListPage(String title) {
        users.tapOnStatusIcon(title);
    }

    @And("^User verify status and takes necessary actions to change the status$")
    public void userVerifyStatusAndTakesNecessaryActionsToChangeTheStatus() {
        users.changeUserStatus();
    }

    @Then("^User verified the changed status$")
    public void userVerifiedTheChangedStatus() {
        users.verifyChangedStatus();
    }

    @Then("^Action column should not be visible to client personnel$")
    public void actionColumnShouldNotBeVisibleToClientPersonnel() {
        users.verifyActionFeatureForPersonnel();
    }

    @Then("^Add User button should not be visible to client personnel$")
    public void addUserButtonShouldNotBeVisibleToClientPersonnel() {
        users.addUserForPersonnel();
    }

    @When("^User tap on the bell icon$")
    public void userTapOnTheBellIcon() {
        users.tapOnBellIcon();
    }

    @Then("^User is added notification is displayed$")
    public void userIsAddedNotificationIsDisplayed() {
        users.verifyAddUserNotification();
        userSigninPage.signout();
    }


    @Then("^Notification for Existing User Deactivated is displayed$")
    public void notificationForExistingUserDeactivatedIsDisplayed() {
        users.VerifyDeactivateNotification();
        userSigninPage.signout();
    }

    @Then("^Notification for Existing User Deleted is displayed$")
    public void notificationForExistingUserDeletedIsDisplayed() {
        users.VerifyDeletedNotification();
        userSigninPage.signout();
    }

    @Then("^Activity log for user creation is displayed$")
    public void activityLogForUserCreationIsDisplayed() {
        users.verifyLogForAddUser();
    }

    @Then("^Upon tapping the entity user is redirected to the detail screen$")
    public void uponTappingTheEntityUserIsRedirectedToTheDetailScreen() {
        users.redirectionOfEntity();
        userSigninPage.signout();
    }

    @Then("^Activity log for existing user edited is displayed$")
    public void activityLogForExistingUserEditedIsDisplayed() {
        users.verifyLogForEditUser();
        userSigninPage.signout();
    }

    @Then("^Activity log for existing user deactivated or activated is displayed$")
    public void activityLogForExistingUserDeactivatedOrActivatedIsDisplayed() {
        users.verifyLogForDeactivateActivateUser();
    }

    @Then("^Activity log for existing user deleted is displayed$")
    public void activityLogForExistingUserDeletedIsDisplayed() {
        users.verifyLogForDeletedUser();
        userSigninPage.signout();
    }

    @Then("^Client Admin is not able to edit other admin details$")
    public void clientAdminIsNotAbleToEditOtherAdminDetails() {
        vendor.verifyEditIconIsNotDisplayed();
        userSigninPage.signout();
    }

}
