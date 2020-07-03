package pages;

import cucumber.api.DataTable;
import models.ContentModel;
import models.ImageModel;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.LoadProperties;
import utilities.RandomGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignageApplicationPage extends PageObject {

    public static String registrationKey;
    public static String tag;
    public static String title;
    public static String description;
    public static String internalDescription;
    @FindBy(xpath = "//span[text()='Kiosks']")
    private WebElementFacade Verifykioskpage;
    @FindBy(xpath = "//a[@href='/kiosk/add/1']")
    private WebElementFacade registerkioskbutton;
    @FindBy(xpath = "//select[@name='facilityId']")
    WebElementFacade selectFacility;
    @FindBy(xpath = "//input[@name='registrationKey']")
    WebElementFacade enterregistrationkey;
    @FindBy(xpath = "//input[@name='tag']")
    WebElementFacade entertagvalue;
    @FindBy(xpath = "//button[text()='Configure ']")
    WebElementFacade configurebutton;
    @FindBy(xpath = "//a[text()=' Manage Kiosk ']")
    WebElementFacade managekioskpage;
    @FindBy(xpath = "//select[@name='DataTables_Table_1_length']")
    WebElementFacade showentries;
    @FindBy(xpath = "(//span[@class='link'])[1]")
    WebElementFacade selecttag;
    @FindBy(xpath = "//a[@class='btn btn-lg btn-primary']")
    private WebElementFacade uploadcontentbutton;
    @FindBy(xpath = "//input[@name='title']")
    private WebElementFacade addtitle;
    @FindBy(xpath = "//div[@class='toast-message ng-star-inserted']/..")
    private WebElementFacade errorPopup;
    @FindBy(xpath = "//*[@class='paginate_button page-item active']//a[text()='1']")
    private WebElementFacade pagination;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElementFacade adddescription;
    @FindBy(xpath = "//textarea[@name='internalDescription']")
    private WebElementFacade addinternaldescription;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElementFacade submitbtn;
    @FindBy(xpath = "//button[text()=' Choose file ']")
    private WebElementFacade signageImage;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement signageInputImage;
    @FindBy(xpath = "//button[text()='Upload']")
    private WebElement donebtn;
    @FindBy(xpath = "//a[text()='Manage']")
    private WebElementFacade managebtn;
    @FindBy(xpath = "//a[text()=' Add Content ']")
    private WebElement addcontentBtn;
    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElement cancelbtntBtn;
    @FindBy(xpath = "//span[text()=' Manage Signage ']")
    private WebElement verifymanagesignagepage;
    @FindBy(xpath = "(//em[@class='fa fa-edit cursor-pointer'])[1]")
    private WebElement editbtn;
    @FindBy(xpath = "(//button[@class='btn btn-outline-dark btn-xs m-l-15'])[1]")
    private WebElement changefile;
    @FindBy(xpath = "(//p[@class='w-100 pt-1 text-center'])[2]")
    private WebElement deleteconetnt;
    @FindBy(xpath = "(//button[text()=' Choose file '])[2]")
    private WebElement thumbnail;
    @FindBy(css = "//i[@class='la la-trash']/..")
    private WebElement deletefile;
    @FindBy(xpath = "//div[@class='col-12 text-right form-group']//a[@class='btn btn-sm btn-outline-primary'][contains(text(),'Manage')]")
    private WebElement managecontentbutton;
    @FindBy(xpath = "//app-kiosk-detail-signage//span[@class='slider round']")
    private WebElement signagetogglebutton;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement uploadbuttoninthumbnail;
    @FindBy(xpath = "//div[text()=' Registration key already used ']")
    private WebElement regkeyalreadyexist;
    @FindBy(xpath = "//tr[2]//td[7]//em[1]")
    private WebElement deletetag;
    @FindBy(xpath = "//input[@placeholder='Type DELETE to confirm']")
    private WebElement writetextinsidedeletepopup;
    @FindBy(xpath = "//button[text()='OK']")
    private WebElement deleteteconfirm;
    @FindBy(xpath = "//div[text()=' One other content exist with same title. ']")
    private WebElement sametitleexist;

    private By manageKioskValidation(String options) {
        return By.xpath("//*[contains(text(),'" + options + "')]");
    }

    public void verifyKioskPage() {
        Assert.assertTrue(Verifykioskpage.isVisible());

    }

    public void verifyRegistration() {

        registerkioskbutton.click();
    }

    public void selectFacilityFromDropdown() {
        waitFor(selectFacility).withTimeoutOf(80, TimeUnit.SECONDS).click();
        Select facilityFilter = new Select(selectFacility);
        facilityFilter.selectByVisibleText(" Simonis LLC");

    }

    public void enterRegistrationKeyAndTag(DataTable values) {
        registrationKey = values.asMaps(String.class, String.class).get(0).get("registrationKey");
        tag = values.asMaps(String.class, String.class).get(0).get("tag");
        waitABit(2000);
        waitFor(enterregistrationkey).waitUntilVisible().sendKeys(registrationKey);
        waitFor(entertagvalue).waitUntilVisible().sendKeys(tag + RandomGenerator.randomAlphanumeric(2));

    }

    public void clickingOnConfigureButton() {

        configurebutton.click();
        waitABit(3000);
    }

    public void redirectsManageKioskPage() {
        Assert.assertTrue(managekioskpage.waitUntilVisible().isDisplayed());
    }


    public void errorMessage(String text) {
        WebElementFacade a = element(manageKioskValidation(text));
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(a).shouldBeVisible();
    }

    public void selectTagFromKiosk() {
        waitFor(selecttag).click();
    }

    public void addContentForSignageAppliccation(DataTable text) {
        title = text.asMaps(String.class, String.class).get(0).get("title");
        description = text.asMaps(String.class, String.class).get(0).get("description");
        internalDescription = text.asMaps(String.class, String.class).get(0).get("internalDescription");
        waitFor(addtitle).waitUntilVisible().sendKeys(title + RandomGenerator.randomAlphanumeric(3));
        waitFor(adddescription).waitUntilVisible().sendKeys(description + RandomGenerator.randomAlphabetic(5));
        waitFor(addinternaldescription).waitUntilVisible().sendKeys(internalDescription + RandomGenerator.randomAlphanumeric(5));

    }

    public void submitButton() {
        submitbtn.click();
        waitABit(700);

    }

    private String getResourceDir() throws IOException {
        return new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    public void uploadProductImage(List<ImageModel> imageModelList) {
        for (ImageModel imageModel : imageModelList) {
            if (StringUtils.isNotBlank(imageModel.getImage())) {
                try {
                    waitABit(2000);
                    String value = getResourceDir() + File.separator + "signImage" + File.separator + imageModel.getImage();
                    getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(value);
//                    signageInputImage.sendKeys(value);
                } catch (Exception e) {
                    e.printStackTrace();
                    waitABit(1000);


                }
                donebtn.click();
            }
        }
    }

    public void clicksOnAddContentBtn() {
        waitABit(5000);
        addcontentBtn.click();
    }

    public void clicksOnCanceltBtn() {
        waitABit(5000);
        cancelbtntBtn.click();
    }

    public void redirectionOnManageSignagepage() {
        Assert.assertTrue(verifymanagesignagepage.isDisplayed());
    }

    public void clicksOnEditButton() {

        editbtn.click();
    }

    public void editFile() {
        waitABit(5000);
        changefile.click();
        waitABit(1000);
    }

    public void editAllContentDetails(DataTable details) {
        title = details.asMaps(String.class, String.class).get(0).get("title");
        description = details.asMaps(String.class, String.class).get(0).get("description");
        internalDescription = details.asMaps(String.class, String.class).get(0).get("internalDescription");
        waitFor(addtitle).waitUntilVisible().clear();
        waitFor(addtitle).waitUntilVisible().sendKeys(title + RandomGenerator.randomAlphanumeric(3));
        waitFor(adddescription).waitUntilVisible().clear();
        waitFor(adddescription).waitUntilVisible().sendKeys(description + RandomGenerator.randomAlphabetic(5));
        waitFor(addinternaldescription).waitUntilVisible().clear();
        waitFor(addinternaldescription).waitUntilVisible().sendKeys(internalDescription + RandomGenerator.randomAlphanumeric(5));
    }

    public void clicksOnDeleteContent() {


        deleteconetnt.click();
        waitABit(5000);
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

        waitABit(1000);

    }

    public void clickOnCancelButtonOfDeletePopup() {
        deleteconetnt.click();
        waitABit(5000);
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();

        waitABit(1000);

    }

    public void clicksOndeleteFileIcon() {
        deletefile.click();
        waitABit(10);

    }


    private String getResourceDirctory() throws IOException {
        return new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    public void uploadVideoPdf(List<ContentModel> contentModelList) {
        for (ContentModel contentModel : contentModelList) {
            if (StringUtils.isNotBlank(contentModel.getContent())) {
                try {
                    waitABit(2000);
                    String value = getResourceDirctory() + File.separator + "contentUpload" + File.separator + contentModel.getContent();
                    getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(value);
//                    signageInputImage.sendKeys(value);
                } catch (Exception e) {
                    e.printStackTrace();
                    waitABit(1000);


                }
            }
        }
    }

    public void uploadContentInThumbnail() {
        thumbnail.click();
        waitABit(10);
    }

    public void userClicksOnUploadContentOrManageContentButton() {
        if (uploadcontentbutton.isVisible()) {
            uploadcontentbutton.click();

        } else if (managecontentbutton.isDisplayed()) {
            managecontentbutton.click();
            waitABit(10);
            addcontentBtn.click();
        }
    }

    public void userClicksOnManageButton() {
        managecontentbutton.click();
    }

    public void userClicksOnTheToggleButtonOfSignageApplication() {
        if (signagetogglebutton.isSelected()) {
            signagetogglebutton.click();
        }
    }

    private String getResourceDirctorythumbnail() throws IOException {
        return new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    public void uploadFileInThumbnail(List<ImageModel> imageModelList) {
        for (ImageModel imageModel : imageModelList) {
            if (StringUtils.isNotBlank(imageModel.getImage())) {
                try {
                    waitABit(2000);
                    String value = getResourceDir() + File.separator + "signImage" + File.separator + imageModel.getImage();
                    getDriver().findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(value);
//                    signageInputImage.sendKeys(value);
                } catch (Exception e) {
                    e.printStackTrace();
                    waitABit(1000);
                }
                uploadbuttoninthumbnail.click();
            }
        }
    }

    public void registrationKeyAlreadyExist() {
        regkeyalreadyexist.isDisplayed();
    }



    public void userClicksOnDeleteTag() {
        deletetag.click();
        writetextinsidedeletepopup.sendKeys("DELETE");
        deleteteconfirm.click();
    }

    public void userEnterSameTitle(String title, String description) {
        addtitle.sendKeys(title);
        adddescription.sendKeys(description);
        submitbtn.click();
        waitABit(300);
    }

    public void userEntersTitleThatAlradyExist(DataTable values) throws IOException, ConfigurationException {
        title = values.asMaps(String.class, String.class).get(0).get("title") + RandomGenerator.randomAlphanumeric(3);
        description = values.asMaps(String.class, String.class).get(0).get("description") + RandomGenerator.randomAlphabetic(5);
        waitFor(addtitle).waitUntilVisible().sendKeys(title);
        waitFor(adddescription).waitUntilVisible().sendKeys(description);
        LoadProperties.saveValueInPropertiesFile("title", title, "testData");
    }

    public void titleText() {
        String titlevalue = LoadProperties.getValueFromPropertyFile("testData", "title");
        waitFor(addtitle).waitUntilVisible().clear();
        waitFor(addtitle).waitUntilVisible().sendKeys(titlevalue);

    }

    public void enterTitleDescription() {
        String titlevalue = LoadProperties.getValueFromPropertyFile("testData", "title");
        waitFor(addtitle).waitUntilVisible().sendKeys(titlevalue);
        waitFor(adddescription).waitUntilVisible().sendKeys(description);
    }

    public void errorMessagePopup() {
        element(errorPopup).waitUntilVisible().isDisplayed();
    }

    public void countOfPlansOnlistPage() {
        element("//*[@class='dataTables_paginate paging_full_numbers']/*//a[@tabindex=0]").withTimeoutOf(200, TimeUnit.SECONDS).waitUntilVisible();
        assertThat(findAll("//*[@class='dataTables_paginate paging_full_numbers']/*//a[@tabindex=0]").size() >= 10);
    }

    public void verifyPaginationExists() {
        if (findAll("//*[@class='dataTables_paginate paging_full_numbers']/*//a[@tabindex=0]").size() >= 10) {
            pagination.isDisplayed();
        } else {
            pagination.shouldNotBePresent();
        }
    }

    public void verifyPagination() {
        Scroll.to(By.xpath("//li[@class='paginate_button page-item ']//a"));
        List<WebElement> pagination = getDriver().findElements(By.xpath("//li[@class='paginate_button page-item ']//a"));
        System.out.println(pagination);
        if (pagination.size() > 0) {
            System.out.println("pagination exists");
            for (int i = 1; i < pagination.size(); i++) {
                WebElement NextButton =getDriver().findElement(By.xpath("//li[@class='paginate_button page-item next']"));
                if (NextButton.isEnabled()) {
                    NextButton.click();
                } else {
                    System.out.println("pagination not exists");
                }

            }
        }
    }
}
