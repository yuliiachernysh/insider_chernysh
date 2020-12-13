package uiTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;
import configs.ConfigProperties;
import configs.ConfigurationProvider;
import org.junit.After;
import org.junit.Before;
import pages.CareerPage;
import pages.JobPage;
import pages.MainPage;

public class ParentTest {
    protected ConfigProperties configProperties;
    protected String baseUrl;
    protected MainPage mainPage;
    protected CareerPage careerPage;
    protected JobPage jobPage;




    @Before
    public void setUp(){
        this.configProperties= ConfigurationProvider.getConfiguration();
        baseUrl = configProperties.baseUrl();
        Configuration.browser = this.configProperties.browser();

        mainPage = new MainPage("");
        careerPage = new CareerPage("career/");
        jobPage = new JobPage("");

        Configuration.pageLoadStrategy="eager";
    }

    @After
    public void tearDown(){

    }
}
