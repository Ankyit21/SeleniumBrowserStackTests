package com.JointheSpot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SampleTest {
    private WebDriver driver;

    public void setUp(String browser, String os, String osVersion) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", os);
        caps.setCapability("os_version", osVersion);

        // Set capability for iOS distribution
        if (os.equalsIgnoreCase("iOS")) {
            caps.setCapability("browserstack.appstore_distribution", "public");
        }
        if (os.equalsIgnoreCase("Android")) {
            caps.setCapability("browserstack.appstore_distribution", "public");
        }

        // Initialize WebDriver for specified browser and platform
        driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
    }

    public void testJoinTheSpot() {
        // Navigate to jointhespot.com
        driver.get("https://dev.d1oh6kkp7wvoqq.amplifyapp.com");

       WebElement element = driver.findElement(By.xpath("//a[@data-bs-toggle='modal' and @data-bs-target='#login-popup' and contains(@class, 'btn-login') and text()='Login']"));
        element.click();
        System.out.println("element clicked");

    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) throws Exception {
        SampleTest test = new SampleTest();

        // Run tests on Chrome
        test.setUp("Chrome", "Windows", "10");
        test.testJoinTheSpot();
        test.tearDown();

        // Run tests on Safari
        test.setUp("Safari", "OS X", "Big Sur");
        test.testJoinTheSpot();
        test.tearDown();

        // Run tests on Firefox
        test.setUp("Firefox", "Windows", "10");
        test.testJoinTheSpot();
        test.tearDown();

        // Run tests on iOS
        test.setUp("iPhone", "iOS", "14");
        test.testJoinTheSpot();
        test.tearDown();

        // Run tests on Android
        test.setUp("Android", "Android", "11.0");
        test.testJoinTheSpot();
        test.tearDown();
    }
}
