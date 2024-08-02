package PomPages;



import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    protected AndroidDriver driver;
    WebDriverWait wait;

    public Homepage(AndroidDriver driver) {
        this.driver = driver;
//        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
    WebElement apidemos;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]")
    WebElement apa;

    public void navigateToCustomView() {
      apidemos.click();
      apa.click();

    }
}
