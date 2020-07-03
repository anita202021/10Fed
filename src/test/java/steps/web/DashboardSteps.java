package steps.web;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DashboardPage;

import java.util.List;

public class DashboardSteps {

    DashboardPage dashboard;

    @Given("^User is on the \"([^\"]*)\" page$")
    public void userIsOnThePage(String arg0) throws Throwable {
        dashboard.verifyHeading(arg0);
    }


    @Then("^User should be able to see the widgets$")
    public void userShouldBeAbleToSeeTheWidgets(List<String> options) {
        for (String option : options) {
            dashboard.verifyHeading(option);
        }
    }

    @Then("^User should be able to see the workorder tiles$")
    public void userShouldBeAbleToSeeTheWorkorderTiles(List<String> options) {
        for (String option : options) {
            dashboard.verifyWorkOrderTiles(option);
        }
    }

    @Then("^User should be able to see the company tiles$")
    public void userShouldBeAbleToSeeTheCompanyTiles(List<String> options) {
        for (String option : options) {
            dashboard.verifyCompanyTiles(option);
        }
    }

    @Then("^User should be able to see the components of Kiosk Heath Status$")
    public void userShouldBeAbleToSeeTheComponentsOfKioskHeathStatus() {
        dashboard.verifyComponentOfHealthStatus();
    }

    @Then("^User should be able to see the components of Offline Kiosk Log$")
    public void userShouldBeAbleToSeeTheComponentsOfOfflineKioskLog() {
        dashboard.verifyComponentOfOfflineLog();
    }

    @And("^User tap on the \"([^\"]*)\" link from side navigation$")
    public void userTapOnTheLinkFromSideNavigation(String arg0)  {
        dashboard.tapOnMenuItems(arg0);
    }

    @When("^User taps on \"([^\"]*)\" tile$")
    public void userTapsOnTile(String arg0) throws Throwable {
        dashboard.tapOnWOSubtitle(arg0);
    }

    @When("^User taps on company \"([^\"]*)\" tile$")
    public void userTapsOnCompanyTile(String arg0) throws Throwable {
        dashboard.tapOnCompanySubtitle(arg0);
    }

    @Then("^User should be redirected to the \"([^\"]*)\" list screen$")
    public void userShouldBeRedirectedToTheListScreen(String arg0) throws Throwable {
        dashboard.verifyHeading(arg0);
    }


    @When("^User observes the \"([^\"]*)\"count displayed$")
    public void userObservesTheCountDisplayed(String workOrderTile) throws Throwable {
        dashboard.countWorkOrdersOnDashboard(workOrderTile);
    }

    @When("^User clicks on the \"([^\"]*)\" tile$")
    public void userClicksOnTheTile(String workOrderTile) throws Throwable {
        dashboard.tapOnWOSubtitle(workOrderTile);
    }

    @Then("^User verifies the number of work order in the list$")
    public void userVerifiesTheNumberOfWorkOrderInTheList() {
        dashboard.verifyItemCountInList();
    }

    @Given("^User is on \"([^\"]*)\" widget$")
    public void userIsOnWidget(String arg0) throws Throwable {
        dashboard.verifyHeading(arg0);
    }


    @Given("^User observes the company \"([^\"]*)\"count displayed$")
    public void userObservesTheCompanyCountDisplayed(List<String> options) {
        for (String option : options) {
            dashboard.observeModuleCountOnDashboard(option);
        }
    }

    @Then("^User verifies the number displayed in the list$")
    public void userVerifiesTheNumberDisplayedInTheList() {
        dashboard.verifyItemCountOfModule();
    }
}
