package StepDefinations;

import Pages.searchBrowser;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchStep {
    private searchBrowser searchBrowser = new searchBrowser();
    @Given("^open the browser and search the searchbar$")
    public void open_the_browser_and_search_the_searchbar() throws Throwable {
        searchBrowser.openBrowser();
    }

    @When("^search the product Nike$")
    public void search_the_product_Nike() throws Throwable {
      searchBrowser.doSearch("Nike");
    }

    @When("^hit the search button$")
    public void hit_the_search_button() throws Throwable {
        searchBrowser.selectAnyProduct();
        searchBrowser.addToTrolley();
        //searchBrowser.goToTrolley();
    }

    @Then("^show the respective product item$")
    public void show_the_respective_product_item() throws Throwable {
        searchBrowser.closeBrowser();
    }

}
