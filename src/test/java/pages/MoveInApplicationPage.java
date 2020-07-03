package pages;

import models.AmenityIconModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class MoveInApplicationPage extends PageObject {

    @FindBy(xpath = "//a[text()=' Manage Kiosk ']")
    private WebElementFacade managekioskdetailview;
    @FindBy(xpath = "//a[text()=' Configure ']")
    private WebElementFacade configureButton;
    @FindBy(xpath = "(//a[text()='Manage'])[1]")
    private WebElementFacade managebutton;
    @FindBy(xpath = "//select[@name='amenityTypeId']")
    private WebElementFacade selectamenity;
    @FindBy(xpath = "//label[@class='kt-checkbox kt-checkbox--brand']//span")
    private WebElementFacade chkbox;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElementFacade addbutton;
    @FindBy(xpath = "//select[@class='custom-select custom-select-sm form-control form-control-sm']")
    private WebElementFacade showeentriesDrpdown;
    @FindBy(xpath = "(//em[@title='Delete'])[1]")
    private WebElementFacade deleteamenity;
    @FindBy(xpath = "//label[contains(@class,'kt-checkbox kt-checkbox--brand')]//span")
    private WebElementFacade drivinglincenchkbox;
    @FindBy(xpath = "//a[@class='nav-link']")
    private WebElementFacade tab;
    @FindBy(xpath = "//app-kiosk-detail-move-in//span[@class='slider round']")
    private WebElementFacade togglebtn;
    @FindBy(xpath = "//button[text()=' Apply Changes ']")
    private WebElementFacade applychangesbtn;


    public void verifyMangeKioskDetailViewPage() {
        Assert.assertTrue(managekioskdetailview.waitUntilVisible().isDisplayed());
    }

    public void uploadAmentiesAndIcons() {
        if (configureButton.isVisible()) {
            waitABit(2000);

            configureButton.click();

        } else if (managebutton.isVisible()) {
            waitABit(2000);
            managebutton.click();

        }
    }

    public void selectAmenity() {
        waitABit(2000);
        waitFor(selectamenity).withTimeoutOf(50, TimeUnit.SECONDS).click();
        Select amenity = new Select(selectamenity);
        amenity.selectByIndex(4);
    }

    private String getResourceDire() throws IOException {
        return new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    public void uploadAmenityAndIcon(List<AmenityIconModel> amenityiconModelList) {
        for (AmenityIconModel iconModel : amenityiconModelList) {
            if (StringUtils.isNotBlank(iconModel.getIcon())) {
                try {
                    waitABit(2300);
                    String value = getResourceDire() + File.separator + "uploadIcon" + File.separator + iconModel.getIcon();
                    getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(value);
                    waitABit(5000);
//                    signageInputImage.sendKeys(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void selectCheckBox() {
        boolean bool = chkbox.isSelected();
        System.out.println(bool);
        if (bool == false) {
            chkbox.click();
        }
    }

    public void clicksOnAddButton() {
        addbutton.isEnabled();
        addbutton.click();
    }

    private By clickOnSelectAminities(String Amenities) {
        return By.xpath("//*[text()='" + Amenities + "']");
    }

    public void iSelectAmenetiesType(String Amenities) {
        selectamenity.click();
        waitABit(3000);
        element(this.clickOnSelectAminities(Amenities)).click();
    }

    public void userClicksOnFromShowEntriesDropdown() {
        waitFor(showeentriesDrpdown).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select drpdown = new Select(showeentriesDrpdown);
        drpdown.selectByVisibleText("100");
    }

    public void clicksOnDeleteAmityicon() {
        deleteamenity.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        waitABit(1000);
    }

    public void clicksOnCancelButtonOfDeleteAmityPopup() {
        deleteamenity.click();
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
        waitABit(1000);
    }
    public void clicksOnFieldAndCriteriaTab() {
        tab.click();
    }

    public void userClicksOnCheckboxOfDrivingLicenseNumber() {
        boolean bool = drivinglincenchkbox.isSelected();
        System.out.println(bool);
        if (bool == false) {
            drivinglincenchkbox.click();
        }
    }

    private By selectRadioElement(String RadioButton, int index) {
        return By.xpath("//label[contains(text(),'" + RadioButton + "')][" + index + "]");
    }

    public void selectDropOrPopUp(String arg0, int index) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element(selectRadioElement(arg0, index))).click().build().perform();
        if (arg0.equals(" Dropdown View ")) {
            index = 2;
        } else if (arg0.equals(" Pop Up View ")) {
            index = 1;
        }
    }

    public void userClicksOnToggleButton() {
        if (togglebtn.isSelected()) {

            togglebtn.click();
        }
    }
    public void userClicksOnApplyChangesButton() {
        applychangesbtn.click();
    }
}