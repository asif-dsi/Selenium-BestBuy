package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utillities.Utils;

import java.time.Duration;
import java.util.List;

public class TC_02 {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils;

    public TC_02(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "hamburger-menu-button")
    WebElement btnMenu;
    @FindBy(className = "caret-right")
    List<WebElement> subMenu;
    @FindBy(css = "button[data-lid='ubr_cp_ld']")
    WebElement subMenu2;
    @FindBy(css = "a[data-lid='ubr_cp_ld_lnb']")
    WebElement laptopBtn;
    @FindBy(xpath = "//a[contains(text(),'PC Laptops')]")
    WebElement navLink;
    @FindBy(className = "sku-title")
    List<WebElement> assertSku;

    public void search() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        utils = new Utils(driver);
        utils.pleaseWait(btnMenu);
        btnMenu.click();
        subMenu.get(6).click();
        System.out.println("What?");
        subMenu2.click();
        laptopBtn.click();
        utils.pleaseWait(navLink);
        navLink.click();
        for (int i = 0; i < assertSku.size(); i++) {
            String a = assertSku.get(i).getText();
            Assert.assertTrue(a.contains("Laptop"));
            System.out.println("Asserted");
        }
    }
}
