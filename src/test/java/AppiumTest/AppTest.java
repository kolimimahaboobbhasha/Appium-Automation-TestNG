package AppiumTest;

import Baseclass.BaseTest;
import PomPages.Homepage;
import PomPages.Loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    @Test
    public  void TestAPp() throws InterruptedException {
        Loginpage loginpage=new Loginpage(driver);
        loginpage.navigateToCustomView();
        System.out.println(" App Testing Done");
    }
}
