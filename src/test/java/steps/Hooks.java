package steps;


import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.WebDriverController;
import helpers.ReadConfigHelper;
import io.cucumber.java.*;
import io.cucumber.java8.En;

import java.lang.reflect.Type;

public class Hooks implements En {
    private WebDriverController driver;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private ReadConfigHelper readConfigHelper;
    public Hooks(WebDriverController driver, ReadConfigHelper readConfigHelper)
    {
        this.driver = driver;
        this.readConfigHelper = readConfigHelper;
    }

    @Before
    public void SetUp() {

        driver.getDriver().get(readConfigHelper.readTestUrl());
        driver.getDriver().manage().window().maximize();
    }

    @After
    public void Finish() {
        driver.getDriver().close();
        if(driver.getDriver() != null)
        {
            driver.getDriver().quit();
        }
    }

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

}
