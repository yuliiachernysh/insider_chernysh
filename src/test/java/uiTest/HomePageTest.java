package uiTest;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends ParentTest {

    @Test
    public void HomePageOpenedTest(){
        Selenide.open(baseUrl);
        Assert.assertTrue(mainPage.isGetDemoButtonVisible());
    }
}
