package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CareerPage extends ParentPage{
    public CareerPage(String partURL) {
        super(partURL);
    }

    SelenideElement cultureButton = $(byXpath(".//a[@href='#culture']"));
    SelenideElement locationButton= $(byXpath(".//a[@href='#locations']"));
    SelenideElement teamsButton = $(byXpath(".//a[@href='#teams']"));
    SelenideElement jobsButton= $(byXpath(".//a[@href='#jobs']"));
    SelenideElement lifeAtInsiderButton = $(byXpath(".//a[@href='#life-at-insider']"));

    SelenideElement cultureBlock = $(byXpath(".//div[@class='wpb_wrapper']/section[@class='grid-container']"));
    SelenideElement locationBlock = $(byId("locations"));
    SelenideElement teamsBlock = $(byId("fws_5fd4853029b9f"));
    SelenideElement jobsBlock = $(byId("jobs-container"));
    SelenideElement lifeAtInsiderBlock = $(byId("sbi_images"));

    SelenideElement careerOpportunitiesTitle = $(byXpath(".//h2[text()='CAREER OPPORTUNITIES']"));
    SelenideElement locationFilter = $(byXpath(".//select[@class='jobs-locations']"));
    SelenideElement jobsFilter = $(byXpath(".//select[@class='jobs-teams']"));
    SelenideElement jobList = $(byXpath(".//div[@class='jobs-list']"));
    SelenideElement firstElementInJobList = $(byXpath("(.//div[@class='jobs-list']/a)[1]"));




    public void clickOnCultureButton(){
        cultureButton.click();
    }

    public void clickOnLocationButton(){
        locationButton.click();
    }

    public void clickOnTeamButton(){
        teamsButton.click();
    }

    public void clickOnJobsButton(){
        jobsButton.click();
    }

    public void clickOnLifeButton(){
        lifeAtInsiderButton.click();
    }

    public boolean isCultureBlockVisible(){
        if(cultureBlock.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isTeamBlockVisible(){
        if(teamsButton.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isJobsBlockVisible(){
        if(jobsBlock.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isLocationBlockVisible(){
        if(locationBlock.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isLifeBlockVisible(){
        if(lifeAtInsiderBlock.isDisplayed()){
            return true;
        }
        return false;
    }

    public void scrollToCareerOpportunities(){
        careerOpportunitiesTitle.scrollIntoView(true);
    }

    public void clickOnLocationFilter(){
        locationFilter.click();
    }

    public void clickOnLocation(String location){
        SelenideElement locationSelection = $(byXpath(".//select[@class='jobs-locations']/option[text()='"+location+"']"));
        locationSelection.click();
    }

    public void clickOnJobFilter(){
        jobsFilter.click();
    }

    public void clickOnJob(String job){
        SelenideElement jobsSelection = $(byXpath(".//select[@class='jobs-teams']/option[text()='"+job+"']"));
        jobsSelection.click();
    }

    public boolean isJobListDisplayed(){
        return jobList.isDisplayed();
    }

    public void clickOnFirstElementInJobList(){
        firstElementInJobList.click();
    }

    public ArrayList<ElementsCollection> getJobElements() throws InterruptedException {
        // Fast fix for filter result reload
        Thread.sleep(1000);

        ArrayList<ElementsCollection> jobsElements = new ArrayList<ElementsCollection>();
        ElementsCollection jobs = $$(byXpath(".//div[@class='jobs-list']/a[contains(@class, 'job')]"));
        for (SelenideElement job:
             jobs) {
            String t = job.getAttribute("class");
            ElementsCollection jobElements = job.$$(byXpath(".//span"));
            jobsElements.add(jobElements);
        }

        return jobsElements;
    }

}
