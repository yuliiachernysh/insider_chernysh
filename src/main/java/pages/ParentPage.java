package pages;

import configs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;

public abstract class ParentPage {
    protected ConfigProperties configProperties;
    String baseUrl;
    String pageUrl;
    protected Integer defaultTimeout;
    //Logger logger = Logger.getLogger(getClass());

    public ParentPage(String partURL){
        String environmentName = System.getProperty("TestEnvironment");
        ConfigFactory.setProperty("env", environmentName);
        configProperties = ConfigFactory.create(ConfigProperties.class);


        defaultTimeout=configProperties.defaultTimeout();
        baseUrl = configProperties.baseUrl();
        pageUrl= baseUrl + partURL;
    }

    protected void setPartUrl(String partUrl){
        pageUrl = baseUrl + partUrl;
    }
}
