import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Bookmyshow {

    private AndroidDriver driver;

    @BeforeSuite
    public void newsetUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Anbu");
        desiredCapabilities.setCapability("appium:udid", "*******");
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
    @Test
    public void ticketBook() throws InterruptedException {
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
        WebElement element =driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='BookMyShow']"));
        element.click();

        Thread.sleep(10000);
//      WebElement aaa= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text('Rudhran')");
        String word="Kasethan Kadavulada";
        WebElement element1=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+word+"\").instance(0))"));

//        Actions actions= new Actions(driver);
//        actions.moveToElement(element1);
//        actions.release().perform();

        String texts = "Ayothi";
        WebElement el = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsHorizontalList().scrollIntoView(" + "new UiSelector().textContains(\""+texts+"\"));"));
        el.click();
        System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>"+el);


    }
}
