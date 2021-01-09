package Pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class searchBrowser {

    private WebDriver driver;
    @Before
    public void openBrowser() {
        System.getProperty("webdriver.chrome.driver", "C:\\Users\\sonup\\ARGOS_TESTING\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
    }
    // search text Box code
    public void doSearch( String item) throws InterruptedException {
        WebElement searchTxtBox = driver.findElement(By.id("searchTerm"));
        searchTxtBox.sendKeys(item);
        //by key enter
        searchTxtBox.sendKeys(Keys.ENTER);
        sleep(3000);
    }
    // Select Product to Add to trolley code
    public String selectAnyProduct() throws InterruptedException {
        //select a product
        List<WebElement> productList = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        int indexNumber = randomNumber(productList.size());
        WebElement selectElement = productList.get(indexNumber);
        String expected = selectElement.getText();
        selectElement.click();
        sleep(5000);
        return expected;
    }
    public void addToTrolley() throws InterruptedException {
        //add to trolley
        driver.findElement(By.cssSelector(".add-to-trolley-main")).click();
        sleep(9000);
    }
    public void goToTrolley() throws InterruptedException {
        //go to trolley
        driver.findElement(By.linkText("Go to Trolley")).click();
        sleep(9000);
    }
    public int randomNumber(int size){
        Random random = new Random();
        return random.nextInt(size-1);

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
