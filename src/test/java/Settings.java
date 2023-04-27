import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Settings {

    private AndroidDriver driver;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Anbu");
        desiredCapabilities.setCapability("appium:udid", "69217b32");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "12 SKQ1.211019.001");
        desiredCapabilities.setCapability("appium:appPackage", "com.xiaomi.misettings");
        desiredCapabilities.setCapability("appium:appActivity", "com.xiaomi.misettings.usagestats.ui.NewAppCategoryListActivity");
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
    public void sampleTest() {


        WebElement app=driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]"));
        app.click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.TextView")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement toggle= driver.findElement(By.id("android:id/checkbox"));
        toggle.click();
        toggle.isEnabled();



    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}

