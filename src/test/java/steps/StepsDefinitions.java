package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.lang.*;
import java.util.concurrent.TimeUnit;

public class StepsDefinitions {

    private WebDriver driver;
    private Page currentPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Zinoviy/Documents/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("User is connected to the Internet")
    public void userIsConnectedToInternet() {
        assert true;
    }

    @Then("Page title is {string}")
    public void pageTitle(String title) {
        assert currentPage.titleEqualsTo(title);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @When("User is on {string}")
    public void userIsOnPage(String pageName) {
        if (pageName.equalsIgnoreCase("Main")) {
            currentPage = new MainPage(driver);
        }
        if (pageName.equals("Careers")) {
            currentPage = new CareersPage(driver);
        }
        if (pageName.equals("About")) {
            currentPage = new AboutPage(driver);
        }
        currentPage.goToPage();
    }

    @When("User clicks language button")
    public void userClicksFindButton() {
        currentPage.clickFindButton();
    }

    @And("User clicks Search Button")
    public void userClicksSearchButton() {

    }

    @When("User select keyword {string}")
    public void userSelectKeyword(String keyword) {
        currentPage.setKeywordField(keyword);
    }

    @Then("User go to page")
    public void userGoToPage() {
    }

    @When("User select location {string}")
    public void userSelectLocation(String location) {
        //currentPage.clickLocation();
        currentPage.setLocationField(location);
    }

    @Then("Menu is visible")
    public void menuIsVisible() {
        assert currentPage.isMenuVisible();
    }

    @Then("User see {string}")
    public void userSee(String result) {
        assert currentPage.resultEqualsTo(result);
    }
}
