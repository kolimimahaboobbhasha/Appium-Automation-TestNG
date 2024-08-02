package AppiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Apidemos {
    public static void main(String[] args) {

        String filepath = "D:\\Github Projects\\MobileAppTesting\\src\\test\\resources\\ApiDemos-debug.apk";

        AppiumDriverLocalService service = null;
        AndroidDriver driver = null;

        try {
            // Start Appium server programmatically
            service = new AppiumServiceBuilder()
                    .withAppiumJS(new File("C:\\Users\\BhashaMahaboobKolimi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .usingAnyFreePort()
                    .build();
            service.start();
            System.out.println("Appium server started at: " + service.getUrl());

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
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Custom View\"]")).click();

            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            if (service != null) {
                service.stop();
                System.out.println("Appium server stopped");
            }
        }
    }
}
