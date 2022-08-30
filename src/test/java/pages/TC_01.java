package pages;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillities.Utils;

import java.io.IOException;

public class TC_01 {
    WebDriver driver;
    WebDriverWait wait;
    Faker faker;
    Utils utils;

    public TC_01(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/usa.svg']")
    WebElement usFlag;
    @FindBy(className = "shop-account-menu")
    WebElement dropDownAccount;
    @FindBy(xpath = "//a[contains(text(), 'Create Account')]")
    WebElement btnCreateAcc;
    @FindBy(id = "firstName")
    WebElement first;
    @FindBy(id = "lastName")
    WebElement last;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "fld-p1")
    WebElement pass;
    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "reenterPassword")
    WebElement confirmPass;
    @FindBy(css = "button[type='submit']")
    WebElement btnSubmit;

    public void step_1() {
        usFlag.click();
    }

    public void step_2() {
        utils = new Utils(driver);
        utils.pleaseWait(dropDownAccount);
        dropDownAccount.click();
        utils.pleaseWait(btnCreateAcc);
        btnCreateAcc.click();
    }

    public void doSignUp() throws IOException, ParseException {
        faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fakeEmail = firstName.toLowerCase() + lastName.toLowerCase() + "@slaydemon.com";
        String fakePass = faker.internet().password(8, 15);
        String fakePhone = faker.phoneNumber().cellPhone();

        utils = new Utils(driver);
        utils.inputJSONArray(fakeEmail, fakePass);

        utils.pleaseWait(first);
        first.sendKeys(firstName);
        last.sendKeys(lastName);
        email.sendKeys(fakeEmail);
        pass.sendKeys(fakePass);
        confirmPass.sendKeys(fakePass);
        phone.sendKeys(fakePhone);
        utils.pleaseWait(btnSubmit);
        btnSubmit.click();
    }
}
