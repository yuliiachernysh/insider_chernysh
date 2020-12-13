package uiTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CareerFilterTest extends ParentTest{
    protected String location = "Istanbul, Turkey";
    protected String position = "Quality Assurance";

    @Test
    public void BaseFilerTest(){
        Selenide.open(baseUrl);
        mainPage.clickOnCareerTab();
        careerPage.scrollToCareerOpportunities();
        careerPage.clickOnLocationFilter();
        careerPage.clickOnLocation(location);
        careerPage.clickOnJobFilter();
        careerPage.clickOnJob(position);
        Assert.assertTrue(careerPage.isJobListDisplayed());
    }

    @Test
    public void NavigateByPositionTest() {
        Selenide.open(baseUrl);
        mainPage.clickOnCareerTab();
        careerPage.scrollToCareerOpportunities();
        careerPage.clickOnLocationFilter();
        careerPage.clickOnLocation(location);
        careerPage.clickOnJobFilter();
        careerPage.clickOnJob(position);
        careerPage.clickOnFirstElementInJobList();
        Assert.assertTrue(jobPage.checkIfElementsDisplayed());
    }

    @Test
    public void ApplicationFormTest() {
        Selenide.open(baseUrl);
        mainPage.clickOnCareerTab();
        careerPage.scrollToCareerOpportunities();
        careerPage.clickOnLocationFilter();
        careerPage.clickOnLocation(location);
        careerPage.clickOnJobFilter();
        careerPage.clickOnJob(position);
        careerPage.clickOnFirstElementInJobList();
        jobPage.clickOnApplyButton();
        Assert.assertTrue(jobPage.isApplicationFormDisplayed());
    }

    @Test
    public void JobsFilterResultTest() throws InterruptedException {
        Selenide.open(baseUrl);
        mainPage.clickOnCareerTab();
        careerPage.scrollToCareerOpportunities();
        careerPage.clickOnLocationFilter();
        careerPage.clickOnLocation(location);
        careerPage.clickOnJobFilter();
        careerPage.clickOnJob(position);

        ArrayList<ElementsCollection> jobs = careerPage.getJobElements();
        for (ElementsCollection jobItems:
             jobs) {
            List<String> textItems = jobItems.texts();
            Assert.assertEquals(3, textItems.size());
            Assert.assertTrue(textItems.get(0).contains(position));
            Assert.assertEquals(position, textItems.get(1));
            Assert.assertEquals(location, textItems.get(2));
        }
        Assert.assertTrue(careerPage.isJobListDisplayed());
    }
}
