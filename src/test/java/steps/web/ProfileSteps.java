package steps.web;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.ProfileModel;
import net.serenitybdd.core.pages.PageObject;
import pages.ProfilePage;
import pages.UserManagementPage;
import utilities.ConfigLoader;
import java.io.IOException;
import java.util.List;


public class ProfileSteps extends PageObject {
    private ProfileModel profileModel = new ProfileModel();
    ProfilePage profilePage;
    UserManagementPage users;

    private Config conf = ConfigLoader.load();

    @Given("^user is on the dashboard page of workorder application$")
    public void userIsOnAddFacilityScreen() {

    }

    @When("^I clicking on Account owner button$")
    public void iClickingOnAccountOwnerButton() {
        profilePage.setOwnername();
    }

    @And("^I clicking on the profile button that is in left navigation bar$")
    public void iClickingOnTheProfileButtonThatIsInLeftNavigationBar() {
        profilePage.myprofile();
    }

    @Then("^verify the profile details$")

    public void verifyTheProfileDetails(List<String> header) {
        profilePage.verifytheprofiledetails(header);
    }

    @Given("^user is on the profile page$")
    public void userIsOnTheProfilePage() {
        profilePage.profileHeading();

    }

    @And("^user click on the action button$")
    public void userClickOnTheActionbutton() {
        profilePage.actionButton();
    }

    @When("^I  clicking  on the \"([^\"]*)\" button$")
    public void iClickingOnTheButton(String textbutton) throws Throwable {
        profilePage.editbutton(textbutton);
    }

    @Then("^user should to redirects to the edit page$")
    public void userShouldToRedirectsToTheEditPage() {
        profilePage.verifyHeader();
    }


    @And("^Edit the profile details$")
    public void editTheProfileDetails(DataTable Credentials) {
        profilePage.editProfile(Credentials);

    }

    @And("^User clicks on submit button$")
    public void userClicksOnSubmitButton() {

        profilePage.submitButton();
    }


    @And("^I clicking on the cancel button$")
    public void iClickingOnTheCancelButton() {
        profilePage.cancelbutton();

    }

    @Then("^user redirects to the profile page$")
    public void userRedirectsToTheProfilePage() {
        profilePage.myprofilepage();

    }

    @And("^user erase all the data from all the input box$")
    public void userEraseAllTheDataFromAllTheInputBox() {
        profilePage.clearData();
    }

    @Then("^Error message should be \"([^\"]*)\" displayed$")
    public void errorMessageShouldBeDisplayed(String Text) throws Throwable {
        profilePage.validationMessage(Text);
    }


    @And("^user taps on the submit button$")
    public void userTapsOnTheSubmitbutton() {
        profilePage.submitButton1();
    }

    @When("^User user enter incorrect password in the old password and enter same password in the new password and confirm passwordfield$")
    public void userUserEnterIncorrectPasswordInTheOldPasswordAndEnterSamePasswordInTheNewPasswordAndConfirmPasswordfield(DataTable data) {
        profilePage.oldpasswordIncorrect(data);

    }


    @Then("^Error message should come \"([^\"]*)\"$")
    public void errorMessageShouldCome(String validationmessage) {
        profilePage.invalidoldPassword();
    }


    @And("^user tap on the cancel button$")
    public void userTapOnTheCancelButton() {
        profilePage.changePasscancelbutton();
    }

    @Then("^user should redirects to the profile page$")
    public void userShouldRedirectsToTheProfilePage() {
        profilePage.verifyProfilepage();
    }

    @Then("^the error message is displayed$")
    public void theErrorMessageIsDisplayed(List<String> errormessage) {
        for (String option : errormessage) {
            profilePage.errorMessage(option);
        }
    }


    @And("^User click on \"([^\"]*)\" button$")
    public void userClickOnButton(String button) throws Throwable {
        profilePage.cancelButton(button);
    }

    @And("^User click on side menu of \"([^\"]*)\" button$")
    public void userClickOnSideMenuOfButton(String SideMenu) throws Throwable {
        profilePage.profileButton(SideMenu);
    }


    @When("^User enter change password details$")
    public void userEnterChangePasswordDetails(DataTable InvalidCredentials) throws Throwable {
        profilePage.changeInvalidPassword(InvalidCredentials);

    }


    @Then("^The error message is displayed as \"([^\"]*)\"$")
    public void theErrorMessageIsDisplayedAs(String ErrorMesaage) throws Throwable {
        profilePage.verifyMessage(ErrorMesaage);
    }


    @Then("^User upload new profile picture$")
    public void userUploadNewProfilePicture() throws IOException {
        users.uploadProfilePicture();
    }

    @Then("^user change the profile picture$")
    public void userChangeTheProfilePicture() throws IOException {
        profilePage.changeProfilePicture();


    }

    @Then("^user  remove the profile picture$")
    public void userRemoveTheProfilePicture() {
        profilePage.userRemovesTheProfilePicture();
    }

    @Then("^user verify the Edit profile$")
    public void userVerifyTheEditProfile() {
        profilePage.userVerifyTheProfileDetails();
    }
}





