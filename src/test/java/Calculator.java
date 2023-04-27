
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Calculator {

    private AndroidDriver driver;

    @BeforeSuite
    public void setUpTheCap() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Anbu");
        desiredCapabilities.setCapability("appium:udid", "******");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "12 SKQ1.211019.001");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        desiredCapabilities.setCapability("appium:allowTestPackages", true);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);


        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void sampleTest() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element1= driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
       element1.click();
       WebElement element2=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
       element2.click();
       WebElement element3= driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"5\"]"));
       element3.click();
       WebElement v= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TextView"));
        Assert.assertTrue(v.isDisplayed());

    }@AfterTest
    public void close() {
    driver.quit();
   }
}