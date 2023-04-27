import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.W3CActions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Task3 {
    private AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Anbu");
        desiredCapabilities.setCapability("appium:udid", "69217b32");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "12 SKQ1.211019.001");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        desiredCapabilities.setCapability("appium:allowTestPackages", true);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);


    }

    @Test(priority = 1)
    public void actionsDown() {
        TouchAction action = new TouchAction(driver);
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startX = width / 2;
        int endY = (int) (height * 0.8);
        int startY = (int) (height * 0.2);

        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();


    }

    @Test(priority = 0)
    public void actionsUP(){
        TouchAction action = new TouchAction(driver);
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startX = width/2;
        int startY = (int) (height-10);
        int endY = (int) (height*0.2);

        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    @Test(priority = 2)
    public void actionsLeft() {
        TouchAction action = new TouchAction(driver);
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startX = width / 2;
        int endY = (int) (height * 0.8);
        int startY = (int) (height * 0.2);

        action.press(PointOption.point(startY, startX))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endY, startX))
                .release()
                .perform();

    }
    @Test(priority = 3)
    public void actionsRight() {

        TouchAction action = new TouchAction(driver);
        int height = driver.manage().window().getSize().getHeight();
        System.out.println("<<<<<<<<<HEIGHT>>>>>>>>>>" + height);
        int width = driver.manage().window().getSize().getWidth();
        int startX = (int)(width*0.6);
        int startY = (int) (height-1000);
        int endX=(int)(width*0.1);


        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    @Test(priority = 4)
    public void Wifi(){
        driver.openNotifications();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement element= driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Wi-Fi,Off,\"]/android.widget.ImageView"));

        element.click();
        actionsUP();
        TouchAction action= new TouchAction(driver);
        

    }



}

