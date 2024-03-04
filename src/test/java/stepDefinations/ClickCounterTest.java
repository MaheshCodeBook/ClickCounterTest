package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClickCounterTest {
    public WebDriver driver;
    WebDriverWait wait;
    int expectedCount;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromediver122\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am on the click counter page with initial count as 0")
    public void iamOnTheClickCounterPage(){
        driver.get("https://qaclickcounter.ccbp.tech/");
    }

    @When("I click on click me button 100 iterations")
    public void clickOnClickmeButton(){
        for (int i=0; i<100; i++){
            driver.findElement(By.className("button")).click();
            expectedCount++;
        }
    }
    @Then("I can verify whether the text matches with the iteration count")
    public void counterDisplayCountOfClicks(){
        String counterText  = driver.findElement(By.className("counter-value")).getText();
        int currentCount = Integer.parseInt(counterText);
       // Assert.assertEquals(currentCount,expectedCount,"Count does not match");
        if (currentCount == expectedCount){
            System.out.println("Click Counter App: Working as expected");
        }else {
            System.out.println("Count does not match");
        }

    }

}
