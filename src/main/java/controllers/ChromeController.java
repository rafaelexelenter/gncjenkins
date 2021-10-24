package controllers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeController implements WebDriverController
{
    public ChromeController(){
        setupController();
    }
    private WebDriver driver;
    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setupController() {
        String resource = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", resource);
        driver = new ChromeDriver();
    }
}
