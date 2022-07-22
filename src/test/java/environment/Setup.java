package environment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import utillities.Utils;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utils utils = new Utils(driver);
            utils.takeScreenShot();
        }
    }
}
