package com.JointheSpot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SampleTest {
    private WebDriver driver;

    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");

        // Initialize WebDriver for Chrome on Windows
        driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
    }

    public void testJoinTheSpot() {
        // Navigate to jointhespot.com
        driver.get("https://dev.d1oh6kkp7wvoqq.amplifyapp.com");

        WebElement element = driver.findElement(By.xpath("//a[@data-bs-toggle='modal' and @data-bs-target='#login-popup' and contains(@class, 'btn-login') and text()='Login']"));
        element.click();
        System.out.println("Element clicked");

    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) throws Exception {
        SampleTest test = new SampleTest();

        // Run tests on Chrome
        test.setUp();
        test.testJoinTheSpot();
        test.tearDown();
    }
}
