package controllers;

import helpers.ReadConfigHelper;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class SauceLabController implements WebDriverController
{
    private WebDriver driver;
    private ReadConfigHelper helper = new ReadConfigHelper();
    public SauceLabController()
    {
        setupController();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setupController()
    {
        String sauceURL =helper.readSauceLabUrl();
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("sauce:options", getSauceOpts());
        capabilities.setCapability("goog:chromeOptions", getChromeOptions());
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformVersion", "Windows 10");
        capabilities.setCapability("browserVersion",  helper.readBrowserVersion());
        try
        {
            driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
        }
        catch (MalformedURLException ex)
        {

        }

    }


    private ChromeOptions getChromeOptions()
    {
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);
        return chromeOpts;
    }

    private MutableCapabilities getSauceOpts()
    {
        String sauceUserName = helper.readSauceLabUserName();
        String sauceAccessKey = helper.readSauceLabAccessKey();
        List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4", "javaTest");
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUserName);
        sauceOpts.setCapability("accessKey", sauceAccessKey);
        /** In order to use w3c you must set the seleniumVersion **/
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("name", "4-best-practices");
        sauceOpts.setCapability("tags", tags);
        sauceOpts.setCapability("maxDuration", 3600);
        sauceOpts.setCapability("commandTimeout", 600);
        sauceOpts.setCapability("idleTimeout", 1000);
        sauceOpts.setCapability("build", "Onboarding Sample App - Java-Junit5");
        return sauceOpts;
    }

    @Override
    public void teardownController() {

    }
}
