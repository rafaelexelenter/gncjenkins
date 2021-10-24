package helpers;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigHelper
{
    private String propFileName = "config.properties";
    private Properties prop = new Properties();

    public ReadConfigHelper()
    {
        initProps();
    }
    public String readBrowserVersion(){return prop.getProperty("browserVersion");}
    public String readEndPointUrl()
    {
        return prop.getProperty("service.url");
    }
    public String readSauceLabUrl(){return prop.getProperty("saucelab.url");}
    public String readSauceLabUserName () {return prop.getProperty("saucelab.username");}
    public String readSauceLabAccessKey(){return prop.getProperty("saucelab.accesskey");}
    public String readRunOnLocal(){return prop.getProperty("runOnLocal");}
    public String readTestUrl(){return prop.getProperty("test.url");}

    private void initProps()
    {
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream == null)
            {
                throw new RuntimeException("property file: '"+ propFileName+"' not found in the classpath");
            }
            prop.load(inputStream);
        }catch (Exception ex)
        {
            throw new RuntimeException(ex.getStackTrace().toString());
        }
    }
}
