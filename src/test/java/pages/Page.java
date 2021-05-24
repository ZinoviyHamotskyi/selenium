package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

class UrlHelper {
    public static String makeUrl(String base, String page) {
        page = page.toLowerCase(Locale.ROOT);
        page = page.replaceAll(" ", "-");
        return base + page;
    }
}

public abstract class Page {
    private final WebDriver driver;

    @FindBy(xpath = "//*[contains(@class, 'search-result__heading')]")
    protected WebElement resultHeader ;

    @FindBy(xpath = "//*[contains(@class, 'recruiting-search__submit')]")
    protected WebElement findButton;

    @FindBy(xpath = "//*[contains(@id, 'new_form_job_search_1445745853_copy-keyword')]")
    protected WebElement keywordField;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[3]/section/div/div[2]/div/section/form/div[2]/div/span/span[1]/span/span[1]")
    protected WebElement locationField;

    @FindBy(xpath = "//*[contains(@class, 'header-ui')]")
    protected WebElement menu;

    Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void visitPage(String address) {
        String url = UrlHelper.makeUrl("https://www.epam.com/", address);
        driver.get(url);
    }

    public abstract void goToPage();

    public boolean isMenuVisible() {
        return menu.isDisplayed();
    }

    public void clickFindButton() { findButton.click(); }

    public void clickLocation(){ locationField.click(); }
    public void setKeywordField(String keyword){ keywordField.sendKeys(keyword); }

    public void setLocationField(String location){
        System.out.println(locationField.getText());
        locationField.click();
        if (location.equalsIgnoreCase("All Locations")) {
            WebElement allLocations = driver.findElement(By.xpath("//*[@id=\"select2-new_form_job_search_1445745853_copy-location-result-p0cd-all_locations\"]"));
            allLocations.click();
        }
        else {
            WebElement locationFieldInput = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[3]/section/div/div[2]/div/section/form/div[2]/div/span[2]/span/span[1]/input"));
            locationFieldInput.sendKeys(location + '\n');
        }
        System.out.println(locationField.getText());

    }

    public boolean resultEqualsTo(String result){
        return resultHeader.getText().equalsIgnoreCase(result);
    }

    public boolean titleEqualsTo(String title) {
        return driver.getTitle().equalsIgnoreCase(title);
    }
}