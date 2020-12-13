package uiTest;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

public class CareerTest extends ParentTest {

    @Test
    public void CultureNavigationTest(){
        Selenide.open(this.configProperties.baseUrl());
        mainPage.clickOnCareerTab();
        careerPage.clickOnCultureButton();
        Assert.assertTrue(careerPage.isCultureBlockVisible());
    }

    @Test
    public void TeamNavigationTest(){
        Selenide.open(this.configProperties.baseUrl());
        mainPage.clickOnCareerTab();
        careerPage.clickOnTeamButton();
        Assert.assertTrue(careerPage.isTeamBlockVisible());
    }

    @Test
    public void JobsNavigationTest(){
        Selenide.open(this.configProperties.baseUrl());
        mainPage.clickOnCareerTab();
        careerPage.clickOnJobsButton();
        Assert.assertTrue(careerPage.isJobsBlockVisible());
    }

    @Test
    public void LocationNavigationTest(){
        Selenide.open(this.configProperties.baseUrl());
        mainPage.clickOnCareerTab();
        careerPage.clickOnLocationButton();
        Assert.assertTrue(careerPage.isLocationBlockVisible());
    }

    @Test
    public void LifeAtInsiderNavigationTest(){
        Selenide.open(this.configProperties.baseUrl());
        mainPage.clickOnCareerTab();
        careerPage.clickOnLifeButton();
        Assert.assertTrue(careerPage.isLifeBlockVisible());
    }
}
