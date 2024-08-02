package PomPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {


AndroidDriver driver;

    public Loginpage(AndroidDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]") public WebElement Accessebility;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]") public WebElement customview;





    public void navigateToCustomView() throws InterruptedException {

        Accessebility.click();
        Thread.sleep(3000);
        customview.click();

    }
}
