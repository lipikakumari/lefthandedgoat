package tests;

import Pages.HomePage;
import base.BaseDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CanopyTest extends BaseDriver {

    @Test  //Should have title: "canopy testing page"
    public void validateTitle() {
        assertEquals("canopy testing page", driver.getTitle());
    }

    @Test //Should be able to enter data to Text field 1
    public void enterDataToTextField1() {
        String  expectedText ="TestData";
        assertEquals(expectedText, new HomePage(driver).enterTextField1(expectedText).getTextFieldOne());
    }

    @Test //Should display "ajax loaded" message
    public void displayAjaxLoaded() {
        assertTrue(new HomePage(driver).waitForAjaxToLoad() );
    }

    @Test //Should be able to select "Item 2" in the first dropdown'
    public void selectItem2InFirstDropDown() {
        String expectedItem = "Item 2";
        assertEquals(expectedItem, new HomePage(driver).selectItemInFirstDropDown(expectedItem).getItemInFirstDropDown());
    }

    @Test //When button "Click Me!!" is clicked, should have text "button clicked"
    public void validateClickMe() {
        String expectedText="button clicked";
        assertEquals(expectedText,new HomePage(driver).clickClickMe().getTextOnButtonClicked());
    }

    @Test //When "Alert Me!" link clicked, should display alert.
    public void validateAlertMe(){
        assertTrue(new HomePage(driver).clickAlertLink().foundAlert());
    }

    @Test  //Should have 70 states options in "#states" dropdown select.
    public void validate70States() {
        assertTrue(new HomePage(driver).sizeOfStateDropdown() == 70);

    }
}
