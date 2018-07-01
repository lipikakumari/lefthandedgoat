package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HomePage extends BasePage {
    @FindBy(id="testfield1")
    private WebElement firstestfield;

    @FindBy(id="ajax")
    private WebElement ajaxLabel;

    @FindBy(id="item_list")
    private WebElement firdropdown;

    @FindBy(id="button")
    private WebElement clickMe;

    @FindBy(id="button_clicked")
    private WebElement btnClicked;

    @FindBy(id="alert")
    private WebElement alertLink;

    String ajax ="ajax";

    public HomePage(WebDriver driver){
        super(driver);
    }


    public HomePage enterTextField1(String data){
        this.firstestfield.clear();
        this.firstestfield.sendKeys(data);
        return this;
    }

    public String getTextFieldOne() {
        return this.firstestfield.getAttribute("value");
    }

    public HomePage selectItemInFirstDropDown(String item) {
        Select dropdown = new Select(this.firdropdown);
        dropdown.selectByVisibleText(item);
        return this;
    }

    public String getItemInFirstDropDown() {
        Select dropdown = new Select(this.firdropdown);
        return dropdown.getFirstSelectedOption().getText();

    }

    public boolean waitForAjaxToLoad(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.textToBe(By.id(ajax), "ajax loaded"));
            return true;
        }catch(Exception e){
            e.getMessage();
            return false;
        }
    }

    public HomePage clickClickMe(){
        this.clickMe.click();
        return this;
    }

    public String getTextOnButtonClicked() {
        return this.btnClicked.getText();

    }


    public HomePage clickAlertLink(){
        this.alertLink.click();
        return this;
    }



    public boolean foundAlert(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
            driver.switchTo().alert().accept();
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }


    public int sizeOfStateDropdown() {
        Select dropdown = new Select(driver.findElement(By.id("states")));
        List<WebElement> options = dropdown.getOptions();
        return options.size();

    }




}
