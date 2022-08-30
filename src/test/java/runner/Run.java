package runner;

import environment.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.TC_01;
import pages.TC_02;

import java.io.IOException;

public class Run extends Setup {

    @Test(priority = 1)
    public void run1() throws IOException, ParseException {
        driver.get("https://www.bestbuy.com");
        TC_01 tc_01 = new TC_01(driver);
        tc_01.step_1();
        tc_01.step_2();
        tc_01.doSignUp();
    }

    @Test(priority = 2)
    public void run2() {
        driver.get("https://www.bestbuy.com");
        TC_01 tc_01 = new TC_01(driver);
        //tc_01.step_1();
        TC_02 tc_02 = new TC_02(driver);
        tc_02.search();
    }
}
