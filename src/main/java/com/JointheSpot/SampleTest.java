package com.JointheSpot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SampleTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String browserstackUsername = System.getenv("BROWSERSTACK_USERNAME");
        String browserstackAccessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browserstack.appstore_distribution", "public");
        caps.setCapability("browserstack.user", browserstackUsername);
        caps.setCapability("browserstack.key", browserstackAccessKey);

        // Initialize WebDriver for Chrome on Windows
        driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
    }

    @Test
    public void testJoinTheSpot() {
        // Navigate to jointhespot.com
        driver.get("https://dev.d1oh6kkp7wvoqq.amplifyapp.com");

        WebElement element = driver.findElement(By.xpath("abc"));
        //a[@data-bs-toggle='modal' and @data-bs-target='#login-popup' and contains(@class, 'btn-login') and text()='Login']
        element.click();
        System.out.println("Element clicked");

        // Add assertions or verifications here
        // For example:
        assertTrue("Element should be displayed after clicking", element.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
