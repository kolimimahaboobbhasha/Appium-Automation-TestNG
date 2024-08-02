package Baseclass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    String filepath = "D:\\Github Projects\\MobileAppTesting\\src\\test\\resources\\ApiDemos-debug.apk";

    AppiumDriverLocalService service = null;
    protected AndroidDriver driver = null;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

//        service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C:\\Users\\BhashaMahaboobKolimi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .usingAnyFreePort()
//                .build();
//        service.start();
//        System.out.println("Appium server started at: " + service.getUrl());

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Pixel 8 API 35");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("app", filepath);
        caps.setCapability("uiautomator2ServerInstallTimeout", 120000); // Increase to 2 minutes
        caps.setCapability("newCommandTimeout", 120000); // Increase to 2 minutes

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        System.out.println("Appium started");


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
